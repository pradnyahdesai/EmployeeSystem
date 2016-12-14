package com.prd.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.prd.test.util.LoggingConstants;
import com.prd.test.vo.mongo.Department;

public class DepartmentDAO {
	
	final static Logger logger = Logger.getLogger(DepartmentDAO.class);
	
	@Resource(name = "mongoOperations")
	private MongoOperations mongoOperations;
	
	public void addDepartments(List<Department> deptList){
		logger.info(LoggingConstants.ENTRY);
		mongoOperations.insertAll(deptList);
		logger.info(LoggingConstants.EXIT);
		
	}
	
	public Department findDepartment(String deptName){
		logger.info(LoggingConstants.ENTRY);
		Department currDept=  null;
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("DEPT_NM").is(deptName));
		currDept= mongoOperations.findOne(query2, Department.class);
		
		logger.info(LoggingConstants.EXIT);
		return currDept;
	}

}
