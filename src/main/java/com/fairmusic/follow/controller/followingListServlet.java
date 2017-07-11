package com.fairmusic.follow.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fairmusic.dto.followDTO;
import com.fairmusic.follow.service.FollowService;
import com.fairmusic.follow.service.FollowServiceImpl;

@WebServlet(name = "followingList", urlPatterns = { "/followingList.do" })
public class followingListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		//HttpSession ses = request.getSession();
		//String loginuser = "";
		//ses.getAttribute("loginuser", loginuser);
		String mycode = request.getParameter("mycode");
		//String mycode ="1";
		System.out.println("팔로잉 리스트 요청한 사람의 code=>"+mycode);
		FollowService service = new FollowServiceImpl();
		ArrayList<followDTO> followinglist = service.FOLLOW_SEARCH_FOLLOWING(mycode);
		
		request.setAttribute("followinglist", followinglist);

		RequestDispatcher rd =
				request.getRequestDispatcher("/followingListTest.jsp");
		rd.forward(request, response);
	}
}
