package com.raj.employee.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.raj.beans.EmployeeBean;
import com.raj.employee.dao.EmployeeDao;

@Repository
@Scope(value = "prototype")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session = null;
	private Transaction tx = null;
	
	private static Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);

	@Override
	public String saveOrUpdateEmployee(EmployeeBean bean) {
		String status = "0";
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			if(null == bean.getId()){
				session.save(bean);
				tx.commit();
				status = "1";
				LOGGER.info("Employee Save Status: "+status);
			}else{
				session.update(bean);
				tx.commit();
				status = "1";
				LOGGER.info("Employee Update Status: "+status);
			}
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		}
		finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public List<EmployeeBean> getEmployeeList() {
		List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		try{
			session = sessionFactory.openSession();
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
	public EmployeeBean getEmployeeById(Integer id) {
		EmployeeBean bean = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			bean = session.get(EmployeeBean.class, id);
		} 
		catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return bean;
	}

	@Override
	public String deleteEmployee(Integer id) {
		String status = "0";
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			EmployeeBean bean = session.get(EmployeeBean.class, id);
			if(null != bean){
				session.delete(bean);
				tx.commit();
				status = "1";
			}
		} catch (Exception e) {
			tx.rollback();
			LOGGER.error("Exception: "+e.getMessage());
		}
		return status;
	}

}
