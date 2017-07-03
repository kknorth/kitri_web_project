<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
   <title>Telephasic by HTML5 UP</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <link rel="stylesheet" href="assets/css/main.css" />
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
                        <form method="post" action="#">
                           <div class="row 50%">
                              <div class="12u">
                                 <input name="id" placeholder="���̵�" type="text" />
                              </div>
                              <div class="12u">
                                 <input name="pass" placeholder="��й�ȣ" type="password" />
                              </div>
                              <div class="5u 12u">
                                 <input type="image" src="images/loginbtn_google.png" width="60%">
                              </div>
                              <div class="5u 12u">
                                 <input type="image" src="images/loginbtn_facebook.png" width="60%">
                              </div>
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
                                 <a href="/FairMusic/view.do?leftpath=Side_Left.jsp&viewpath=../content.jsp&rightpath=Side_Right.jsp"><input type="button" value="���ư���" /></a>
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