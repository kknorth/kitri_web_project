package com.blocko.controller;

import io.blocko.bitcoinj.core.Sha256Hash;
import io.blocko.bitcoinj.core.Utils;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.Stamp;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.api.API;
import com.blocko.dto.BitcoinAdressDTO;
import com.blocko.dto.MusicStampDTO;
import com.blocko.service.BlockoService;
import com.blocko.service.BlockoServiceImpl;

@WebServlet(name = "stamplist", urlPatterns = { "/stamplist.do" })
public class StampSelect extends HttpServlet {
	CoinStackClient coinstack = API.createNewCoinStackClient();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//최종 업로드 버튼 리스트 페이지로 리다이렉트 된다 그리고 리스트를 누르게되면 블록체인 정보가 출력
		String id= null;
		try {
			String musicName ="";
			Date timestamp = null;
			String musicHash ="";
			String stampId ="";
			String txId ="";
			BlockoService service = new BlockoServiceImpl();
			MusicStampDTO musicstamp = service.StampSelect(id, musicHash);
			MusicStampDTO stamplist = new MusicStampDTO(id, musicName, musicHash, stampId, txId, timestamp);
			
			Stamp stamp = coinstack.getStamp("f706145581af043206600a9182357b59c57d37dcf232d44c276f8ce22016c4a1-0");
			
			System.out.println("블록체인 트랜잭션 값: "+stamp.getTxId());
			System.out.println("OutputIndex: "+stamp.getOutputIndex());
			System.out.println("Confirmations: "+stamp.getConfirmations());
			System.out.println("Timestamp: "+stamp.getTimestamp());
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
			
			String formattedDate = dateFormat.format(date);
			System.out.println("Confirmations2 :"+formattedDate);
			
		} catch (CoinStackException e) {
			
			e.printStackTrace();
		}finally{
			coinstack.close();
		}

		RequestDispatcher rd =
				request.getRequestDispatcher("/MusicUpload/musicstamp.jsp");
		rd.forward(request, response);
	}
}
