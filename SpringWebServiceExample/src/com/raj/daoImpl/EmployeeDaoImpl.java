package com.raj.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raj.beans.EmployeeBean;
import com.raj.dao.EmployeeDao;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	SessionFactory sessionFactory;
	private Session session = null;
	private Transaction tx = null;

	@Override
	public String saveOrUpdateEmployee(EmployeeBean bean) {
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			if(null == bean.getId()){
				session.save(bean);
			}else{
				session.update(bean);
			}
			tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBean> getEmployeeList() {
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		try{
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			Query<EmployeeBean> query = session.createQuery("From EmployeeBean");
			list = query.getResultList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(session.isOpen()){
				session.close();
			}
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
