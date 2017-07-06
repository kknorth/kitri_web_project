package com.blocko.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.blocko.apache.commons.codec.binary.Hex;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.Math;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.exception.MalformedInputException;
import io.blocko.coinstack.model.BlockchainStatus;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.blocko.api.API;


 @WebServlet(name = "bitcoin", urlPatterns = { "/bitcoin" })
public class BitcoinServlet extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		try {
			String newPrivateKey = PrivateKey();
			String MusicAddress = MusicAddress();
			long balance = coinstack.getBalance(MusicAddress);
			System.out.println("create privateKey: "+newPrivateKey);
			System.out.println("balance: " + balance);
			
			request.setAttribute("MusicAddress", MusicAddress);
			request.setAttribute("balance", balance);
		} catch (CoinStackException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/OpenAsset/OpenAsset.jsp");
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
