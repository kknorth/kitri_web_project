<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

   <div id="mainview">
      <div class="row">
      <div class="12u">
      <br/><br/>
       <ol class="list-group">
         <li class="list-group-item disabled">조성원님의 최근 게시글</li>
          <li class="list-group-item">
          
         <jsp:include page="/widget.do" flush="true">
		<jsp:param value="e6ddn02ie17ngn4a1l44" name="audio_code"/>
		</jsp:include>
		 </div>
      </div>
   </div>
</body>

<script type="text/javascript">
// Add contents for max height
		$(document).ready(function () {
			$(document).scroll(function() {
				var maxHeight = $(document).height();
					var currentScroll = $(window).scrollTop() + $(window).height();
					
						if (maxHeight <= currentScroll + 100) {
							$.ajax({
								url:"/widget.do",
								type:"get",
								dataType :"html",
								success :success_run,
								error :err_run
							})
						}
				})
		});
		function success_run(txt) {
			$("#mainview").html("어렵다 ㅅㅂjquery:"+txt)		
		}
</script>
</html>