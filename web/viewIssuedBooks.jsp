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
        <ul class="nav navbar-nav">
        <li class="active"><form action = "StudentLogin" method = "post">
                    <li class="active"><a href="viewIssuedBooks.jsp">View Issued Books</a></li>
                    <li class="active"><a href="viewBooks.jsp">View All Books</a></li>
                    
                   <!--  <li class="active"><a href="viewIssuedBooks.jsp">View Issued Books</a></li></li> -->
        </ul>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="studentLogin.jsp">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="login-form">
    <div class = "well">
    <form action="StudentLogin" method="Post">
    <h3>List of Books Issued</h3>       
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Book ID</th>
        <th>Book Title</th>
        <th>Book Author</th>
        <th>Publication Date</th>
      </tr>
    </thead>
    <tbody>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
    <c:forEach var="book" items="${book}">
  <tr>
    <td>${book.getBookid()}</td>
    <td>${book.getTitle()}</td>
    <td>${book.getAuthor()}</td>
    <td>${book.getPubdate()}</td>
    </form>    
  </tr>
  </c:forEach>
    </tbody>
  </table>
   </form>
   
 <p>${message}</p>
</div>
</div>
</body>
</html>