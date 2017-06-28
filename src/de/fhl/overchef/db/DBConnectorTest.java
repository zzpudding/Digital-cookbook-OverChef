package de.fhl.overchef.db;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import de.fhl.overchef.model.Cookbook;
import de.fhl.overchef.view.OverchefMainApp;

public class DBConnectorTest {
	
	private static DBConnector dbConnection;

	@Before
	public void setUp() throws Exception {
		dbConnection = new DBConnector();
	}

	@Test
	public void testConnect() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisconnect() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectAllRecipe() throws SQLException, InstantiationException, IllegalAccessException, FileNotFoundException, IOException{
		DBConnector.connect();
		ResultSet rs=DBOperation.selectAllRecipe();
		int count=0;
		while(rs.next()){
			count++;
		}
		
		Cookbook ck = new Cookbook();
		ck.setRecipeList(ck.loadRecipesFromDB(DBOperation.selectAllRecipe()));
		OverchefMainApp.setRecipeData(ck.getRecipeList());
		assertEquals(count,OverchefMainApp.getRecipeData().size());
		DBConnector.disconnect();
	}
	
	
	@Test
	public void testExecuteSelectSQL() throws SQLException {
		DBConnector.connect();
		ResultSet rs=DBConnector.executeSelectSQL("select * from RECIPE");
		
		String judgement="empty";
		while(rs.next()){
			judgement="data";
		}
		assertTrue(judgement=="data");
		DBConnector.disconnect();
	}

	@Test
	public void testExecuteNonSelectSQL() {
		fail("Not yet implemented");
		
	}

	@Test
	public void testGetCon() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCon() {
		fail("Not yet implemented");
	}

}
