<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<style>
.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.desc {
	padding: 15px;
	text-align: center;
}

#content .section1 div {
	margin-top: 10px;
	height: 300px;
	text-align: center;
}

#content .music_product ul li {
	list-style: none;
	float: left;
	margin: 0 15px 0 0;
	width: 200px;
	height: 200px;
	border: 1px solid #cccccc;
	box-sizing: border-box;
	cursor: pointer;
}
</style>
</head>
<body>

<div id="mainview">
      <div class="row">
      <div class="12u">
      <br/><br/>
       <ol class="list-group">
         <li class="list-group-item disabled">���������� �ֱ� �Խñ�</li>
          <li class="list-group-item">
<%--<a href= "/FairMusic/widget.do">����->��</a>
         <jsp:include page ="/widget.do"></jsp:include> --%>
         
         <a href= "/widget/fmWidget.jsp">��->����</a>
<%--          <jsp:include page ="/widget/fmWidget.jsp">
         <jsp:param value="e6ddn02ie17ngn4a1l44" name="audio_code"/>
         </jsp:include> --%>
         <%-- <jsp:include page="/widget/temp2widget.jsp"></jsp:include> --%>
          </li>
          <li class="list-group-item disabled">��������� �ֱ� �Խñ�</li>
          <li class="list-group-item">
          <a href="#"><img src="/FairMusic/images/M.PNG" class="img-thumbnail" alt="Cinque Terre" width="200" height="200"></a>
          <a href="#">������</a>-<a href="#"> �ȳȼ�</a>
          <a href="#"><img src="/FairMusic/images/like.PNG" class="img-thumbnail" alt="Cinque Terre" width="20" height="20"></a>
          <a href="#"><img src="/FairMusic/images/like.PNG" class="img-thumbnail" alt="Cinque Terre" width="20" height="20"></a>
          <a href="#"><img src="/FairMusic/images/like.PNG" class="img-thumbnail" alt="Cinque Terre" width="20" height="20"></a>
          </li>
          <li class="list-group-item disabled">���ؿ����� �ֱ� �Խñ�</li>
          <li class="list-group-item">
          <a href="#"><img src="/FairMusic/images/M.PNG" class="img-thumbnail" alt="Cinque Terre" width="200" height="200"></a>
          <a href="#">������</a>-<a href="#"> ���ڼ�</a>
          <a href="#"><img src="/FairMusic/images/like.PNG" class="img-thumbnail" alt="Cinque Terre" width="20" height="20"></a>
          <a href="#"><img src="/FairMusic/images/like.PNG" class="img-thumbnail" alt="Cinque Terre" width="20" height="20"></a>
          <a href="#"><img src="/FairMusic/images/like.PNG" class="img-thumbnail" alt="Cinque Terre" width="20" height="20"></a>
          </li>      
          
      </ol>
      </div>
      </div>
   </div>
</body>
</html>