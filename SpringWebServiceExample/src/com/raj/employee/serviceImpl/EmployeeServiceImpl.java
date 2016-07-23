package com.raj.employee.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.raj.beans.EmployeeBean;
import com.raj.employee.dao.EmployeeDao;
import com.raj.employee.service.EmployeeService;

@Service
@Scope(value = "prototype")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;
	private JSONObject requestJson = null;
	private JSONObject responseJson = null;
	private Gson gson = null;
	
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Override
	public String saveOrUpdateEmployee(String requestData) {
		logger.info("saveOrUpdateEmployee in ServiceImpl");
		try {
			requestJson = new JSONObject(requestData);
			JSONObject jObj = requestJson.getJSONObject("requestData");
			gson = new Gson();
			EmployeeBean bean = gson.fromJson(jObj.get("emp").toString(), EmployeeBean.class);
			String status = employeeDao.saveOrUpdateEmployee(bean);
			responseJson = new JSONObject();
			responseJson.put("status", status);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

	@Override
	public String getEmployeeList(String requestData) {
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
	public String getEmployeeById(String requestData) {
		String status = "0";
		try {
			logger.info(requestData);
			requestJson = new JSONObject(requestData);
			JSONObject jObj = requestJson.getJSONObject("requestData");
			String empId = jObj.get("empId").toString();
			Integer id = Integer.parseInt(empId);
			EmployeeBean bean = employeeDao.getEmployeeById(id);
			responseJson = new JSONObject();
			if(null != bean){
				status = "1";
				gson = new Gson();
				responseJson.put("status", status);
				responseJson.put("emp", gson.toJson(bean));
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

	@Override
	public String deleteEmployee(String requestData) {
		try {
			logger.info("deleteEmployee: "+requestData);
			requestJson = new JSONObject(requestData);
			JSONObject jObj = requestJson.getJSONObject("requestData");
			String empId = jObj.get("empId").toString();
			Integer id = Integer.parseInt(empId);
			String status = employeeDao.deleteEmployee(id);
			responseJson = new JSONObject();
			responseJson.put("status", status);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

}
