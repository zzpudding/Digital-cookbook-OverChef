package de.fhl.overchef.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.fhl.overchef.model.Recipe;

public class DBOperation {
	
	public static ResultSet selectAllRecipe() {
		return DBConnector.executeSQL("select * from RECIPE");
	}
	public static ResultSet selectIngredient(Recipe r){
		return DBConnector.executeSQL("select * from INGREDIENT where INGREDIENT.rid="+r.getRecipeID());
	}
	public static ResultSet selectPicture(Recipe r){
		return DBConnector.executeSQL("select * from PICTURE where PICTURE.rid="+r.getRecipeID());
	}
	public static ResultSet selectPrepStep(Recipe r){
		return DBConnector.executeSQL("select * from PREPARATIONSTEP where PREPARATIONSTEP.rid="+r.getRecipeID());
	}
	
	
	
	
	public static void addRecipeToDB(Recipe r) throws SQLException{
//		DBConnector.executeSQL("INSERT INTO RECIPE (recipeName, servings, preparationTime, cookingTime, recipeDesc) VALUES(" + r.getRecipeName()+","+r.getServeNum()+","+r.getPreparationTime()+","+r.getCookTime()+","+"sss"+")");
//		DBConnector.executeSQL("INSERT INTO INGREDIENT (");
	}
	
	
	
}
