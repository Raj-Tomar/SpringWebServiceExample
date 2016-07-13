package com.raj.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.raj.beans.EmployeeBean;

@Repository
@Scope(value = "prototype")
public interface EmployeeDao {

	public String saveOrUpdateEmployee(EmployeeBean bean);
	public List<EmployeeBean> getEmployeeList();
	public String getEmployeeById(Integer id);
	public String updateEmployee(Integer id);
	
}
