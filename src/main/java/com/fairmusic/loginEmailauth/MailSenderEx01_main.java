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
 
public class MailSenderEx01_main {
    
    private String fromEmail = "fairmusichelp@gmail.com"; // ������ ��� �̸���(gmail) ���̵�
    private String password = "fairmusic"; // ������ ��� �̸���(gmail) ��й�ȣ
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	MailSenderEx01_main mail = new MailSenderEx01_main();
    	
    	String authNum = mail.RandomNum();
    	String toEmail = "junie2368@naver.com"; // �޴� ��� �̸��� �ּ�
        String toName = "������ ȸ����";
        String subject = "FairMusic �̸��� �����Դϴ�.";
        String content = "������ȣ ["+authNum+"]";
        
        mail.sendMail(toEmail, toName, subject, content);
    }
    
    // �޴� ��� �̸���, ������ ��� �̸�, ���� ����, ���� ����
    public void sendMail(String toEmail, String toName, String subject, String content) {
        try {
            // ������ ���(gmail)�� ȯ�� ���� �κ����� �� �κ��� ���� �߿��ϴ�.
            Properties props = new Properties();
 
            // ���� ȯ�� ����
            // �Ʒ��� ȯ�� ������ ���ۿ��� �̷��� ����� �ִ� ��
            props.put("mail.smtp.starttls", "true");
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.auth", "true");
            
            // ���� ȯ�� ����
            Session sess = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(fromEmail, password);
			    }
			});
            
            // �޼��� ���� ó��
            MimeMessage msg = new MimeMessage(sess);
            msg.setHeader("content-type", "text/plain;charset=utf-8");
            
            // ���� ���
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, toName, "utf-8"));
            
            // ���� ����
            msg.setSubject(subject);
            
            // ���� ����
            // �� �κ��� html�� plain�� ���� ���� Ÿ���� �ٲ��.
            msg.setContent(content, "text/html;charset=utf-8");
            msg.setSentDate(new java.util.Date());
            
            Transport.send(msg);
            
            System.out.println("������ �Ϸ�Ǿ����ϴ�.");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
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
