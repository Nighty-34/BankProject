package com.cestar.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.dao.empDao;
import com.cestar.model.Customer;
import com.cestar.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	empDao dao = new empDao();
	/**
     * Default constructor. 
     */
    public Controller() {
        super();
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String url = request.getServletPath();
		switch(url) {
		case ("/login"):{
			logining(request,response);
			break;
		}
		case ("/customer_login"):{
			cust_login(request,response);
			break;
		}
		case ("/register"):{
			registered(request,response);
			break;
		}
		case ("/deposit"):{
			deposited(request,response);
			break;
		}
		case ("/withdraw"):{
			withdrawed(request,response);
			break;
		}
		case ("/transfer"):{
			transfered(request,response);
			break;
		}
		case ("/pay_bills"):{
			payedBills(request,response);
			break;
		}
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void payedBills(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String fn = request.getParameter("name");
		String accountNo=request.getParameter("account");
		String bill=request.getParameter("bills");
		int amount=Integer.parseInt(request.getParameter("amount"));
		int balance=Integer.parseInt(request.getParameter("balance"));
		if (balance>=amount) {
			balance-=amount;
			empDao dao = new empDao();
			Connection con = dao.getConnection();
			String sql ="UPDATE Customers SET balance=(balance-"+amount+") WHERE account_no = '"+accountNo+"'";
			try {
				con.setAutoCommit(true);
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sql);
				out.print("<h1>You have paid "+amount+" dollars off of your "+bill+" bill!!!</h1><br><a href='customerDB.jsp?name="+fn+"&account="+accountNo+"&crnt_balance="+balance+"'>Go back to dashboard</a>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error happened");
				
			}
		}
		else {
			out.print("You do not have enough money in you account to withdraw "+amount+" dollars.\nCurrent Balance is: "+balance);
		}
	}	
	protected void transfered(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String fn = request.getParameter("name");
		String accountNo=request.getParameter("account");
		String email = request.getParameter("email");
		int amount=Integer.parseInt(request.getParameter("amount"));
		int balance=Integer.parseInt(request.getParameter("balance"));
	    empDao dao = new empDao();
	    Connection con = dao.getConnection();
	    String sql1="select * from Customers";
		List<Customer> list=new ArrayList<Customer>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql1);	
			while(rs.next())
			{
				Customer stdnt=new Customer(rs.getString("account_no"),rs.getString("full_name"),rs.getString("email"),rs.getString("phone"),rs.getString("pin"),rs.getInt("balance"));
				list.add(stdnt);
			}	
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (balance>=amount) {
			Boolean found=false; 
			for (int i = 0; i < list.size(); i++) { 
		          if (email.equals(list.get(i).getEmail()))	{
		        	  found=true;
		        	  balance-=amount;
		  			String sql ="UPDATE Customers SET balance=(balance-"+amount+") WHERE account_no = '"+accountNo+"'";
		  			try {
		  				con.setAutoCommit(true);
		  				Statement stmt = con.createStatement();
		  				stmt.executeUpdate(sql);
		  			} catch (SQLException e) {
		  				// TODO Auto-generated catch block
		  				e.printStackTrace();
		  				System.out.println("error happened");
		  				
		  			}
		  			sql ="UPDATE Customers SET balance=(balance+"+amount+") WHERE email = '"+email+"'";
		  			try {
		  				con.setAutoCommit(true);
		  				Statement stmt = con.createStatement();
		  				stmt.executeUpdate(sql);
		  				out.print("<h1>Money has been withdrawed from your account!!!</h1><br><a href='customerDB.jsp?name="+fn+"&account="+accountNo+"&crnt_balance="+balance+"'>Go back to dashboard</a>");
		  			} catch (SQLException e) {
		  				// TODO Auto-generated catch block
		  				e.printStackTrace();
		  				System.out.println("error happened");
		  				
		  			}
		  		}
		         
		          
		  		
		          }
			if (!found) {
				out.print("There is no account assoicieted with this email!!!");
			}
		}
		else {
  			out.print("You do not have enough money in you account to make "+amount+" dollars transfer.\nCurrent Balance is: "+balance);
  		}
			
	}
	protected void withdrawed(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String fn = request.getParameter("name");
		String accountNo=request.getParameter("account");
		int amount=Integer.parseInt(request.getParameter("amount"));
		int balance=Integer.parseInt(request.getParameter("balance"));
		if (balance>=amount) {
			balance-=amount;
			empDao dao = new empDao();
			Connection con = dao.getConnection();
			String sql ="UPDATE Customers SET balance=(balance-"+amount+") WHERE account_no = '"+accountNo+"'";
			try {
				con.setAutoCommit(true);
				Statement stmt = con.createStatement();
				stmt.executeUpdate(sql);
				out.print("<h1>Money has been withdrawed from your account!!!</h1><br><a href='customerDB.jsp?name="+fn+"&account="+accountNo+"&crnt_balance="+balance+"'>Go back to dashboard</a>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error happened");
				
			}
		}
		else {
			out.print("You do not have enough money in you account to withdraw "+amount+" dollars.\nCurrent Balance is: "+balance);
		}
	}	
	protected void deposited(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String fn = request.getParameter("name");
		String accountNo=request.getParameter("account");
		int amount=Integer.parseInt(request.getParameter("amount"));
		int balance=Integer.parseInt(request.getParameter("balance"));
		balance+=amount;
		empDao dao = new empDao();
		Connection con = dao.getConnection();
		String sql ="UPDATE Customers SET balance=(balance+"+amount+") WHERE account_no = '"+accountNo+"'";
		try {
			con.setAutoCommit(true);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			out.print("<h1>Money has been deposited to your account!!!</h1><br><a href='customerDB.jsp?name="+fn+"&account="+accountNo+"&crnt_balance="+balance+"'>Go back to dashboard</a>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error happened");
			
		}
	}
	protected void cust_login(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
	    String username=request.getParameter("username");
	    String pin=request.getParameter("pin");
	    empDao dao = new empDao();
	    Connection con = dao.getConnection();
		String sql="select * from Customers";
		List<Customer> list=new ArrayList<Customer>();

		//For Select statement we can use Connection Interface
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);	
			while(rs.next())
			{
				Customer custs=new Customer(rs.getString("account_no"),rs.getString("full_name"),rs.getString("email"),rs.getString("phone"),rs.getString("pin"),rs.getInt("balance"));
				list.add(custs);
			}	
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int found=0;
		String fn = null;
		int blnc = 0;
		String acntno=null;
		for (int i = 0; i < list.size(); i++) { 
			String username1=list.get(i).getAccount_no();
			String pin1=list.get(i).getPin();
			
	          if (username.equals(username1)&&pin.equals(pin1))	{
	        	  found=1;
	        	  fn = list.get(i).getFull_name();
	        	  blnc = list.get(i).getBalance();
	        	  acntno = list.get(i).getAccount_no();
	        	  break;
	          } 
	      } 
		if(found==1) {
			response.sendRedirect(request.getContextPath() + "/customerDB.jsp?name="+fn+"&crnt_balance="+blnc+"&account="+acntno);
		}
		else {
			out.println("wrong password or email");
		}
	}
	protected void registered(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("user");
		PrintWriter out = response.getWriter();
	    empDao dao = new empDao();
	    Connection con = dao.getConnection();
	    String accno=request.getParameter("accno");
	    String name =request.getParameter("full_name");
	    String email=request.getParameter("email");
	    String phone=request.getParameter("phone");
	    String pin=request.getParameter("pin");
	    int balance = 0;
	    String sql="select * from Customers";
		List<Customer> list=new ArrayList<Customer>();

		//For Select statement we can use Connection Interface
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);	
			while(rs.next())
			{
				Customer stdnt=new Customer(rs.getString("account_no"),rs.getString("full_name"),rs.getString("email"),rs.getString("phone"),rs.getString("pin"),rs.getInt("balance"));
				list.add(stdnt);
			}	
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean found=false;
		for (int i = 0; i < list.size(); i++) { 
	          if (accno.equals(list.get(i).getAccount_no()))	{
	        	  out.print("<h1>Customer with this account number exists already!!!</h1>");
	        	  found = true;
	          }

	      }
		if (!found) {
			try {
    			PreparedStatement st=con.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?,?)");
    			st.setString(1, accno);
    			st.setString(2, name);
    			st.setString(3, email);
    			st.setString(4, phone);
    			st.setString(5, pin);
    			st.setInt(6, balance);
    			st.executeUpdate();
                st.close();
                
                out.print("<h1>Account has been created!!!</h1><br><a href='employeeDB.jsp?name="+user+"'>Go back to dashboard</a>");

    		} 	
    		catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    			System.out.println("something is wrong");//localhost:8080/BankProject/employeeLogin.jsp
    		}
		}
	}
	protected void logining(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    empDao dao = new empDao();
	    Connection con = dao.getConnection();
		String sql="select * from Employees";
		List<Employee> list=new ArrayList<Employee>();

		//For Select statement we can use Connection Interface
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);	
			while(rs.next())
			{
				Employee empl=new Employee(rs.getString("emp_id"),rs.getString("full_name"),rs.getString("email"),rs.getString("pwd"),rs.getString("job_title"));
				list.add(empl);
			}	
		} 	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int found=0;
		String fn = null;
		for (int i = 0; i < list.size(); i++) { 
			String username1=list.get(i).getEmp_id();
			String password1=list.get(i).getPassword();
			
	          if (username.equals(username1)&&password.equals(password1))	{
	        	  found=1;
	        	  fn = list.get(i).getFull_name();
	        	  break;
	          } 
	      } 
		if(found==1) {
			response.sendRedirect(request.getContextPath() + "/employeeDB.jsp?name="+fn);
		}
		else {
			out.println("wrong password or email");
		}
	}

}
