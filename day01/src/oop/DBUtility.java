package oop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {
	private static Properties properties = new Properties();
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;
	public static Properties getProperties() {
		return properties;
	}
	public static void setProperties(Properties properties) {
		DBUtility.properties = properties;
	}
	public static String getDriver() {
		return driver;
	}
	public static void setDriver(String driver) {
		DBUtility.driver = driver;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		DBUtility.url = url;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		DBUtility.user = user;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		DBUtility.password = password;
	}
	static{
		try{
			properties.load(DBUtility.class.getClassLoader().getResourceAsStream("oop/db.properties"));
			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			user = properties.getProperty("jdbc.user");
			password = properties.getProperty("jdbc.password");
			Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Connection openConnection()throws SQLException{
		return DriverManager.getConnection(url,user,password);
	}
	public static void closeConnection(Connection con){
		if(con!=null){
			try{
				con.close();
			}catch(SQLException e){
				System.out.println("数据库关闭异常");
			}
		}
	}
}
