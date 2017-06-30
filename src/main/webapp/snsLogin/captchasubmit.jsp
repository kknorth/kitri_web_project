<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ page import="nl.captcha.Captcha"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
	request.setCharacterEncoding("UTF-8");
	String answer = request.getParameter("answer");
	if (captcha.isCorrect(answer)) {
%>
<b>Correct Captcha Code !</b> <%
 	} else {
 %> <b>In Correct Captcha Code !</b> <%
 	}
 %>
</body>
</html>