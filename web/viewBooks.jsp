<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
<title>Akondi's Library Management System</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script type="https://code.jquery.com/jquery-3.2.1.min.js"></script>
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
        <li class="active">
        <form action = "StudentLogin" method = "post">
                    <button type ="submit" name="Action" value="view">View All Books</button>
                                        <button type ="submit" name="Action" value="issue">View Issued Books</button></form> 
                    
                    <!-- <li><a href="viewIssuedBooks.jsp">View Issued Books</a></li> --> 
       	 </ul>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="studentLogin.jsp">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="login-form">
    <div class = "well">
    <form name="myIssueServlet" action="IssueServlet" method="Post">  
    <h3>List of Books available in the library</h3> 
    <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://tiger.ceonkd3lm0ub.us-east-2.rds.amazonaws.com:3306/onlinelibrary"
         user = "kashwath"  password = "tigerlion"/>
         
		<sql:query dataSource="${snapshot}" var="result">
		SELECT * from Book;
		</sql:query>

          
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Book ID</th>
        <th>Book Title</th>
        <th>Book Author</th>
        <th>Publication Date</th>
        <th>Copies Available</th>
        <th>Issue Book</th>
        <th>Remove Book</th>
      </tr>
    </thead>
    <tbody>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    <c:forEach var="row" items="${result.rows}">
    
    <tr>
	    <td><input type="hidden" name="bookid" value="<c:out value='${row.bookid}'/>">${row.bookid}</td>
	    <td>${row.title}</td>
	    <td>${row.author}</td>
	    <td>${row.publicationdate}</td>
	    <td>${row.quantity}</td>
	    <td><button type="button" name="issue" value='${row.bookid}' onclick="f1(this)" class="clickMe" id="<c:out value='${row.bookid}'/>">Issue Book</button><br></td>
	    <td><button type="submit" name="remove" value='${row.bookid}' id="onclick">Remove Book</button><br></td>
	      
	  </tr>
   	  
  </c:forEach>
    </tbody>
  </table>
    </form>
  <input type="checkbox" id="javamail">
  <label for="javamail">Would you like a confirmation to be sent to your email id</label>
   <form action="EmailSendingServlet" method="post">
  <table border="0" width="35%" align="center">
            <tr>
                <td width="50%">Email address </td>
                <td><input type="text" name="recipient" size="50"/></td>
            </tr>
            <tr>
                <!-- <td>Subject </td> -->
                <td><input type="hidden" name="subject" size="50""/></td>
            </tr>
            <tr>
                <!--  <td>Content </td> -->
                <td><input type="hidden" textarea rows="10" cols="39" name="content"></textarea> </td>
            </tr>
            <tr>
            	<td colspan="2" align="center"><button type="submit" name="action" value="Send">Confirm Issue</button><br></td>
                <!-- <td colspan="2" align="center"><input type="submit" value="Send"/></td> -->
            </tr>
        </table>
   </form>
   
 <p>${message}</p>
</div>
</div>
</body>
<script type="text/javascript">
function f1(objButton){  
 
    var url = "IssueServlet"; // the script where you handle the form input.

   
    $.ajax({
        url:'IssueServlet',
        data:{'bookid':objButton.value,
        	'issue':true
        },
        type:'post',
        cache:false,
        success:function(data){
           //$('#somediv').text(responseText); 
        },
        error:function(e){
        }
     });

}
</script>
</html>
<!-- 
 $('.clickMe').click(function(){
  var clickedID= this.id;
  }); -->