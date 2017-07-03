<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="javax.activation.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%!
public class MyAuthentication extends Authenticator { //아이디 패스워드 인증받기 함수
  PasswordAuthentication pa;
  public MyAuthentication(){
    pa=new PasswordAuthentication("이메일계정","이메일계정비밀번호");        
  }
  @Override
  protected PasswordAuthentication getPasswordAuthentication() {
    return pa;
  }
}
%>


<%
 // SMTP 서버 주소
 String smtpHost = "SMTP 주소나 아이피등 정보";


 //받는 사람의 정보
 String toName = "메일 받는사람 이름";
 String toEmail = "메일 받는사람 이메일 주소";


 //보내는 사람의 정보
 String fromName = "메일 보내는사람 이름";
 String fromEmail = "메일 보내는사람 이메일 주소";
 
 try {
  Properties props = new Properties();
  props.put("mail.smtp.host", smtpHost);
  props.put("mail.smtp.auth","true");


  // 메일 인증
  Authenticator myauth=new MyAuthentication(); 
  Session sess=Session.getInstance(props, myauth);


  InternetAddress addr = new InternetAddress();
  addr.setPersonal(fromName,"UTF-8");
  addr.setAddress(fromEmail);


  Message msg = new MimeMessage(sess);
  msg.setFrom(addr);         
  msg.setSubject(MimeUtility.encodeText("이메일 제목", "utf-8","B"));
  msg.setContent("이메일 보낼 내용", "text/html;charset=utf-8");
  msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));


  Transport.send(msg);


 } catch (Exception e) {
  e.printStackTrace();
  out.println("<script>alert('메일 전송에 실패했습니다.\\n다시 시도해주세요.');</script>");
  return;
 }
 
 out.println("<script>alert('메일이 전송되었습니다.');<script>");

%>
