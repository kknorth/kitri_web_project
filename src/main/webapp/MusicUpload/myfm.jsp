<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-3"><img src="temp2.png" class="img-circle img-responsive" alt="Placeholder image"></div>
    <div class="col-sm-9">
      <div class="row">
        <div class="col-sm-5"><span class="label label-info">해원우해원</span></div>
        <div class="col-sm-4 col-sm-offset-0"></div>
        <div class="col-sm-3">
          <button type="button" class="btn btn-sm btn-default">EDIT</button>
        </div>
        <div class="col-sm-12">
          <fieldset>
          <legend>자기소개</legend>
            <span class="label label-success">안녕하세요 2조의 귀염둥이를 맡고 있는 귀염둥이 해원이에요. 잘부탁드려요!!!<br>
              준희씨의 노래를 정말정말 좋아한답니다.<br>
            </span>
          </fieldset>
          &nbsp;</div>
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-sm-9">
      <div role="tabpanel">
        <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#home1" data-toggle="tab" role="tab" aria-controls="tab1">All</a></li>
          <li role="presentation"><a href="#paneTwo1" data-toggle="tab" role="tab" aria-controls="tab2">Music</a></li>
        </ul>
        <div id="tabContent1" class="tab-content">
          <div role="tabpanel" class="tab-pane fade in active" id="home1">
            <p><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
              <button type="button" class="btn btn-info">수박송</button>
              &nbsp;
              <div class="row">
  <div class="col-sm-4">
    <button type="button" class="btn btn-warning">upload</button>
  </div>
  <div class="col-sm-4">
    <button type="button" class="btn btn-warning">update</button>
  </div>
  <div class="col-sm-4">
    <button type="button" class="btn btn-warning">delete</button>
  </div>
</div>
            </p>
          </div>
          <div role="tabpanel" class="tab-pane fade" id="paneTwo1">
            <p>&nbsp;</p>
          </div>
</div>
      </div>
    </div>
    <div class="col-sm-3">
      <div role="tabpanel">
        <ul class="nav nav-tabs" role="tablist">
          <li role="presentation" class="active"><a href="#home2" data-toggle="tab" role="tab" aria-controls="tab1">팔로잉</a></li>
          <li role="presentation"><a href="#paneTwo2" data-toggle="tab" role="tab" aria-controls="tab2">팔로워</a></li>
          <li role="presentation" class="dropdown">
<ul class="dropdown-menu" aria-labelledby="tabDropOne1">
              <li><a href="#tabDropDownOne1" tabindex="-1" data-toggle="tab">Dropdown Link 1</a></li>
              <li><a href="#tabDropDownTwo1" tabindex="-1" data-toggle="tab">Dropdown Link 2</a></li>
            </ul>
          </li>
        </ul>
        <div id="tabContent2" class="tab-content">
          <div role="tabpanel" class="tab-pane fade in active" id="home2">
            <p><img src="temp.png" class="img-circle img-responsive" alt="Placeholder image" width="40"></p>
          </div>
          <div role="tabpanel" class="tab-pane fade" id="paneTwo2">
            <p><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></p>
          </div>
</div>
      </div>
    </div>
  </div>
</div>

</body>
</html>