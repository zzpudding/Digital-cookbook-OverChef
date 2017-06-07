package de.fhl.overchef.model;

public class Ingredient {
	private String ingredientName;
	private double quantity;
	private String unit;
	private String description = "";

	public Ingredient(String ingredientName, double quantity, String unit, String description) {
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.unit = unit;
		this.description = description;
	}

	public String getIngredientName() {
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
