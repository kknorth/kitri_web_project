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
		// 받는 사람 이메일 주소 
		String toEmail = "godjsdleka@naver.com";  //request.getParameter("artist_id");
		String toName = "우해원 회원님";
		String subject = "FairMusic 이메일 인증입니다.";
		String content = "인증번호 [" + authNum + "]";

		logic.sendMail(toEmail, toName, subject, content);
	}
}
