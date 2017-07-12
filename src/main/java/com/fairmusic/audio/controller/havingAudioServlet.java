package com.fairmusic.audio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fairmusic.album.service.AlbumService;
import com.fairmusic.album.service.AlbumServiceimpl;
import com.fairmusic.artist.service.ArtistServiceimpl;
import com.fairmusic.audio.service.AudioService;
import com.fairmusic.audio.service.AudioServiceimpl;
import com.fairmusic.dto.albumDTO;
import com.fairmusic.dto.artistDTO;
import com.fairmusic.dto.audioDTO;
import com.fairmusic.dto.audiobuyDTO;


public class havingAudioServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		artistDTO ardto = (artistDTO)request.getSession().getAttribute("user");
		
		String artist_code = ardto.getArtist_code();
		
		AudioService service = new AudioServiceimpl();
		ArrayList<audiobuyDTO> havingdto = service.havingAudio(artist_code);
		
		ArrayList<audioDTO> havingAudioDTO = new ArrayList<audioDTO>();
		
		int size = havingdto.size();
		audioDTO tempdto = null;
		for(int i = 0;i < size;i++){
			tempdto = service.selectAudio(havingdto.get(i).getAudio_code());
			if(tempdto!= null){
				havingAudioDTO.add(tempdto);
			}
		}
		
		request.setAttribute("havingAudioDTO", havingAudioDTO);

		request.setAttribute("viewpath", "../MusicDownload/havingMusic.jsp");
		
		
		//4. 요청재지정
		RequestDispatcher rd =
				request.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(request, response);
	}

}
