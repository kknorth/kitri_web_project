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
		try {
			BlockoService service = new BlockoServiceImpl();
			ArrayList<BitcoinAdressDTO> btcaddrlist = service.bitcoinAdressSelect(audio_code);
			request.setAttribute("btcaddrlist", btcaddrlist); //어드레스 리스트에서 내가 보낼 주소와 프라이빗키를 보여준뒤 클릭
			
			String bitcoinAdress1 = "";
			String privatekey1 = "";
			String bitcoinAdress2 = "";
			String privatekey2 = "";
			String bitcoinAdress3 = "";
			String privatekey3 = "";
			String righterName1 = "";
			long righterVal1 = 0;
			String righterName2 = "";
			long righterVal2 = 0;
			String righterName3 = "";
			long righterVal3 = 0;
			
			BitcoinAdressDTO btcaddr = new BitcoinAdressDTO(audio_code, bitcoinAdress1, privatekey1, bitcoinAdress2, privatekey2, bitcoinAdress3, privatekey3, righterName1, righterVal1, righterName2, righterVal2, righterName3, righterVal3);
			for (int i = 0; i < btcaddrlist.size(); i++) {
				btcaddr = btcaddrlist.get(i);
			}
			String[] privatekey = {btcaddr.getPrivatekey1(),btcaddr.getPrivatekey2(),btcaddr.getPrivatekey3()};			
			String[] rawSignedTx = null;
			String[] transactionId = null;
			long[] righterVal = {btcaddr.getRighterVal1(),btcaddr.getRighterVal2(),btcaddr.getRighterVal3()};
			long[] amount = null; 
			//long[] fee =null; 
			
			String[] toAddress ={btcaddr.getBitcoinAdress1(),btcaddr.getBitcoinAdress2(),btcaddr.getBitcoinAdress3()};
			TransactionBuilder builder = new TransactionBuilder();
			
			for (int i = 0; i < 2; i++) {		
				String RVAL = Long.toString(righterVal[i]);
				amount[i] = io.blocko.coinstack.Math.convertToSatoshi(RVAL);
				//fee =io.blocko.coinstack.Math.convertToSatoshi("fee[i]");
				builder.addOutput(toAddress[i], amount[i]);
				//builder.setFee(fee);
				rawSignedTx[i] = coinstack.createSignedTransaction(builder, privatekey[i]);
				System.out.println(rawSignedTx[i]);
				transactionId[i] = TransactionUtil.getTransactionHash(rawSignedTx[i]);
				System.out.println(transactionId[i]);
				request.setAttribute("transactionId"+i, transactionId[i]);
			}
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
