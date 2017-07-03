<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Collection.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="Collection.css">
</head>
<body>
	<header>
	 <br/>
        <jsp:include page="../CollectionTop.jsp"></jsp:include>
        <div class="label">hear what the people you follow : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" size = "30" value ="filter" style = "text-align:center; color:#cccccc;">
        <br/><br/>
		</div>
	 </header>
		<div id="content">
		        <div class="section6">
		            <div class="following_product">
		                <ul>
		                    <li><a href="#" alt="">following</a></li>
		                    <li><a href="#" alt="">following</a></li>
		                    <li><a href="#" alt="">following</a></li>
		                    <li><a href="#" alt="">following</a></li>
		                    <li><a href="#" alt="">following</a></li>
		                    <li><a href="#" alt="">following</a></li>
		                </ul>
		            </div>   
		        </div>
		 </div>
</body>
</html>