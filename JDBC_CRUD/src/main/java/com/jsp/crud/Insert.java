package com.jsp.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	
	
	public static void main(String[] args) {
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/2026_JDBC";
		String username="postgres";
		String pass="root";
		
		try {
			Class.forName(driver);
			
			Connection connection=DriverManager.getConnection(url, username, pass);
//========================================================================================
			//for normal
//			Statement statement=connection.createStatement();
//			String query ="INSERT INTO flat_owner VALUES (2,'Vraj',603,5656485987)";
//			
//			statement.execute(query);
			//for dynamic
			String query="INSERT INTO flat_owner VALUES(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 2);
			preparedStatement.setString(2, "Pratik");
			preparedStatement.setInt(3, 2303);
			preparedStatement.setString(4, "6598256248");
			preparedStatement.execute();
			
			
//========================================================================================
			System.out.println("data enterd sucessfully");
			connection.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
