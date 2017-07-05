<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<!--
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
-->
<html>
<head>
    <meta charset="utf-8" />
    <script type="text/javascript" charset="utf-8" src="js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="oauth/jquery.cookie.js"></script>
    <script type="text/javascript" charset="utf-8" src="oauth/naverLogin.js"></script>



</head>
<body>

<script type="text/javascript">
    function generateState() {
        
        var oDate = new Date();
        return oDate.getTime();
    }
    function saveState(state) {
        $.removeCookie("state_token");
        $.cookie("state_token", state);
    }
    var naver = NaverAuthorize({
        client_id : "ICE62Psxbc57doDUR0WE",
        redirect_uri : "http://127.0.0.1:8088/FairMusic/oauth.jsp",
        client_secret : "nxy2Jk2wqV"
    });


     function loginNaver() {
        var state = generateState();
        saveState(state);
        naver.login(state);
    }

    $("#NaverIdLoginBTN").click( function () {
        var state = generateState();
        saveState(state);
        naver.login(state);
    });
</script>
<script type="text/javascript">
    window.onload=function(){

        checkLoginState();
    }
    var tokenInfo = { access_token:"" , refresh_token:"" };
    function checkLoginState() {
    var state = $.cookie("state_token");
    if(naver.checkAuthorizeState(state) === "connected") {
        
        naver.getAccessToken(function(data) {

            var response = data._response.responseJSON;
            if(response.error === "fail") {
                
                return ;
            }
            tokenInfo.access_token = response.access_token;
            tokenInfo.refresh_token = response.refresh_token;

           
            console.log("success to get access token", response);
        });
    } else {
       
        return ;
    }
    
    function getNaverUserInfo(){
    	   naver.api(URL, tokenInfo.access_token, function(data) {
    	       var response = data._response.responseJSON;
    	       console.log("success to get user info", response);
    	       alert(response.response.email);
    	   });
    	}
}
</script>
<div>
    <button onclick='loginNaver()'>naver call</button>
</div>
</body>
</html>
