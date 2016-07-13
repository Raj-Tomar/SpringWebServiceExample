package com.raj.service;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.raj.beans.EmployeeBean;

@Service
@Scope(value = "prototype")
public interface EmployeeService {

	public String saveOrUpdateEmployee(String requestData);
	public List<EmployeeBean> getEmployeeList();
	public String getEmployeeById(Integer id);
	public String updateEmployee(Integer id);
}
