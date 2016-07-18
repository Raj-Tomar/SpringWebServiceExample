package com.raj.chart.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.raj.beans.CityBean;
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
	public String areaWiseCountries(String requestData) {
		String status = "0";
		List<KeyValueDto> list = null;
		try {
			requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			list = chartDao.areaWiseCountries(requestData);
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
	
	@Override
	public String getAllCountryCode(String requestData) {
		String status = "0";
		List<String> list = null;
		try {
			requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			list = chartDao.getAllCountryCode(requestData);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("countryCode", list);
			}
			else{
				responseJson.put("status", status);
			}
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return responseJson.toString();
	}

	@Override
	public String cityWisePopulation(String requestData) {
		String status = "0";
		List<CityBean> list = null;
		try {
			requestJson = new JSONObject(requestData);
			LOGGER.info("RequestData: "+requestJson.toString());
			JSONObject jObj = requestJson.getJSONObject("requestData");
			String countryCode = jObj.getString("countryCode");
			list = chartDao.cityWisePopulation(countryCode);
			responseJson = new JSONObject();
			if(list.size() > 0){
				status = "1";
				responseJson.put("status", status);
				responseJson.put("cityPopulation", list);
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
