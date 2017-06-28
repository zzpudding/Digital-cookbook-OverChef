package de.fhl.overchef.model;

/**
 * 
 * @author zhangyujia
 *
 */
public class Relationship {
	private String recipeName;
	private double quantiy = 0;
	private String unit = null;
	private String ingredientDesp = "";
	private String ingredientName = "";

	public Relationship(String ingredientName, String recipeName, int quantity, String unit, String ingredientDesp) {
		this.ingredientName = ingredientName;
		this.recipeName = recipeName;
		this.quantiy = quantity;
		this.unit = unit;
		this.ingredientDesp = ingredientDesp;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
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

	public String getIngredientDesp() {
		return ingredientDesp;
	}

	public void setIngredientDesp(String ingredientDesp) {
		this.ingredientDesp = ingredientDesp;
	}

}
