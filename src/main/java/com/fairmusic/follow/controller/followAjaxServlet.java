package com.fairmusic.follow.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fairmusic.dto.followDTO;
import com.fairmusic.follow.service.FollowService;
import com.fairmusic.follow.service.FollowServiceImpl;

@WebServlet(name = "follow_ajax", urlPatterns = { "/follow_ajax.do" })
public class followAjaxServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter pw = response.getWriter();
		// HttpSession ses = request.getSession();
		// String loginuser = "";
		// ses.getAttribute("loginuser", loginuser);
		String me = request.getParameter("me");
		String follower = request.getParameter("follower");

		System.out.println("follow���������� �� �ڵ� : " + me);
		System.out.println("follow���������� �ȷο� �ڵ� : " + follower);
		String msg = "";
		// String me = loginuser.artist_code;
		// String follower = follow ��ư�� ���� artist�� artist_code;
		FollowService service = new FollowServiceImpl();
		followDTO dto = service.FOLLOW_CHECK(me, follower);
		System.out.println("follow���������� dto : " + dto);
		// String check = dto.getFollow_good_alive();
		if (me.equals("") | follower.equals("")) {
			msg="�߸��� ����Դϴ�.";
		}else{
			if (dto == null) {
				service.FOLLOW_INSERT(me, follower);
				msg = me+"���� "+follower + "���� �ȷο� �߽��ϴ�.";
			} else if (dto.getFollow_good_alive().equals("1")) {
				System.out.println("follow���������� dto�� check number : "
						+ dto.getFollow_good_alive());
				service.FOLLOW_UNFOLLOW(me, follower);
				msg = me+"���� "+follower + "���� ���ȷο� �߽��ϴ�.";
			} else if (dto.getFollow_good_alive().equals("0")) {
				System.out.println("follow���������� dto�� check number : "
						+ dto.getFollow_good_alive());
				service.FOLLOW_REFOLLOW(me, follower);
				msg = me+"���� "+follower + "���� �ٽ� �ȷο� �߽��ϴ�.";
			}
		}

		System.out.println("follow�������� �Ѱ��� msg : " + msg);

		pw.print(msg);
	}
}
