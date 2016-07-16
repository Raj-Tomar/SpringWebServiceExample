package com.raj.chart.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.raj.dto.KeyValueDto;

@Repository
@Scope(value = "prototype")
public interface ChartAndGraphDao {

	/**
	 * @param requestData
	 * @return
	 */
	public List<KeyValueDto> googlePieChart(String requestData);
}
