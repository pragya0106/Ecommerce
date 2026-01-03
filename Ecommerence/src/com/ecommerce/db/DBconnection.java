package com.ecommerce.db;

import java.sql.Connection;
import java.sql.DriverManager;
//This is the database connection class of this repository as it will help to connect jdbc to java for the same
public class DBconnection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Loading a driver by using forName()
			String url = "jdbc:mysql://localhost:3306/ecommercestore"; //it has schema name so that our java package will connect with particular c=schema of mysql 
			String user = "root";
			String password = "pragya0106!"; //it consists of your username and password credentials of mysql.

			con = DriverManager.getConnection(url, user, password); //getConnection() method is used to create a connection object that will correspond to a physical connection with the database.
		} catch (Exception e) {
			System.out.println("inside getConnection catch");
			e.printStackTrace();
		}
		return con;
	}
}
