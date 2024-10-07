package utils;

import java.io.FileReader;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactor {
          
	
	private static final ConnectionFactor connectionFactor=new ConnectionFactor();
	private Properties prop=new Properties();
	
	static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found");
        }
    }
	
	
	private ConnectionFactor() {
		try {
			prop.load(new FileReader("C:\\Users\\saik6\\eclipse-workspace\\EcommerceProject\\src\\main\\resources\\db.properties"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static ConnectionFactor getConnectionFactor() {
		return connectionFactor;
		
	}
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("username"),
					prop.getProperty("password")
					);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
}