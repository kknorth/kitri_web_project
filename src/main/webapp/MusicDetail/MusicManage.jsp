<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ page import="com.fairmusic.dto.*" %>
   <%@ page import="com.blocko.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<style type="text/css">
   .row{
      background-image: url("/FairMusic/images/back.jpg");
   }
</style>
<body>
<% audioDTO audiodto = (audioDTO)request.getAttribute("audiodto"); %>

  <div class="row">
    <div class="col-lg-12">
   	<h1><%= audiodto.getAudio_title() %></h1>
    </div>
  </div>
  <div class="row">
    <div class="col-lg-4"></div>
    이름
    <div class="col-lg-4"></div>
    비트코인 계좌
    <div class="col-lg-4"></div>
  수익 비율
  </div>
  <% BitcoinAdressDTO bitdto = (BitcoinAdressDTO)request.getAttribute("bitaddrdto");  %>
  <%if (bitdto!= null){ %>
  <div class="row">
    <div class="col-lg-4">저작권자</div>
    <div class="col-lg-4">비트코인 주소</div>
    <div class="col-lg-4">수익비율</div>
    
  </div>
  
  <div class="row">
    <div class="col-lg-12"></div>

  </div>
  <%}else{ %>
  <div class="row">
    <div class="col-lg-12"><h1>이 음원은 0원입니다.</h1></div>
  </div>
  <%} %>
   <div class="row">
    <div class="col-lg-12">
    판매 현황 : 
    가격 : 
    </div>
  </div>
 <div class="row">
    <div class="col-lg-12">
    <input type = "button" value = "DELETE" onclick = "/FairMusic/audiodel.do?audio_code=<%=audiodto.getAudio_code()%>"/>
    
    </div>
  </div>

</body>
</html>