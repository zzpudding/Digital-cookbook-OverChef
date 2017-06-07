package de.fhl.overchef.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import de.fhl.overchef.db.Connection;
import de.fhl.overchef.model.Cookbook;
import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.model.Relationship;

public class RecipeController {

	private Cookbook cb = null;
	private Connection con = null;

	public RecipeController(Cookbook cb, Connection con) {
		this.cb = cb;
		this.con = con;
	}

	/**
	 * Add current recipe to memory and memory
	 * @param recipe
	 * @param ingredients
	 * @param prepStep
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void addRecipe(Recipe recipe, Map<Ingredient, Relationship> ingredients, List<String> prepStep, String path) throws FileNotFoundException, IOException {
		recipe.setIngredients(ingredients);
		recipe.setPrepStep(prepStep);

		// add to memory
		cb.addRecipe(recipe);
		for (Ingredient i : ingredients.keySet()) {
			cb.addIngredient(i);
		}
		
		//if a picture has been chosen by user, then add the picture into recipe
		if(path != null) {
			createPicture(recipe, path);
		}
		
		// add to database
		int id = con.addRecipe(recipe);
		recipe.setId(id);
		for (Ingredient i : ingredients.keySet()) {
			con.addIngredient(i);
		}
		
	}

	/**
	 * Delete current recipe from memory and database
	 * @param recipe
	 */
	public void deleteRecipe(Recipe recipe) {
		// delete in memory
		cb.deleteRecipe(recipe);
		
		// delete in database
		con.deleteRecipe(recipe);	
		
		// if the recipe has a picture, then delete it
		if(!recipe.getPictures().isEmpty()) {
			recipe.getPictures().remove(0).deletePicture();
		}
	}

	public void modifyRecipe(Recipe oldRecipe, Map<Ingredient, Relationship> ingredients, List<String> prepStep, Recipe newRecipe, String path) throws FileNotFoundException, IOException {
		deleteRecipe(oldRecipe);
		addRecipe(newRecipe, ingredients, prepStep, path);
	}

	/**
	 * Search recipes with the given keyword.
	 * The result would be sorted according to the relevance.
	 * @param recipes giving recipes
	 * @param keyword user's input
	 * @return the search result containing relevant recipes
	 */
	public Set<Recipe> searchResult(Set<Recipe> recipes, String keyword) {
		Map<Recipe, Integer> tempMap = new HashMap<>();
		for (Recipe r : recipes) {
			int relevance = cb.searchByIngredient(keyword)+cb.searchByRecipe(keyword);
			if (relevance > 0) {
				tempMap.put(r, relevance);
			}
		}
		List<Entry<Recipe, Integer>> sortingList = new ArrayList<>(tempMap.entrySet());
		sortingList.sort((o1, o2) -> o2.getValue() - o1.getValue());
		Set<Recipe> tempSet = new LinkedHashSet<>();
		for (Map.Entry<Recipe, Integer> entry : sortingList) {
			tempSet.add(entry.getKey());
		}
		return tempSet;
	}

	/**
	 * create a picture chosen by user
	 * @param recipe
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void createPicture(Recipe recipe, String path) throws FileNotFoundException, IOException {
		recipe.addPicture(path);
	}

}