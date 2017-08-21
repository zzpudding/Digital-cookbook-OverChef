package de.fhl.overchef.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.fhl.overchef.db.DBConnector;
import de.fhl.overchef.db.DBOperation;
import de.fhl.overchef.model.Cookbook;
import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Picture;
import de.fhl.overchef.model.Recipe;

public class CookbookTest {

	private static Cookbook cookBook;

	@Before
	public void setUp() throws Exception {
		cookBook = new Cookbook();
	}

	@Test
	public void testAddRecipe() throws SQLException {
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		DBConnector.connect();
		int currentRid = DBOperation.getMaxRid();
		int rid = DBOperation.getMaxRid() + 1;
		cookBook.addRecipe(r);
		int newRid = DBOperation.getMaxRid();
		assertEquals("junittestrecipe", cookBook.getRecipeList().get(0).getRecipeName());
		assertTrue(currentRid == newRid - 1);
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testLoadRecipesFromDB()
			throws InstantiationException, IllegalAccessException, FileNotFoundException, SQLException, IOException {
		List<Recipe> resultList=new LinkedList();
		DBConnector.connect();
		ResultSet rs = DBOperation.selectAllRecipe();
		resultList.addAll(cookBook.loadRecipesFromDB(rs));
		assertFalse(resultList.isEmpty());
		DBConnector.disconnect();
	}

	@Test
	public void testLoadIngredientFromDB() throws SQLException, InstantiationException, IllegalAccessException {
		DBConnector.connect();
		
		List<Recipe> recipes = new LinkedList<Recipe>();
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		Ingredient itest=new Ingredient("junittestIngredient",4,"kg","desc");
		r.addIngredient(itest);
		
		Recipe newR = new Recipe("junittestrecipe", 4, 20, 30);
		
		int currentRid = DBOperation.getMaxRid();
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		cookBook.addRecipe(r);
		
		ResultSet rs = DBOperation.selectIngredient(r);
		cookBook.loadIngredientFromDB(rs, newR);
		System.out.println(newR.getIngredientList().get(0).getIngredientName());
		assertEquals("junittestIngredient", newR.getIngredientList().get(0).getIngredientName());
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testLoadPictureFromDB() throws SQLException, FileNotFoundException, IOException {
		DBConnector.connect();
		
		List<Recipe> recipes = new LinkedList<Recipe>();
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		Picture pic = new Picture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\view\\recipeViewPicture\\testpicture.PNG");
		
		Recipe newR = new Recipe("junittestrecipe", 4, 20, 30);
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		r.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\view\\recipeViewPicture\\testpicture.PNG");
		cookBook.addRecipe(r);
		
		ResultSet rs = DBOperation.selectPicture(r);
		cookBook.loadPictureFromDB(rs, newR);
		System.out.println(newR.getPictures().get(0).getRoot());
		assertEquals(System.getProperty("user.dir") + "/src/de/fhl/overchef/model/Pictures/testpicture.PNG", newR.getPictures().get(0).getRoot());
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testLoadPrepStepFromDB() throws SQLException {
		DBConnector.connect();
		
		List<Recipe> recipes = new LinkedList<Recipe>();
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		String step = "set aside";
		r.addPreparationStep(step);
		
		Recipe newR = new Recipe("junittestrecipe", 4, 20, 30);
		
		int rid = DBOperation.getMaxRid() + 1;
		r.setRecipeID(rid);
		cookBook.addRecipe(r);
		
		ResultSet rs = DBOperation.selectPrepStep(r);
		cookBook.loadPrepStepFromDB(rs, newR);
		assertEquals("set aside", newR.getPreparationStep().get(0));
		DBOperation.deleteRecipe(rid);
		DBConnector.disconnect();
	}

	@Test
	public void testSetRecipeList() {
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		List<Recipe> recipes = new LinkedList<>();
		recipes.add(r);
		cookBook.setRecipeList(recipes);
		assertTrue(recipes.get(0).getRecipeName().equals(cookBook.getRecipeList().get(0).getRecipeName()));
	}

	@Test
	public void testDeleteRecipe() {
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		List<Recipe> recipes = new LinkedList<>();
		recipes.add(r);
		cookBook.setRecipeList(recipes);
		int before = cookBook.getRecipeList().size();
		cookBook.deleteRecipe(r);
		int after = cookBook.getRecipeList().size();
		assertTrue(before == after + 1);
	}

	@Test
	public void testGetRecipeList() {
		Recipe r = new Recipe("junittestrecipe", 4, 20, 30);
		List<Recipe> recipes = new LinkedList<>();
		recipes.add(r);
		cookBook.setRecipeList(recipes);
		assertTrue(recipes.get(0).getRecipeName().equals(cookBook.getRecipeList().get(0).getRecipeName()));
	}

}
