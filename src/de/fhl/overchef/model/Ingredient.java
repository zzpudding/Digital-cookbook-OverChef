package de.fhl.overchef.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

	public StringProperty ingredientNameProperty() {
		return ingredientName;
	}

	public double getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public String getUnit() {
		return unit;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

}
