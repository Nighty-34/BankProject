package com.cestar.model;

public class Employee {
	private String emp_id;
	private String full_name;
	private String email;
	private String password;
	private String job_title;
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public Employee(String emp_id, String full_name, String email, String password, String job_title) {
		super();
		this.emp_id = emp_id;
		this.full_name = full_name;
		this.email = email;
		this.password = password;
		this.job_title = job_title;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
