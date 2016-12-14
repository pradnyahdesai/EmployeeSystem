package com.prd.test.delegate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;

import com.prd.test.EmployeeServiceException;
import com.prd.test.dao.DepartmentDAO;
import com.prd.test.dao.EmployeeDAO;
import com.prd.test.util.LoggingConstants;
import com.prd.test.vo.mongo.Department;
import com.prd.test.vo.mongo.Employee;

public class EmployeeMongoDalegate implements InitializingBean{
	
	private static final String rootDept = "CEO";
	
	final static Logger logger = Logger.getLogger(EmployeeMongoDalegate.class);
	
	Map<String, String> initialDeptMap = new HashMap<String, String>(){/**
		 * 
		 */
		private static final long serialVersionUID = 4136985113464463363L;

	{
		put("CEO", "Root Department");
		put("Admin", "Admistrative");
		put("HR", "Human Resource");
		put("Technology", "Information Technology");
		put("Business", "Business Team");
		put("Product", "Product Group");
		
	}};
	
	
	@Resource(name = "objEmpDAO")
	private EmployeeDAO objEmpDAO;
	
	@Resource(name = "objDeptDAO")
	private DepartmentDAO objDeptDAO;
	
	public String addEmployee(Employee objEmp, String deptName) throws EmployeeServiceException{
	
		String result = "";
		HttpStatus errorCode = null;
		logger.info(LoggingConstants.ENTRY);
		
		try{
			Department currDept = objDeptDAO.findDepartment(deptName);
			if(currDept != null && currDept.getDeptName() != null){
				Employee currEmployee = objEmpDAO.findEmployee(objEmp.getEmpFirstName(),objEmp.getEmpLastName(), objEmp.getDateOfBirth());
				if(currEmployee == null || currEmployee.getEmpFirstName() == null){
					objEmp.setDeptId(currDept.getDeptId());
					objEmpDAO.addEmployee(objEmp);
					result = "SuccessFully Inserted Employee";
				}else{
					logger.error("Cannot insert Employee Record. Employee with same name and birth Date Already Exists : " 
							+ objEmp.getEmpFirstName() + " " + objEmp.getEmpLastName() + " , Birth Date : " + objEmp.getDateOfBirth());
					result = "Cannot insert Employee Record. Employee with same name and birth Date Already Exists";
					errorCode = HttpStatus.BAD_REQUEST;
					throw new EmployeeServiceException(result, errorCode);
				}
			}else{
				logger.error("Cannot insert Employee Record. Invalid Department : " + deptName);
				errorCode = HttpStatus.BAD_REQUEST;
				result = "Cannot insert Employee Record. Invalid Department : " + deptName;
				throw new EmployeeServiceException(result, errorCode);
			}
		}catch(Exception ex){
			result = "Error While Inserting Employee Record : " + ex.toString();
			throw new EmployeeServiceException(result, errorCode);
		}
		
		logger.info(LoggingConstants.EXIT);
		return result;
	}
	
	public Employee findEmployee(String empName, String empLastName, String birthDate){
		logger.info(LoggingConstants.ENTRY);
		
		Employee objEmployee = objEmpDAO.findEmployee(empName,empLastName, birthDate);
		
		logger.info(LoggingConstants.EXIT);
		
		return objEmployee;
	}

	public void afterPropertiesSet() throws Exception {
		logger.info(LoggingConstants.ENTRY);
		//find root department
		Department currDept = objDeptDAO.findDepartment(rootDept);
		
		if(currDept == null || currDept.getDeptName() == null){
			Set<String> keySet = initialDeptMap.keySet();
			String key = null;
			String descr = null;
			List<Department> deptList = new ArrayList<Department>();
			Iterator<String> keyIt = keySet.iterator();
			for(int i=0; i< keySet.size(); i++){
				key = keyIt.next();
				descr = initialDeptMap.get(key);
				Department objDept = new Department();
				objDept.setDeptId(String.valueOf(i+1));
				objDept.setDeptName(key);
				objDept.setDeptDescription(descr);
				
				deptList.add(objDept);
							
			}
			
			objDeptDAO.addDepartments(deptList);
		}else{
			logger.info("Skiping Deptarment initialization Step : ");
		}
		
		logger.info(LoggingConstants.EXIT);
	}

}
