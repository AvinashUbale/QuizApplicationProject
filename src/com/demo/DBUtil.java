package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
public static Connection getCon() {
		
		Connection con = null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url= "jdbc:mysql://127.0.0.1:3306/QuizApp";
		con = DriverManager.getConnection(url, "root", "AviMU@5455");
		}
		
		catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
		}
		
		return con;
}
}
