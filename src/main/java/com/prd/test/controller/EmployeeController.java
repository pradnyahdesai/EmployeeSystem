package com.prd.test.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prd.test.EmployeeServiceException;
import com.prd.test.handler.EmployeeAddHandler;
import com.prd.test.handler.EmployeeQueryHandler;
import com.prd.test.mapper.ReponseMapper;
import com.prd.test.util.LoggingConstants;
import com.prd.test.vo.mongo.Employee;
import com.prd.test.vo.request.EmployeeRequest;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	final static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private ApplicationContext context;
	
	@Resource(name = "objRespMapper")
	ReponseMapper objRespMapper;
	
	@RequestMapping(value = "/getEmployee/{empName}/{empLsNm}/{dob}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getEmployee(@PathVariable(value = "empName") String empName, @PathVariable(value = "empLsNm") String empLastName
			, @PathVariable(value = "dob") String birthDate){	
		logger.info(LoggingConstants.ENTRY);
		
		String result = null;
		String status = "Success";
		HttpStatus responseCode = HttpStatus.OK; 
		
		EmployeeQueryHandler objEmpQHandler = (EmployeeQueryHandler)context.getBean("empQueryHandler");
		
		Employee objEmployee = objEmpQHandler.handleRequest(empName, empLastName, birthDate);
		
		if(objEmployee == null){
			status = "Failure";
			result = "Error While Fetching Employee Data";
			responseCode = HttpStatus.BAD_REQUEST; 
		}	
		
		String respString = objRespMapper.buildEmployeeReponse(status, result, responseCode.toString(),objEmployee);
			
		logger.info(LoggingConstants.EXIT);
		return new ResponseEntity<String>(respString, new HttpHeaders(), responseCode);
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addEmployee(@RequestBody final EmployeeRequest request){	
		
		logger.info(LoggingConstants.ENTRY);
		String result = null;
		String status = "Success";
		HttpStatus responseCode = HttpStatus.CREATED;
		EmployeeAddHandler objEmpAddHandler = (EmployeeAddHandler)context.getBean("empAddHandler");

		try{				
			result =  objEmpAddHandler.handleRequest(request);
		}catch(EmployeeServiceException empEx){
			result = empEx.getMessage();
			responseCode = empEx.getErrorCode();
			status = "Failure";
		}
		
		String respString = objRespMapper.buildGlobalReponse(status, result, responseCode.toString());
		
		logger.info(LoggingConstants.EXIT);
		
		return new ResponseEntity<String>(respString, new HttpHeaders(), responseCode);
	}

}
