package com.fairmusic.loginEmailauth;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public class MailAuth02_ModelandView{
	
	public ModelAndView emailAuth(HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		String email = request.getParameter("email");
		String authNum = "";
		
		authNum = RandomNum();
		
		sendEmail(email.toString(),authNum);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("regist-no-sidebar.jsp");
		mv.addObject("email", email);
		mv.addObject("authNum", authNum);
		
		return mv;
		
	}
	
	private void sendEmail(String email, String authNum){
		String subject = "FairMusic 이메일 인증번호입니다.";
		String fromName = "페어뮤직 관리자";
		final String fromEmail = "faormusichelp@gmail.com";
        String to1 = email;
        String toEmail = "junie2368@naver.com";
        
        String content = "인증번호 ["+authNum+"]";
        
        try {
			Properties props = new Properties();

			props.put("mail.smtp.starttls", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.port", "465");
			props.put("mail.smtp.user", fromEmail);
			props.put("mail.smtp.auth", "true");

			Session mailSession = Session.getInstance(props,
					new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(fromEmail, "fairmusic");
			    }
			});

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(fromEmail, MimeUtility.encodeText(fromName, "utf-8", "B")));
			msg.setHeader("content-type", "text/plain;charset=utf-8");

			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toEmail, "FairMusic회원님", "utf-8"));

			msg.setSubject(subject);

			msg.setContent(content, "text/html;charset=utf-8");
			msg.setSentDate(new java.util.Date());

			Transport.send(msg);

			System.out.println("전송이 완료되었습니다.");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
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
