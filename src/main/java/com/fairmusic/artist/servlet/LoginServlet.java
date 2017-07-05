package com.fairmusic.artist.servlet;

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

			
			String viewpath = "";
			String leftpath="";
			String rightpath="";
			if (loginUser == null) {
				viewpath = "../login-no-sidebar.jsp";
			} else {
				viewpath = "../content.jsp";
				leftpath="Side_Left.jsp";
				rightpath="Side_Right.jsp";
			}


			HttpSession ses = request.getSession();
			ses.setAttribute("user", loginUser);
			request.setAttribute("viewpath", viewpath);
			request.setAttribute("leftpath", leftpath);
			request.setAttribute("rightpath", rightpath);

			RequestDispatcher rd = request
					.getRequestDispatcher("/layout/mainLayout.jsp");
			rd.forward(request, response);

		}
	}


