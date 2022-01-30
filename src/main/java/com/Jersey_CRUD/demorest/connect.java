package com.Jersey_CRUD.demorest;

import java.sql.*;

public class connect {
	public Connection sqlret() throws ClassNotFoundException, SQLException
{
		 String DriverName = "com.mysql.cj.jdbc.Driver";
	        String dbURL = "jdbc:mysql://localhost:3306/";
	        // Database name to access
	        String database = "Data1";
	        String user = "root";
	        String password = "Mysql";
		Connection con = null;
		
			Class.forName(DriverName);
		    con = DriverManager.getConnection(dbURL+database,user,password);
//		    System.out.println("Conncection Successful");
		
		return con;
		}
}
