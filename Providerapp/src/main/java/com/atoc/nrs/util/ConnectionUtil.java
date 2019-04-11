package com.atoc.nrs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConn(){
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String un="system";
		String pwd="harsh";
		Connection con=null;
		try {
			Class.forName(driverClass);
			con=DriverManager.getConnection(url, un, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
