package com.dkEnt.sample.login.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dkEnt.sample.login.model.LoginSuccess;
import com.dkEnt.sample.login.service.LoginService;
import com.wordnik.swagger.annotations.Api;

@Api(value = "login", description = "login을 가장한 샘플 API Swagger!!") // Swagger annotation
@RestController
public class GreetingController {

	
	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/login")
	public List<LoginSuccess> greeting(@RequestParam(value="name", required=false, defaultValue="World") String name){
			
		List<LoginSuccess> testLogin = new ArrayList<LoginSuccess>();
		testLogin = loginService.getAllLogins();
		
		logger.info("login 메서드 호출!!");
		
		return testLogin;
	
	}
}
