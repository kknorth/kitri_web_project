<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>FairMusic 회원가입</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#artist_email").on("keyup", function(){
			$.post("/FairMusic/emailCheck.do", {"artist_email":$("#artist_email").val()}, success_run)
		})
		
		$("#email_verify").on("click", function(){
			$.post("/FairMusic/email", {"artist_email": $("#artist_email").val()}, success_email)
		})
		
		$("#email_verify_check").on("click", function(){
			alert($("#authnum_check").val())
			$.post("/FairMusic/email_check.do", {"authnum_check" : $("#authnum_check").val()}, success_eamil_check)
			
		})
		$("#artist_pass2").on("keyup", function(){
			if($("#artist_pass").val()!=$("#artist_pass2").val()){
				$("#artist_pass_check").html("비밀번호가 일치하지 않습니다.")
			}else{
				$("#artist_pass_check").html("");
			}
		})
		
		$("#artist_pass").on("keyup", function(){
			if($("#artist_pass").val()!=$("#artist_pass2").val()){
				$("#artist_pass_check").html("비밀번호가 일치하지 않습니다.")
			}else{
				$("#artist_pass_check").html("");
			}
		})

	})
	
	function success_eamil_check(txt){
		$("#email_verify_result").html(txt);
	}
	function success_email(txt){
	/* 	$("#eamiltest").html("이메일이 전송되었습니다."); */
	}
	
	function success_run(txt){
		$("#artist_email_check").html(txt)
	}
   function FormSubmit() {
      if (grecaptcha.getResponse() == "") {
         alert("로봇이 아님을 체크해 주세요.");
         return false;
      } else {
         return true;
      }

      if (typeof (greCAPTCHA != 'undefined')) {
         if (greCAPTCHA.getResponsc() == "") { //서버단에서 한번 더 체크, 
         // 사용자가 인증하는 순간 구글의 서버로 부터 토큰 부여받음 
            alert("스팸방지코드를 확인해 주세요.");
            return false;
         }
      } else {
         return false;
      }
   }
  
</script>

</head>
<body class="no-sidebar">
   <div id="page-wrapper">

      <!-- Main -->
      <div id="header-wrapper">
         <div class="container" id="main">
            <div class="\35 0\25">
               <!-- Content -->
               <article id="content">
                  <header>
                     <h2>회원가입</h2>
                  </header>
               </article>
            </div>
         </div>
      </div>

      <!-- Footer -->
      <div id="footer-wrapper">
         <div id="footer" class="container">

            <div class="row">
               <section class="12u">
                  <form method="post" action="/FairMusic/artistregist.do" onsubmit="FormSubmit()">
                     <div class="row 50%">
                        <div class="5u 12u">
                           <input type="image" src="images/facebookRegister.png"
                              width="100%">
                        </div>
                        <div class="5u 12u">
                           <input type="image" src="images/googleRegister.png"
                              width="100%">
                        </div>

                        <div class="9u 12u">
                           <input name="artist_email" placeholder="E-mail" type="text" id = "artist_email"/>
                        </div>
                        <div class="3u 12u">
                          <input type="button" value="이메일 인증하기"  data-toggle="modal" data-target="#findidModal" id="email_verify"/>
                        </div>
                         <div class="12u">
                          	<span id="artist_email_check" style="color: red"></span>
                        </div>

                        <div class="12u">
                           <input name="artist_pass" placeholder="비밀번호" type="password" id = "artist_pass"/>
                        </div>
                        <div class="12u">
                           <input name="passverify" placeholder="비밀번호 확인" type="password" id="artist_pass2" />
                        </div>
                        <div id="artist_pass_check" style= "color: red"></div>
                        <div class="12u">
                           <input name="artist_id" placeholder="이름" type="text" id = "artist_id"/>
                        </div>

                     </div>
                     <br />
                     <div class="row 50%" style="float: left;">
                        <div class="12u" align="right">
                           <ul class="actions">

                              <li><input type="submit" name="submit" value="회원 가입"
                                  /></li>
                              <li><a href="/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp"><input type="button" value="가입 취소" /></a></li>
                           </ul>
                        </div>
                     </div>
                     <div class="g-recaptcha"
                        data-sitekey="6LeWpScUAAAAAEZHSU8Ofsqp1B06zp7EZCi1Oem_"
                        style="float: right;"></div>
                     

                  </form>
               </section>
            </div>
         </div>
         <div id="copyright" class="container">
            <ul class="menu">
               <li>&copy; Untitled. All rights reserved.</li>
               <li>Design: <a href="#">FariMusic</a></li>
            </ul>
         </div>
      </div>

   </div>

   <div class="modal fade" id="findidModal" role="dialog">
      <div class="modal-dialog modal-lg">
         <!-- Modal content-->
      <div class="modal-content">
         <div class = "modal-header">
         <h3>이메일이 전송되었습니다.</h3>
      </div>
        <div class = "modal-body">
	      <div class="row">
				<div class="col-lg-12">
					<span class="label label-info">이메일 검증</span>
					<span id="email_verify_result" style="color: red"></span>
				</div>
				<div class="col-lg-12">
					<span class="label label-info">인증번호 7자리를 입력하세요</span> 
					<input type="text" name="authnum"  id="authnum_check"/>
					<span id="authnum_check_result"></span>
				</div>
				<div class="col-lg-12">
					<button type="submit" class="btn btn-lg btn-default" id="email_verify_check">확인</button>
				</div>
				
			</div>
			
        </div>
        <div class="modal-footer">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> Save changes</button>      
        </div>
      </div>
      </div>
   </div>
   


   <!-- Scripts -->

   <script src="assets/js/jquery.min.js"></script>
   <script src="assets/js/jquery.dropotron.min.js"></script>
   <script src="assets/js/skel.min.js"></script>
   <script src="assets/js/util.js"></script>
   <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
   <script src="assets/js/main.js"></script>

</body>
</html>