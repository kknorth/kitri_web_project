<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<body>
<div class="row">
  <div class="col-lg-12"><span class="label label-info">비밀번호 찾기</span></div>
  <div class="col-lg-12">
  <span class="label label-info">아이디</span>
<input type="text" name="textfield" id="textfield">
  </div>
  <div class="col-lg-12">
<span class="label label-info">이메일</span>
<input type="text" name="textfield" id="textfield">
&nbsp;</div>
  <div class="col-lg-12">
    <button type="button" class="btn btn-lg btn-default">ㄱㄱㄱ</button>
  &nbsp;</div>
  
   존재하는 이메일인지 select
 if존재하면 그 이메일로 이메일 검증할때 쓰는 코드 보내
 코드는 비밀번호 update문으로 수정 -db
 
 비밀번호는 인증번호처럼 임시비밀번호를 전송해서 발송 후 id값 파라미터로 받고 비밀번호 입력시 update문 
 
 
</div>
</body>
</body>
</html>