package com.fairmusic.audio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fairmusic.audio.service.AudioService;
import com.fairmusic.audio.service.AudioServiceimpl;
import com.fairmusic.dto.artistDTO;
import com.fairmusic.dto.audioDTO;
import com.fairmusic.dto.audiobuyDTO;

/**
 * Servlet implementation class audioBuyServlet
 */
public class audioBuyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		artistDTO ardto = (artistDTO)request.getSession().getAttribute("user");
		
		String artist_code = ardto.getArtist_code();
		String audio_code = request.getParameter("audio_code");
		
		AudioService service = new AudioServiceimpl();
		
		
		int result = service.audiopurchase(artist_code, audio_code);
		
		if(result>=1){
			System.out.println(artist_code+"°¡" + audio_code+"¸¦ »ò´Ù");
		}
		
		request.setAttribute("result", result);
		
		
	}


}
