<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Collection</title>
<link rel="stylesheet" type="text/css" href="Collection/Collection.css">
</head>
<body>
	<header>
      <!--   <div class="top_menu">
            <ul>
                <li><a href="/FairMusic/view.do?viewpath=../Collection.jsp" alt="">Overview</a></li>
                <li><a href="/FairMusic/view.do?viewpath=../Collection/Likes.jsp" alt="">Likes</a></li>
                <li><a href="/FairMusic/view.do?viewpath=../Collection/Playlists.jsp" alt="">Playlists</a></li>
                <li><a href="/FairMusic/view.do?viewpath=../Collection/Albums.jsp" alt="">Albums</a></li>
                <li><a href="/FairMusic/view.do?viewpath=../Collection/Stations.jsp" alt="">Stations</a></li>
                <li><a href="/FairMusic/view.do?viewpath=../Collection/Following.jsp" alt="">Following</a></li>
                <li><a href="/FairMusic/view.do?viewpath=../Collection/History.jsp" alt="">History</a></li>
            </ul>
        </div> -->
         <br/>
        <jsp:include page="CollectionTop.jsp"></jsp:include>
        <div class="label">Recently played</div>
    </header>
    <div id="content">
        <div class="section1">
            <div class="music_product">
                <ul>
                    <li><a href="#"><img src="/FairMusic/images/M.PNG" class="img-thumbnail" alt="Cinque Terre" width="200" height="200"></a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                </ul>
            </div>   
        </div>
    </div>
    	<div class="label">Likes</div>
    <div id="content">
        <div class="section2">
            <div class="like_product">
                <ul>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                </ul>
            </div> 
            <div class="like_product">
                <ul>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                    <li><a href="#" alt="">likemusic</a></li>
                </ul>
            </div>     
        </div>
    </div>
    	<div class="label">Playlists</div>
    <div id="content">
        <div class="section3">
            <div class="playlists_product">
                <ul>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                    <li><a href="#" alt="">music</a></li>
                </ul>
            </div>   
        </div>
    </div>
    	<div class="label">Albums</div>
    <div id="content">
        <div class="section4">
            <div class="Albums_product">
                <ul>
                    <li><a href="#" alt="">Albums</a></li>
                    <li><a href="#" alt="">Albums</a></li>
                    <li><a href="#" alt="">Albums</a></li>
                    <li><a href="#" alt="">Albums</a></li>
                    <li><a href="#" alt="">Albums</a></li>
                    <li><a href="#" alt="">Albums</a></li>
                </ul>
            </div>   
        </div>
    </div>
    	<div class="label">Liked stations</div>
    <div id="content">
        <div class="section5">
            <div class="stations_product">
                <ul>
                    <li><a href="#" alt="">stations</a></li>
                    <li><a href="#" alt="">stations</a></li>
                    <li><a href="#" alt="">stations</a></li>
                    <li><a href="#" alt="">stations</a></li>
                    <li><a href="#" alt="">stations</a></li>
                    <li><a href="#" alt="">stations</a></li>
                </ul>
            </div>   
        </div>
    </div>	
    	<div class="label">Following</div>
    <div id="content">
        <div class="section6">
            <div class="following_product">
                <ul>
                    <li><a href="#" alt="">Following</a></li>
                    <li><a href="#" alt="">Following</a></li>
                    <li><a href="#" alt="">Following</a></li>
                    <li><a href="#" alt="">Following</a></li>
                    <li><a href="#" alt="">Following</a></li>
                    <li><a href="#" alt="">Following</a></li>
                </ul>
            </div>   
        </div>
    </div>	
    <footer>
        <div class="copyright">FairMusic</div>
    </footer>
</body>
</html>