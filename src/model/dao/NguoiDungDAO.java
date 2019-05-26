package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * NguoiDungDAO.java
 *
 * Version 1.0
 *
 * Date: Jan 21, 2015
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Jan 21, 2015        	DaiLV2          Create
 */

public class NguoiDungDAO {
	String url = "jdbc:mysql://localhost:3306/JavaEE_Example";
	String userName = "root";
	String password = "";
	Connection connection;
	
	void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean checkLogin(String tenDangNhap, String matKhau) {
		connect();
		String sql=	String.format("SELECT TenDangNhap FROM NguoiDung WHERE TenDangNhap = '%s' AND MatKhau = '%s'", tenDangNhap, matKhau);
		System.out.println("cau lenh sql nhu sau: " + sql);
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			//System.out.println("jjj" + rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("tu viet van");
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}

