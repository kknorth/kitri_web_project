<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>BitcoinSend</h3>
	<form method="post" action="/FairMusic/bitcoinsend">
		<div>����</div>
		<input type = "text" name="bitcoin" placeholder="bitcoin value"><br/>
		<input type = "text" name="fee" placeholder="fee value"><br/>
		<input type = "text" name="toAddress" placeholder="toBitcoinAddress"><br/>
		
		<input type = "submit" value ="BitcoinSend"><br/>
		��Ʈ���� �ּ� ==> ${MusicAddress}<br/>
		���� ��Ʈ���� �ܰ� ==>${balance} BTC <br/>
		
	</form>
</body>
</html>