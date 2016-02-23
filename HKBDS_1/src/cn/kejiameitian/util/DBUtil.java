package cn.kejiameitian.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * jdbc connection管理工具
 * 
 */
public class DBUtil {
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		Properties prop = new Properties(); 
		try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream(
					"db.properties");
	    prop.load(in); 
		String driverClassName = "com.mysql.jdbc.Driver";
		Class.forName(driverClassName);
		String url="jdbc:mysql://localhost/hkbds_1?";
		String username="root";
		String password="Zkai";
		conn = DriverManager
					.getConnection(url,username,password);
		System.out.println("获得连接");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("关闭连接");
			} catch (SQLException e) {
			}
		}
	}

}
