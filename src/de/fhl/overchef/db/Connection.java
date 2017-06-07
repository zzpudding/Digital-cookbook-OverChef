package de.fhl.overchef.db;

import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;

public class Connection {
	private Connection instance = null;
	
	
	private Connection() {
		
	}
	
	public Connection connect() {
		return null;
	}
	
	public void disconnect() {
		
	}
	
	private void connectToDB() {
		
	}

	public int addRecipe(Recipe r) {
		// check if exist
		// return auto-generated id
		return 0;// to avoid bugs now. can be change when program to this part 随便写的避免报错，以后再改
	}

	public int addIngredient(Ingredient i) {
		// check if exist
		// return auto-generated id
		return 0; // to avoid bugs now. can be change when program to this part 随便写的避免报错，以后再改
	}

	public void deleteRecipe(Recipe r) {
		// check if exist
		// consider exceptions in db
		// to avoid bugs now. can be change when program to this part 随便写的避免报错，以后再改
	}

}
