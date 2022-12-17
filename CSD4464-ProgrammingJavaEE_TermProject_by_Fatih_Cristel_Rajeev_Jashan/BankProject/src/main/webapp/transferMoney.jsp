<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
<style>
 body{
	background-image:url('https://t3.ftcdn.net/jpg/02/97/45/58/360_F_297455861_5KvVjKvwEMTs4LYQuytQNbehvhOWiXme.jpg');
    height: 100%;
    background-size: cover;}

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
<%String acount_no=request.getParameter("account"); %>
<%String balance=request.getParameter("crnt_balance"); %>
<h1>Bank of Toronto</h1>
<h2>Make an transfer</h2>
<form method="POST" action="/BankProject/transfer">
<input type="email" name="email" placeholder="Enter the email" required>
<input type="number" name="amount" placeholder="Enter the amount" required>
<input type="hidden" name="account" value="<%=acount_no%>"/>
<input type="hidden" name="name" value="<%=Name%>"/>
<input type="hidden" name="balance" value="<%=balance%>"/>
<button type="submit">Transfer</button>
</form>
</body>
</html>