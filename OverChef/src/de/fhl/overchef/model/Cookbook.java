package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import de.fhl.overchef.db.DBOperation;
/**
 * This class is used to save and handle recipes in the memory
 * @author Jiacheng Zhou, Yujia Zhang
 *
 */
public class Cookbook {
	private static List<Recipe> recipes = new LinkedList<Recipe>();

	private String res = "/src/de/fhl/overchef/model/Pictures/";
	
	public void addRecipe(Recipe r) throws SQLException {
		this.recipes.add(r);
		DBOperation.addRecipeToDB(r);
	}
	/**
	 * loading all the recipe stored in the database to the list in the memory
	 * @param rs the result set for the recipes
	 * @return
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
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
		       	 loadPictureFromDB(DBOperation.selectPicture(r),r);
		       	 loadPrepStepFromDB(DBOperation.selectPrepStep(r), r);
		         resultList.add(r);
		         
            }
       return resultList;
   }
	/**
	 * loading ingredients stored in the database to the list in the memory
	 * @param rs result set for the ingredients
	 * @param r the recipe
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
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
	/**
	 * loading the names of pictures stored in the database to the memory
	 * @param rs result set storing names of pictures
	 * @param r the recipe
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public  void loadPictureFromDB(ResultSet rs, Recipe r) throws SQLException, FileNotFoundException, IOException{
		while(rs.next()){
			
			String picPath = System.getProperty("user.dir") + res + rs.getString("picPath");			
			Picture picture = new Picture(picPath);
			picture.setRoot(picPath);
			r.getPictures().add(picture);
			
		}
	}
	/**
	 * loading preparation step stored in the database to the memory
	 * @param rs result set for preparation step
	 * @param r the recipe
	 * @throws SQLException
	 */
	public void loadPrepStepFromDB(ResultSet rs, Recipe r) throws SQLException{
		while(rs.next()){
			r.addPreparationStep(rs.getString("step"));
		}
		
	}
	/**
	 * adding recipes to the list
	 * @param list the list for storing recipes
	 */
	public void setRecipeList(List<Recipe> list){
		recipes.addAll(list);
	}
	/**
	 * deleting recipe
	 * @param r the recipe to be deleted
	 */
	public void deleteRecipe(Recipe r) {
		recipes.remove(r);
	}

	public List<Recipe> getRecipeList(){
		return recipes;
	}
	
}
