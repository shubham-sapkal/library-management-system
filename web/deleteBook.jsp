<!DOCTYPE html>
<html>
<head>
<title>Akondi's Library Management System</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
<nav class="navbar navbar-default">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <a href="adminDashboard.jsp" class="navbar-brand">Dashboard</a>
    </div>
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="result.jsp">Add Book</a></li>
            <li><a href="updateBook.jsp">Update Book</a></li>
            <li><a href="deleteBook.jsp">Delete Book</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="adminLogin.jsp">Logout</a></li>
        </ul>
    </div>
</nav>
<div class="login-form">
<div class="well">
	<h3>Delete a Book</h3>
<form action="DeleteBook" method="post" align="center">
<input type="hidden" name="action" value="delete"> 
<label for= "bookid">Book ID</label>
<input type="text" class="ggg" placeholder="Enter Book ID" name="bookid" id="bookid" ><br>       
<div class="clearfix"></div>
 <button type="submit" name="action" value="delete">Delete</button><br>
 <p>${message}</p>
</form> 
</div>
</div>
</body>
</html>


