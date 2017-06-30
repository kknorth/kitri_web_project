<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<meta name="google-signin-scope" content="profile email">
	<meta name="google-signin-client_id" content="624407017745-25gq08l8jhdvp90b5pp0rhvj4v8320gh.apps.googleusercontent.com">
    <title>Insert title here</title>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
	 <div class="g-signin2" data-onsuccess="onSignIn"></div>
    <script>
    function onSignIn(googleUser) {
    	  var profile = googleUser.getBasicProfile();
    	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    	  console.log('Name: ' + profile.getName());
    	  console.log('Image URL: ' + profile.getImageUrl());
    	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    	}
    	function signOut() {
    	    var auth2 = gapi.auth2.getAuthInstance();
    	    auth2.signOut().then(function () {
    	      console.log('User signed out.');
    	    });
    	  };
    </script>
    <a href="#" onclick="signOut();">Sign out</a>
</body>
</html>