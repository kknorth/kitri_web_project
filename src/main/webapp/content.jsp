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
	
<script type="text/javascript">
	 $(document).ready(function() {
		for (var i = 0; i < 5; i++) {
			$("div#scroll").appendTo("div#bottom");
		}
	}); 

	$(document).ready(function() {
		//스크롤 이벤트 발생 시
		$(window).scroll(function() {
			var scrollHeight = $(window).scrollTop() + $(window).height();
			var documentHeight = $(document).height();
			if (scrollHeight = documentHeight) {
				for (var i = 0; i < 10; i++) {
					$("<img src='/FairMusic/images/M.PNG'>").appendTo("div#content");
				}
			}
		});
	});
</script>
</head>
<body>

<div id ="scroll" class="container">
  <h2>Hear the latest posts from the people you’re following:</h2>
	
	<div class="dropdown">
	
	
	  <img src="/FairMusic/images/sing.PNG" alt="Trolltunga Norway" width="100" height="50">
	  <div class="dropdown-content">
	    <img src="/FairMusic/images/sing.PNG" alt="Trolltunga Norway" width="300" height="200">
	    <div class="caption">
            <a href="MusicUpload/myFMpage.jsp">visit singer profile</a> 
            &nbsp <a><img src="/FairMusic/images/like.PNG" class="img-thumbnail" alt="Cinque Terre" width="20" height="20"></a>
            <br/><a href="#">fllow</a> 
         </div>
	  </div>
	</div>
	<jsp:include page="/widget/temp2widget.jsp"></jsp:include>
	<!-- <div id="mainview">
		<div class="row">
			<div class="12u"><br/>
				<ol class="list-group">					
					<li><a href="MusicUpload/myFMpage.jsp"><img src="/FairMusic/images/M.PNG" class="img-thumbnail" alt="Cinque Terre" width="200" height="200"></a></li><br/>
				</ol>
			</div>
		</div>
	</div> -->
<!-- 	<div id="content">
        <div class="section1"> 
           <ul>
               <li><a href="MusicUpload/myFMpage.jsp"><img src="/FairMusic/images/M.PNG" class="img-thumbnail" alt="Cinque Terre" width="200" height="200"></a></li>
           </ul>
        </div>
    </div> -->
    
</div>
	<div id="bottom"></div>

</body>
</html>