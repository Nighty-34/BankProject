package com.cestar.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class empDao {
//Write a method which returns a Connection Object for
public Connection getConnection()
{
Connection con = null;
String user="root";
String pwd="fatih2013";
String url="jdbc:mysql://localhost:3306/Bank";		
//Load or Register the driver for Mysql
try {
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url,user,pwd);
	System.out.println("Connection successful!!!");
}
catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return con;
}



}