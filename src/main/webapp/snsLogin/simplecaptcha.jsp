<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<img id="captcha" src="<c:url value="simpleCaptcha.jpg"/>" width="150"><br>
		<form action="captchasubmit.jsp" method="post">
		<input type="text" name="answer" /><br>
		<input type="submit" value="Submit">
		</form>
	</center>
</body>
</html>
