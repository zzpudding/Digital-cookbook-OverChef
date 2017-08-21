package de.fhl.overchef.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import de.fhl.overchef.db.DBConnector;
import de.fhl.overchef.db.DBOperation;
import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;

public class DBOperationTest {

	DBOperation dbOperation;

	@Before
	public void setUp() throws Exception {
		dbOperation = new DBOperation();
	}

	@Test
	public void testSelectAllRecipe()
			throws SQLException, InstantiationException, IllegalAccessException, FileNotFoundException, IOException {
		DBConnector.connect();
		ResultSet rs = DBOperation.selectAllRecipe();
		int lastCount = 0;
		int currentCount = 0;
		while (rs.next()) {
			lastCount++;
		}
		Recipe r = new Recipe("test", 4, 20, 30);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBConnector.executeNonSelectSQL(
				"INSERT INTO RECIPE (rid,recipeName, servings, preparationTime, cookingTime, recipeDesc) VALUES("
						+ r.getRecipeID() + "," + "'" + r.getRecipeName() + "'" + "," + r.getIntServeNum() + ","
						+ r.getPreparationTime() + "," + r.getCookTime() + "," + "'" + r.getDescription() + "'" + ")");
		rs = DBOperation.selectAllRecipe();
		while (rs.next()) {
			currentCount++;
		}
		assertTrue(lastCount + 1 == currentCount);
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testSelectIngredient() throws SQLException {
		DBConnector.connect();
		Recipe r=new Recipe("junittestrecipe", 4, 20, 30);
		Ingredient itest=new Ingredient("junittestIngredient",4,"kg","desc");
		r.addIngredient(itest);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		ResultSet rs=DBConnector.executeSelectSQL("select * from INGREDIENT where INGREDIENT.rid="+r.getRecipeID());
		if(rs.next())
			assertTrue(rs.getString("ingredientName").equals("junittestIngredient"));
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testSelectPicture() throws SQLException, FileNotFoundException, IOException {
		DBConnector.connect();
		Recipe r=new Recipe("junittestrecipe", 4, 20, 30);
		String path =System.getProperty("user.dir") +"/src/de/fhl/overchef/model/Pictures/"+ "overChef.png";
		r.addPicture(path);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		ResultSet rs=DBOperation.selectPicture(r);
		String picPath="";
		while(rs.next()){
			picPath = rs.getString("picPath");
		}
		assertEquals(picPath,r.getPictures().get(0).getPictureName());
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testSelectPrepStep() throws SQLException {
		DBConnector.connect();
		Recipe r=new Recipe("junittestrecipe", 4, 20, 30);
		r.addPreparationStep("junittestpreparationstep");
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		ResultSet rs=DBConnector.executeSelectSQL("select * from PREPARATIONSTEP where PREPARATIONSTEP.rid="+r.getRecipeID());
		if(rs.next())
			assertTrue(rs.getString("step").equals("junittestpreparationstep"));
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testAddRecipeToDB() throws SQLException {
		DBConnector.connect();
		ResultSet rs = DBOperation.selectAllRecipe();
		int lastCount = 0;
		int currentCount = 0;
		while (rs.next()) {
			lastCount++;
		}
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
//		DBConnector.executeNonSelectSQL(
//				"INSERT INTO RECIPE (rid,recipeName, servings, preparationTime, cookingTime, recipeDesc) VALUES(" + rid
//						+ "," + "'" + r.getRecipeName() + "'" + "," + r.getIntServeNum() + "," + r.getPreparationTime()
//						+ "," + r.getCookTime() + "," + "'" + r.getDescription() + "'" + ")");
		DBOperation.addRecipeToDB(r);
		rs = DBOperation.selectAllRecipe();
		while (rs.next()) {
			currentCount++;
		}
		assertTrue(lastCount + 1 == currentCount);
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testAddIngredientToDB() throws SQLException, InstantiationException, IllegalAccessException {
		DBConnector.connect();
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		Ingredient itest = new Ingredient("junittestIngredient", 4, "kg", "desc");
		r.addIngredient(itest);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		Recipe s = new Recipe("", 0, 0, 0);
		ResultSet rs = DBConnector.executeSelectSQL("select * from INGREDIENT where INGREDIENT.rid=" + r.getRecipeID());
		while (rs.next()) {
			Ingredient i = new Ingredient("", 0.0, "", "");
			i.setIngredientName(rs.getString("ingredientName"));
			i.setQuantity(rs.getDouble("quantity"));
			i.setUnit(rs.getString("unit"));
			i.setDescription(rs.getString("ingredientDesc"));
			s.addIngredient(i);
		}
		assertEquals(s.getIngredientList().get(0).getIngredientName(),
				r.getIngredientList().get(0).getIngredientName());
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testAddPrepStep() throws SQLException {
		DBConnector.connect();
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		r.addPreparationStep("junittestpreparationstep");
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		Recipe s = new Recipe("", 0, 0, 0);
		ResultSet rs = DBConnector
				.executeSelectSQL("select * from PREPARATIONSTEP where PREPARATIONSTEP.rid=" + r.getRecipeID());
		while (rs.next()) {
			s.addPreparationStep(rs.getString("step"));
		}
		assertEquals(s.getPreparationStep().get(0), r.getPreparationStep().get(0));
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testAddPicture() throws SQLException, FileNotFoundException, IOException {
		DBConnector.connect();
		Recipe r=new Recipe("junittestrecipe", 4, 20, 30);
		String path =System.getProperty("user.dir") +"/src/de/fhl/overchef/view/recipeViewPicture/overChef.png";
		r.addPicture(path);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		ResultSet rs=DBConnector.executeSelectSQL("select * from PICTURE where PICTURE.rid="+r.getRecipeID());
		String picPath="";
		while(rs.next()){
			picPath = rs.getString("picPath");
		}
		assertEquals(picPath,r.getPictures().get(0).getPictureName());
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testDeleteRecipe() throws SQLException {
		DBConnector.connect();
		int lastCount = 0;
		int currentCount = 0;
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBConnector.executeNonSelectSQL(
				"INSERT INTO RECIPE (rid,recipeName, servings, preparationTime, cookingTime, recipeDesc) VALUES(" + rid
						+ "," + "'" + r.getRecipeName() + "'" + "," + r.getIntServeNum() + "," + r.getPreparationTime()
						+ "," + r.getCookTime() + "," + "'" + r.getDescription() + "'" + ")");
		ResultSet rs = DBOperation.selectAllRecipe();
		while (rs.next()) {
			lastCount++;
		}
		DBOperation.deleteRecipe(rid);
		rs = DBOperation.selectAllRecipe();
		while (rs.next()) {
			currentCount++;
		}
		assertEquals(lastCount - 1, currentCount);
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testSelectMaxRid() throws SQLException {
		DBConnector.connect();
		ResultSet rs = DBOperation.selectMaxRid();
		rs.next();
		Integer maxRid = rs.getInt(1);
		Recipe r=new Recipe("junittestrecipe", 4, 20, 30);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		rs = DBOperation.selectMaxRid();
		rs.next();
		Integer newRid = rs.getInt(1);
		assertTrue(newRid.intValue() == (maxRid.intValue() + 1));
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testGetMaxRid() throws SQLException {
		DBConnector.connect();
		Integer maxRid = DBOperation.getMaxRid();
		Recipe r=new Recipe("junittestrecipe", 4, 20, 30);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		DBOperation.addRecipeToDB(r);
		Integer newRid = DBOperation.getMaxRid();
		assertTrue(newRid.intValue() == (maxRid.intValue() + 1));
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

}
