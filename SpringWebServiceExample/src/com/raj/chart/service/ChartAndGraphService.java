package com.raj.chart.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public interface ChartAndGraphService {

	/**
	 * @param requestData
	 * @return
	 */
	public String googlePieChart(String requestData);
}
