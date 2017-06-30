<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/main.css" />
	</head>
	<body>
			<!-- top -->
			<jsp:include page="top_Logout.jsp"></jsp:include>
			<!-- Main -->
				<div class="wrapper">
					<div id="test_main">
						<div class="row">
							<div class="col-sm-3">
								<jsp:include page="layout/Side_Left.jsp"></jsp:include>
							</div>
									<!-- MainView -->							
							<div class="col-sm-6">
									<!-- Content -->
										<jsp:include page="content.jsp"></jsp:include>
									<!-- Sidebar -->
							</div>
							<div class="col-sm-3">
								<jsp:include page="layout/Side_Right.jsp"></jsp:include>
							</div>
						</div>
					</div>
				</div>
		<!-- Scripts -->

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			

	</body>
</html>