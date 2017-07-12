package com.blocko.controller;

import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.ECKey;
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
import javax.servlet.http.HttpSession;

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

		String audio_code= null;
		MyBtcAddrReq pk = null;
		try {
			BlockoService service = new BlockoServiceImpl();
			ArrayList<BitcoinAdressDTO> btcaddrlist = service.bitcoinAdressSelect(audio_code);
		
			pk.execute(request, response);//내 비트코인 프라이빗키 받아와
			String MyPrivateKey = (String) request.getAttribute("pk");
		
			String[] toAddress = new String[2];
			//String[] privatekey = new String[2];
			long[] righterVal = new long[2];
			String[] rawSignedTx = new String[2];
			String[] transactionId = new String[2];
			long[] amount = new long[2];
			TransactionBuilder builder = new TransactionBuilder();
			for (int i = 0; i < btcaddrlist.size(); i++) {
				toAddress[i]= (btcaddrlist.get(i).getBitcoinAdress());
				//privatekey[i] = (btcaddrlist.get(i).getPrivatekey());
				righterVal[i] = (btcaddrlist.get(i).getRighterVal());
				String RVAL = Long.toString(righterVal[i]);
				amount[i] = io.blocko.coinstack.Math.convertToSatoshi(RVAL);
				builder.allowDustyOutput(true);
				builder.addOutput(toAddress[i], amount[i]);
				rawSignedTx[i] = coinstack.createSignedTransaction(builder, MyPrivateKey);
				System.out.println(rawSignedTx[i]);
				transactionId[i] = TransactionUtil.getTransactionHash(rawSignedTx[i]);
				System.out.println(transactionId[i]);
				request.setAttribute("transactionId", transactionId[i]);
			}
			
			//String[] privatekey = {btcaddr.getPrivatekey()};
			//long[] righterVal = {btcaddr.getRighterVal()};
			//String[] toAddress ={btcaddr.getBitcoinAdress()};
			//long[] fee =null; 
			//fee =io.blocko.coinstack.Math.convertToSatoshi("fee[i]");
			//builder.setFee(fee);
			
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
