package com.fairmusic.loginEmailauth;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
		
	@RequestMapping("emailAuth.do")
	public ModelAndView emailAuth(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String email = request.getParameter("email");
		String authNum ="";
		
		authNum = RandomNum();
		
		sendEmail(email.toString(), authNum);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/emailAuth.jsp");
		mv.addObject("email",email);
		mv.addObject("authNum", authNum);
		/*
		 * *authNum = RandomNum();
		RandomNum 함수를 호출하여 리턴값을 authNum에 저장한다.
		*sendEmail(email.toString(), authNum);
		sendEmail 함수를 호출한다.
		email이 String이니 구지 toString안해도 될듯-수정해야함
		여기서, email과 authNum을 매개변수로 함
		*/
		return mv;
	}
	
	private void sendEmail(String email,String authNum){
		String host = "smtp.gamil.com";
		String subject = "인증번호 전달";
		String fromName = "우해원";
		String from = "godjsdleka@naver.com";
		String to1 = email;
		
		String content = "인증번호["+authNum+"]";
		
		try {
			Properties props = new Properties();
			
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", host);
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.starttls.port", "465");
			props.put("mail.smtp.starttls.user", from);
			props.put("mail.smtp.starttls.auth", "true");
			
			Session mailSession = Session.getInstance(props, new javax.mail.Authenticator(){
				 	protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				 		return new javax.mail.PasswordAuthentication("fairmusichelp@gmail.com", "fairmusic");
				 	}
				});
			
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from,MimeUtility.encodeText(fromName,"UTF-8","B")));
			
			InternetAddress[] address1 = {new InternetAddress(to1)};
			
			
			
		} catch (Exception e) {
			
		}
	}
	
	 public String RandomNum(){
	    	StringBuffer buffer = new StringBuffer();
	    	for (int i = 0; i <= 6; i++) {
				int n = (int)(Math.random()*10);
				buffer.append(n);
			}
	    	return buffer.toString();
	    }
}
