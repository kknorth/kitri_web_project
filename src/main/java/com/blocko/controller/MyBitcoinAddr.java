package com.blocko.controller;

import io.blocko.coinstack.ECKey;
import io.blocko.coinstack.exception.CoinStackException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blocko.dto.MyBTCaddrDTO;
import com.blocko.service.BlockoService;
import com.blocko.service.BlockoServiceImpl;
import com.fairmusic.dto.artistDTO;

@WebServlet(name = "MyBitcoinAddr", urlPatterns = { "/MyBitcoinAddr" })
public class MyBitcoinAddr extends HttpServlet implements MyBtcAddrReq{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		execute(request, response);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession ses = request.getSession();
		artistDTO artist= (artistDTO)ses.getAttribute("user"); 
		String artist_code = artist.getArtist_code();
		System.out.println("artist_code :"+artist_code);
		try {
			String Myprivatekey = PrivateKey();
			String MybitcoinAddr = btcAddress();
			PrintWriter pw = response.getWriter();
			System.out.println(Myprivatekey);
			System.out.println(MybitcoinAddr);
			ses.setAttribute("Myprivatekey", Myprivatekey);

			request.setAttribute("MybitcoinAddr", MybitcoinAddr);
			pw.print("BitcoinAddress : "+MybitcoinAddr);
			
			MyBTCaddrDTO myaddr = new MyBTCaddrDTO(artist_code, Myprivatekey, MybitcoinAddr);
			BlockoService service = new BlockoServiceImpl();
			int result = service.mybtcaddr(myaddr);
			
		} catch (CoinStackException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String PrivateKey() throws CoinStackException {
		String newPrivateKey ="";
		newPrivateKey = ECKey.createNewPrivateKey();
		return newPrivateKey;
	}
	public String btcAddress() throws CoinStackException {
		String bitcoinAddr ="";
		String newPrivateKey = PrivateKey();
		bitcoinAddr = ECKey.deriveAddress(newPrivateKey);
		return bitcoinAddr;
	}
}
