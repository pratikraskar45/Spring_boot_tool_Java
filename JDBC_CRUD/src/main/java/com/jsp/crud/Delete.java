package com.jsp.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
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
//			String query="DELETE FROM flat_owner where fid=2";
//			statement.execute(query);
			//dynamic
			String query="DELETE FROM flat_owner where fid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 2);
			preparedStatement.execute();
			
			
//========================================================================================

			System.out.println("delete data");
			connection.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
