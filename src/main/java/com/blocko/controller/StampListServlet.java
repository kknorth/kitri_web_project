package com.blocko.controller;
import io.blocko.coinstack.exception.CoinStackException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blocko.blockchain.MusicStamp;



@WebServlet(name = "stamplist", urlPatterns = { "/stamplist.do" })
public class StampListServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1. 요청정보추출
		req.setCharacterEncoding("euc-kr");
		resp.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = resp.getWriter();
		
		
		MusicStamp stamp = new MusicStamp();
		String hexHash = stamp.getMusicHashHex();
		try {
			String stampId = stamp.testStampMusic(hexHash);
			String stamHash = stamp.testGetStamp(stampId);
			System.out.println(stamHash);
		} catch (CoinStackException e) {
			e.printStackTrace();
		} 

		String viewpath = req.getParameter("viewpath");
		req.setAttribute("viewpath", viewpath);

		RequestDispatcher rd =
			req.getRequestDispatcher("mainLayout.jsp");
		rd.forward(req, resp);
		
	}	
}











