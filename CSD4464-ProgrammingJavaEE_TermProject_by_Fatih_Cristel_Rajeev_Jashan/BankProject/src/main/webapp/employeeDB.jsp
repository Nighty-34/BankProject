<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Dashboard</title>
<style>
body{
background-image:url('https://t3.ftcdn.net/jpg/02/97/45/58/360_F_297455861_5KvVjKvwEMTs4LYQuytQNbehvhOWiXme.jpg');
background-size: cover;

}
*{
text-align:center;}
    h1{
  text-align:center;
	text-shadow: 2px 2px 4px black;
	color:green;
	font-size: 50px;
</style>
</head>
<body>
<%String Name=request.getParameter("name"); %>
<h1>Bank of Toronto</h1>
<h2>Good morning! <%=Name%></h2>
<h2>What do you want to proceed with?</h2>
<h3>Create a new customer account by clicking <a href="createAccount.jsp?name=<%=Name%>"> here</a></h3>
<h3>View the table of all customers by clicking <a href="customerTable.jsp?name=<%=Name%>"> here</a></h3>
<h3><a href="home.jsp">Sign Out</a></h3>



</body>
</html>