<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		for (var i = 0; i < 10; i++) {
			$("<h1>무한 스크롤</h1>").appendTo("body");
		}
	});
	
	$(document).ready(function() {
		//스크롤 이벤트 발생 시
		$(window).scroll(function() {
			var scrollHeight = $(window).scrollTop() + $(window).height();
			var documentHeight = $(document).height();
			if (scrollHeight = documentHeight) {
				for (var i = 0; i < 20; i++) {
					$("<h2>무한 스크롤2 </h2>").appendTo("body");
				}
			}
		});
	});
	
</script>
<body>
<!-- <div class="wrdLastest" id=1>콘덴츠</div>
<div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div><div class="wrdLastest" id=2>콘덴츠</div>


<script type="text/javascript">
		function lastPostFunc() {   
		    $('div#lastPostsLoader').html('img src="bigLoader.gif"')
		    $.post("NewFile.jsp?lastID=" + $(".wrdLastest:last").attr("id"),    // ④ test.html 페이지로 현재보여지는 리스트의 마지막값을 보내고
		    function(data){ //⑤ test.html 페이지에서는 마지막값 이외에 다른 값들이 있으면 마지막 콘덴츠 밑에 보여지게 되고
		        if (data != "") { 
		            $(".scrolling:last").after(data);            
		        } 
		    	$('div#lastPostsLoader').empty();
		    });
		};
		
		$(window).scroll(function(){ // ① 스크롤 이벤트 최초 발생
		        if  ($(window).scrollTop() >= $(document).height() - $(window).height()){  //② 현재스크롤의 위치가 화면의 보이는 위치보다 크다면
		            lastPostFunc();    // ③ 위에있는 lastPostFunc 이벤트를 발생
		        }
		});

</script> -->
</body>
</html>