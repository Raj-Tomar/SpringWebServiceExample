package com.raj.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raj.beans.EmployeeBean;
import com.raj.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Override
	public String saveOrUpdateEmployee(EmployeeBean bean) {
		return null;
	}

	@Override
	public List<EmployeeBean> getEmployeeList() {
		return null;
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
