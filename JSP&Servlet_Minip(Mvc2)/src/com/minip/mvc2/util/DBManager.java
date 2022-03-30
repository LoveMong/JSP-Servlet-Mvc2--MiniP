package com.minip.mvc2.util;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
		 	 Context initContext = new InitialContext();
			 Context envContext = (Context) initContext.lookup("java:/comp/env");
			 DataSource ds = (DataSource) envContext.lookup("jdbc/Mysql");
			 conn = ds.getConnection();	// jdbc/Mysql이란 이름을 객체를 찾아서 DataSourc가 받는다.

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// select을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DML(insert, update, delete)을 수행한 후 리로스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt) {
		
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
