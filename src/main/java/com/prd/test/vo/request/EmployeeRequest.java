package com.prd.test.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"empFirstName",
	"empLastName",
	"joiningDate",
	"dateOfBirth",
	"salary",
	"deptName",
	"designation"})

public class EmployeeRequest {

	
	@JsonProperty("empFirstName")
	private String empFirstName;
	
	@JsonProperty("empLastName")
	private String empLastName;
	
	@JsonProperty("joiningDate")
	private String joiningDate;
	
	@JsonProperty("dateOfBirth")
	private String dateOfBirth;
	
	@JsonProperty("salary")
	private String salary;
	
	@JsonProperty("deptName")
	private String deptName;
	
	@JsonProperty("designation")
	private String designation;

	
	

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Employee [empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", joiningDate=" + joiningDate + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + ", deptName="
				+ deptName + "]";
	}
	
	
	
}
