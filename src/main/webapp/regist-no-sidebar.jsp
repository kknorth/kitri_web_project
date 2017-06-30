<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<title>Telephasic by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<!-- <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer></script> -->
		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
		<script type="text/javascript">
			/* var onloadCallback = function(){
				greCAPTCHA.render('html_element',{
					'siteKey':'6LembScUAAAAAKz63gwf9DihVKJAY_1ExV40ph72',
					'theme':'light'
				});
			};
			if(typeof(greCAPTCHA!='undefined')){
				if(greCAPTCHA.getResponsc()==""){ //서버단에서 한번 더 체크,
												// 사용자가 인증하는 순간 구글의 서버로 부터 토큰 부여받음
					alert("스팸방지코드를 확인해 주세요.");
					return false;
				}
			}else{
				return false;
			} */
			$.ajax({
				url : '/member/captchaAjax',
				type : 'post',
				data : {
					recaptcha : document.getElementById("g-recaptcha-response").value
				},
				success : function(data){
					
					//성공여부
				}
			});
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
								<form method="post" action="/FairMusic/mailtest.do">
									<div class="row 50%">
										<div class="5u 12u">
											<input type="image" src="images/facebookRegister.png" width="100%">
										</div>
										<div class="5u 12u">
											<input type="image" src="images/googleRegister.png" width="100%">
										</div>
										<div class="12u">
											<input name="id" placeholder="E-mail" type="text" />
										</div>
										
										<div class="9u 12u">
											<input name="email" placeholder="E-mail" type="text" />
										</div>
										<div class="3u 12u">
											<input type="button" value="이메일 확인" />
										</div>
										
										<div class="12u">
											<input name="pass" placeholder="비밀번호" type="password" />
										</div>
										<div class="12u">
											<input name="pass" placeholder="비밀번호 확인" type="password" />
										</div>
										<div class="12u">
											<input name="name" placeholder="이름" type="text" />
										</div>
										
									</div>
									
									<!-- <div id ="html_element"></div> -->
									<div class="g-recaptcha" data-sitekey="${siteKey}"></div>
									
									
									<div class="row 50%">
										<div class="12u" align="right">
											<ul class="actions">												
												<li><input type="submit" value="회원 가입" /></li>
												<li><input type="reset" value="가입 취소" /></li>
											</ul>
										</div>
									</div>
								</form>
							</section>
						</div>
					</div>
					<div id="copyright" class="container">
						<ul class="menu">
							<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="#">FariMusic</a></li>
						</ul>
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