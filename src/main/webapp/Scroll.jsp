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
			$("<h1>���� ��ũ��</h1>").appendTo("body");
		}
	});
	
	$(document).ready(function() {
		//��ũ�� �̺�Ʈ �߻� ��
		$(window).scroll(function() {
			var scrollHeight = $(window).scrollTop() + $(window).height();
			var documentHeight = $(document).height();
			if (scrollHeight = documentHeight) {
				for (var i = 0; i < 20; i++) {
					$("<h2>���� ��ũ��2 </h2>").appendTo("body");
				}
			}
		});
	});
	
</script>
<body>
<!-- <div class="wrdLastest" id=1>�ܵ���</div>
<div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div><div class="wrdLastest" id=2>�ܵ���</div>


<script type="text/javascript">
		function lastPostFunc() {   
		    $('div#lastPostsLoader').html('img src="bigLoader.gif"')
		    $.post("NewFile.jsp?lastID=" + $(".wrdLastest:last").attr("id"),    // �� test.html �������� ���纸������ ����Ʈ�� ���������� ������
		    function(data){ //�� test.html ������������ �������� �̿ܿ� �ٸ� ������ ������ ������ �ܵ��� �ؿ� �������� �ǰ�
		        if (data != "") { 
		            $(".scrolling:last").after(data);            
		        } 
		    	$('div#lastPostsLoader').empty();
		    });
		};
		
		$(window).scroll(function(){ // �� ��ũ�� �̺�Ʈ ���� �߻�
		        if  ($(window).scrollTop() >= $(document).height() - $(window).height()){  //�� ���罺ũ���� ��ġ�� ȭ���� ���̴� ��ġ���� ũ�ٸ�
		            lastPostFunc();    // �� �����ִ� lastPostFunc �̺�Ʈ�� �߻�
		        }
		});

</script> -->
</body>
</html>