package com.blocko.controller;


import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.exception.CoinStackException;

import java.io.IOException;

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



 @WebServlet(name = "bitcoinAddr", urlPatterns = { "/bitcoinaddr" })
public class BitcoinAdressInsert extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		String id= null;
		try {
			String newPrivateKey = PrivateKey();
			String MusicAddress = MusicAddress();
			long balance = coinstack.getBalance(MusicAddress);
			System.out.println("create privateKey: "+newPrivateKey);
			System.out.println("MusicAddress: "+MusicAddress);
			System.out.println("balance: " + balance);
			
			request.setAttribute("MusicAddress", MusicAddress);
			request.setAttribute("balance", balance);
			BitcoinAdressDTO bitaddr = new BitcoinAdressDTO(id, MusicAddress, newPrivateKey);
			BlockoService service = new BlockoServiceImpl();
			int result = service.bitcoinAdressInsert(bitaddr);
			
		} catch (CoinStackException e) {
			e.printStackTrace();
		}finally{
			coinstack.close();
		}
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/bitcoinAddress/bitcoinAddress.jsp");
		rd.forward(request, response);
		
	}
	public String PrivateKey() throws CoinStackException {
		String newPrivateKey ="";
		newPrivateKey = ECKey.createNewPrivateKey();
		return newPrivateKey;
	}
	public String MusicAddress() throws CoinStackException {
		String MusicAddress ="";
		String newPrivateKey = PrivateKey();
		MusicAddress = ECKey.deriveAddress(newPrivateKey);
		return MusicAddress;
	}
}
