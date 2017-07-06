<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
	var client = new CoinStack('c7dbfacbdf1510889b38c01b8440b1', '10e88e9904f29c98356fd2d12b26de');
	var privateKey = CoinStack.ECKey.createKey();
	console.log(privateKey);
	var address = CoinStack.ECKey.deriveAddress(privateKey);
	console.log(address);
	
	
	client.getBlockchainStatus(function(err, status) {
	    console.log(status);
	});
	
	client.getBalance(address,
			function(err, balance) {
			    console.log(CoinStack.Math.toBitcoin(balance) + ' BTC');
			});

	</script>
	
	<h3>openasset</h3>
</body>
</html>