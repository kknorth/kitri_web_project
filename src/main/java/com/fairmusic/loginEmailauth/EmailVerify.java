package com.fairmusic.loginEmailauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmailVerify extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("asdfasdf");
		EmailLogic logic = new EmailLogic();
		String authNum = logic.RandomNum();
		// �޴� ��� �̸��� �ּ� 
		String toEmail = "godjsdleka@naver.com";  //request.getParameter("artist_id");
		String toName = "���ؿ� ȸ����";
		String subject = "FairMusic �̸��� �����Դϴ�.";
		String content = "������ȣ [" + authNum + "]";

		logic.sendMail(toEmail, toName, subject, content);
	}
}
