package de.fhl.overchef.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class RecipeTest {
	
	private static Recipe recipe;

	@Before
	public void setUp() throws Exception {
		recipe = new Recipe("Hong Shao Rou", 2, 20, 30);
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		Ingredient ingredient1 = new Ingredient("onion", 20, "gram", "samll thing");
		Ingredient ingredient2 = new Ingredient("butter", 1, "piece", "yellow");
		ingredientList.add(ingredient1);
		ingredientList.add(ingredient2);
		recipe.setIngredientList(ingredientList);
		
		List<String> preparationStep = new ArrayList<String>();
		String step1 = "set aside";
		String step2 = "and go";
		preparationStep.add(step1);
		preparationStep.add(step2);
		recipe.setPreparationStep(preparationStep);
	}

	@Test
	public void testGetIngredientList() {
		Ingredient ingredient = new Ingredient("Hong Dou", 50, "gram", "Red");
		recipe.addIngredient(ingredient);
		assertEquals("Hong Dou", recipe.getIngredientList().get(2).getIngredientName());
		assertTrue(50 == recipe.getIngredientList().get(2).getQuantity());
		assertEquals("gram", recipe.getIngredientList().get(2).getUnit());
		assertEquals("Red", recipe.getIngredientList().get(2).getDescription());
	}

	@Test
	public void testSetIngredientList() {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		Ingredient ingredient = new Ingredient("Hong Dou", 50, "gram", "Red");
		ingredients.add(ingredient);
		recipe.setIngredientList(ingredients);
		assertEquals("Hong Dou", recipe.getIngredientList().get(0).getIngredientName());
		assertTrue(50 == recipe.getIngredientList().get(0).getQuantity());
		assertEquals("gram", recipe.getIngredientList().get(0).getUnit());
		assertEquals("Red", recipe.getIngredientList().get(0).getDescription());
	}

	@Test
	public void testGetDescription() {
		assertEquals("", recipe.getDescription());
	}

	@Test
	public void testSetDescription() {
		recipe.setDescription("OK");
		assertEquals("OK", recipe.getDescription());
	}

	@Test
	public void testAddIngredient() {
		Ingredient ingredient = new Ingredient("Hong Dou", 50, "gram", "Red");
		recipe.addIngredient(ingredient);
		assertEquals("Hong Dou", recipe.getIngredientList().get(2).getIngredientName());
		assertTrue(50 == recipe.getIngredientList().get(2).getQuantity());
		assertEquals("gram", recipe.getIngredientList().get(2).getUnit());
		assertEquals("Red", recipe.getIngredientList().get(2).getDescription());
		assertEquals("onion, butter, Hong Dou", recipe.getIngredientNameListProperty());
	}

	@Test
	public void testAddPreparationStep() {
		recipe.addPreparationStep("Set aside.");
		assertEquals("Set aside.", recipe.getPreparationStep().get(2));
	}

	@Test
	public void testAddPicture() {
		
	}

	@Test
	public void testRecipeNameProperty() {
		assertEquals("StringProperty [value: Hong Shao Rou]", recipe.recipeNameProperty().toString());
	}

	@Test
	public void testGetIngredientNameListProperty() {
		String ingredientNameListString = "onion, butter";
		assertEquals(ingredientNameListString, recipe.getIngredientNameListProperty());
	}

	@Test
	public void testGetRecipeName() {
		assertEquals("Hong Shao Rou", recipe.getRecipeName());
	}

	@Test
	public void testSetRecipeName() {
		recipe.setRecipeName("Xiao Chao Rou");
		assertEquals("Xiao Chao Rou", recipe.getRecipeName());
	}

	@Test
	public void testGetServeNum() {
		assertTrue(2 == recipe.getServeNum().intValue());
	}

	@Test
	public void testGetServeNumber() {
		assertTrue(2 == recipe.getServeNumber());
	}

	@Test
	public void testSetServeNum() {
		recipe.setServeNum(10);
		assertTrue(10 == recipe.getServeNumber());
	}

	@Test
	public void testGetPrepTime() {
		assertTrue(20 == recipe.getPrepTime().intValue());
	}

	@Test
	public void testGetPreparationTime() {
		assertTrue(20 == recipe.getPreparationTime());
	}

	@Test
	public void testSetPrepTime() {
		recipe.setPrepTime(15);
		assertTrue(15 == recipe.getPreparationTime());
	}

	@Test
	public void testToGetPreparationStep() {
		
		assertEquals("1: set aside\r\n2: and go\r\n", recipe.toGetPreparationStep());
	}

	@Test
	public void testGetCookTime() {
		assertTrue(30 == recipe.getCookTime());
	}

	@Test
	public void testSetCookTime() {
		recipe.setCookTime(20);
		assertTrue(20 == recipe.getCookTime());
	}

	@Test
	public void testChangeQuantity() {
		
		recipe.changeQuantity(4);
		assertTrue(4 == recipe.getServeNumber());
		assertTrue(40 == recipe.getIngredientList().get(0).getQuantity());
		assertTrue(2 == recipe.getIngredientList().get(1).getQuantity());
	}

	@Test
	public void testGetPictures() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPictures() {
		fail("Not yet implemented");
	}

	@Test
	public void testToGetIngredients() {
		String result = "onion   20.0   gram      samll thing\r\nbutter   1.0   piece      yellow\r\n";
		assertEquals(result, recipe.toGetIngredients());
	}

	@Test
	public void testGetPreparationStep() {
		List<String> preparationStep = new ArrayList<String>();
		String step1 = "set aside";
		String step2 = "and go";
		assertEquals("set aside", recipe.getPreparationStep().get(0));
		assertEquals("and go", recipe.getPreparationStep().get(1));
	}

	@Test
	public void testSetPreparationStep() {
		List<String> preparationStep = new ArrayList<String>();
		String step1 = "and go";
		String step2 = "set aside";
		preparationStep.add(step1);
		preparationStep.add(step2);
		recipe.setPreparationStep(preparationStep);
		assertEquals("and go", recipe.getPreparationStep().get(0));
		assertEquals("set aside", recipe.getPreparationStep().get(1));
	}

}
