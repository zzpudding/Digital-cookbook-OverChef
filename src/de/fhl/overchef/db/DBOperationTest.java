package de.fhl.overchef.db;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import de.fhl.overchef.model.Recipe;

public class DBOperationTest {
	
	DBOperation dbOperation;

	@Before
	public void setUp() throws Exception {
		dbOperation = new DBOperation();
	}

	@Test
	public void testSelectAllRecipe() throws SQLException {
		assertFalse(dbOperation.selectAllRecipe().wasNull());
	}

	@Test
	public void testSelectIngredient() throws SQLException {
		Recipe recipe = new Recipe();
		assertFalse(dbOperation.selectIngredient(recipe).wasNull());
	}

	@Test
	public void testSelectPicture() throws SQLException {
		Recipe recipe = new Recipe();
		assertFalse(dbOperation.selectPicture(recipe).wasNull());
	}

	@Test
	public void testSelectPrepStep() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRecipeToDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddIngredientToDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPrepStep() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPicture() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteRecipe() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectMaxRid() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMaxRid() {
		fail("Not yet implemented");
	}

}
