<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<script type="text/javascript">
			var onloadCallback = function(){
				greCAPTCHA.render('html_element',{
					'siteKey':'6LembScUAAAAAKz63gwf9DihVKJAY_1ExV40ph72',
					'theme':'light'
				});
			};
			
			function chkCaptcha(){
				if(typeof(greCAPTCHA!='undefined')){
			
					if(greCAPTCHA.getResponsc()==""){ //서버단에서 한번 더 체크,
												// 사용자가 인증하는 순간 구글의 서버로 부터 토큰 부여받음
						alert("스팸방지코드를 확인해 주세요.");
						return false;
					}
				}else{
					return false;
				}
			}
		</script>
</head>
<body>
	<form id ="form1" runat="server">
		<div id="grecaptcha" class="g-recaptcha" data-sitekey="6LembScUAAAAAKz63gwf9DihVKJAY_1ExV40ph72"></div>
		<input type="submit" value="제출">
	</form>

</body>
</html>