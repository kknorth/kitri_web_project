<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {

		/* 
		alert("��ť��Ʈ �����");
		$("#uploadagreechk").on("click",function(){
		  $("#agreeModal").modal("hide"); 
		  $("#selectModal").modal({show: true})
		
		   alert("���ε� ������");
		}); 
		
		$("#audioupload").on("click",function(){
		  $("#selectModal").modal("hide");
		  $("#audioModal").modal("show");
		});
		
		$("#albumupload").on("click",function(){
		  $("#selectModal").modal("hide");
		  $("#myModal2").modal("show");
		}); */
	});
</script>

</head>
<body>
	<div class="row">
		<div class="col-sm-3">
			<img src="/FairMusic/images/temp.png"
				class="img-circle img-responsive" alt="Placeholder image">
		</div>
		<div class="col-sm-9">
			<div class="row">
				<div class="col-sm-5">
					<span class="label label-info">�ؿ����ؿ�</span>
				</div>
				<div class="col-sm-4 col-sm-offset-0"></div>
				<div class="col-sm-3">
					 <button type="button" class="btn btn-info btn-lg " data-toggle="modal" data-target="#editModal">EDIT</button>
				</div>
				<div class="col-sm-12">
					<fieldset>
						<legend>�ڱ�Ұ�</legend>
						<span class="label label-success">�ȳ��ϼ��� 2���� �Ϳ����̸� �ð� �ִ�
							�Ϳ����� �ؿ��̿���. �ߺ�Ź�����!!!<br> ������ �뷡�� �������� �����Ѵ�ϴ�.<br>
						</span>
					</fieldset>
					&nbsp;
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-9">
			<div role="tabpanel">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#home1"
						data-toggle="tab" role="tab" aria-controls="tab1">All</a></li>
					<li role="presentation"><a href="#paneTwo1" data-toggle="tab"
						role="tab" aria-controls="tab2">Music</a></li>
				</ul>
				<div id="tabContent1" class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="home1">
						<p>
							<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
							<button type="button" class="btn btn-info">���ڼ�</button>
							&nbsp;
						<div class="row">
							<div class="col-sm-4">
								<button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" data-target="#agreeModal">upload</button>

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
					<li role="presentation" class="active"><a href="#home2"
						data-toggle="tab" role="tab" aria-controls="tab1">�ȷ���</a></li>
					<li role="presentation"><a href="#paneTwo2" data-toggle="tab"
						role="tab" aria-controls="tab2">�ȷο�</a></li>
					<li role="presentation" class="dropdown"></li>
				</ul>
				<div id="tabContent2" class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active" id="home2">
						<p>
							<img src="/FairMusic/images/temp.png"
								class="img-circle img-responsive" alt="Placeholder image"
								width="40">
						</p>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="paneTwo2">
						<p>
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>




	<div class="modal fade" id="agreeModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">��</button>
					<h3>UPLOAD</h3>
				</div>

				<div class="modal-body">
					<h3>���� ���ε忡 �����Ͻʴϱ�?</h3>
					<input type="checkbox" id="uploadagreechk" data-toggle="modal"
						data-target="#selectModal" data-dismiss="modal" aria-hidden="true" />
				</div>
				<div class="modal-footer"></div>
			</div>

		</div>
	</div>

	<div class="modal fade" id="selectModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">��</button>
					<h3></h3>
				</div>

				<div class="modal-body">
					<button type="button" class="btn btn-info" id="audioupload"
						data-toggle="modal" data-target="#audioModal" data-dismiss="modal"
						aria-hidden="true">
						<h1>����</h1>
					</button>
					<button type="button" class="btn btn-info" id="albumupload" data-toggle="modal" data-target="#albumModal" data-dismiss="modal"
						aria-hidden="true">
						<h1>�ٹ�</h1>
					</button>
				</div>
				<div class="modal-footer"></div>
			</div>

		</div>
	</div>

	<div class="modal fade" id="audioModal" role="dialog" width = "800">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<jsp:include page="/MusicUpload/musicupload.jsp"></jsp:include>
				</div>
				<div class="modal-footer">
					<button data-dismiss="modal" aria-hidden="true" >����ϱ�</button>
					
				</div>
			</div>

		</div>
	</div>
	
	<div class="modal fade" id="albumModal" role="dialog" width = "800">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">
							<div class="col-xs-3">
								<img
									src="/FairMusic/images/temp.png"
									class="img-circle img-responsive" alt="Placeholder image">
							</div>
							<div class="col-xs-8">
								<div class="row">
									<div class="col-xs-2">
										<span class="label label-info">�ٹ� ��</span>
									</div>
									<div class="col-xs-10">
										<input type="text" name="textfield" id="textfield" required="required">
									</div>
									<div class="col-xs-2">
										<span class="label label-info">�ٹ����� ���ΰ�</span>
									</div>
									<div class="col-xs-10">
										<input type="range" min="0" max="10">
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
				</div>
				<div class="modal-footer">
					<button data-dismiss="modal" aria-hidden="true" >����ϱ�</button>
					
				</div>
			</div>

		</div>
	</div>
	
	
	<div class="modal fade" id="editModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
         <div class = "modal-header">
         <h3>Edit your Profile</h3>
      </div>

        <div class = "modal-body">
            <div class="row">
               <div class="col-sm-3">
                  <img src="/FairMusic/images/temp.png" class="img-circle img-responsive" alt="Placeholder image">
                  <input type="file"/>
               </div>
               <div class="col-sm-9">
                  <div>
                     <h5>Display name</h5>
                     <input name="name" type="text" />
                  </div>
                  <div class="row">
                     <div class="col-sm-6">
                        <h5>First name</h5>
                        <input type="text">
                        <h5>City</h5>
                        <input type="text">
                     </div>
                     <div class="col-sm-6">
                         <h5>Last name</h5>
                        <input type="text">
                        <h5>Country</h5>
                        <input type="text">
                     </div>
                  </div>
                  <div>
                  <h5>bio</h5>
                  <textarea class="form-control" rows="5" id="comment"></textarea>
                   <h3>your links</h3>
                  <div id="linktext"><input type="text" size="70" /><br/></div>
                  <div ><input type="button" value="add link" id="addlink"/></div>                 
                  </div>
               </div>
            </div>
        </div>
        <div class="modal-footer">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> Save changes</button>      
        </div>
      </div>
      
    </div>
  </div>
</body>
</html>