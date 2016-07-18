package com.raj.chart.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.raj.beans.CityBean;
import com.raj.chart.dao.ChartAndGraphDao;
import com.raj.dto.KeyValueDto;

@Repository
@Scope(value = "prototype")
public class ChartAndGraphDaoImpl implements ChartAndGraphDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session = null;
	
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphDaoImpl.class);
	
	@Override
	public List<KeyValueDto> areaWiseCountries(String requestData) {
		List<KeyValueDto> list = new ArrayList<KeyValueDto>();
		try {
			list.add(new KeyValueDto("Russia", "17098242"));
			list.add(new KeyValueDto("Canada", "9984670"));
			list.add(new KeyValueDto("USA", "9826675"));
			list.add(new KeyValueDto("China", "9596961"));
			list.add(new KeyValueDto("Brazil", "8514877"));
			list.add(new KeyValueDto("Australia", "7741220"));
			list.add(new KeyValueDto("India", "3287263"));
		} 
		catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCountryCode(String requestData) {
		List<String> list = new ArrayList<String>();
		try {
			session = sessionFactory.openSession();
			Query<String> query = session.createQuery("Select distinct countryCode From CityBean");
			list = query.getResultList();;
			LOGGER.info("Total Country Codes: "+list.size());
		} 
		catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CityBean> cityWisePopulation(String countryCode) {
		List<CityBean> list = new ArrayList<CityBean>();
		try {
			session = sessionFactory.openSession();
			//Query<CityBean> query = session.createQuery("Select name, district, population From CityBean where countryCode=?");
			Query<CityBean> query = session.createQuery("From CityBean where countryCode=?");
			query.setParameter(0, countryCode);
			list = query.getResultList();;
			LOGGER.info("Total Cities: "+list.size());
		} 
		catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		finally {
			if(session.isOpen()){
				session.close();
			}
		}
		return list;
	}

}
