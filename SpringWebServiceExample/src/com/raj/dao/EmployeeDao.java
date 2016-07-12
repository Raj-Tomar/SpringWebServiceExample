package com.raj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.raj.beans.EmployeeBean;

@Repository
public interface EmployeeDao {

	public String saveOrUpdateEmployee(EmployeeBean bean);
	public List<EmployeeBean> getEmployeeList();
	public String getEmployeeById(Integer id);
	public String updateEmployee(Integer id);
	
}
