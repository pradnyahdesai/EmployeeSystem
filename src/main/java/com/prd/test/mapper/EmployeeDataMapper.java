package com.prd.test.mapper;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.prd.test.handler.EmployeeAddHandler;
import com.prd.test.util.CounterUtil;
import com.prd.test.util.LoggingConstants;
import com.prd.test.vo.mongo.Employee;
import com.prd.test.vo.request.EmployeeRequest;

public class EmployeeDataMapper {
	
	final static Logger logger = Logger.getLogger(EmployeeAddHandler.class);
	
	@Resource(name = "objCounterUtil")
	private CounterUtil objCounterUtil;

	public Employee mapEmployeeData(EmployeeRequest objEmpReq){
		logger.info(LoggingConstants.ENTRY);
		Employee objEmp = new Employee();
		objEmp.setEmpFirstName(objEmpReq.getEmpFirstName());
		objEmp.setEmpLastName(objEmpReq.getEmpLastName());		
		objEmp.setDateOfBirth(objEmpReq.getDateOfBirth());
		
		objEmp.setDesignation(objEmpReq.getDesignation());
		
		objEmp.setEmpId(String.valueOf(objCounterUtil.getNextSequence("EmpId")));
		
		objEmp.setJoiningDate(objEmpReq.getJoiningDate());
		objEmp.setSalary(Double.valueOf(objEmpReq.getSalary()));
		
		logger.info(LoggingConstants.EXIT);
		return objEmp;
	}
	
	
}
