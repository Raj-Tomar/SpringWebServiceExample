package com.raj.chart.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.raj.chart.dao.ChartAndGraphDao;
import com.raj.chart.service.ChartAndGraphService;
import com.raj.dto.KeyValueDto;

@Service
@Scope(value = "prototype")
public class ChartAndGraphServiceImpl implements ChartAndGraphService{
	
	@Autowired
	private ChartAndGraphDao chartDao;
	private JSONObject requestJson = null;
	private JSONObject responseJson = null;
	
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphServiceImpl.class);

	@Override
	public String googlePieChart(String requestData) {
		String status = "0";
		List<KeyValueDto> list = null;
		try {
			requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			list = chartDao.googlePieChart(requestData);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("keyValue", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

}
