package com.blocko.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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

@WebServlet(name = "MyBitcoinAddrSelect", urlPatterns = { "/MyBitcoinAddrSelect" })
public class MyBitcoinAddrSelect extends HttpServlet implements MyBtcAddrReq{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		execute(request, response);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("euc-kr");
			response.setContentType("text/html;charset=euc-kr");
			HttpSession ses = request.getSession();
			artistDTO artist= (artistDTO)ses.getAttribute("user"); 
			String artist_code = artist.getArtist_code();
			BlockoService service = new BlockoServiceImpl();
			MyBTCaddrDTO addr = service.read(artist_code);
			request.setAttribute("pk", addr.getMybtcaddr());
			PrintWriter pw = response.getWriter();
			pw.print(addr.getMybtcaddr());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}