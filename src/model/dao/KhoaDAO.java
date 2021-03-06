package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Khoa;

/**
 * KhoaDAO.java
 *
 * Version 1.0
 *
 * Date: Jan 20, 2015
 *
 * Copyright 
 *
 * Modification Logs:
 * DATE                 AUTHOR          DESCRIPTION
 * -----------------------------------------------------------------------
 * Jan 20, 2015        	DaiLV2          Create
 */

public class KhoaDAO {

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
	
	public ArrayList<Khoa> getListKhoa() {
		connect();
		String sql=	"SELECT MaKhoa, TenKhoa FROM Khoa";
		ResultSet rs = null;
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<Khoa> list = new ArrayList<Khoa>();
		Khoa khoa;
		try {
			while(rs.next()){
				khoa = new Khoa();
				khoa.setMaKhoa(rs.getString("MaKhoa"));
				khoa.setTenKhoa(rs.getString("TenKhoa"));
				list.add(khoa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

