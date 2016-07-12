package com.raj.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.raj.beans.EmployeeBean;
import com.raj.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

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
