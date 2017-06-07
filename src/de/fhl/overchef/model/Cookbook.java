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

	/**
	 * Search strings with given keyword in recipe list
	 * Will also do boundary check and replace characters which could cause exception.
	 * @param keyword user's input
	 * @return a relevance value
	 */
	public int searchByRecipe(String keyword) {
		int relevance = 0;
		for (char c : new char[] { '*', '(', ')', '[', ']', '{', '}', '.' }) {
			keyword = keyword.replaceAll("\\" + c, "\\" + c);
		}
		for (int i = 0; i < this.recipes.size();i++) {
			Recipe r = recipes.get(i);
			String recipeName = r.getRecipeName();
			if (recipeName != null && !recipeName.equals("")) {
				if (recipeName.equalsIgnoreCase(keyword)) {
					relevance += 10;
				} else {
					String[] subKeywords = keyword.split("\\p{Blank}|-|,|;");
					for (String subKeyword : subKeywords) {
						if (recipeName != null && recipeName.toLowerCase().matches(".*" + subKeyword.toLowerCase() + ".*")) {
							relevance++;
						}
					}
				}
			}
		}
		return relevance;
	}

	/**
	 * Search strings with given keyword in ingredient list
	 * Will also do boundary check and replace characters which could cause exception.
	 * @param keyword user's input
	 * @return a relevance value to sort the result
	 */
	public int searchByIngredient(String keyword) {
		int relevance = 0;
		for (char c : new char[] { '*', '(', ')', '[', ']', '{', '}', '.' }) {
			keyword = keyword.replaceAll("\\" + c, "\\\\" + c);
		}
		for (int j = 0; j < this.ingredients.size();j++) {
			Ingredient i = ingredients.get(j);
			String ingredientName = i.getIngredientName();
			if (ingredientName != null && !ingredientName.equals("")) {
				if (ingredientName.equalsIgnoreCase(keyword)) {
					relevance += 10;
				} else {
					String[] subKeywords = keyword.split("\\p{Blank}|-|,|;");
					for (String subKeyword : subKeywords) {
						if (ingredientName != null && ingredientName.toLowerCase().matches(".*" + subKeyword.toLowerCase() + ".*")) {
							relevance++;
						}
					}
				}
			}
		}
		return relevance;
	}	

}
