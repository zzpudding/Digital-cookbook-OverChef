package de.fhl.overchef.db;

import java.sql.*;
/**
 * Database connection class of connection and disconnection to the database
 * 
 * @author Jiacheng Zhou,Yujia Zhang
 */
public class DBConnector {
	public static Connection connection;
	private static DBConnector dbConnection = new DBConnector();
	
	
	/**
	 * Connect to the database
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection connect() throws SQLException {
		return connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/overchefdb", "root", "root");
		
	}
	
	/**
	 * Disconnect to the database
	 * 
	 * @throws SQLException
	 */
	public static void disconnect() throws SQLException {
		connection.close();
	}

	/**
	 * Execute the select sql and return the result
	 *
	 * @param sql
	 * @return result set
	 */
	public static ResultSet executeSelectSQL(String sql) {
		try {
			return connection.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Execute the insert,delete sql
	 *
	 * @param sql
	 */
	public static void executeNonSelectSQL(String sql) {
		try {
			connection.createStatement().execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
