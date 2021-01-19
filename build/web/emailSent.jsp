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
        <a href="studentDashboard.jsp" class="navbar-brand">Dashboard</a>
    </div>
    <!-- Collection of nav links and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse">
    <form action = "StudentLogin" method = "post">
        <ul class="nav navbar-nav">
          
            <li class="active"><a href="viewBooks.jsp" type ="submit" name="Action" value="view">View All Books</a></li>
            <li><a href="#">Issue Book</a></li>
            <li><a href="#">View Issued Books</a></li>
        </ul>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="studentLogin.jsp">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="login-form">
<div class = "well">
    <h1>An email has been sent to you for confirmation</h1>
	<h3>Click here to go back to your dashboard</h3>
	<form action="studentDashboard.jsp">
	<button type="submit" value="Dashboard">Dashboard</button>
    </form>
 <p>${message}</p>
</div>
</div>
</body>
</html>