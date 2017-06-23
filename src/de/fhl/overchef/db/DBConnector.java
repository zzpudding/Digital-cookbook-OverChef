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

	public static ResultSet executeSelectSQL(String sql) {
		try {
			return connection.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void executeNonSelectSQL(String sql) {
		try {
			connection.createStatement().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		return connection;
	}

	public void setCon(Connection connection) {
		this.connection = connection;
	}
	
	

}
