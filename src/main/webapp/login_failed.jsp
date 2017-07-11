<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
   <title>Telephasic by HTML5 UP</title>
      <meta charset="utf-8" />
      <meta name="google-signin-scope" content="profile email">
      <meta name="google-signin-client_id" content="858926206600-4civml71qto6t35fd8hvosi4so9ku55e.apps.googleusercontent.com">
	  <link rel="stylesheet" href="assets/css/main.css" />
      <script src="https://www.google.com/recaptcha/api.js" async defer></script>
      <script src="https://apis.google.com/js/platform.js" async defer></script> 
     <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
     <meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width" />
      <script>
      /* ####################################################�κ�����########################################################## */
	      function FormSubmit() {
	          if (grecaptcha.getResponse() == "") {
	             alert("�κ��� �ƴ��� üũ�� �ּ���.");
	             return false;
	          } else {
	             return true;
	          }
	
	          if (typeof (greCAPTCHA != 'undefined')) {
	             if (greCAPTCHA.getResponsc() == "") { //�����ܿ��� �ѹ� �� üũ, 
	             // ����ڰ� �����ϴ� ���� ������ ������ ���� ��ū �ο����� 
	                alert("���Թ����ڵ带 Ȯ���� �ּ���.");
	                return false;
	             }
	          } else {
	             return false;
	          }
	       }
      /* ####################################################���̽��Ϸα���########################################################## */
      
		function statusChangeCallback(response) {
	 		console.log('statusChangeCallback'); console.log(response); 
	 		// response ��ü�� ���� �α��� ���¸� ��Ÿ���� ������ �����ش�. 
	 		// �ۿ��� ������ �α��� ���¿� ���� �����ϸ� �ȴ�. 
	 		// FB.getLoginStatus().�� ���۷������� �� �ڼ��� ������ ���� �����ϴ�. 
	 		if (response.status === 'connected') { 
	 			// ���̽����� ���ؼ� �α����� �Ǿ��ִ�. 
	 			<%-- <%pageContext.forward("/layout/mainLayout.jsp"); %> --%>
	 			testAPI(); 
	 			} else if (response.status === 'not_authorized') { 
	 				// ���̽��Ͽ��� �α��� ������, �ۿ��� �α����� �Ǿ����� �ʴ�. 
	 				document.getElementById('status').innerHTML = 'Please log ' + 'into this app.'; 
	 			} else { 
	 					// ���̽��Ͽ� �α����� �Ǿ����� �ʴ�. ����, �ۿ� �α����� �Ǿ��ִ��� ���ΰ� ��Ȯ���ϴ�. 
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
			   // ��Ű�� ������ ������ �� �ֵ��� ��� 
			      xfbml      : true,
			   // �Ҽ� �÷������� ������ ó�� 
			      version    : 'v2.8'
			    });
			    FB.AppEvents.logPageView();   
			  };
		
		  
		  // SDK�� �񵿱������� ȣ�� 
		  (function(d, s, id) {
  			var js, fjs = d.getElementsByTagName(s)[0];
 			 if (d.getElementById(id)) return;
 			 js = d.createElement(s); js.id = id;
 			 js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.9&appId=148079569074801";
 			 fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
		  
		  
			// �α����� ������ �������� ������ �׷���API�� ȣ���Ѵ�. 
	 		// �� ȣ���� statusChangeCallback()���� �̷������. 
	 		function testAPI() { 
	 			console.log('Welcome! Fetching your information.... '); 
	 			FB.api('/me', function(response) { 
	 				console.log(JSON.stringify(response));
	 				console.log('���̵� : ' + response.id);
	 				console.log('Successful login for : ' + response.name); 
	 				
	 				document.getElementById('name').innerHTML = 
	 					'Thanks for logging in, ' + response.name + '!'; 
	 				document.getElementById('id').innerHTML = 
	 					'yourID, ' + response.id + '!'; 
	 			}); 
	 			
	 		}

	</script>
	<!-- īī���� ���� -->
<script type='text/javascript'>
    Kakao.init('2c01299435b34c747838e7271ed23461');
    function loginWithKakao() {
		Kakao.Auth.login({
			throughTalk : false,
			success: function(authObj) {
				/* alert(JSON.stringify(authObj)); */
		        Kakao.API.request({
		          url: '/v1/user/me',
		          success: function(res) {
		            /* alert(JSON.stringify(res)); */
		          },
		          fail: function(error) {
		            alert(JSON.stringify(error));
		          }
		        });
		         if(authObj){
	      			 location.href='/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp';
	    		}
		      },
		      fail: function(err) {
		        alert(JSON.stringify(err));
		      }
		    });
		};
	function logoutWithKakao() {
		Kakao.Auth.logout(function(e){
    		if(e){
      			 location.href='login-no-sidebar.jsp';
    		}
    	});
	};
	function afterloginfacebook(){
		/* alert("login facebook?"); */
		location.href='/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp';
	};
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
                           <h2>�α���</h2>
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
                        <form method="post" action="/FairMusic/login.do">
                           <div class="row 50%">
                              <div class="12u">
                              		<span style="color: red"> ��ġ�ϴ� ������ �����ϴ�. �ٽ� �õ����ּ���.</span><br/><br/>
                                 <input name="email" placeholder="���̵�" type="text"  id="email" style="color: black;"/>
                              </div>
                              <div class="12u">
                                 <input name="pass" placeholder="��й�ȣ" type="password" id="pass" style="color: black;"/>
                              </div>
                              
                              <!-- facebook########################### -->
								<div class="fb-login-button" data-max-rows="1" data-size="large"
									data-button-type="continue_with" data-show-faces="false"
									data-auto-logout-link="true" data-use-continue-as="false" data-scope="public_profile,email" onlogin="afterloginfacebook();"></div>
								<!-- kakao########################### -->
								<div>
								<a id="custom-login-btn" href="javascript:loginWithKakao()">
										<img
										src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg"
										width="260" />
									</a>
								</div>	
								<div>
									<a href="javascript:logoutWithKakao()">kakao logout</a>
								</div>
								
								<!-- google########################### -->
								<div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark"></div>
								<script>
								      function onSignIn(googleUser) {
								    	var login="";
								        // Useful data for your client-side scripts:
								        var profile = googleUser.getBasicProfile();
								        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
								        console.log('Full Name: ' + profile.getName());
								        console.log('Given Name: ' + profile.getGivenName());
								        console.log('Family Name: ' + profile.getFamilyName());
								        console.log("Image URL: " + profile.getImageUrl());
								        console.log("Email: " + profile.getEmail());
									 	name = profile.getGivenName();
								        Email = profile.getEmail();
								        id = profile.getId();
								        if(name!=null && Email!=null && id!=null){
								        	loginUser_google = "success";
								        }else{
								        	loginUser_google = null;
								        }
								         
								   		  /*  document.getElementById('ID').innerHTML = 
												'Thanks for logging in, ' + profile.getId() + '!'; 
											document.getElementById('Full Name').innerHTML = 
												'name, ' + profile.getName() + '!'; 
											document.getElementById('Email').innerHTML = 
												'yourEmailID, ' + profile.getEmail() + '!'; 
								        // The ID token you need to pass to your backend:
								        var id_token = googleUser.getAuthResponse().id_token;
								        console.log("ID Token: " + id_token); */
								        location.href="/FairMusic/login_google.do?loginUser_google="+loginUser_google;
								      };
								      function signOut() {
								  	    var auth2 = gapi.auth2.getAuthInstance();
								  	    auth2.signOut().then(function () {
								  	      console.log('User signed out.');
								  	    });
								  	  };
								    </script>
								    
								 	 <a href="#" onclick="signOut();">Sign out</a>
								 <!-- google########################### -->
	
	
								<div id="name"></div>
								<br />
								<div id="id"></div>
								
                              <div class="2u 12u" align="right">
                                 <ul class="actions">
                                    <li><input type="submit" value="�α���" /></li>
                                 </ul>
                              </div>
                              <div class="3u 12u">
                                 <input type="button" value="���̵� ã��" data-toggle="modal"
                  data-target="#findidModal" />
                              </div>
                              <div class="3u 12u">
                                 <input type="button" value="��й�ȣ ã��" data-toggle="modal"
                  data-target="#findpassModal" />
                              </div>
                              <div class="3u 12u">
                                 <input type="button" value="ȸ������" onclick="location.href='regist-no-sidebar.jsp'"/>
                              </div>
                              <div class="3u 12u">
                                 <input type="button" value="���ư���" onclick="location.href='/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp'"/>
                              </div>
                              
                              <!-- �κ�����  -->
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
               <button>������¯¯��</button>
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
               <button>������¯¯��</button>
            </div>
         </div>

      </div>
   </div>



   </body>
</html>