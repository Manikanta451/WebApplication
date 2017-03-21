package com.durgasoft;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	static Connection con;
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/servletdatabase","root","root"); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		return con;
	}
}



