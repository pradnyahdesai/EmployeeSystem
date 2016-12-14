package com.prd.test.vo.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "EMPLOYEE_INFO")
public class Employee {

	@Field("EMP_ID")
	private String empId;
	
	@Field("EMP_FIRST_NM")
	private String empFirstName;
	
	@Field("EMP_LAST_NM")
	private String empLastName;
	
	@Field("JOINING_DT")
	private String joiningDate;
	
	@Field("BIRTH_DT")
	private String dateOfBirth;
	
	@Field("SAL_AMT")
	private Double salary;
	
	@Field("DEP_ID")
	private String deptId;
	
	@Field("DESIGNATION")
	private String designation;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	

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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", joiningDate=" + joiningDate + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + ", deptId="
				+ deptId + "]";
	}
	
	
	
}
