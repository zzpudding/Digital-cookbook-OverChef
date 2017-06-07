package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
	private int id = 0;
	private String recipeName = null;
	private int serveNum = 0;
	private int prepTime = 0;
	private int cookTime = 0;

	private List<String> prepStep = new ArrayList<String>();
	private Map<Ingredient, Relationship> ingredients = new HashMap<Ingredient, Relationship>();
	private List<Picture> pictures = new ArrayList<Picture>();

	public Recipe(String recipeName, int serveNum, int prepTime, int cookTime) {
		this.recipeName = recipeName;
		this.serveNum = serveNum;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
	}
	
	public void addIngredient(Ingredient ingredient, Relationship r) {
		this.ingredients.put(ingredient, r);
	}

	public void addPrepStep(String string) {
		this.prepStep.add(string);
	}

	/**
	 * add a picture to recipe with the given path of picture chosen by user and save it in file system
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void addPicture(String path) throws FileNotFoundException, IOException {
		Picture picture = new Picture(path);
		picture.writePicture();
		this.pictures.add(picture);
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public int getServeNum() {
		return serveNum;
	}

	public void setServeNum(int serveNum) {
		this.serveNum = serveNum;
	}

	public List<String> getPrepStep() {
		return prepStep;
	}

	public void setPrepStep(List<String> prepStep) {
		this.prepStep = prepStep;
	}

	public int getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		this.prepTime = prepTime;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}
	
	public Map<Ingredient, Relationship> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<Ingredient, Relationship> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

}
