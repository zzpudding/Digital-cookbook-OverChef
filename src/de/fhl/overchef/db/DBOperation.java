package de.fhl.overchef.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.fhl.overchef.model.Recipe;

public class DBOperation {
	
	/**
	 * 
	 * @return
	 */
	public static ResultSet selectAllRecipe() {
		return DBConnector.executeSelectSQL("select * from RECIPE");
	}

	public static ResultSet selectIngredient(Recipe r){
		return DBConnector.executeSelectSQL("select * from INGREDIENT where INGREDIENT.rid="+r.getRecipeID());
	}

	public static ResultSet selectPicture(Recipe r){
		return DBConnector.executeSelectSQL("select * from PICTURE where PICTURE.rid="+r.getRecipeID());
	}

	public static ResultSet selectPrepStep(Recipe r){
		return DBConnector.executeSelectSQL("select * from PREPARATIONSTEP where PREPARATIONSTEP.rid="+r.getRecipeID());
	}
	
	public static void addRecipeToDB(Recipe r) throws SQLException{
		Integer rid= getMaxRid()+1;
		DBConnector.executeNonSelectSQL("INSERT INTO RECIPE (rid,recipeName, servings, preparationTime, cookingTime, recipeDesc) VALUES(" +rid+","+ "'"+r.getRecipeName()+"'"+","+r.getIntServeNum()+","+r.getPreparationTime()+","+r.getCookTime()+","+"'"+r.getDescription()+"'"+")");
		addIngredientToDB(r,rid);
		addPrepStep(r,rid);
		addPicture(r,rid);
	}

	public static void addIngredientToDB(Recipe r,Integer rid) throws SQLException{
		for(int i=0;i<r.getIngredientList().size();i++){
			DBConnector.executeNonSelectSQL("INSERT INTO INGREDIENT (rid,iid,ingredientName,quantity,unit,ingredientDesc) VALUES("+rid+","+(i+1)+","+"'"+r.getIngredientList().get(i).getIngredientName()+"'"+","+r.getIngredientList().get(i).getQuantity()+","+"'"+r.getIngredientList().get(i).getUnit()+"'"+","+"'"+r.getIngredientList().get(i).getDescription()+"'"+")");
		}
	}

	public static void addPrepStep(Recipe r,Integer rid) throws SQLException{
		for(int i=0;i<r.getPreparationStep().size();i++){
				DBConnector.executeNonSelectSQL("INSERT INTO PREPARATIONSTEP (rid,stepNum,step) VALUES("+rid+","+(i+1)+","+"'"+r.getPreparationStep().get(i)+"'"+")");
		}
	}

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
	
	public static void deleteRecipe(Integer rid) {
		DBConnector.executeNonSelectSQL("delete from RECIPE where rid=" + rid);
	}
	
//	public static void deleteIngredientInDB(Recipe r, int iid) {
//		DBConnector.executeNonSelectSQL("delete from INGREDIENT where rid=" +r.getRecipeID()+"and iid=" + iid);	
//	}
	
//	public static void deletePrepStep(Recipe r, int stepNum) {
//		DBConnector.executeNonSelectSQL("delete from PREPARATIONSTEP where rid=" + r.getRecipeID() + "and stepNum=" + stepNum);
//	}

	public static void modifyRecipe(Recipe r,Integer rid) throws SQLException {
		deleteRecipe(rid);
		addRecipeToDB(r);
	}
	
	public static ResultSet selectMaxRid() {
		return DBConnector.executeSelectSQL("SELECT MAX(rid) AS rid_max from RECIPE ");
	}
	
	public static Integer getMaxRid() throws SQLException{
		ResultSet rs = DBOperation.selectMaxRid();
		rs.next();
		Integer newRid = rs.getInt(1);
		return newRid;
	}
}
