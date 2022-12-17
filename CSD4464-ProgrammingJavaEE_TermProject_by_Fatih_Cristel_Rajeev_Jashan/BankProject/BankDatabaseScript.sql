create database Bank;
CREATE TABLE Customers(
account_no varchar(6) NOT NULL,
full_name varchar(40) NOT NULL,
email varchar(40) NOT NULL,
phone varchar(20) NOT NULL,
pin varchar(4) NOT NULL,
balance int DEFAULT 0);

CREATE TABLE Employees(
emp_id varchar(6) NOT NULL,
full_name varchar(40) NOT NULL,
email varchar(40) NOT NULL,
pwd varchar(30) NOT NULL,
job_title varchar(50));

INSERT INTO Employees(emp_id,full_name,email,pwd,job_title) VALUES('856839','Fatih Caliskan','fatih@bankoftoronto.ca','fatih123','District Manager');
INSERT INTO Customers VALUES('123456','Zafer Caliskan','zafer@gmail.com','1234567891','1974',0),
('654321','Nalan Kirkac','nalan@gmail.com','9876543219','1978',0),
('918374','Sam Johnes','sam@gmail.com','8574621836','1982',0),
('628716','Mallika','mallika@gmail.com','6583618421','2022',245680);

