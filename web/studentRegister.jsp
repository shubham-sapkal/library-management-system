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
<form action="StudentRegister" method="post">
<input type="hidden" name="action" value="add">        
<label for= "firstname">Firstname</label>
<input type="text" class="ggg" placeholder="Enter First Name" name="firstname" id="firstname"><br>
<label for= "lastname">Lastname</label>
<input type="text" class="ggg" placeholder="Enter Last Name" name="lastname" id="lastname"><br>
<label for= "username">Username</label>
<input type="text" class="ggg" placeholder="Enter User Name" name="username" id="username"><br>
<label for= "password">Password</label>
<input type="password" class="ggg" placeholder="Enter Password" name="password" id="password"><br>
<label for= "email">Email</label>
<input type="text" class="ggg" placeholder="Enter Email" name="email" id="email"><br>
<label for= "sid">Student ID</label>
<input type="text" class="ggg" placeholder="Enter Student ID" name="sid" id="sid"><br>

<!-- <h6><a href="forgotPassword.jsp">Forgot Password?</a></h6>
 -->
 <div class="clearfix"></div>
 <button type="submit" name="action" value="add">Sign Up</button><br>
</form>
<form action="index.jsp">
<button type="submit" value="Back">Back</button>
</form>
</div>
</div>
</body>
</html>