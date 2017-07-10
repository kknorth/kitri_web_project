package com.fairmusic.artist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fairmusic.artist.service.ArtistServiceimpl;
import com.fairmusic.dto.artistDTO;

@WebServlet(name = "login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("euc-kr");

			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			
			ArtistServiceimpl service = new ArtistServiceimpl();
			artistDTO loginUser = service.login(email, pass);
			System.out.println("서블릿에 가져와?"+ email+pass);
			
			String viewpath = "";
			String leftpath= null;
			String rightpath= null;
			String rdpath = null;
			if (loginUser == null) {
				rdpath = "login-no-sidebar.jsp";
			} else {
				viewpath = "../content.jsp";
				leftpath="Side_Left.jsp";
				rightpath="Side_Right.jsp";
				rdpath="/layout/mainLayout.jsp";
			}


			HttpSession ses = request.getSession();
			ses.setAttribute("user", loginUser);
			request.setAttribute("viewpath", viewpath);
			request.setAttribute("leftpath", leftpath);
			request.setAttribute("rightpath", rightpath);

			RequestDispatcher rd = request
					.getRequestDispatcher(rdpath);
			rd.forward(request, response);

		}
	}


