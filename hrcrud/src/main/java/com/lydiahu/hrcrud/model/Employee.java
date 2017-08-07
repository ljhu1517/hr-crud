package com.lydiahu.hrcrud.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	private BigDecimal id;
	private String firstName; 
	private String lastName; 
	private String email; 
	private Date hireDate; 
	private BigDecimal managerId; 

	private BigDecimal salary;
	private Department department;
	private Job job; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public BigDecimal getManagerId() {
		return managerId;
	}
	public void setManagerId(BigDecimal managerId) {
		this.managerId = managerId;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {     
		this.job = job;
	}
	
	public String toString() {
		
		return firstName + " " + lastName;
	}
	
}
