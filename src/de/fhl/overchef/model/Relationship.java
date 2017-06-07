package de.fhl.overchef.model;

public class Relationship {
	private int recipeID = 0;
	private int ingredientID = 0;
	private double quantiy = 0;

	private String unit = null;
	private String ingredientDesp = null;

	public Relationship(int recipeID, int ingredientID, int quantity, String unit, String ingredientDesp) {
		this.recipeID = recipeID;
		this.ingredientID = ingredientID;
		this.quantiy = quantity;
		this.unit = unit;
		this.ingredientDesp = ingredientDesp;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public double getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(double quantiy) {
		this.quantiy = quantiy;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
