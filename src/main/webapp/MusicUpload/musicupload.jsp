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
						data-toggle="tab" role="tab" aria-controls="tab1">음원 업로드</a></li>
					<li role="presentation"><a href="#audio_fan_02" data-toggle="tab"
						role="tab" aria-controls="tab2">수익 분배 설정</a></li>
					<li role="presentation"><a href="#audio_fan_03" data-toggle="tab"
						role="tab" aria-controls="tab2">저작권 허가</a></li>

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
										<span class="label label-info">음원 명</span>
									</div>
									<div class="col-xs-10">
										<input type="text" name="textfield" id="textfield" required="required">
									</div>
									<div class="col-xs-2">
										<span class="label label-info">장르</span>
									</div>
									<div class="col-xs-10">
										<select name="select" id="select">
										</select> &nbsp;
									</div>
									<div class="col-xs-2">
										<span class="label label-info">앨범</span>
									</div>
									<div class="col-xs-10">
										<select name="select2" id="select2">
										</select> &nbsp;
									</div>
									<div class="col-xs-2">
										<span class="label label-info">소개</span>
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
									<h5>저작권료 안내사항</h5>
									<p><h6>판매된 음원은 여기에서 설정한 비율대로 계좌에 전송됩니다. 제대로 입력하셔야 하며, 사용자의 실수로
										부주의하게 입력된 피해는 FM측에서 책임지지 않습니다.</h6></p>
									<div class="row">
										<div class="col-lg-6">
											<div class="input-group">
												<span class="input-group-btn">
													<button class="btn btn-default" type="button">동의</button>
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
										<span class="label label-primary" >저작권자 명</span>
									</div>
									<div class="col-xs-3">
										<span class="label label-primary">수익 비율</span>
									</div>
									<div class="col-xs-3">
										<span class="label label-primary">계좌 등록</span>
									</div>
									<div class="col-xs-3">
										<span class="label label-primary">FM 아이디 연동</span>
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
										<button type="button" class="btn btn-info">등록</button>
									</div>
									<div class="col-xs-3">
										<button type="button" class="btn btn-default">아이디 인증</button>
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
										<button type="button" class="btn btn-info">등록</button>
									</div>
									<div class="col-xs-3">
										<button type="button" class="btn btn-default">아이디 인증</button>
									</div>
									<div class="col-xs-12">
										<button type="button" class="btn btn-success">추가하기</button>
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
								<span class="label label-info">이제 저작권 이용 허락 범위를 결정하시면 음원
									등록이 완료됩니다. FM에서 마음껏 창작활동을 펼쳐주세요!</span>
							</div>
							<div class="col-xs-12">
								<div>
									<p>
										<label> <input type="checkbox" name="CheckboxGroup1"
											value="ㄴㄹㅇ" id="CheckboxGroup1_0"> CCL 조건 선택. ▲저작자 표시(attribution) ▲비영리(noncommercial) ▲2차 변경 금지(no derivative) ▲동일조건 변경 허락(share alike)
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="ㅇㅇ" id="CheckboxGroup1_1">
											이 음악은 무료입니다
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="ㅇㅇㅇㅇㅇㅇㅇㅇㅇ" id="CheckboxGroup1_2">
											상업적 이용을 금지하는 조건으로 무료입니다
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="ㅇㅇㅇ" id="CheckboxGroup1_3">
											수익은 기부합니다(조성원 계좌에)
										</label> <br> <label> <input type="checkbox"
											name="CheckboxGroup1" value="ㄹㅇㅎㅎㅇㄹ" id="CheckboxGroup1_4">
											이 음악은 유료입니다
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