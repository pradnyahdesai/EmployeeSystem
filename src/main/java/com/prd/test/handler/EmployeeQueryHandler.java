package com.prd.test.handler;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.prd.test.delegate.EmployeeMongoDalegate;
import com.prd.test.util.LoggingConstants;
import com.prd.test.vo.mongo.Employee;

public class EmployeeQueryHandler{

	final static Logger logger = Logger.getLogger(EmployeeQueryHandler.class);
	
	@Resource(name = "empMongoDel")
	private EmployeeMongoDalegate empMongoDel;

	public Employee handleRequest(String empName, String empLastName, String birthDate) {
		logger.info(LoggingConstants.ENTRY);
		// TODO Auto-generated method stub
		Employee objEmployee = empMongoDel.findEmployee(empName, empLastName, birthDate);
		
		logger.info(objEmployee);
		logger.info(LoggingConstants.EXIT);
		return objEmployee;
	}

}
