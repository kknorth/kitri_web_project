<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<br/>
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#messageModal">New Message</button>
	<br/><br/>
	<ul class="list-group">
		<li class="list-group-item"><img src="/FairMusic/images/temp.png" class="img-thumbnail" alt="Cinque Terre" width="30" height="30"><a href="/FairMusic/view.do?leftpath=Side_Left_Message.jsp&viewpath=../Message/message.jsp">한준희님의 메세지</a></li>
		<li class="list-group-item"><img src="/FairMusic/images/temp2.png" class="img-thumbnail" alt="Cinque Terre" width="30" height="30"><a href="#">우해원님의 메세지</a></li>
		<li class="list-group-item"><img src="/FairMusic/images/M.PNG" class="img-thumbnail" alt="Cinque Terre" width="30" height="30"><a href="#">john님의 메세지</a></li>
	</ul>
  <div class="modal fade" id="messageModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <form action="">   
      <div class="modal-content">
         <div class = "modal-header">
         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
         <h3>New Message</h3>
     </div>
    <div class = "modal-body">

         <h3>To</h3>
         <input name="To" type="text" />
         <h3>Write your message </h3>
    <div class="form-group">
      <label for="comment"></label>
      <textarea class="form-control" rows="5" id="comment"></textarea>
    </div>
      </div>
        <div class="modal-footer">
			<input type="submit" value="send"/>
        </div>
      </div>
      </form>
    </div>
  </div>	
  

</body>
</html>

