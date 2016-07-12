package com.raj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raj.beans.EmployeeBean;

@Service
public interface EmployeeService {

	public String saveOrUpdateEmployee(EmployeeBean bean);
	public List<EmployeeBean> getEmployeeList();
	public String getEmployeeById(Integer id);
	public String updateEmployee(Integer id);
}