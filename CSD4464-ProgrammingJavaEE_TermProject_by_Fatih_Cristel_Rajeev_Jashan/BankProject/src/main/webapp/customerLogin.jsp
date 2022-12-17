<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Customer Login </title>  
<style>   
Body {  
background-image:url('https://t3.ftcdn.net/jpg/02/97/45/58/360_F_297455861_5KvVjKvwEMTs4LYQuytQNbehvhOWiXme.jpg');
background-size:cover;
font-family: Calibri, Helvetica, sans-serif;   
}  
button {   
       background-color: green;   
       width: 100%;  
        color: black;   
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid black;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }    
        
     
 .container {   
        padding: 25px;    
    }  
    
    h1{
    text-align:center;
	text-shadow: 2px 2px 4px black;
	padding-top: 10px;
	color:green;
	font-size: 50px;
} 
}

</style>   
</head>    
<body>    
<h1>Bank of Toronto</h1>
    <h2 style="text-align:center;"> Customer Login  </h2>   
    <form action="/BankProject/customer_login" method="post">  
        <div class="container">   
            <label>Account Number: </label>   
            <input type="text" placeholder="Enter account number" name="username" required>  
            <label>Pin: </label>   
            <input type="password" placeholder="4-digits" name="pin" required>  
            <input type="checkbox" checked="checked"> Remember me<br> 
            <button type="submit">Login</button>   
               
            <p style="text-align:center;"><a href="#"> Forgot password? </a>   </p>
        </div>   
    </form>     
</body>     
</html>  