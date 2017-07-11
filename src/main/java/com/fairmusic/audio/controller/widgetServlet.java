package com.fairmusic.audio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fairmusic.artist.service.ArtistServiceimpl;
import com.fairmusic.audio.service.AudioService;
import com.fairmusic.audio.service.AudioServiceimpl;
import com.fairmusic.dto.artistDTO;
import com.fairmusic.dto.audioDTO;

public class widgetServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");

			
		String audio_code = request.getParameter("audio_code");
		System.out.println("������ڵ�"+audio_code);
		AudioService audioservice = new AudioServiceimpl();
		System.out.println("���������"+audioservice);
		audioDTO audiodto = audioservice.selectAudio(audio_code);
		System.out.println("�������Ƽ��"+audiodto);
		ArtistServiceimpl artistservice = new ArtistServiceimpl();
	/*	artistDTO artistdto = artistservice.getArtistDTO(audiodto.getArtist_code());*/
		/*System.out.println("��Ƽ��Ʈ��Ƽ��"+artistdto);*/
		String artistName = "�ϴ� ����";/*artistdto.getArtist_id();*/
		System.out.println("��Ƽ��Ʈ����"+artistName);
		
		request.setAttribute("audio_code", audio_code);
		String audioPath = "";
		String audioImage = "";
		String audioMovie = "";
		
		request.setAttribute("audioDto", audiodto);
		System.out.println("�¾�Ʈ����Ʈ");
		request.setAttribute("artistName",artistName);
RequestDispatcher rd = request
				.getRequestDispatcher("/widget/fmWidget.jsp");
		rd.include(request, response);
	}

}
