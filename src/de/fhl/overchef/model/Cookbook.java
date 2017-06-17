package de.fhl.overchef.model;

import java.util.LinkedList;
import java.util.List;

public class Cookbook {
	private List<Recipe> recipes = new LinkedList<Recipe>();
	private List<Ingredient> ingredients = new LinkedList<Ingredient>();
	
	public void addRecipe(Recipe r) {
		this.recipes.add(r);
	}

	public void addIngredient(Ingredient i) {
		if (!this.ingredients.contains(i)) {
			this.ingredients.add(i);
		}
	}

	public void deleteRecipe(Recipe r) {
		recipes.remove(r);
	}
	
}
