<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="</script'>http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
 
 
  
 //��. ó���� ��ũ���� ����� �ϱ� ���ؼ� ������ �־���.
 var dheight = $(document).height();
 var sheight = $(window).scrollTop() + $(window).height();
  
 for(var i=0; i<20; i++){
  $('<h6>���̽��� �Խù�'+$(document).height()+"/"+$(window).scrollTop()+"/"+$(window).height()+'</h6>').appendTo('body');
 } 
 $(window).scroll(function(){
  var dheight = $(document).height();
  var sheight = $(window).scrollTop() + $(window).height();
  
  //��. ��ũ���� �ٴ����� ������ �� <h6>�±׸� 10���߰� =>body
  if(dheight == sheight){
   for (var i = 0; i < 10; i++) {
    //�ڡڡڡڡڹ��� ��ũ�� ���� : docment.height�� ���� ���� ���� ������ ���� (������â ��ũ�� ������ �� + ������â ������ ��) �������� �Խù� ������ �߰����� �Ǿ�����. 
    $('<h6>���̽��� �߰� �Ǿ��� �Խù�'+$(document).height()+"/"+$(window).scrollTop()+"/"+$(window).height()+'</h6>').appendTo('body');
0   }
  }
 });
});
</script>

</head>
<body>
</body>
</html>