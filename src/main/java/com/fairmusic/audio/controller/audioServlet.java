package com.fairmusic.audio.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.DATE;

import com.fairmusic.audio.service.AudioService;
import com.fairmusic.audio.service.AudioServiceimpl;
import com.fairmusic.dto.audioDTO;



public class audioServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		Random r = new Random();
		
		String randomcode = (r.nextInt(98)+1) + getRandomString(2)+ (r.nextInt(98)+1) + getRandomString(2)+ (r.nextInt(98)+1) + getRandomString(2)+(r.nextInt(98)+1) + getRandomString(2)+ (r.nextInt(98)+1) + getRandomString(2);
		System.out.println(randomcode);

		
		audioDTO audio = new audioDTO(randomcode, request.getParameter("audio_title"), "id", request.getParameter("audio_jenre"), "temp.png", request.getParameter("audio_detail"), request.getParameter("audio_album"), "", "음악파일 주소", "9999", "2");

		 
	
		AudioService service = new AudioServiceimpl();
		System.out.println(audio);
		int result = service.createAudio(audio);

		if (result==1){
			System.out.println("오디오 삽입 성공");
			
			
		}

		request.setAttribute("viewpath", "../MusicUpload/myFMpage.jsp");

		
		//4. 요청재지정
		RequestDispatcher rd =
				request.getRequestDispatcher("/layout/mainLayout.jsp");
		rd.forward(request, response);
		
		
		
	}
	private String getRandomString(int length){
	  StringBuffer buffer = new StringBuffer();
	  Random random = new Random();
	 
	  char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','n','m','o','p','q','r','s','t','u','v','w','x','y','z'};
	  
	 
	  for (int i=0 ; i<length ; i++)
	  {
	    buffer.append(chars[random.nextInt(chars.length)]);
	  }
	  return buffer.toString();
	}

}
