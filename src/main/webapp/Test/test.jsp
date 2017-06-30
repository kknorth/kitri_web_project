<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<script src="</script'>http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
 
 
  
 //ㄱ. 처음에 스크롤이 생기게 하기 위해서 내용을 넣어줌.
 var dheight = $(document).height();
 var sheight = $(window).scrollTop() + $(window).height();
  
 for(var i=0; i<20; i++){
  $('<h6>페이스북 게시물'+$(document).height()+"/"+$(window).scrollTop()+"/"+$(window).height()+'</h6>').appendTo('body');
 } 
 $(window).scroll(function(){
  var dheight = $(document).height();
  var sheight = $(window).scrollTop() + $(window).height();
  
  //ㄴ. 스크롤이 바닥으로 내렸을 때 <h6>태그를 10개추가 =>body
  if(dheight == sheight){
   for (var i = 0; i < 10; i++) {
    //★★★★★무한 스크롤 공식 : docment.height의 현재 문서 실제 높이의 값과 (윈도우창 스크롤 높이의 값 + 윈도우창 높이의 값) 같아지면 게시물 내용이 추가가가 되어진다. 
    $('<h6>페이스북 추가 되어진 게시물'+$(document).height()+"/"+$(window).scrollTop()+"/"+$(window).height()+'</h6>').appendTo('body');
0   }
  }
 });
});
</script>

</head>
<body>
</body>
</html>