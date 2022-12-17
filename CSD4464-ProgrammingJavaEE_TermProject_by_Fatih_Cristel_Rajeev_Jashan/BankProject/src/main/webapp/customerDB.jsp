<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Profile</title>
<style>
*{
text-align:center;
}
    body{
	background-image: url('https://t3.ftcdn.net/jpg/02/97/45/58/360_F_297455861_5KvVjKvwEMTs4LYQuytQNbehvhOWiXme.jpg');
    height: 100%;
    background-size: cover;
    
}

    h1{
  
	text-shadow: 2px 2px 4px black;
	padding-top: 10px;
	color:green;
	font-size: 50px;
</style>
</head>
<body>
<%String Name=request.getParameter("name"); %>
<%String balance=request.getParameter("crnt_balance"); %>
<%String acount_no=request.getParameter("account"); %>
<h1>Bank of Toronto</h1>
<h2>Good day <%=Name%>!</h2>
<h2>Your account balance is <%=balance%></h2>
<h3>Here are the list of actions that you can take:</h3>

<p><a href="transferMoney.jsp?account=<%=acount_no%>&name=<%=Name%>&crnt_balance=<%=balance%>">Transfer Money</a></p>
<p><a href="depositMoney.jsp?account=<%=acount_no%>&name=<%=Name%>&crnt_balance=<%=balance%>">Make a Deposit</a></p>
<p><a href="withdrawMoney.jsp?account=<%=acount_no%>&name=<%=Name%>&crnt_balance=<%=balance%>">Withdraw Money</a></p>
<p><a href="payBills.jsp?account=<%=acount_no%>&name=<%=Name%>&crnt_balance=<%=balance%>">Pay Bills</a></p>
<p><a href="home.jsp">Log Out</a></p>
</body>
</html>