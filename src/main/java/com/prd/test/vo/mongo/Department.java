package com.prd.test.vo.mongo;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "DEP_INFO")
public class Department {
	
	@Field("DEPT_ID")
	private String deptId;
	
	
	@Field("DEPT_NM")
	private String deptName;
	
	@Field("DEPT_DESC")
	private String deptDescription;


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDeptDescription() {
		return deptDescription;
	}


	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}
	
	
	
}
