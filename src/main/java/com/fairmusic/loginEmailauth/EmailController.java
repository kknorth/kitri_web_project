/*package com.fairmusic.loginEmailauth;

import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

@WebServlet(name = "emailauth", urlPatterns = { "/emailauth.do" })
public class EmailController extends HttpServlet{
	private String fromEmail = "fairmusichelp@gmail.com"; // 보내는 사람 이메일(gmail) 아이디
	private String password = "fairmusic"; // 보내는 사람 이메일(gmail) 비밀번호
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		String email = request.getParameter("email");
		String authNum ="";
		
		authNum = RandomNum(); //RandomNum 함수를 호출하여 리턴값을 authNum에 저장한다.
		sendEmail(email, authNum);
		//sendEmail 함수를 호출한다. 여기서, email과 authNum을 매개변수로 함
		
		
		RequestDispatcher rd =
				request.getRequestDispatcher("/email.jsp");
		rd.forward(request, response);

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
			//보내는 사람 설정
			msg.setFrom(new InternetAddress(from,MimeUtility.encodeText(fromName,"UTF-8","B")));
			
			InternetAddress[] address1 = {new InternetAddress(to1)};
			msg.setRecipients(Message.RecipientType.TO, address1);//받는사람설정1
			msg.setSubject(subject);
			msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
			msg.setContent(content,"text/html;charset=euc-kr"); //내용설정(HTML형식)
			
			Transport.send(msg); //메일 보내기
			
		}catch (MessagingException e) {
			e.printStackTrace();
		}catch (Exception e){
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
*/