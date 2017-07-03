<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<body>
	
		<form id="form1" name="form1" method="post">
			<div role="tabpanel">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#audio_fan_01"
						data-toggle="tab" role="tab" aria-controls="tab1">���� ���ε�</a></li>
					<li role="presentation"><a href="#audio_fan_02" data-toggle="tab"
						role="tab" aria-controls="tab2">���� �й� ����</a></li>
					<li role="presentation"><a href="#audio_fan_03" data-toggle="tab"
						role="tab" aria-controls="tab2">���۱� �㰡</a></li>

				</ul>
				<div id="tabContent1" class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="audio_fan_01">
						<p>&nbsp;</p>
						<div class="row">
							<div class="col-xs-3">
								<img
									src="/FairMusic/images/temp.png"
									class="img-circle img-responsive" alt="Placeholder image">
							</div>
							<div class="col-xs-8">
								<div class="row">
									<div class="col-xs-2">
										<span class="label label-info">���� ��</span>
									</div>
									<div class="col-xs-10">
										<input type="text" name="textfield" id="textfield" required="required">
									</div>
									<div class="col-xs-2">
										<span class="label label-info">�帣</span>
									</div>
									<div class="col-xs-10">
										<select name="select" id="select">
										</select> &nbsp;
									</div>
									<div class="col-xs-2">
										<span class="label label-info">�ٹ�</span>
									</div>
									<div class="col-xs-10">
										<select name="select2" id="select2">
										</select> &nbsp;
									</div>
									<div class="col-xs-2">
										<span class="label label-info">�Ұ�</span>
									</div>
									<div class="col-xs-10">
										<textarea name="textarea" id="textarea"></textarea>
										
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-6">&nbsp;</div>
							<div class="col-xs-6">&nbsp;</div>
							<div class="col-xs-12">
								<label for="fileField">File:</label> <input type="file"
									name="fileField" id="fileField" >
								<audio controls></audio>
								&nbsp;
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="audio_fan_02">
						<div class="row">
							<div class="col-xs-4">
								<div class="jumbotron">
									<h5>���۱Ƿ� �ȳ�����</h5>
									<p><h6>�Ǹŵ� ������ ���⿡�� ������ ������� ���¿� ���۵˴ϴ�. ����� �Է��ϼž� �ϸ�, ������� �Ǽ���
										�������ϰ� �Էµ� ���ش� FM������ å������ �ʽ��ϴ�.</h6></p>
									<div class="row">
										<div class="col-lg-6">
											<div class="input-group">
												<span class="input-group-btn">
													<button class="btn btn-default" type="button">����</button>
												</span> <input type="text" class="form-control"
													placeholder="placeholder content">
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
									<div class="col-xs-3">
										<span class="label label-primary" >���۱��� ��</span>
									</div>
									<div class="col-xs-3">
										<span class="label label-primary">���� ����</span>
									</div>
									<div class="col-xs-3">
										<span class="label label-primary">���� ���</span>
									</div>
									<div class="col-xs-3">
										<span class="label label-primary">FM ���̵� ����</span>
									</div>
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
										&nbsp;
									</div>
								</div>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="audio_fan_03">
						&nbsp;
						<div class="row">
							<div class="col-xs-12">
								<span class="label label-info">���� ���۱� �̿� ��� ������ �����Ͻø� ����
									����� �Ϸ�˴ϴ�. FM���� ������ â��Ȱ���� �����ּ���!</span>
							</div>
							<div class="col-xs-12">
								<div>
									<p>
										<label> <input type="checkbox" name="CheckboxGroup1"
											value="������" id="CheckboxGroup1_0"> CCL ���� ����. �������� ǥ��(attribution) ��񿵸�(noncommercial) ��2�� ���� ����(no derivative) �㵿������ ���� ���(share alike)
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="����" id="CheckboxGroup1_1">
											�� ������ �����Դϴ�
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="������������������" id="CheckboxGroup1_2">
											����� �̿��� �����ϴ� �������� �����Դϴ�
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="������" id="CheckboxGroup1_3">
											������ ����մϴ�(������ ���¿�)
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="������������" id="CheckboxGroup1_4">
											�� ������ �����Դϴ�
										</label> <br>
									</p>
									<p>
									
									</p>
									&nbsp;
								</div>
								&nbsp;
							</div>
						</div>
					</div>
				</div>
				<div>&nbsp;</div>
			</div>
		</form>


</body>
</html>