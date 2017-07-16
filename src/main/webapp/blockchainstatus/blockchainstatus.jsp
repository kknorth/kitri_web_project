<%@page import="com.fairmusic.dto.followDTO"%>
<%@page import="com.blocko.controller.MyBtcAddrReq"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%@ page import="java.util.ArrayList" %>
<%@page import="com.fairmusic.dto.albumDTO"%>
<%@page import="com.fairmusic.dto.audioDTO"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/FairMusic/MusicUpload/js/range.js"></script>
<link rel="stylesheet" href="/FairMusic/MusicUpload/css/range.css">

	<style>
	
		 div #bg {
		  position:  absolute; 
 		  margin-left: 2%; margin-right: auto; display: block;
		  min-width: 90%;
		  min-height: 95.5%;
		  background-image: url('../images/certificate2.jpg');
		  background-repeat: no-repeat;
		 }  
	
		.modal-dialog.modal-80size {
		  width: 80%;
		  height: 80%;
		  margin: 0;
		  padding: 0;
		}
		
		.modal-content.modal-80size {
		  margin-left: 20%;
		}		
	</style>
	
			<script type="text/javascript">
				var state = 0;
				$(document).ready(function() {
					$("#create").on("click",function() {
						if (state == 1) {
								alert("이미 생성했습니다.")
						} else {
							$.post("/FairMusic/MyBitcoinAddr",{ },success_addr)
						}

					})
					
					$("#btcaddr").on("click",function() {
						if (state == 1){
							$.post("/FairMusic/MyBitcoinAddrSelect",{ },success_addr)
						}
					})
					
					$("#search").on("click",function() {
							$.post("/FairMusic/BlockChainSearch",{"btcval" : $("#btcval").val()},success_search)
					})
					
					$("#BlockStatus").on("click",function() {
							$.post("/FairMusic/BlockChainStatus",{ },success_status)
					})

				})

				function success_addr(txt) {
					state = 1;
					$("#mybtc").html("Bitcoin Address : "+txt);
				}
				
				function success_search(txt) {
					 data = txt.split(",");
				      balance = data[0]; 
				      txid = data[1];
					$("#mybitcoin").html("잔액 : "+balance+"<br/>"+"거래된 트랜잭션 ID : "+txid);
				}
				
				function success_status(txt) {
					 data = txt.split(",");
				      balance = data[0]; 
				      txid = data[1];
					$("#block").html("잔액 : "+balance+"<br/>"+"거래된 트랜잭션 ID : "+txid);

					$("#mybtcaddr").html(txt);
				}
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
					<div class="col-sm-12">
						<fieldset>
							<legend>fairMusic에서 나의 블록체인의 상태를 확인하세요</legend>
								<span class="label label-success">fairMusic은 원원 저작권을 블록체인 상에 보관함으로써 저작권자들의 권리를 보호해줍니다.<br><br> 블록체인에 삽입된 음원 검색 및 비트코인 주소 잔액을 조회해 보세요
								 <br>
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
						
					<li role="presentation" id ="btcaddr"><a href="#pane1" data-toggle="tab"
					role="tab" aria-controls="tab2">My Bitcoin Address</a></li>
					
					<li role="presentation" id ="btcsearch"><a href="#pane2" data-toggle="tab"
						role="tab" aria-controls="tab3">BlockChainSearch</a></li>
						
					<li role="presentation" id ="BlockStatus"><a href="#pane3" data-toggle="tab"
					role="tab" aria-controls="tab4">BlockStatus</a></li>
						
				</ul>
		
				<div id="tabContent1" class="tab-content">
					
						<div role="tabpanel" class="tab-pane fade" id="pane1">
							<button type="button" class="btn btn-info btn-lg" id="create">Create Bitcoin</button>
							<div class="mybitcoin"></div>
						</div>
						
						
						<div role="tabpanel" class="tab-pane fade" id="pane2">
							<a class="btn btn-info btn-lg " data-toggle="modal" data-target="BlockChainSearchModal">BlockChainSearch</a>
							<p>비트코인 주소 : </p><input type="text" name="btcval" id="btcval">
							<div id = "mybtcaddr" style ="color:red;"></div>
						<%-- <button id = "balance" style ="color:red;">balance</button>
						<%String[] txIds = (String[])request.getAttribute("txIds");
						  String txId="";%>
						<%for(int i=0; i <=txIds.length; i++){ %>
								<button id = "txID" style ="color:red;"><%=txIds[i]%></button>
						<%} %> --%>
	
						</div>
						
						
						<div role="tabpanel" class="tab-pane fade" id="pane3">
						<a class="btn btn-info btn-lg " data-toggle="modal" data-target="blockstatusModal">BlockStatus</a>
						
							<%--  <%BlockChainStatusDTO status = (BlockChainStatusDTO)request.getAttribute("statusdto"); %>  --%>
									<!-- alert(status.getBlockId()) -->
					<%--	<button id = "block" style ="color:red;"><%=status.getBlockId() %></button><br/>
				 		<!-- <button id = "block2" style ="color:red;"><%=status.getParentId()%></button><br/>
						<button id = "block3" style ="color:red;"><%=status.getHeight()%></button><br/>
						<button id = "block4" style ="color:red;"><%=status.getTime()%></button><br/>
						 <div id = "block" style ="color:red;"></div> -->  --%>
						</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ########################################### modalmodalmodalmodalmodalmodalmodal -->

	<div class="modal fade" id="certificationModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3></h3>
				</div>

				<div class="modal-body">
					<button type="button" class="btn btn-info" id="audioupload"
						data-toggle="modal" data-target="#audioModal" data-dismiss="modal"
						aria-hidden="true">
						<h1>음원</h1>
					</button>
					<button type="button" class="btn btn-info" id="albumupload" data-toggle="modal" data-target="#albumModal" data-dismiss="modal"
						aria-hidden="true">
						<h1>앨범</h1>
					</button>
				</div>
				<div class="modal-footer"></div>
			</div>

		</div>
	</div>

	<div class="modal fade" id="btcaddrModal" role="dialog" width = "1200">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<jsp:include page="/MusicUpload/musicupload.jsp"></jsp:include>
				</div>
				<div class="modal-footer">
					<button data-dismiss="modal" aria-hidden="true" id="audiocreate" data-toggle="modal" data-target="#fakeloadingModal"  onclick = "faketime()">등록하기</button>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
