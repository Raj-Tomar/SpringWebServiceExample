package com.raj.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raj.beans.EmployeeBean;
import com.raj.service.EmployeeService;


@RestController
public class WebServiceController {
	
	@Autowired
	EmployeeService employeeService;
	
	private static Logger logger = Logger.getLogger(WebServiceController.class);
	
	@RequestMapping(value = "/testUrl", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> testUrl(@RequestBody String requestData, HttpServletRequest request){
		logger.info("testUrl");
		String str = "test";
		ResponseEntity<String> result = null;
		try {
			result = new ResponseEntity<String>(str, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/saveOrUpdateEmployee", method=RequestMethod.POST, consumes="application/json", produces="applicatin/json")
	@ResponseBody
	public ResponseEntity<String> saveOrUpdateEmployee(@RequestBody String requestData){
		logger.info("saveOrUpdateEmployee in controller");
		ResponseEntity<String> result = null;
		try {
			String status = employeeService.saveOrUpdateEmployee(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/getAllEmployee", method=RequestMethod.POST, consumes="application/json", produces="applicatin/json")
	@ResponseBody
	public ResponseEntity<String> getAllEmployee(@RequestBody String requestData){
		logger.info("getAllEmployee in controller");
		ResponseEntity<String> result = null;
		try {
			List<EmployeeBean> list = employeeService.getEmployeeList();
			result = new ResponseEntity<String>(list.toString(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return result;
	}
}
