package com.cestar.model;

public class Customer {
	private String account_no;
	private String full_name;
	private String email;
	private String phone;
	private String pin;
	private Integer balance;
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Customer(String account_no, String full_name, String email, String phone, String pin, Integer balance) {
		super();
		this.account_no = account_no;
		this.full_name = full_name;
		this.email = email;
		this.phone = phone;
		this.pin = pin;
		this.balance = balance;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
