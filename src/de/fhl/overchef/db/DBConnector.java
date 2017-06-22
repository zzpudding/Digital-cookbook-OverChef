package de.fhl.overchef.db;
import java.sql.*;

public class DBConnector {
	static Connection connection;
	private static DBConnector dbConnection = new DBConnector();
	
	private DBConnector() {
		
	}
	
	public static Connection connect() throws SQLException {
		return connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/cookbook", "root", "root");
	}
	
	public static void disconnect() throws SQLException {
		connection.close();
	}

	public static ResultSet executeSQL(String sql) {
		try {
			return connection.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Connection getCon() {
		return connection;
	}

	public void setCon(Connection connection) {
		this.connection = connection;
	}
	
	

}
