package assignment2b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionWAMP {
	
	
	public static Connection con;
	public static Connection getConn() throws ClassNotFoundException
	{
	
		try
	{
	
		
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment2b","root","");
	System.out.println("Connected to database...");
	return con;
	}
	
	catch(SQLException e){
	System.out.println(e);
	return null;
	}
	}
}

