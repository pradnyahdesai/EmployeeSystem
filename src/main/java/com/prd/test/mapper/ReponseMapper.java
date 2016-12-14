package com.prd.test.mapper;

import javax.annotation.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prd.test.util.CounterUtil;
import com.prd.test.vo.mongo.Employee;
import com.prd.test.vo.request.EmployeeRequest;
import com.prd.test.vo.response.GlobalResponse;

public class ReponseMapper {
	
	@Resource(name = "objMapper")
	ObjectMapper objMapper;
	
	public String buildGlobalReponse(String status, String reponseString, String responseCode){
		
		String respString = buildEmployeeReponse(status, reponseString, responseCode, null);
		return respString;
	}
	
	public String buildEmployeeReponse(String status, String reponseString, String responseCode, Employee objEmployee){
		
		GlobalResponse objGlobalResponse = new GlobalResponse();
		
		objGlobalResponse.setReturnCode(responseCode);
		objGlobalResponse.setReturnMessage(reponseString);
		objGlobalResponse.setStatus(status);
		
		if(objEmployee != null){
			objGlobalResponse.setEmployeeDetails(objEmployee);
		}
		
		String respString = null;
		
		try{
			respString = objMapper.writeValueAsString(objGlobalResponse);
		}catch(Exception ex){
			respString = "{ \"ReturnMessage\" : \"UnknownError\"}";
		}
		System.out.println("buildEmployeeReponse : "  + respString);
		
		return respString;
	}
}
