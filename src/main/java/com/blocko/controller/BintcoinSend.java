package com.blocko.controller;

import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.TransactionBuilder;
import io.blocko.coinstack.TransactionUtil;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.exception.MalformedInputException;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.api.API;
import com.blocko.dto.BitcoinAdressDTO;
import com.blocko.service.BlockoService;
import com.blocko.service.BlockoServiceImpl;
@WebServlet(name = "bitcoinsend", urlPatterns = { "/bitcoinsend" })
public class BintcoinSend extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		String bitcoin = request.getParameter("bitcoin");
		String reqfee = request.getParameter("fee");
		String toAddress = request.getParameter("toAddress");
		
		long amount = io.blocko.coinstack.Math.convertToSatoshi(bitcoin); 
		long fee = io.blocko.coinstack.Math.convertToSatoshi(reqfee);

		TransactionBuilder builder = new TransactionBuilder();
		builder.addOutput(toAddress, amount);
		
		String id= null;
		
		try {
			builder.setFee(fee);
			// sign the transaction using the private key
			BlockoService service = new BlockoServiceImpl();
			ArrayList<BitcoinAdressDTO> deptlist = service.bitcoinAdressSelect(id);
			
			String rawSignedTx = coinstack.createSignedTransaction(builder, "상대방에게 보낼때 내가보냈다는 증명 : 나의 프라이빗 키로 서명을 해야함");
			System.out.println(rawSignedTx);
			// transaction lookup
			String transactionId = TransactionUtil.getTransactionHash(rawSignedTx);
			System.out.println(transactionId);
			// 조회한 트랜잭션 id로 스탬핑 고고싱
		} catch (MalformedInputException e) {
			e.printStackTrace();
		} catch (CoinStackException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/bitcoinAddress/bitcoinSend.jsp");
		rd.forward(request, response);

	}
}
