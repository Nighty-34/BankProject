<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
    <title>Bank of Toronto</title>
    <style>
    body{
    background-image:url('https://t3.ftcdn.net/jpg/02/08/78/54/240_F_208785472_e8eEaUreV9Qew7teCXMFFFjNvonaRp3v.jpg');
    height: 100%;
    background-size: cover;
    
}
    
h1{
	text-shadow: 3px 3px 6px black;
	padding-top: 50px;
	color:green;
	font-size: 75px;
}
body{

	padding-top: 20px;
	padding-left: 10px;
	text-align: center;
}

footer{
	  margin-top: 40px;
}
footer a{
	  text-decoration: none;
	  font-size: 20px;
	  border: 2.5px solid green;
	  color: black;
	  background-image: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4));
	  margin: 10px;
      padding: 5px 50px;
      padding-bottom: 8px;
      transition: 0.3s ease;
  
}
footer a:hover{
	background-color: #000;
	color: #fff;
	border: 2.5px solid green;
}
p{
	font-family: "Times New Roman", Times, serif;
	font-size: 20px;
	padding-left:20px;
	padding-right: 20px;
}
nav a{
	  float:right;
	  font-size: 20px;
	  text-decoration: none;
	  border: 2.5px solid green;
	  color: black;
	  background-image: linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3));
      margin-top: 10px;
      margin-right: 50px;
      padding: 5px 30px;
      transition: 0.3s ease;
}
body nav a:hover{
	background-color: #000;
		color: #fff;
		border: 2.5px solid green;

}
    </style>
</head>
<body>
 <nav>
   <a style="color:white;" href="#">About Us</a>
 </nav>
<header>
  <h1>Bank of Toronto</h1>
</header>
 <h2 style="color:green;"> Let's Make Things Happen! </h2>

 <p style="color:green; ">We are one of North America's leading diversified financial services companies, and provide personal and commercial banking, <br>wealth management, insurance, investor services and capital markets products and services on a global basis.<br>
 Choose one of the options below to start using our services.
 </p>
 <footer>
	<a style="color:white;" href="employeeLogin.jsp">Employee Login</a>
	<a style="color:white;" href="customerLogin.jsp">Customer Login</a>
 </footer>
</body>
</html>
