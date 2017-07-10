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
		
		String reqbitcoin = request.getParameter("bitcoin");
		String reqfee = request.getParameter("fee");
		String toAddress = request.getParameter("toAddress");
		
		long amount = io.blocko.coinstack.Math.convertToSatoshi(reqbitcoin); 
		long fee = io.blocko.coinstack.Math.convertToSatoshi(reqfee);

		TransactionBuilder builder = new TransactionBuilder();
		builder.addOutput(toAddress, amount);
		
		String id= null;
		
		try {
			builder.setFee(fee);
			// sign the transaction using the private key
			BlockoService service = new BlockoServiceImpl();
			ArrayList<BitcoinAdressDTO> btcaddrlist = service.bitcoinAdressSelect(id);
			request.setAttribute("btcaddrlist", btcaddrlist); //��巹�� ����Ʈ���� ���� ���� �ּҿ� �����̺�Ű�� �����ص� Ŭ��
			
			String bitcoinAdress = "";
			String privatekey = "";
			String rightName = "";
			int percent = 0;
			BitcoinAdressDTO btcaddr = new BitcoinAdressDTO(id, bitcoinAdress, privatekey,rightName,percent);

			for (int i = 0; i < btcaddrlist.size(); i++) {
				btcaddr = btcaddrlist.get(i);
			}
			
			String privateKey = request.getParameter("privatekey");
			String rawSignedTx = coinstack.createSignedTransaction(builder, privateKey);
			System.out.println(rawSignedTx);
			// transaction lookup
			String transactionId = TransactionUtil.getTransactionHash(rawSignedTx);
			System.out.println(transactionId);
			// ��ȸ�� Ʈ����� id�� ������ ����
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
