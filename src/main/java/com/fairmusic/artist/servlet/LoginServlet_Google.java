package com.fairmusic.artist.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login_google", urlPatterns = { "/login_google.do" })
public class LoginServlet_Google extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");

		String loginUser_google = request.getParameter("loginUser_google");
		System.out.println("서블릿에 가져와?"+ loginUser_google);
		
		String viewpath = "";
		String leftpath= null;
		String rightpath= null;
		String rdpath = null;
		if (loginUser_google == null) {
			rdpath = "login-no-sidebar.jsp";
		} else {
			viewpath = "../content.jsp";
			leftpath="Side_Left.jsp";
			rightpath="Side_Right.jsp";
			rdpath="/layout/mainLayout.jsp";
		}
		HttpSession ses = request.getSession();
		ses.setAttribute("loginUser_google", loginUser_google);
		request.setAttribute("viewpath", viewpath);
		request.setAttribute("leftpath", leftpath);
		request.setAttribute("rightpath", rightpath);

		RequestDispatcher rd = request
				.getRequestDispatcher(rdpath);
		rd.forward(request, response);

	}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("euc-kr");

	String loginUser_google = request.getParameter("loginUser_google");
	System.out.println("서블릿에 가져와?"+ loginUser_google);
	
	String viewpath = "";
	String leftpath= null;
	String rightpath= null;
	String rdpath = null;
	if (loginUser_google == null) {
		rdpath = "login-no-sidebar.jsp";
	} else {
		viewpath = "../content.jsp";
		leftpath="Side_Left.jsp";
		rightpath="Side_Right.jsp";
		rdpath="/layout/mainLayout.jsp";
	}


	HttpSession ses = request.getSession();
	ses.setAttribute("loginUser_google", loginUser_google);
	request.setAttribute("viewpath", viewpath);
	request.setAttribute("leftpath", leftpath);
	request.setAttribute("rightpath", rightpath);

	RequestDispatcher rd = request
			.getRequestDispatcher(rdpath);
	rd.forward(request, response);		
	}

}
