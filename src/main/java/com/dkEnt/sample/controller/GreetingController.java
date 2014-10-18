package com.dkEnt.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dkEnt.sample.model.SampleModel;
import com.dkEnt.sample.service.LoginService;
import com.wordnik.swagger.annotations.Api;

@Api(value = "sample", description = "sample API Swagger!!") // Swagger annotation
@RestController
public class GreetingController {

	
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/GET/sample")
	public List<SampleModel> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name){
		
		logger.info("sample controller init!!");

		List<SampleModel> sampleModel = new ArrayList<SampleModel>();
		sampleModel = loginService.getAllLogins();
		
		logger.info("sample Success!!");
		
		return sampleModel;
	
	}
}
