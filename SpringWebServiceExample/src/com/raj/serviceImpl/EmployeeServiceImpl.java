package com.raj.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.raj.beans.EmployeeBean;
import com.raj.dao.EmployeeDao;
import com.raj.service.EmployeeService;

@Service
@Scope(value = "prototype")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDao employeeDao;
	
	private static Logger logger = Logger.getLogger(EmployeeServiceImpl.class);

	@Override
	public String saveOrUpdateEmployee(String requestData) {
		logger.info("saveOrUpdateEmployee in ServiceImpl");
		try {
			logger.info("Request Data: "+requestData);
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
		}
		return null;
	}

	@Override
	public List<EmployeeBean> getEmployeeList() {
		logger.info("saveOrUpdateEmployee in ServiceImpl");
		List<EmployeeBean> list = null;
		try {
			list = employeeDao.getEmployeeList();  
		} catch (Exception e) {
			logger.error("Exception: "+e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String getEmployeeById(Integer id) {
		return null;
	}

	@Override
	public String updateEmployee(Integer id) {
		return null;
	}

}
