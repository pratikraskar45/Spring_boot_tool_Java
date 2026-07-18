package com.jsp.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Updtae {
	public static void main(String[] args) {
		String driver="org.postgresql.Driver";
		String url="jdbc:postgresql://localhost:5432/2026_JDBC";
		String username="postgres";
		String pass="root";
		
		try {
			Class.forName(driver);
			Connection connection=DriverManager.getConnection(url, username, pass);
			
//========================================================================================

			//normal entry
//			Statement statement=connection.createStatement();
//			String query="UPDATE flat_owner SET phone=8888888888 where fid=2 ";
//			statement.execute(query);
			
			//dynamic
			String query="UPDATE flat_owner SET owner_name=?  WHERE fid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "Vraj");
			preparedStatement.setInt(2, 2);
			
			int executeUpdate = preparedStatement.executeUpdate();
			
//========================================================================================

			System.out.println("Update the "+ executeUpdate +" data sucessfully");
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
