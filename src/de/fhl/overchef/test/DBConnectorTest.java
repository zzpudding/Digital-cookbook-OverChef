package de.fhl.overchef.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import de.fhl.overchef.db.DBConnector;
import de.fhl.overchef.db.DBOperation;
import de.fhl.overchef.model.Cookbook;
import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.view.OverchefMainApp;

public class DBConnectorTest {
	
	private static DBConnector dbConnection;

	@Before
	public void setUp() throws Exception {
		dbConnection = new DBConnector();
	}

	@Test
	public void testConnect() throws SQLException {
		DBConnector.connect();
		assertFalse(dbConnection.connection.isClosed());
	}

	@Test
	public void testDisconnect() throws SQLException {
		DBConnector.connect();
		DBConnector.disconnect();
		assertTrue(dbConnection.connection.isClosed());
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
		System.out.println(OverchefMainApp.getRecipeData().size());
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
	public void testExecuteNonSelectSQL() throws SQLException {
		DBConnector.connect();
		ResultSet rs=DBOperation.selectAllRecipe();
		int lastCount=0;
		int currentCount=0;
		while(rs.next()){
			lastCount++;
		}
		Recipe r=new Recipe("test", 4, 20, 30);
		DBOperation.deleteRecipe(r.getRecipeID());
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBConnector.executeNonSelectSQL("INSERT INTO RECIPE (rid,recipeName, servings, preparationTime, cookingTime, recipeDesc) VALUES(" +rid+","+ "'"+r.getRecipeName()+"'"+","+r.getIntServeNum()+","+r.getPreparationTime()+","+r.getCookTime()+","+"'"+r.getDescription()+"'"+")");
		
		rs=DBOperation.selectAllRecipe();
		while(rs.next()){
			currentCount++;
		}
		assertTrue(lastCount+1==currentCount);
		
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

}
