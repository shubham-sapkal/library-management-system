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
    <div class = "well">
    <h1>Welcome to the online library management system</h1>
	<h3 id="login-line">Login As</h3>
	
	<form action="adminLogin.jsp">
            <button type="submit" value="Admin">Admin</button>
        </form>
        <br>
    <form action="studentLogin.jsp">
    <button type="submit" value="Student">Student</button>
    </form>
    
    <h5>Not a member yet! get registered right away... 
    <form action="studentRegister.jsp">
    <button type="submit" value="Register">Register</button>
    </form></h5>

</div>
</div>

</body>
</html>