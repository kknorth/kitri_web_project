package com.fairmusic.artist.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fairmusic.artist.service.ArtistServiceimpl;
import com.fairmusic.dto.artistDTO;
import com.fairmusic.dto.MessageDTO;
import com.fairmusic.message.service.MessageServiceImpl;

@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("euc-kr");

			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			ArtistServiceimpl service = new ArtistServiceimpl();
			artistDTO loginUser = service.login(email, pass);
			System.out.println("�α��μ��� : "+ email+pass);
			String artist_code = loginUser.getArtist_code();
			System.out.println("�α��μ��� articode : "+artist_code);
			
			MessageServiceImpl M_service = new MessageServiceImpl();
			ArrayList<MessageDTO> newMessageList = M_service.NewMessage(artist_code);
			
			
			String viewpath = "";
			String leftpath= null;
			String rightpath= null;
			String rdpath = null;
			if (loginUser == null) {
				rdpath = "login_failed.jsp";
			} else {
				viewpath = "../content.jsp";
				leftpath="Side_Left.jsp";
				rightpath="Side_Right.jsp";
				rdpath="/layout/mainLayout.jsp";
			}

			System.out.println("�α��μ��� newMessageList : "+newMessageList);
			System.out.println("�α��μ��� loginUser : "+loginUser);
			HttpSession ses = request.getSession();
			ses.setAttribute("user", loginUser);
			ses.setAttribute("newMessageList", newMessageList);
			/*request.setAttribute("viewpath", viewpath);
			request.setAttribute("leftpath", leftpath);
			request.setAttribute("rightpath", rightpath);

			RequestDispatcher rd = request
					.getRequestDispatcher(rdpath);
			rd.forward(request, response);*/

			response.sendRedirect("/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp");
		}
	}


