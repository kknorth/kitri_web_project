package com.fairmusic.album.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fairmusic.album.service.AlbumService;
import com.fairmusic.album.service.AlbumServiceimpl;
import com.fairmusic.dto.albumDTO;

/**
 * Servlet implementation class albumServlet
 */
public class albumServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		Random r = new Random();
		
		String randomcode = (r.nextInt(98)+1) + getRandomString(2)+ (r.nextInt(98)+1) + getRandomString(2)+ (r.nextInt(98)+1) + getRandomString(2)+(r.nextInt(98)+1) + getRandomString(2)+ (r.nextInt(98)+1) + getRandomString(2);
		System.out.println(randomcode);

		
		albumDTO album = new albumDTO(randomcode, request.getParameter("album_title"), request.getParameter("artist_code"), request.getParameter("album_image"), request.getParameter("album_date"), request.getParameter("album_dc"));

		 
	
		AlbumService service = new AlbumServiceimpl();
		System.out.println(album);
		int result = service.createAlbum(album);

		if (result==1){
			System.out.println("¾Ù¹ü»ðÀÔ ¼º°ø");
			
			
		}else{
			System.out.println("¾Ù¹ü»ðÀÔ ½ÇÆÐ");
		}

		request.setAttribute("viewpath", "../MusicUpload/myFMpage.jsp");

		
		//4. ¿äÃ»ÀçÁöÁ¤
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
