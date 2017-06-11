package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recipe {
	private int id = 0;
	private StringProperty recipeName = null;
	private IntegerProperty serveNum;
	private IntegerProperty prepTime;
	private IntegerProperty cookTime;

	private List<String> prepStep = new ArrayList<String>();
	private Map<Ingredient, Relationship> ingredients = new HashMap<Ingredient, Relationship>();
	private List<Picture> pictures = new ArrayList<Picture>();

	public Recipe(String recipeName, int serveNum, int prepTime, int cookTime) {
		this.recipeName = new SimpleStringProperty(recipeName);
		this.serveNum = new SimpleIntegerProperty(serveNum);
		this.prepTime = new SimpleIntegerProperty(prepTime);
		this.cookTime = new SimpleIntegerProperty(cookTime);
	}

	public void addIngredient(Ingredient i, Relationship r) {
		this.ingredients.put(i, r);
	}

	public void addPrepStep(String s) {
		this.prepStep.add(s);
	}

	/**
	 * add a picture to recipe with the given path of picture chosen by user and
	 * save it in file system
	 * 
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void addPicture(String path) throws FileNotFoundException, IOException {
		Picture picture = new Picture(path);
		picture.writePicture();
		this.pictures.add(picture);

	}

	public StringProperty recipeNameProperty() {
		return recipeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName.get();
	}

	public void setRecipeName(String recipeName) {
		this.recipeName.set(recipeName);
	}

	public IntegerProperty getServeNum() {
		return serveNum;
	}

	public void setServeNum(int serveNum) {
		 this.serveNum.set(serveNum);
	}

	public IntegerProperty getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(int prepTime) {
		 this.prepTime.set(prepTime);
	}


	public IntegerProperty getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime.set(cookTime);
	}

	public List<String> getPrepStep() {
		return prepStep;
	}

	public void setPrepStep(List<String> prepStep) {
		this.prepStep = prepStep;
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
