package controller;

import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class ConectionDb {
	
	private static String user;
	private static String password;
	private static String url;
	private static Properties connectionProps;
	
    public static Connection connectDatabase() {
    	url="mysql://localhost:3306/consumo_energetico";
    	user="root";
    	password="Vidanueva123";
    	    	
    	connectionProps = new Properties();
        connectionProps.put("user", user);
        connectionProps.put("password", password);
    	
    	Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection("jdbc:"+url+"?useSSL=false",connectionProps);
            
            boolean valid = connection.isValid(50000);
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);         
        }
      return connection;
    }  
    
    public static void closeConection(Connection conn) {
    	try {
    		conn.close();
    		System.out.println("Cerrada");
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
}

