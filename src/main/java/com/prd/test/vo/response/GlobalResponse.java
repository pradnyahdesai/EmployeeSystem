package com.prd.test.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.prd.test.vo.mongo.Employee;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"Status",
	"ReturnCode",
	"ReturnMessage",
	"EmployeeDetails"})
public class GlobalResponse {

	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("ReturnCode")
	private String returnCode;
	
	@JsonProperty("ReturnMessage")
	private String returnMessage;
	
	@JsonProperty("EmployeeDetails")
	private Employee employeeDetails;

	

	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getReturnCode() {
		return returnCode;
	}



	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}



	public String getReturnMessage() {
		return returnMessage;
	}



	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}



	public Employee getEmployeeDetails() {
		return employeeDetails;
	}



	public void setEmployeeDetails(Employee employeeDetails) {
		this.employeeDetails = employeeDetails;
	}



	@Override
	public String toString() {
		return "GlobalResponse [status=" + status + ", returnCode=" + returnCode + ", returnMessage=" + returnMessage
				+ ", employeeDetails=" + employeeDetails + "]";
	}

	
	
	
}
