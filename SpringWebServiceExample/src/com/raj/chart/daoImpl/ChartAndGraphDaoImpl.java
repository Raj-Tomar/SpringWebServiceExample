package com.raj.chart.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.raj.chart.dao.ChartAndGraphDao;
import com.raj.dto.KeyValueDto;

@Repository
@Scope(value = "prototype")
public class ChartAndGraphDaoImpl implements ChartAndGraphDao{
	
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphDaoImpl.class);
	
	@Override
	public List<KeyValueDto> googlePieChart(String requestData) {
		List<KeyValueDto> list = new ArrayList<KeyValueDto>();
		try {
			list.add(new KeyValueDto("Russia", "17098242"));
			list.add(new KeyValueDto("Canada", "9984670"));
			list.add(new KeyValueDto("USA", "9826675"));
			list.add(new KeyValueDto("China", "9596961"));
			list.add(new KeyValueDto("Brazil", "8514877"));
			list.add(new KeyValueDto("Australia", "7741220"));
			list.add(new KeyValueDto("India", "3287263"));
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return list;
	}

}
