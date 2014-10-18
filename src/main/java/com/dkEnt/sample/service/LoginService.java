package com.dkEnt.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkEnt.sample.dao.SampleDao;
import com.dkEnt.sample.model.SampleModel;


@Service("sammpleService")
public class LoginService {
	
	
	@Autowired
	private SampleDao sampleDao;

	
	private Logger logger = Logger.getLogger(getClass());
	
	
	public List<SampleModel> getAllLogins() {				
		
		List<SampleModel> sampleModelList = new ArrayList<SampleModel>();
		
		try {
			logger.info("Service init()");
			sampleModelList = sampleDao.getAllSampleDatas();
			logger.info("Service Success");
		} catch (Exception e) {
			logger.error("service error");
			System.out.println(e);
		}
		return sampleModelList;
	}
}
