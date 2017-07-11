package com.command.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comment.service.ContentServiceImpl;
import com.comment.service.DeleteServiceImpl;
import com.comment.service.ListServiceImpl;
import com.comment.service.ModifyServiceImpl;
import com.comment.service.ReplyServiceImpl;
import com.comment.service.ReplyViewServiceImpl;
import com.comment.service.WriteServiceImpl;
import com.comment.service.CommentService;


@WebServlet("*.do")
public class BFrontController extends HttpServlet {
    public BFrontController(){
    	super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		CommentService command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new WriteServiceImpl();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/list.do")) {
			command = new ListServiceImpl();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/content_view.do")){
			command = new ContentServiceImpl();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/modify.do")) {
			command = new ModifyServiceImpl();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")) {
			command = new DeleteServiceImpl();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/reply_view.do")) {
			command = new ReplyViewServiceImpl();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if(com.equals("/reply.do")) {
			command = new ReplyServiceImpl();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}