package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;

public class CreateRecipe {
	
	public static Recipe createRecipe_01() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Spicy Chicken", 4, 20, 30);
		recipe.addIngredient(new Ingredient("Chicken leg", 1.0, "kg"," The legs of chicken are better "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon","can be used to eliminate the smell of the chicken"));
		recipe.addIngredient(new Ingredient("pepper", 100, "g","choose the spicy pepper"));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon","make the chicken better"));
		recipe.addIngredient(new Ingredient("Garlic", 30, "g","important flavor"));
		recipe.addIngredient(new Ingredient("pepper", 5, "g","important flavor"));
		recipe.addIngredient(new Ingredient("green onion", 200, "g","important flavor"));
		recipe.addIngredient(new Ingredient("ginger", 10, "g","important flavor"));

		recipe.addPreparationStep("Clean the chicken and cut chicken into pieces");
		recipe.addPreparationStep("Put these pieces into boiling water for 5- 10 minutes and then take them out");
		recipe.addPreparationStep("Cut pepper into small pieces, so do garlic, green onion and ginger");
		recipe.addPreparationStep("Heat up the pot and fry the garlic and green onion at first ");
		recipe.addPreparationStep("Then put chicken into the pot and fry it and put peppers also in the pot");
		recipe.addPreparationStep("Add soy sauce and Shaoxin rice wine into the stuff and boil it for 15-20 minutes");

		//recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_02() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe(" Xiao Chao Rou", 4, 20, 20);
		recipe.addIngredient(new Ingredient("Pork", 600 , "g"," main material "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," this can be used to eliminate the smell of the prok "));
		recipe.addIngredient(new Ingredient("pepper", 100, "g","choose the spicy pepper"));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon","make the pork better"));
		recipe.addIngredient(new Ingredient("Garlic", 30, "g","important flavor"));
		recipe.addIngredient(new Ingredient("pepper", 5, "g","important flavor"));
		recipe.addIngredient(new Ingredient("spicy pepper", 5, "g","important flavor"));
		recipe.addIngredient(new Ingredient("green onion", 200, "g","important flavor"));
		recipe.addIngredient(new Ingredient("ginger", 10, "g","important flavor"));

		recipe.addPreparationStep("Clean and cut the pork into pieces");
		recipe.addPreparationStep("Put these pieces into boiling water for 5- 10 minutes and then take them out");
		recipe.addPreparationStep("Cut pepper into small pieces, so do garlic, green onion and ginger");
		recipe.addPreparationStep("Put all the flavors except for pepper powder together and set aside and heat up the pot");
		recipe.addPreparationStep("Put flavors first to fry and then the pork");
		recipe.addPreparationStep("Add soy sauce, Shaoxin rice wine and pepper podwer into the stuff and boil it for 10- 15 minutes");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_03() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Chicken Soup", 4, 20, 60);
		recipe.addIngredient(new Ingredient("Chicken", 1 , "kg"," Main material "));
		recipe.addIngredient(new Ingredient("Marsroom", 100, "g","make the chicken soup better"));
		recipe.addIngredient(new Ingredient("Mu er", 100, "g"," a traditional Chinese ingredient"));
		recipe.addIngredient(new Ingredient("salt", 5, "g", ""));
		recipe.addIngredient(new Ingredient("green onion", 200, "g","important flavor"));
		recipe.addIngredient(new Ingredient("ginger", 10, "g","important flavor"));

		recipe.addPreparationStep("Clean and cut the chicken into pieces");
		recipe.addPreparationStep("Put these pieces into boiling water for 5 minutes and then take them out");
		recipe.addPreparationStep("Cut the marshroom and mu er into pieces");
		recipe.addPreparationStep("Change the water in the pot and then put chicken back into the pot with green onion and ginger");
		recipe.addPreparationStep("Boil the stuff for 20 minute and add marshroom and salt");
		recipe.addPreparationStep("Put mu er into the pot 10 minutes before the dish finished");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_04() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Chocolate Cake", 4, 40, 20);
		recipe.addIngredient(new Ingredient("Flour", 1 , "kg"," Main material "));
		recipe.addIngredient(new Ingredient("Chocolate podwer", 150, "g","Main material"));
		recipe.addIngredient(new Ingredient("yeast", 3 , "g"," necessary material"));
		recipe.addIngredient(new Ingredient("egg", 100 , "g", "make the cake better"));
		recipe.addIngredient(new Ingredient("sugar", 20, "g","important flavor"));

		recipe.addPreparationStep("Porcess the flour");
		recipe.addPreparationStep("add chocolate, yeast, egg and sugar into the flour");
		recipe.addPreparationStep("put the cake into oven for 20 miniutes");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_05() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Fruit Salad", 4, 40, 10);
		recipe.addIngredient(new Ingredient("Fruit", 1 , "kg"," You can choose all kinds of fruit you want "));
		recipe.addIngredient(new Ingredient("salad sauce", 150, "g","Main flavor"));

		recipe.addPreparationStep("Clean and cut all the fruit into pieces");
		recipe.addPreparationStep("add salad into the pieces");
		recipe.addPreparationStep("Stir them and prepare to enjoy it. You can also put some flavor you like");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_06() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Hamburger", 4, 20, 20);
		recipe.addIngredient(new Ingredient("beef", 1 , "kg"," Main material "));
		recipe.addIngredient(new Ingredient("salat", 500, "g","Main material"));
		recipe.addIngredient(new Ingredient("tomato", 500 , "g"," Main material"));
		recipe.addIngredient(new Ingredient("hamburger sauce", 100 , "g", "make the burger better"));
		recipe.addIngredient(new Ingredient("pepper", 20, "g","flavor"));

		recipe.addPreparationStep("Use the beef to make meat balls");
		recipe.addPreparationStep("Press the meat balls into pastries");
		recipe.addPreparationStep("fry the meat pastries");
		recipe.addPreparationStep("Cut the salat and tomatoes into pieces to eat with hamburger");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_07() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Tomato and Beef Soup", 4, 20, 40);
		recipe.addIngredient(new Ingredient("Beef", 500 , "g"," Main material"));
		recipe.addIngredient(new Ingredient("Tomato", 500, "g","Main material"));
		recipe.addIngredient(new Ingredient("Potato", 500 , "g"," Main"));
		recipe.addIngredient(new Ingredient("green onion", 50 , "g", "important flavor"));
		recipe.addIngredient(new Ingredient("ginger", 20, "g","important flavor"));

		recipe.addPreparationStep("Cut the beef, tomatoes and potatoes into pieces");
		recipe.addPreparationStep("Heat up the pot and fry beef, potatoes and tomatoes in order");
		recipe.addPreparationStep("Put all the main materials together and fry them");
		recipe.addPreparationStep("Add about 2 L water to boli the stuff for about 30 miniutes");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_08() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Chicken with Onion", 4, 20, 20);
		recipe.addIngredient(new Ingredient("Chicken", 500 , "g"," Main material "));
		recipe.addIngredient(new Ingredient("Onion", 500, "g","Main material"));
		recipe.addIngredient(new Ingredient("pepper", 10 , "g"," important flavor"));
		recipe.addIngredient(new Ingredient("soy sauce", 10 , "g", "important flavor"));

		recipe.addPreparationStep("Cut the chicken and onions into pieces");
		recipe.addPreparationStep("Heat up the pot and fry chicken and onions in order");
		recipe.addPreparationStep("Put all the main materials together and fry them and add soy sauce");
		recipe.addPreparationStep("Finally add pepper into the stuff");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}


	

}
