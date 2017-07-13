package com.fairmusic.audio.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		System.out.println("오디오코드"+audio_code);
		AudioService audioservice = new AudioServiceimpl();
		System.out.println("오디오서비스"+audioservice);
		audioDTO audiodto = audioservice.selectAudio(audio_code);
		System.out.println("오디오디티오"+audiodto);
		ArtistServiceimpl artistservice = new ArtistServiceimpl();
		artistDTO artistdto = artistservice.getArtistDTO(audiodto.getArtist_code());
		System.out.println("아티스트디티오"+artistdto);
		String artistName = artistdto.getArtist_name();
		System.out.println("아티스트네임"+artistName);
		
		request.setAttribute("audio_code", audio_code);
		String audioPath = "C:/Users/seong_jo/webwork/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FairMusic/FM_audio_file/"+audio_code+"."+audiodto.getAudio_file();
		String audioImage = "C:/Users/seong_jo/webwork/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/FairMusic/FM_audio_image/"+audio_code+"."+audiodto.getAudio_image();
		String audioMovie = "";
		
		request.setAttribute("audioDto", audiodto);
		
		System.out.println("셋애트리뷰트");
		request.setAttribute("artistName",artistName);
		
		ServletContext context = this.getServletContext();
	    String realPath = context.getRealPath("/");
		request.setAttribute("audioPath",audioPath);
		request.setAttribute("audioImage", audioImage);
		
RequestDispatcher rd = request
				.getRequestDispatcher("/widget/fmWidget.jsp");
		rd.include(request, response);
	}

}
