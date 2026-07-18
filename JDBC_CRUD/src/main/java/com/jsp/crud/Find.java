package com.jsp.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Find {
	public static void main(String[] args) {
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/2026_JDBC";
		String username="postgres";
		String pass="root";
		try {
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url, username, pass);
//========================================================================================

			//normal
//			Statement statement=connection.createStatement();
//			String query = "SELECT * FROM flat_owner";
//			ResultSet executeQuery = statement.executeQuery(query);
//			while (executeQuery.next()) {
//				System.out.println(executeQuery.getInt(1));
//				System.out.println(executeQuery.getString(2));
//				System.out.println(executeQuery.getInt(3));
//				System.out.println(executeQuery.getString(4));
//				
//			}
//========================================================================================
			//dynamic
			String query="SELECT * FROM flat_owner where fid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt(3));
				System.out.println(resultSet.getString(4));
				
			}
			
//========================================================================================

			connection.close();
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
