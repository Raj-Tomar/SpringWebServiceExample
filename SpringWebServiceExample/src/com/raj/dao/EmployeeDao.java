package com.raj.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.raj.beans.EmployeeBean;
import com.raj.dto.KeyValueDto;

@Repository
@Scope(value = "prototype")
public interface EmployeeDao {

	/**
	 * @param bean
	 * @return
	 */
	public String saveOrUpdateEmployee(EmployeeBean bean);
	/**
	 * @return
	 */
	public List<EmployeeBean> getEmployeeList();
	
	/**
	 * @param id
	 * @return
	 */
	public EmployeeBean getEmployeeById(Integer id);
	/**
	 * @param id
	 * @return
	 */
	public String deleteEmployee(Integer id);
	/**
	 * @param requestData
	 * @return
	 */
	public List<KeyValueDto> googlePieChart(String requestData);
	
}
