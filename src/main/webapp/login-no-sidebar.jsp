<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
   <title>Telephasic by HTML5 UP</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link rel="stylesheet" href="assets/css/main.css" />
      <script src="https://www.google.com/recaptcha/api.js" async defer></script>
      
      <script>
      /* ####################################################로봇인증########################################################## */
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
      /* ####################################################페이스북로그인########################################################## */
      
		function statusChangeCallback(response) {
	 		console.log('statusChangeCallback'); console.log(response); 
	 		// response 객체는 현재 로그인 상태를 나타내는 정보를 보여준다. 
	 		// 앱에서 현재의 로그인 상태에 따라 동작하면 된다. 
	 		// FB.getLoginStatus().의 레퍼런스에서 더 자세한 내용이 참조 가능하다. 
	 		if (response.status === 'connected') { 
	 			// 페이스북을 통해서 로그인이 되어있다. 
	 			<%-- <%pageContext.forward("/layout/mainLayout.jsp"); %> --%>
	 			testAPI(); 
	 			} else if (response.status === 'not_authorized') { 
	 				// 페이스북에는 로그인 했으나, 앱에는 로그인이 되어있지 않다. 
	 				document.getElementById('status').innerHTML = 'Please log ' + 'into this app.'; 
	 			} else { 
	 					// 페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다. 
	 					document.getElementById('status').innerHTML = 'Please log ' + 'into Facebook.'; 
	 			} 
	 		}
		  function checkLoginState() {
			    FB.getLoginStatus(function(response) {
			      statusChangeCallback(response);
			    });
			}
		  
		  window.fbAsyncInit = function() {
			    FB.init({
			      appId      : '349635012119334',
			      cookie     : true,
			   // 쿠키가 세션을 참조할 수 있도록 허용 
			      xfbml      : true,
			   // 소셜 플러그인이 있으면 처리 
			      version    : 'v2.8'
			    });
			    FB.AppEvents.logPageView();   
			  };
		
		  
		  // SDK를 비동기적으로 호출 
		  (function(d, s, id){
		     var js, fjs = d.getElementsByTagName(s)[0];
		     if (d.getElementById(id)) {return;}
		     js = d.createElement(s); js.id = id;
		     js.src = "//connect.facebook.net/en_US/sdk.js";
		     fjs.parentNode.insertBefore(js, fjs);
		   }(document, 'script', 'facebook-jssdk'));
		  
		  
			// 로그인이 성공한 다음에는 간단한 그래프API를 호출한다. 
	 		// 이 호출은 statusChangeCallback()에서 이루어진다. 
	 		function testAPI() { 
	 			console.log('Welcome! Fetching your information.... '); 
	 			FB.api('/me', function(response) { 
	 				console.log(JSON.stringify(response));
	 				console.log('아이디 : ' + response.id);
	 				console.log('Successful login for : ' + response.name); 
	 				
	 				document.getElementById('name').innerHTML = 
	 					'Thanks for logging in, ' + response.name + '!'; 
	 				document.getElementById('id').innerHTML = 
	 					'yourID, ' + response.id + '!'; 
	 			}); 
	 			
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
                           <h2>로그인</h2>
                        </header>
                     </article>
                  </div>
               </div>
            </div>

         <!-- Footer -->
            <div id="promo-wrapper">
               <div id="footer" class="container">
                  
                  <div class="row">
                     <section class="12u">
                        <form method="post" action="/FairMusic/login.do">
                           <div class="row 50%">
                              <div class="12u">
                                 <input name="email" placeholder="아이디" type="text"  id="email"/>
                              </div>
                              <div class="12u">
                                 <input name="pass" placeholder="비밀번호" type="password" id="pass"/>
                              </div>
								<div class="fb-login-button" data-max-rows="1" data-size="large"
									data-button-type="continue_with" data-show-faces="false"
									data-auto-logout-link="true" data-use-continue-as="false"></div>

								<div id="name"></div>
								<br />
								<div id="id"></div>
								
                              <div class="2u 12u" align="right">
                                 <ul class="actions">
                                    <li><input type="submit" value="로그인" /></li>
                                 </ul>
                              </div>
                              <div class="3u 12u">
                                 <input type="button" value="아이디 찾기" data-toggle="modal"
                  data-target="#findidModal"/>
                              </div>
                              <div class="3u 12u">
                                 <input type="button" value="비밀번호 찾기" data-toggle="modal"
                  data-target="#findpassModal"/>
                              </div>
                              <div class="3u 12u">
                                 <a href="regist-no-sidebar.jsp"><input type="button" value="회원가입" /></a>
                              </div>
                              <div class="3u 12u">
                                 <a href="/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp">
                                 <input type="button" value="돌아가기" /></a>
                              </div>
                              
                              <!-- 로봇검증  -->
                              <div class="g-recaptcha"data-sitekey="6LeWpScUAAAAAEZHSU8Ofsqp1B06zp7EZCi1Oem_" style="float: right;"></div>
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
         <script src="assets/js/main.js"></script>
         
         
   <div class="modal fade" id="findidModal" role="dialog">
      <div class="modal-dialog modal-lg">
         <!-- Modal content-->
         <div class="modal-content">
            <div class="modal-body">
               <jsp:include page="/findId.jsp"></jsp:include>
            </div>
            <div class="modal-footer">
               <button>조성원짱짱맨</button>
            </div>
         </div>

      </div>
   </div>
   
      <div class="modal fade" id="findpassModal" role="dialog">
      <div class="modal-dialog modal-lg">
         <!-- Modal content-->
         <div class="modal-content">
            <div class="modal-body">
               <jsp:include page="/findpass.jsp"></jsp:include>
            </div>
            <div class="modal-footer">
               <button>조성원짱짱맨</button>
            </div>
         </div>

      </div>
   </div>



   </body>
</html>