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
		  (function(d, s, id){
		     var js, fjs = d.getElementsByTagName(s)[0];
		     if (d.getElementById(id)) {return;}
		     js = d.createElement(s); js.id = id;
		     js.src = "//connect.facebook.net/en_US/sdk.js";
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
            <div id="promo-wrapper">
               <div id="footer" class="container">
                  
                  <div class="row">
                     <section class="12u">
                        <form method="post" action="/FairMusic/login.do">
                           <div class="row 50%">
                              <div class="12u">
                                 <input name="email" placeholder="���̵�" type="text"  id="email"/>
                              </div>
                              <div class="12u">
                                 <input name="pass" placeholder="��й�ȣ" type="password" id="pass"/>
                              </div>
								<div class="fb-login-button" data-max-rows="1" data-size="large"
									data-button-type="continue_with" data-show-faces="false"
									data-auto-logout-link="true" data-use-continue-as="false"></div>

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
                  data-target="#findidModal"/>
                              </div>
                              <div class="3u 12u">
                                 <input type="button" value="��й�ȣ ã��" data-toggle="modal"
                  data-target="#findpassModal"/>
                              </div>
                              <div class="3u 12u">
                                 <a href="regist-no-sidebar.jsp"><input type="button" value="ȸ������" /></a>
                              </div>
                              <div class="3u 12u">
                                 <a href="/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp">
                                 <input type="button" value="���ư���" /></a>
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