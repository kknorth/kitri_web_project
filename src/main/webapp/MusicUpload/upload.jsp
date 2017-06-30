<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

    <link href="assets/css/bootstrap-ko.css" rel="stylesheet">
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="assets/css/docs-ko.css" rel="stylesheet">
    <link href="assets/js/google-code-prettify/prettify.css" rel="stylesheet">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<!-- <a href ="#myModal" role = "button" class = "btn" data-toggle="modal">모달 시작</a>


<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<div class = "modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h3>UPLOAD</h3>
</div>
<div>
<div class = "modal-body">
<h3> 파일 업로드에 동의하십니까?</h3>
<input type = "checkbox" id = "accept"/>
</div>
<div class = "modal-footer">

<button type ="button" class = "btn btn-info">음원</button>
<button type ="button" class = "btn btn-info">앨범</button><br/>

<button type = "button" class = "btn btn-info">다음</button>
</div>

</div>
</div> -->

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <h3 id="myModalLabel">모달 제목</h3>
            </div>
            <div class="modal-body">
              <h4>모달 속 본문</h4>
              <p>어느 틈에 기만이가 언덕을 내려와서 영신이가 앉은 맞은편 논둑에 가 버티고 섰다.</p>

              <h4>모달 속 팝오버</h4>
              <p>이 <a href="#" role="button" class="btn popover-test" title="제목" data-content="그리고 여기 놀라운 내용이 있다. 정말 마음에 들죠?">버튼</a>을 클릭하면 팝오버가 나타난다.</p>

              <h4>모달 속 툴팁</h4>
              <p><a href="#" class="tooltip-test" title="툴팁">이 링크</a>와 <a href="#" class="tooltip-test" title="툴팁">저 링크</a>는 마우스를 올리면 툴팁이 나타난다.</p>

              <hr>

              <h4>한 줄이 넘어가서 선택적인 스크롤 막대를 보이는 본문</h4>
              <p>우리는 <code>.modal-body</code>의 <code>max-height</code>를 고정했다. 한 줄이 넘어가는 본문을 줄바꿈한 결과를 보라.</p>
              <p>두 사람은 나란히 서서 기만의 등뒤를 돌아 멀리 바다가 내려다보이는 언덕으로 올라갔다. 논과 밭이 눈앞에 질펀히 깔렸는데 여기저기서 두레로 물을 푸는 소리와 소 모는 소리가 들린다.</p>
              <p>남들은 다 벗고 들어서서 일을 하는데 저 혼자 외톨로 돌아다니며 구경하듯 하기가 미안스럽기도 하고 한편으로는 무료하기도 해서 이말 저말 묻는 것이다.</p>
              <p>영신이도 아름드리 느티나무와 고목이 된 대추나무가 얼크러진 큰마을 편을 바라본다. 옥색 저고리를 입은 호리호리한 사나이가 안경을 번쩍거리며 기다란 살포를 지팡이삼아 짚고 언덕길을 어슬렁거리고 내려온다.</p>
              <p>두 사람은 나란히 서서 기만의 등뒤를 돌아 멀리 바다가 내려다보이는 언덕으로 올라갔다. 논과 밭이 눈앞에 질펀히 깔렸는데 여기저기서 두레로 물을 푸는 소리와 소 모는 소리가 들린다.</p>
              <p>남들은 다 벗고 들어서서 일을 하는데 저 혼자 외톨로 돌아다니며 구경하듯 하기가 미안스럽기도 하고 한편으로는 무료하기도 해서 이말 저말 묻는 것이다.</p>
              <p>영신이도 아름드리 느티나무와 고목이 된 대추나무가 얼크러진 큰마을 편을 바라본다. 옥색 저고리를 입은 호리호리한 사나이가 안경을 번쩍거리며 기다란 살포를 지팡이삼아 짚고 언덕길을 어슬렁거리고 내려온다.</p>            </div>
            <div class="modal-footer">
              <button class="btn" data-dismiss="modal">닫기</button>
              <button class="btn btn-primary">변경사항 저장</button>
            </div>
          </div>
          <div class="bs-docs-example" style="padding-bottom: 24px;">
            <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-large">모달 시연 시작</a>
          </div>

</body>
</html>