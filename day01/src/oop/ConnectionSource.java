package oop;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionSource {
	private static BasicDataSource dataSource = null;
	public ConnectionSource(){
		
	}
	public static void init(){
		Properties dbProps = new Properties();
		try{
			dbProps.load(ConnectionSource.class.getClassLoader().getResourceAsStream("oop/db.properties"));
			
		}catch(IOException e){
			e.printStackTrace();
		};
		try{
			String driverClassName = dbProps.getProperty("jdbc.driver");
			String url = dbProps.getProperty("jdbc.url");
			String user = dbProps.getProperty("jdbc.user");
			String password = dbProps.getProperty("jdbc.password");
			
			String initialSize = dbProps.getProperty("dataSource.initialSize");
			String maxIdle = dbProps.getProperty("dataSource.maxIdle");
			String minIdle = dbProps.getProperty("dataSource.minIdle");
			String maxActive = dbProps.getProperty("dataSource.maxActive");
			String maxWait = dbProps.getProperty("dataSource.maxWait");
			
			dataSource = new BasicDataSource();
			dataSource.setDriver(driverClassName);
			dataSource
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
