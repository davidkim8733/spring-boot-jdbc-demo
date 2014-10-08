package com.dkEnt.sample.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkEnt.sample.login.dao.LoginDao;
import com.dkEnt.sample.login.model.LoginSuccess;
import com.dkEnt.sample.mybatis.mapper.SampleMapper;


@Service("loginService")
public class LoginService {
	
	
	@Autowired
	private LoginDao loginDao;
	private SampleMapper sampleMapper;

	
	@SuppressWarnings("unchecked")
	public List<LoginSuccess> getAllLogins() {				
		
		
		return (List<LoginSuccess>) sampleMapper.sampleSelect();
		//return loginDao.getAllLogins();
	}
}
