<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<body>
<div class="container">
  <form id="form1" name="form1" method="post">
    <div role="tabpanel">
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home1" data-toggle="tab" role="tab" aria-controls="tab1">���� ���ε� 01</a></li>
        <li role="presentation"><a href="#paneTwo1" data-toggle="tab" role="tab" aria-controls="tab2">���۱� ���� �й�</a></li>
        <li role="presentation"><a href="#paneTwo2" data-toggle="tab" role="tab" aria-controls="tab2">���۱� �㰡</a></li>
        
      </ul>
      <div id="tabContent1" class="tab-content">
<div role="tabpanel" class="tab-pane fade in active" id="home1">
  <p>&nbsp;</p>
  <div class="row">
            <div class="col-xs-3"><img src="file:///C|/Users/seong_jo/AppData/Roaming/Adobe/Dreamweaver CC 2017/ko_KR/Configuration/Temp/Assets/eam55E5.tmp/images/ImgResponsive_Placeholder.png" class="img-circle img-responsive" alt="Placeholder image"></div>
            <div class="col-xs-8">
              <div class="row">
                <div class="col-xs-2"><span class="label label-info">���� ��</span></div>
                <div class="col-xs-10">
<input type="text" name="textfield" id="textfield">
                </div>
                <div class="col-xs-2"><span class="label label-info">�帣</span></div>
                <div class="col-xs-10">
<select name="select" id="select">
</select>
                &nbsp;</div>
                <div class="col-xs-2"><span class="label label-info">�ٹ�</span></div>
                <div class="col-xs-10">
<select name="select2" id="select2">
</select>
                &nbsp;</div>
                <div class="col-xs-2"><span class="label label-info">�Ұ�</span></div>
                <div class="col-xs-10">
<textarea name="textarea" id="textarea"></textarea>
                &nbsp;</div>
              </div>
            </div>
</div>
          <div class="row">
            <div class="col-xs-6">&nbsp;</div>
            <div class="col-xs-6">&nbsp;</div>
            <div class="col-xs-12">
              <label for="fileField">File:</label>
              <input type="file" name="fileField" id="fileField">
<audio controls></audio>
            &nbsp;</div>
          </div>
        </div>
        <div role="tabpanel" class="tab-pane fade" id="paneTwo1">
          <div class="row">
            <div class="col-xs-4">
              <div class="jumbotron">
                <h1>���۱Ƿ� �ȳ�����</h1>
                <p>�Ǹŵ� ������ ���⿡�� ������ ������� ���¿� ���۵˴ϴ�. ����� �Է��ϼž� �ϸ�, ������� �Ǽ��� �������ϰ� �Էµ� ���ش� FM������ å������ �ʽ��ϴ�.</p>
                <div class="row">
                  <div class="col-lg-6">
                    <div class="input-group"><span class="input-group-btn">
                      <button class="btn btn-default" type="button"> ����</button>
                      </span>
                      <input type="text" class="form-control" placeholder="placeholder content">
                    </div>
                    <!-- /input-group -->
                  </div>
                  <!-- /.col-lg-6 -->
                  
                  <!-- /.col-lg-6 -->
                </div>
                <p>&nbsp;</p>
              </div>
            </div>
            <div class="col-xs-8">
              <div class="row">
                <div class="col-xs-3"><span class="label label-primary">���۱��� ��</span></div>
                <div class="col-xs-3"><span class="label label-primary">���� ����</span></div>
                <div class="col-xs-3"><span class="label label-primary">���� ���</span></div>
                <div class="col-xs-3"><span class="label label-primary">FM ���̵� ����</span></div>
              </div>
              <div class="row">
                <div class="col-xs-3">
                  <input type="text" name="textfield4" id="textfield4">
                </div>
                <div class="col-xs-3">
                  <input type="text" name="textfield2" id="textfield2">
                </div>
                <div class="col-xs-3">
                  <button type="button" class="btn btn-info">���</button>
                </div>
                <div class="col-xs-3">
                  <button type="button" class="btn btn-default">���̵� ����</button>
                </div>
</div>
<div class="row">
                <div class="col-xs-3">
<input type="text" name="textfield3" id="textfield3">
                </div>
                <div class="col-xs-3">
<input type="text" name="textfield5" id="textfield5">
                </div>
                <div class="col-xs-3">
                  <button type="button" class="btn btn-info">���</button>
                </div>
                <div class="col-xs-3">
                  <button type="button" class="btn btn-default">���̵� ����</button>
                </div>
                <div class="col-xs-12">
                  <button type="button" class="btn btn-success">�߰��ϱ�</button>
                &nbsp;</div>
              </div>
            </div>
          </div>
        </div>
        <div role="tabpanel" class="tab-pane fade" id="paneTwo2">&nbsp;
          <div class="row">
            <div class="col-xs-12"><span class="label label-info">���� ���۱� �̿� ��� ������ �����Ͻø� ���� ����� �Ϸ�˴ϴ�. FM���� ������ â��Ȱ���� �����ּ���!</span></div>
<div class="col-xs-12">
  <div>
    <p>
      <label>
        <input type="checkbox" name="CheckboxGroup1" value="������" id="CheckboxGroup1_0">
        ����</label>
      <br>
      <label>
        <input type="checkbox" name="CheckboxGroup1" value="��������" id="CheckboxGroup1_1">
        ������</label>
      <br>
      <label>
        <input type="checkbox" name="CheckboxGroup1" value="������" id="CheckboxGroup1_2">
        ������</label>
      <br>
      <label>
        <input type="checkbox" name="CheckboxGroup1" value="������" id="CheckboxGroup1_3">
        ������</label>
      <br>
      <label>
        <input type="checkbox" name="CheckboxGroup1" value="������������" id="CheckboxGroup1_4">
        ����</label>
      <br>
    </p>
    <p>
      <button type="button" class="btn btn-default"> ���� ����ϱ�</button>
    </p>
  &nbsp;</div>
  &nbsp;</div>
</div>
</div>
      </div>
      <div>&nbsp;</div>
</div>
    &nbsp;
  </form>
</div>

</body>
</html>