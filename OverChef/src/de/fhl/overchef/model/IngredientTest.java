package de.fhl.overchef.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
	
	Ingredient ingredient;

	@Before
	public void setUp() throws Exception {
		ingredient = new Ingredient("pepper", 10, "gram", "black");
	}


	@Test
	public void testGetIngredientName() {
		assertEquals("pepper", ingredient.getIngredientName());
	}

	@Test
	public void testSetIngredientName() {
		ingredient.setIngredientName("black pepper");
		assertEquals("black pepper", ingredient.getIngredientName());
	}

	@Test
	public void testGetQuantity() {
		assertTrue(10 == ingredient.getQuantity());
	}

	@Test
	public void testGetDescription() {
		assertEquals("black", ingredient.getDescription());
	}

	@Test
	public void testGetUnit() {
		assertEquals("gram", ingredient.getUnit());
	}

	@Test
	public void testSetQuantity() {
		ingredient.setQuantity(5);
		assertTrue(5 == ingredient.getQuantity());
	}

}
