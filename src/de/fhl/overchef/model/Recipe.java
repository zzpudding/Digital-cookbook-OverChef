package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 * The Recipe class stores all the data and contents of a recipe
 *
 */
public class Recipe {
	private StringProperty recipeName = null;
	private IntegerProperty serveNum;
	private IntegerProperty prepTime;
	private IntegerProperty cookTime;
	private String description = "";
	private Integer recipeID=0;
	private List<String> preparationStep = new ArrayList<String>();
	private List<Ingredient> ingredientList = new ArrayList<Ingredient>();
	private Vector<Picture> pictures = new Vector<Picture>();

	public Recipe(String recipeName, int serveNum, int prepTime, int cookTime) {
		this.recipeName = new SimpleStringProperty(recipeName);
		this.serveNum = new SimpleIntegerProperty(serveNum);
		this.prepTime = new SimpleIntegerProperty(prepTime);
		this.cookTime = new SimpleIntegerProperty(cookTime);
	}

	public Recipe(){
		//empty
	}

	/**
	 * adding an ingredient into the ingredient list
	 * @param i the ingredient to be added
	 */
	public void addIngredient(Ingredient i) {
		this.ingredientList.add(i);
	}
	/**
	 * adding a preparation step to the preparation step list
	 * @param s the preparation to be added
	 */
	public void addPreparationStep(String s) {
		this.preparationStep.add(s);
	}

	/**
	 * getting the preparation step
	 * @return
	 */
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

	/**
	 * add a picture to recipe with the given path of picture chosen by user and
	 * save it in file system
	 * 
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 */
	public void addPicture(String path) throws FileNotFoundException, IOException {
		System.out.println(path);
		Picture picture = new Picture(path);
		picture.writePicture();
		this.pictures.add(picture);

	}

	/**
	 * changing the quantities of the ingredients according to the serving number
	 * @param serveNum the serving number give by user or the software's default value
	 */
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

	/**
	 * getting the names of ingredients'names
	 * @return
	 */
	public String getIngredientNameListProperty() {
		StringBuffer ing = new StringBuffer();
		for (int i = 0; i < this.ingredientList.size(); i++) {
			ing.append(this.ingredientList.get(i).getIngredientName() + "; ");
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
	/**
	 * getting ingredients
	 * @return
	 */
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

	/**
	 * @param preparationStep the preparationStep to set
	 */
	public void setPreparationStep(List<String> preparationStep) {
		this.preparationStep = preparationStep;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	public List<String> getPreparationStep() {
		return preparationStep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Ingredient> getIngredientList() {
		return ingredientList;
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
