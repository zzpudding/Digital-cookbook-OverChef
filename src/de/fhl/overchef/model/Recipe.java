package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recipe {
	private StringProperty recipeName = null;
	private IntegerProperty serveNum;
	private IntegerProperty prepTime;
	private IntegerProperty cookTime;
	private String description = "";
	private Integer recipeID=0;
	private List<String> preparationStep = new ArrayList<String>();
	private List<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private List<String> ingredientNameList = new LinkedList<String>();
	private Vector<Picture> pictures = new Vector<Picture>();

	public Recipe(String recipeName, int serveNum, int prepTime, int cookTime) {
		this.recipeName = new SimpleStringProperty(recipeName);
		this.serveNum = new SimpleIntegerProperty(serveNum);
		this.prepTime = new SimpleIntegerProperty(prepTime);
		this.cookTime = new SimpleIntegerProperty(cookTime);
	}

	public Recipe(){
		
	}

	public void addIngredient(Ingredient i) {
		this.ingredientList.add(i);
		this.ingredientNameList.add(i.getIngredientName());

	}

	public void addIngredientNametoList(String iname) {
		this.ingredientNameList.add(iname);
	}

	public void addPreparationStep(String s) {
		this.preparationStep.add(s);
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
		System.out.println(path);
		Picture picture = new Picture(path);
		picture.writePicture();
		this.pictures.add(picture);

	}
	public void changeQuantity(int serveNum) {
		int currentNum = getServeNumber();
		for (Ingredient i : ingredientList) {
			i.setQuantity(i.getQuantity() / currentNum * serveNum);
		}
		this.setServeNum(serveNum);
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

	public String toGetPreparationStep() {
		StringBuffer toStringPreparationStep = new StringBuffer();
		for (int i = 0; i < preparationStep.size(); i++) {
			String item = preparationStep.get(i);
			int m=i+1;
			toStringPreparationStep.append(m+": " + item);
			toStringPreparationStep.append("\r\n");
		}
		return toStringPreparationStep.toString();
	}

	public int getCookTime() {
		return cookTime.get();
	}

	public void setCookTime(int cookTime) {
		this.cookTime.set(cookTime);
	}

	public Vector<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Vector<Picture> pictures) {
		this.pictures = pictures;
	}

	public String toGetIngredients() {
		StringBuffer toStringIngredients = new StringBuffer();
		for (Ingredient item : ingredientList) {
			StringBuffer itemReal = new StringBuffer();
			itemReal.append(item.getIngredientName());
			itemReal.append("   " + item.getQuantity());
			itemReal.append("   " + item.getUnit());
			itemReal.append("      " + item.getDescription());
			toStringIngredients.append(itemReal);
			toStringIngredients.append("\r\n");
		}
		return toStringIngredients.toString();
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the preparationStep
	 */
	public List<String> getPreparationStep() {
		return preparationStep;
	}
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	/**
	 * @param preparationStep the preparationStep to set
	 */
	public void setPreparationStep(List<String> preparationStep) {
		this.preparationStep = preparationStep;
	}

	public Integer getRecipeID() {
		return recipeID;
	}

	public int getIntServeNum(){
		return serveNum.get();
	}
	public void setRecipeID(Integer recipeID) {
		this.recipeID = recipeID;
	}

}
