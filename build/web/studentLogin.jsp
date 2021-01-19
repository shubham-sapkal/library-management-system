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
<div class="login-form">
<div class="well">
	<h3>Student Login</h3>
<form action="StudentLogin" method="post">
<input type="text" class="ggg" placeholder="Enter User Name" name="username"><br>
<input type="password" class="ggg" placeholder="Enter Password" name="password"><br>
<div class="clearfix"></div>
<button type="submit" name="Action" value="Login">Login</button><br>
        <input type="hidden" name="Action" value="view">        

</form>
<form action="index.jsp">
<button type="submit" value="Back">Back</button>
</form>
</div>
</div>
</body>
</html>