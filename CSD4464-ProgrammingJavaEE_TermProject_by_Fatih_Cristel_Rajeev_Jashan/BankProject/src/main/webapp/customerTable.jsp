<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
<style>
 body{
 background-image:url('https://t3.ftcdn.net/jpg/02/97/45/58/360_F_297455861_5KvVjKvwEMTs4LYQuytQNbehvhOWiXme.jpg');
    height: 100%; 
    background-size: cover;}
    h1{
  text-align:center;
	text-shadow: 2px 2px 4px black;
	color:green;
	font-size: 50px;
</style>
</head>
<body>
<%String Name=request.getParameter("name"); %>
    <sql:setDataSource
        var="myDS" 
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/Bank"
        user="root" password="fatih2013"
    />
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM Customers;
    </sql:query>
<h1>Bank of Toronto</h1>
<div align="center">
        <table border="1" cellpadding="5">
            <caption>List Of Customers</caption>
            <tr>
                <th>Account No</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>phone</th>
                <th>balance</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.account_no}" /></td> 
                    <td><c:out value="${user.full_name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.phone}" /></td>
                    <td><c:out value="${user.balance}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <h3>Go back to Dashboard <a href="employeeDB.jsp?name=<%=Name%>"> here</a></h3>
</body>
</html>