package com.prd.test.handler;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.prd.test.EmployeeServiceException;
import com.prd.test.delegate.EmployeeMongoDalegate;
import com.prd.test.mapper.EmployeeDataMapper;
import com.prd.test.util.LoggingConstants;
import com.prd.test.vo.mongo.Employee;
import com.prd.test.vo.request.EmployeeRequest;

public class EmployeeAddHandler{

	@Resource(name = "empMongoDel")
	private EmployeeMongoDalegate empMongoDel;
	
	@Resource(name = "empDataMapper")
	private EmployeeDataMapper empDataMapper;
	
	final static Logger logger = Logger.getLogger(EmployeeAddHandler.class);
	
	public String handleRequest(final EmployeeRequest objEmpReq) throws EmployeeServiceException{
		logger.info(LoggingConstants.ENTRY);
		Employee objEmp = empDataMapper.mapEmployeeData(objEmpReq);		
		String result = empMongoDel.addEmployee(objEmp, objEmpReq.getDeptName());
		logger.info(LoggingConstants.EXIT);
		return result;
	}

}
