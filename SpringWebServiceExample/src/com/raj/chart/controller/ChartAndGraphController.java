package com.raj.chart.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raj.chart.service.ChartAndGraphService;

@Controller
public class ChartAndGraphController {

	@Autowired
	private ChartAndGraphService chartService;
	
	private static Logger LOGGER = Logger.getLogger(ChartAndGraphController.class);
	
	@RequestMapping(value="/googlePieChart", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> googlePieChart(@RequestBody String requestData){
		ResponseEntity<String> result = null;
		try {
			String status = chartService.googlePieChart(requestData);
			result = new ResponseEntity<String>(status, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception: "+e.getMessage());
		}
		return result;
	}
}
