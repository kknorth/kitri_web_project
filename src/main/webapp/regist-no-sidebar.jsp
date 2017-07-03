<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>FairMusic ȸ������</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<script type="text/javascript">
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
                     <h2>ȸ������</h2>
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
                           <input type="button" value="�̸��� Ȯ��" />
                        </div>

                        <div class="12u">
                           <input name="artist_pass" placeholder="��й�ȣ" type="password" id = "artist_pass"/>
                        </div>
                        <div class="12u">
                           <input name="passverify" placeholder="��й�ȣ Ȯ��" type="password" />
                        </div>
                        <div class="12u">
                           <input name="artist_id" placeholder="�̸�" type="text" id = "artist_id"/>
                        </div>

                     </div>
                     <br />

                     <div class="row 50%" style="float: left;">
                        <div class="12u" align="right">
                           <ul class="actions">

                              <li><input type="submit" name="submit" value="ȸ�� ����"
                                  /></li><!-- onclick="FormSubmit()" -->
                              <li><input type="reset" value="���� ���" /></li>
                           </ul>
                        </div>
                     </div>
                     <div class="g-recaptcha"
                        data-sitekey="6LeWpScUAAAAAEZHSU8Ofsqp1B06zp7EZCi1Oem_"
                        style="float: right;"></div>
                     <!-- <div id ="html_element"></div> -->

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

   <!-- Scripts -->

   <script src="assets/js/jquery.min.js"></script>
   <script src="assets/js/jquery.dropotron.min.js"></script>
   <script src="assets/js/skel.min.js"></script>
   <script src="assets/js/util.js"></script>
   <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
   <script src="assets/js/main.js"></script>

</body>
</html>