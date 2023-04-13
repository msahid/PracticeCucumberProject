package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	Connection connection ;
	Statement statement;
	ResultSet resultSet;
	String columnValue;


	public String getDataFromDb(String columnName) {

		try {
//			setting properties for MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			String sqlUrl = "jdbc:mysql://localhost:3306/february2022";
			String sqlusername = "root";
			String sqlPassword = "root";
			String sqlQuery = "select * from users;";
			
//			Create a connection to local DB:
			connection = DriverManager.getConnection(sqlUrl, sqlusername, sqlPassword);
			
//			Empowering the connection reference variable to Execute queries
			statement = connection.createStatement();
			
//			Execute/Deliver query
			resultSet = statement.executeQuery(sqlQuery);
			while(resultSet.next()) {
				
				columnValue = resultSet.getString(columnName);
				return columnValue;
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		return columnValue;
		
	}

}
