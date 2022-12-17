<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background-image:url('https://t3.ftcdn.net/jpg/02/97/45/58/360_F_297455861_5KvVjKvwEMTs4LYQuytQNbehvhOWiXme.jpg');
background-size:cover;}
*{
text-align:center;
}
table {

  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  
}
td, tr{
padding-bottom:10px;
text-align:center;
}
.center, .centerA {
  margin-left: auto;
  margin-right: auto;
}
    h1{
  text-align:center;
	text-shadow: 2px 2px 4px black;
	color:green;
	font-size: 50px;

</style>

</head>
<body>
<h1>Bank of Toronto</h1>
<h2>Create an account</h2>
<%String Name=request.getParameter("name"); %>
<p><%=Name%></p>
<form action="/BankProject/register" method="post">
			<table class="center">
				<tr>
					<td>New Account's Number</td>
					<td><input type="text" name="accno" required/></td>
				</tr>
				
				<tr>
					<td>Full Name</td>
					<td><input type="text" name="full_name" required/></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="number" name="phone" required/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required/></td>
				</tr>
				<tr>
					<td>pin</td>
					<td><input type="text" name="pin" placeholder="4-digits" required/></td>
				</tr>
				</table>
				<br>
			<input type="hidden" name="user" value="<%=Name%>"/>
			<button type="submit">Register</button> </form>



</body>
</html>