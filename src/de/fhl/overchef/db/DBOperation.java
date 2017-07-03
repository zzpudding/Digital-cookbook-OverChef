package de.fhl.overchef.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.fhl.overchef.model.Recipe;
/**
 * A class of operating the database
 * 
 * @author Jiacheng Zhou, Yujia Zhang
 */
public class DBOperation {
	/**
	 * Select all the recipe data in the RECIPE table and return as a resultset
	 * 
	 * @return result set of all recipes
	 */
	public static ResultSet selectAllRecipe() {
		return DBConnector.executeSelectSQL("select * from RECIPE");
	}
	
	/**
	 * Select all the ingredients of a specific recipe determined by the recipe id
	 * 
	 * @param r
	 * @return result set of ingredients of a specific recipe
	 */
	public static ResultSet selectIngredient(Recipe r){
		return DBConnector.executeSelectSQL("select * from INGREDIENT where INGREDIENT.rid="+r.getRecipeID());
	}
	
	/**
	 * Select the picture of a specific recipe determined by the recipe id
	 * 
	 * @param r
	 * @return result set of pictures of a specific recipe 
	 */
	public static ResultSet selectPicture(Recipe r){
		return DBConnector.executeSelectSQL("select * from PICTURE where PICTURE.rid="+r.getRecipeID());
	}

	/**
	 * Select the preparation step of a specific recipe determined by the recipe id
	 * 
	 * @param r
	 * @return result set of preparation steps of a specific recipe
	 */
	public static ResultSet selectPrepStep(Recipe r){
		return DBConnector.executeSelectSQL("select * from PREPARATIONSTEP where PREPARATIONSTEP.rid="+r.getRecipeID());
	}
	
	/**
	 * Insert the recipe into the database
	 *
	 * @param r
	 * @throws SQLException
	 */
	public static void addRecipeToDB(Recipe r) throws SQLException{
		int rid=getMaxRid()+1;
		DBConnector.executeNonSelectSQL("INSERT INTO RECIPE (rid,recipeName, servings, preparationTime, cookingTime, recipeDesc) VALUES(" +rid+","+ "'"+r.getRecipeName()+"'"+","+r.getIntServeNum()+","+r.getPreparationTime()+","+r.getCookTime()+","+"'"+r.getDescription()+"'"+")");
		addIngredientToDB(r,rid);
		addPrepStep(r,rid);
		addPicture(r,rid);
	}

	/**
	 * Insert the ingredients list to the INGREDIENT table 
	 * 
	 * @param r
	 * @param rid
	 * @throws SQLException
	 */
	public static void addIngredientToDB(Recipe r,Integer rid) throws SQLException{
		for(int i=0;i<r.getIngredientList().size();i++){
			DBConnector.executeNonSelectSQL("INSERT INTO INGREDIENT (rid,iid,ingredientName,quantity,unit,ingredientDesc) VALUES("+rid+","+(i+1)+","+"'"+r.getIngredientList().get(i).getIngredientName()+"'"+","+r.getIngredientList().get(i).getQuantity()+","+"'"+r.getIngredientList().get(i).getUnit()+"'"+","+"'"+r.getIngredientList().get(i).getDescription()+"'"+")");
		}
	}
	
	/**
	 * Insert the preparation step to the PREPARATIONSTEP table
	 *
	 * @param r
	 * @param rid
	 * @throws SQLException
	 */
	public static void addPrepStep(Recipe r,Integer rid) throws SQLException{
		for(int i=0;i<r.getPreparationStep().size();i++){
				DBConnector.executeNonSelectSQL("INSERT INTO PREPARATIONSTEP (rid,stepNum,step) VALUES("+rid+","+(i+1)+","+"'"+r.getPreparationStep().get(i)+"'"+")");
		}
	}

	/**
	 * Insert the picture path to the PICTURE table
	 *
	 * @param r
	 * @param rid
	 * @throws SQLException
	 */
	public static void addPicture(Recipe r,Integer rid) throws SQLException{
		if(!r.getPictures().isEmpty()){
			for(int i=0;i<r.getPictures().size();i++){
				DBConnector.executeNonSelectSQL("INSERT INTO PICTURE (rid,pid,picPath) VALUES("+rid+","+(i+1)+","+"'"+r.getPictures().lastElement().getPictureName()+"'"+")");
			}
		}else{
			for(int i=0;i<r.getPictures().size();i++){
				DBConnector.executeNonSelectSQL("delete from PICTURE where rid=" +r.getRecipeID());
				DBConnector.executeNonSelectSQL("INSERT INTO PICTURE (rid,pid,picPath) VALUES("+rid+","+(i+1)+","+"'"+r.getPictures().lastElement().getPictureName()+"'"+")");
			}
		}
	}
	
	/**
	 * Delete the specific recipe from database
	 * 
	 * @param rid 
	 * 			recipe id
	 *         
	 */
	public static void deleteRecipe(Integer rid) {
		DBConnector.executeNonSelectSQL("delete from RECIPE where rid=" + rid);
	}
	
	/**
	 * Select the maximum recipe id in the RECIPE table
	 * 
	 * @return result set of the maximum recipe id
	 */
	public static ResultSet selectMaxRid() {
		return DBConnector.executeSelectSQL("SELECT MAX(rid) AS rid_max from RECIPE ");
	}
	
	/**
	 * Get the Maximum recipe id
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Integer getMaxRid() throws SQLException{
		ResultSet rs = DBOperation.selectMaxRid();
		rs.next();
		Integer newRid = rs.getInt(1);
		return newRid;
	}
}
