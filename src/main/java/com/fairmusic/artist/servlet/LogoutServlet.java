package com.fairmusic.artist.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
		
@WebServlet(name = "logout", urlPatterns = { "/logout.do" })
public class LogoutServlet extends HttpServlet {

		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			HttpSession ses = request.getSession(false);
			if(ses!=null){
				ses.invalidate();
			}
			request.setAttribute("viewpath", "../content.jsp" );
			request.setAttribute("leftpath", "Side_Left.jsp");
			request.setAttribute("rightpath", "Side_Right.jsp");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/layout/mainLayout.jsp");
			rd.forward(request, response);
	}

}
