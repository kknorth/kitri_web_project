<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/main.css" />
</head>
<body>
   <jsp:include page="../top_Logout.jsp"></jsp:include>
   <div class="container-fluid text-center">
      <div class="row">
      <% if(request.getAttribute("leftpath")!=null){ %>
         <div class="col-sm-3">
         <%System.out.println("연결할 leftSide이름=>"+request.getAttribute("leftpath")); %>
         
            <jsp:include page="${leftpath}"></jsp:include>
            
         </div>
         <%}else{System.out.println("레프트 사이드 없어");} %>
         <div class="col-sm-6">
            <%System.out.println("연결할 mainview이름=>"+request.getAttribute("viewpath")); %>
            <jsp:include page="${viewpath}"></jsp:include>
         </div>
         <%System.out.println("연결할 rightSide이름=>"+request.getAttribute("rightpath")); %>
         <div class="col-sm-3">
            
            <%if(request.getAttribute("rightpath")!=null){ %>
            <jsp:include page="${rightpath}"></jsp:include>
            
         </div>
         <%}else{System.out.println("라이트 사이드 없어");} %>
      </div>
   </div>
   <!-- Scripts -->

         <script src="assets/js/jquery.min.js"></script>
         <script src="assets/js/jquery.dropotron.min.js"></script>
         <script src="assets/js/skel.min.js"></script>
         <script src="assets/js/util.js"></script>
         <script src="assets/js/main.js"></script>      
</body>
</html>