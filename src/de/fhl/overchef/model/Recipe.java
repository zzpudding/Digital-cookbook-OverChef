package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class Recipe {
	private StringProperty recipeName = null;
	private IntegerProperty serveNum;
	private IntegerProperty prepTime;
	private IntegerProperty cookTime;
	private String description;
	private List<String> preparationStep = new ArrayList<String>();
	private List<String> prepStep = new ArrayList<String>();
	private List<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private List<String> ingredientNameList = new LinkedList<String>();
	// private Map<Ingredient, Relationship> ingredients = new
	// HashMap<Ingredient, Relationship>();

	private Vector<Picture> pictures = new Vector<Picture>();

	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	// public void setDescription(StringProperty description) {
	// this.description = description;
	// }

	public Recipe(String recipeName, int serveNum, int prepTime, int cookTime) {
		this.recipeName = new SimpleStringProperty(recipeName);
		this.serveNum = new SimpleIntegerProperty(serveNum);
		this.prepTime = new SimpleIntegerProperty(prepTime);
		this.cookTime = new SimpleIntegerProperty(cookTime);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addIngredient(Ingredient i) {
		this.ingredientList.add(i);
		this.ingredientNameList.add(i.getIngredientName());

	}

	public void addIngredientNametoList(String iname) {
		this.ingredientNameList.add(iname);
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

	public String getIngredientNameListProperty() {
		StringBuffer ing = new StringBuffer();
		for (int i = 0; i < this.ingredientNameList.size(); i++) {
			ing.append(this.ingredientNameList.get(i) + ", ");
		}

		return ing.toString();

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

	public int getServeNumber() {
		return serveNum.get();
	}

	public void setServeNum(int serveNum) {
		this.serveNum.set(serveNum);
	}

	public IntegerProperty getPrepTime() {
		return prepTime;
	}

	public int getPreparationTime() {
		return prepTime.get();
	}

	public void setPrepTime(int prepTime) {
		this.prepTime.set(prepTime);
	}

	public String getPreparationStep() {
		StringBuffer toStringPreparationStep = new StringBuffer();
		for (int i = 1; i <= preparationStep.size(); i++) {
			String item = preparationStep.get(i);
			toStringPreparationStep.append("i: " + item);
			toStringPreparationStep.append("\r\n");
		}
		return toStringPreparationStep.toString();
	}

	public void setPreparationStep(List<String> prepStep) {
		this.preparationStep = prepStep;
	}

	// public String getDescription(){
	// return description.get();
	// }
	// public void setDescription(String description){
	// this.description.set(description);
	// }
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

	public void changeQuantity(int serveNum) {
		int currentNum = getServeNumber();
		for (Ingredient i : ingredientList) {
			i.setQuantity(i.getQuantity() / currentNum * serveNum);
		}
		this.setServeNum(serveNum);
	}

	public Vector<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Vector<Picture> pictures) {
		this.pictures = pictures;
	}

	public void setIngredients(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public String getIngredients() {
		StringBuffer toStringIngredients = new StringBuffer();
		for (Ingredient item : ingredientList) {
			StringBuffer itemReal = new StringBuffer();
			itemReal.append(item.getIngredientName());
			itemReal.append("   " + item.getQuantity());
			itemReal.append("   " + item.getUnit());
			toStringIngredients.append(itemReal);
			toStringIngredients.append("\r\n");
		}
		return toStringIngredients.toString();
	}



}
