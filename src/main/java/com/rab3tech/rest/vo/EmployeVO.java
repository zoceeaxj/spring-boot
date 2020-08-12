package com.rab3tech.rest.vo;

public class EmployeVO {
	
	private String name;
	private String email;
	private int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeVO [name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}
	
	

}
