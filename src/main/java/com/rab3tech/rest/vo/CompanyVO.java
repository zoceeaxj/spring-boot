package com.rab3tech.rest.vo;

import java.util.List;

public class CompanyVO {
	
	private int cid;
	private String name;
	private String location;
	private List<EmployeVO> employeVOs;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<EmployeVO> getEmployeVOs() {
		return employeVOs;
	}
	public void setEmployeVOs(List<EmployeVO> employeVOs) {
		this.employeVOs = employeVOs;
	}
	@Override
	public String toString() {
		return "CompanyVO [cid=" + cid + ", name=" + name + ", location=" + location + ", employeVOs=" + employeVOs
				+ "]";
	}
	
	

}
