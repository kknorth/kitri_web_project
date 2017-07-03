package com.blocko.controller;
import static org.junit.Assert.assertEquals;
import io.blocko.coinstack.CoinStackClient;
import io.blocko.coinstack.exception.CoinStackException;
import io.blocko.coinstack.model.Stamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.blockchain.MusicStamp;
import com.blocko.dto.MusicStampDTO;
import com.blocko.service.BlockoService;
import com.blocko.service.BlockoServiceImpl;



@WebServlet(name = "stamplist", urlPatterns = { "/stamplist.do" })
public class StampListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		CoinStackClient coinstack = null;
		MusicStamp MusicStamp = new MusicStamp();
		String hexHash = MusicStamp.getMusicHashHex();
		
		try {
			String stampId = MusicStamp.testStampMusic(hexHash);
			String MusicHash = MusicStamp.testGetStamp(stampId);
			Stamp stamp = coinstack.getStamp(stampId);
			Date timestamp = stamp.getTimestamp();
			System.out.println(MusicHash);
			String music = request.getParameter("artist_music");
			String user = request.getParameter("artist_id");
			MusicStampDTO dept = new MusicStampDTO(music , user, timestamp, MusicHash);
			BlockoService service = new BlockoServiceImpl();
			int result = service.insert(dept);
			if (result==1){
				System.out.println("블록체인 삽입 성공");
				//블록체인 데이터 뿌려준다. 현재 내 블록에 삽입된 상태
			}
		} catch (CoinStackException e) {
			e.printStackTrace();
		} 
		

		request.setAttribute("leftpath", "layout/Side_Left.jsp");
		request.setAttribute("viewpath", "MusicStamp.jsp");
		request.setAttribute("rightpath", "layout/Side_Right.jsp");

		RequestDispatcher rd =
				request.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(request, response);
		
	}	
}