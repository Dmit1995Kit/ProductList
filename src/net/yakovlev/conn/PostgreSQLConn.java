package net.yakovlev.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConn {
	
	public static Connection getPostgresConnection()
	           throws ClassNotFoundException, SQLException {
	        
	       // Примечание: Изменить параметры соединения соответствующе.
	       String hostName = "localhost";
	       String sid = "service";
	       String userName = "user_developer";
	       String password = "yki1995yki";
	  
	       return getPostgresConnection(hostName, sid, userName, password);
	   }
	
	public static Connection getPostgresConnection(String hostName, String sid,
	           String userName, String password) throws ClassNotFoundException,
	           SQLException {
	   
	       Class.forName("org.postgresql.Driver");
	  
	       // Структура URL Connection для Oracle
	       // Например:
	       // jdbc:oracle:thin:@localhost:1521:db11g
	       // jdbc:oracle:thin:@//HOSTNAME:PORT/SERVICENAME
	       String connectionURL = "jdbc:postgresql://" + hostName + ":5432/" + sid;
	  
	       Connection conn = DriverManager.getConnection(connectionURL, userName,
	               password);
	       return conn;
	   }

}
