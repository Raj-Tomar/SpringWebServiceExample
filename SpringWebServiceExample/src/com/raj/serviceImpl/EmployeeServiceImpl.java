package com.raj.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.raj.beans.EmployeeBean;
import com.raj.dao.EmployeeDao;
import com.raj.dto.KeyValueDto;
import com.raj.service.EmployeeService;

@Service
@Scope(value = "prototype")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	private JSONObject requestJson = null;
	private JSONObject responseJson = null;
	
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Override
	public String saveOrUpdateEmployee(String requestData) {
		logger.info("saveOrUpdateEmployee in ServiceImpl");
		try {
			requestJson = new JSONObject(requestData);
			logger.info("Requested Data: "+requestJson.toString());
			logger.info("Request Data: "+requestData);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return null;
	}

	@Override
	public String getEmployeeList() {
		String status = "0";
		List<EmployeeBean> list = null;
		try {
			list = employeeDao.getEmployeeList();
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status",status);
				responseJson.put("empList",list);
			}
			else{
				responseJson.put("status",status);
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
			e.printStackTrace();
		}
		return responseJson.toString();
	}

	@Override
	public String getEmployeeById(Integer id) {
		return null;
	}

	@Override
	public String updateEmployee(Integer id) {
		return null;
	}

	@Override
	public String googlePieChart(String requestData) {
		String status = "0";
		List<KeyValueDto> list = null;
		try {
			list = employeeDao.googlePieChart(requestData);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("keyValue", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

}
