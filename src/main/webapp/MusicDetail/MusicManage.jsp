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
    �̸�
    <div class="col-lg-4"></div>
    ��Ʈ���� ����
    <div class="col-lg-4"></div>
  ���� ����
  </div>
  <% BitcoinAdressDTO bitdto = (BitcoinAdressDTO)request.getAttribute("bitaddrdto");  %>
  <%if (bitdto!= null){ %>
  <div class="row">
    <div class="col-lg-4">���۱���</div>
    <div class="col-lg-4">��Ʈ���� �ּ�</div>
    <div class="col-lg-4">���ͺ���</div>
    
  </div>
  
  <div class="row">
    <div class="col-lg-12"></div>

  </div>
  <%}else{ %>
  <div class="row">
    <div class="col-lg-12"><h1>�� ������ 0���Դϴ�.</h1></div>
  </div>
  <%} %>
   <div class="row">
    <div class="col-lg-12">
    �Ǹ� ��Ȳ : 
    ���� : 
    </div>
  </div>
 <div class="row">
    <div class="col-lg-12">
    <input type = "button" value = "DELETE" onclick = "/FairMusic/audiodel.do?audio_code=<%=audiodto.getAudio_code()%>"/>
    
    </div>
  </div>

</body>
</html>