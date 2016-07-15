package com.raj.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public interface EmployeeService {

	/**
	 * @param requestData
	 * @return
	 */
	public String saveOrUpdateEmployee(String requestData);
	/**
	 * @return
	 */
	public String getEmployeeList();
	/**
	 * @param id
	 * @return
	 */
	public String getEmployeeById(Integer id);
	/**
	 * @param id
	 * @return
	 */
	public String updateEmployee(Integer id);
	/**
	 * @param requestData
	 * @return
	 */
	public String googlePieChart(String requestData);
}
