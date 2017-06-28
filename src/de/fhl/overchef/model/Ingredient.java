package de.fhl.overchef.model;

import java.text.DecimalFormat;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The Ingredient class contains the data and content of ingredients
 * 
 * @author zhangyujia
 *
 */
public class Ingredient {
	private StringProperty ingredientName;
	private double quantity;
	private String unit;
	private String description = "";

	public Ingredient(String ingredientName, double quantity, String unit, String description) {
		this.ingredientName = new SimpleStringProperty(ingredientName);
		this.quantity = quantity;
		this.unit = unit;
		this.description = description;
	}

	public String getIngredientName() {
		return ingredientName.get();
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName.set(ingredientName);
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getQuantity() {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(quantity));
	}

	public String getDescription() {
		return description;
	}

	public String getUnit() {
		return unit;
	}

}
