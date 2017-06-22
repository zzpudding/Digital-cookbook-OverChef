package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import de.fhl.overchef.db.DBOperation;
import de.fhl.overchef.view.OverchefMainApp;

public class Cookbook {
	private static List<Recipe> recipes = new LinkedList<Recipe>();
	private static List<Ingredient> ingredients = new LinkedList<Ingredient>();
	
	public void addRecipe(Recipe r) {
		this.recipes.add(r);
	}

	public void addIngredient(Ingredient i) {
		if (!this.ingredients.contains(i)) {
			this.ingredients.add(i);
		}
	}
	
	
	public  List<Recipe> loadRecipesFromDB(ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException, FileNotFoundException, IOException{
        List resultList = new LinkedList();
        while(rs.next()){
		       	 Recipe r= new Recipe("",0, 0,0);
		       	 r.setRecipeName(rs.getString("recipeName"));
		       	 r.setCookTime(rs.getInt("cookingTime"));
		       	 r.setPrepTime(rs.getInt("preparationTime"));
		       	 r.setServeNum(rs.getInt("servings"));
		       	 r.setDescription(rs.getString("recipeDesc"));
		       	 r.setRecipeID(rs.getInt("rid"));
		       	 loadIngredientFromDB(DBOperation.selectIngredient(r),r);
		       	// loadPictureFromDB(DBOperation.selectPicture(r),r);
		       	 //loadPrepStepFromDB(DBOperation.selectPrepStep(r), r);
		         resultList.add(r);
		         
            }
       return resultList;
   }


	public  void loadIngredientFromDB(ResultSet rs,Recipe r) throws SQLException, InstantiationException, IllegalAccessException{

        while(rs.next()){
            Ingredient i= new Ingredient("",0.0,"","");
            i.setIngredientName(rs.getString("ingredientName"));
            i.setQuantity(rs.getDouble("quantity"));
            i.setUnit(rs.getString("unit"));
            i.setDescription(rs.getString("ingredientDesc"));
            r.addIngredient(i);
        }
   }

	public  void loadPictureFromDB(ResultSet rs, Recipe r) throws SQLException, FileNotFoundException, IOException{
		while(rs.next()){
			r.addPicture(rs.getString("picPath"));
			
		}
	}
	
	public void loadPrepStepFromDB(ResultSet rs, Recipe r) throws SQLException{
		while(rs.next()){
			r.addPreparationStep(rs.getString("description"));
		}
		
	}
	
	public void setRecipeList(List<Recipe> list){
		recipes.addAll(list);
	}
	public void deleteRecipe(Recipe r) {
		recipes.remove(r);
	}
	public List<Recipe> getRecipeList(){
		return recipes;
	}
	
}
