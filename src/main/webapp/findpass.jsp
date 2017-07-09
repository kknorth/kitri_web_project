<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript">
	$(document).ready(function(){
  		$("#email_verify_pass").on("click", function(){
  		 	if($("#artist_email").val()==""){
  				alert("이메일을 입력해 주세요")	
  			}else{
  				 $.post("/FairMusic/passFind.do", {"artist_email": $("#artist_email").val()}, success_email) 
  			} 
  		})
  		
/*   		$("#email_verify_pass_check").on("click", function(){
  			alert($("#authnum_check").val())
			$.post("/FairMusic/pass_update.do", {"authnum_check" : $("#authnum_check").val()}, success_eamil_check)
  		}) */
  	})
  	function success_email(text){
  		$("#artist_email_check").html(text);
  	}

  </script>
</head>
<body>
<body>
<div class="row">
  <div class="col-lg-12"><span class="label label-info">비밀번호 찾기</span></div>
  <div class="col-lg-12">
<span class="label label-info">이메일</span>
<input type="text" name="textfield" id="artist_email">
<button type="button" class="btn btn btn-default" id="email_verify_pass"  >임시비밀번호 전송하기</button>
<span id="artist_email_check" style="color: red"></span>
 <div class="col-lg-12">
 <br/>
<button type="button" class="btn btn btn-default" id="login" onclick="location.href='/FairMusic/login-no-sidebar.jsp'" >로그인 화면으로 돌아가기</button>
 
 </div>
  

&nbsp;</div>
<!--   <div class="col-lg-12">
  <span class="label label-info">인증번호</span>
  <input type="text" name="textfield" id="authnum_check">
  <span id="artist_email_check" style="color: red"></span>
    <button type="button" class="btn btn btn-default" id="email_verify_pass_check">인증번호 확인</button>    
    &nbsp;</div>
      <div class="col-lg-12">
  	<span id="email_verify_result" style="color: red"></span>
 	 </div> -->
 
 
</div>
</body>
</body>
</html>