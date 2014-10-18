package com.dkEnt.sample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.dkEnt.sample.common.DBUtil;
import com.dkEnt.sample.model.SampleModel;

@Repository("sampleDao")
public class SampleDao {
	
	private Logger logger = Logger.getLogger(getClass());
	
	private Connection connection;

	public SampleDao() {
		connection = DBUtil.getConnection();
	}

	//sample_table 테이블의 모든 데이터를 LIST 구조에 담아 리턴
	public List<SampleModel> getAllSampleDatas() {
		List<SampleModel> sampleModels = new ArrayList<SampleModel>();
		try {
			
			logger.info("sampleDao Start....");
			
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select seq, url from sample_table");
			while (rs.next()) {
				SampleModel sampleModel = new SampleModel();
				sampleModel.setSeq(rs.getString("seq"));
				sampleModel.setUrl(rs.getString("url"));
				sampleModels.add(sampleModel);
			}
			
			logger.info("sampleDao Success....");

		} catch (SQLException e) {
			
			logger.info("sampleDao error...." + e);
			e.printStackTrace();
		}
		return sampleModels;
	}

	//이름을 통래 데이터 한건 SELECT 후 Onj 객체에 담아 리턴

}

