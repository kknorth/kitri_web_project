<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="css/main.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="header-wrapper">
		<form action="#" name="mainform">
		<div id="header" class="container">
			<nav id="nav">
				<ul>
				
				
				
	   <% EmpDTO user = (EmpDTO) session.getAttribute("user"); %>
       <%if(session.getAttribute("user")==null) {%> 
				<li><a href="index.jsp" >FairMusic</a></li>
				<li><a href="/FairMusic/view.do?viewpath=../Collection.jsp" >Collection</a></li>
				<li><input type="text" size="40" /></li>
				<li><input type="submit" value="search"/></li>
				<li><a href="#">Login</a></li>
				<li><a href="#">Create Account</a></li>
      	   <%}else{ %>
				<li><a href="index.jsp" >FairMusic</a></li>
				<li><a href="/FairMusic/view.do?viewpath=../Collection.jsp" >Collection</a></li>
				<li><input type="text" size="40" /></li>
				<li><input type="submit" value="search"/></li>
				<li><a href="#">Upload</a></li>
				<li><a class="dropdown-toggle" data-toggle="dropdown" href="#">user</a>
					<ul>
						<li><a href="#">Mypage</a></li>
						<li><a href="#">Likes</a></li>
						<li><a href="#">PlayList</a></li>
						<li><a href="#">Following</a></li>
						<li><a href="#">Tracks</a></li>
					</ul>
				</li>
							
				<li><a href="#">Message</a></li>
				<li><a href="#">Logout</a></li>
      	   <%} %>

	
				</ul>
							</nav>
						
						</div>
						</form>
					</div>
	<!-- Scripts -->

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>								
</body>
</html> --%>