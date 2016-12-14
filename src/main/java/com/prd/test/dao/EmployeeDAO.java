package com.prd.test.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prd.test.delegate.EmployeeMongoDalegate;
import com.prd.test.util.LoggingConstants;
import com.prd.test.vo.mongo.Employee;

public class EmployeeDAO {
	
	@Resource(name = "mongoOperations")
	private MongoOperations mongoOperations;
	
	final static Logger logger = Logger.getLogger(EmployeeDAO.class);
	
	public void addEmployee(Employee objEmp){
		logger.info(LoggingConstants.ENTRY);
		mongoOperations.save(objEmp);	
		logger.info(LoggingConstants.EXIT);
	}
	
	public Employee findEmployee(String firstName, String lastName, String birthDate){
		logger.info(LoggingConstants.ENTRY);
		Employee currEmp=  null;
		Query empQuery = new Query();
		empQuery.addCriteria(Criteria.where("EMP_FIRST_NM").is(firstName).and("EMP_LAST_NM").is(lastName));
		empQuery.addCriteria(Criteria.where("BIRTH_DT").is(birthDate));
		currEmp= mongoOperations.findOne(empQuery, Employee.class);
		logger.info(LoggingConstants.EXIT);
		return currEmp;
	}

}
