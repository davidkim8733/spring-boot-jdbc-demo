package com.dkEnt.sample.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dkEnt.sample.common.DBUtil;
import com.dkEnt.sample.login.model.LoginSuccess;

@Repository("loginDao")
public class LoginDao {
	private Connection connection;

	public LoginDao() {
		connection = DBUtil.getConnection();
	}

	//login 테이블의 모든 데이터를 LIST 구조에 담아 리턴
	public List<LoginSuccess> getAllLogins() {
		List<LoginSuccess> users = new ArrayList<LoginSuccess>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select name, url from onj");
			while (rs.next()) {
				LoginSuccess loginSuccess = new LoginSuccess();
				loginSuccess.setId(rs.getString("name"));
				loginSuccess.setContent(rs.getString("url"));
				users.add(loginSuccess);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	//이름을 통래 데이터 한건 SELECT 후 Onj 객체에 담아 리턴

}

