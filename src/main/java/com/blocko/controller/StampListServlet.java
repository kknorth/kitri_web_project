package com.blocko.controller;

import static org.junit.Assert.assertNotNull;
import io.blocko.bitcoinj.core.Sha256Hash;
import io.blocko.bitcoinj.core.Utils;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.Stamp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.api.API;

@WebServlet(name = "stamplist", urlPatterns = { "/stamplist.do" })
public class StampListServlet extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		String music = "efefef"; // mp3데이터값 가져오니라
		byte[] data = music.getBytes();
		byte[] hash = Sha256Hash.create(data).getBytes();
		String MusicHash = Utils.HEX.encode(hash);
		System.out.println("음악 해쉬값: "+MusicHash);
		
		try {
			String stampId = coinstack.stampDocument(MusicHash);
			System.out.println("음악이 스탬프된 값 : "+stampId);
			request.setAttribute("stampId", stampId);
			
			Stamp stamp = coinstack.getStamp("f706145581af043206600a9182357b59c57d37dcf232d44c276f8ce22016c4a1-0");
			
			System.out.println("블록체인 트랜잭션 값: "+stamp.getTxId());
			System.out.println("OutputIndex: "+stamp.getOutputIndex());
			System.out.println("Confirmations: "+stamp.getConfirmations());
			System.out.println("Timestamp: "+stamp.getTimestamp());
			
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
			
			String formattedDate = dateFormat.format(date);
			System.out.println(formattedDate);
		} catch (CoinStackException e) {
			
			e.printStackTrace();
		}

		request.setAttribute("MusicHash", MusicHash);

		RequestDispatcher rd =
				request.getRequestDispatcher("/MusicUpload/musicstamp.jsp");
		rd.forward(request, response);
	}
}
