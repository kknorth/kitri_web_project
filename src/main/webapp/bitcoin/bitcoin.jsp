<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- <script type="text/javascript">
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

	</script> -->
	
	<h3>openasset</h3>
	<form method="post" action="/FairMusic/bitcoin">
		<div>어드레스 </div>
		<input type = "submit" value ="bitcoin주소 발급"><br/>
		비트코인 주소 ==> ${MusicAddress}<br/>
		나의 비트코인 잔고 ==>${balance} BTC <br/>
		
	</form>
	
	<form method="post" action="/FairMusic/openasset">
	보낼 주소 : <input type="text" placeholder="bitcoin-Address">
	</form>
</body>
</html>