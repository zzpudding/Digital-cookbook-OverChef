package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;
/**
 * This class is used to edit recipes to be saved in the database at the first time when the software is set up
 * @author Zhengjiang Hu, Fangtian Li
 *
 */
public class CreateRecipe {
	
	public static Recipe createRecipe_01() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Spicy Chicken", 4, 20, 30);
		recipe.addIngredient(new Ingredient("Chicken leg", 1.0, "kg"," The legs of chicken are better "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon","can be used to eliminate the smell of the chicken "));
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

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	
	public static Recipe createRecipe_02() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Xiao Chao Rou", 4, 20, 20);
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
		recipe.addIngredient(new Ingredient("Beef", 500 , "g"," Main material "));
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

	public static Recipe createRecipe_09() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Chicken burger", 1, 10, 8);
		recipe.addIngredient(new Ingredient("chicken breast", 500 , "g"," Main material "));
		recipe.addIngredient(new Ingredient("chipotle paste", 100, "g","Main material"));
		recipe.addIngredient(new Ingredient("lime juiced", 10 , "g"," important flavor"));
		recipe.addIngredient(new Ingredient("slices cheese", 2 , "piece", "important flavor"));
		recipe.addIngredient(new Ingredient("cherry tomatoes", 2 , "piece", "important flavor"));

		recipe.addPreparationStep("put the chicken on a plate and cut it into 1cm cube.");
		recipe.addPreparationStep("Mix the sauce in the ingredient and spread it on the chicken.");
		recipe.addPreparationStep("Heat a pan and cook the chicken chest for 3 minutes, then add the cheese at the last. ");
		recipe.addPreparationStep("Choose two bread, add the meat to the middle of the breads.");
		recipe.addPreparationStep(" Meanwhile, add some other sauce such as pepper.");
//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_10() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Salmon", 2, 10, 10);
		recipe.addIngredient(new Ingredient("Salmon fillets", 2 , "piece"," Main material "));
		recipe.addIngredient(new Ingredient("sweet chilli sauce", 1 , "tbsp"," important flavor"));
		recipe.addIngredient(new Ingredient("honey", 1 , "tbsp", "important flavor"));
		recipe.addIngredient(new Ingredient("oil", 1 , "tbsp", "important flavor"));


		recipe.addPreparationStep("Heat the pan and put the salmon into it.");
		recipe.addPreparationStep("Mix the sweet chilli, honey, oil, in a small bowl and pour over the salmon. Bake for 10 mins.");
		recipe.addPreparationStep("Cut a slice across the base so the fish separate. Heat the oils in another pan, add the garlic briefly to soften.");
		recipe.addPreparationStep("Pour over the oil, cover the pan and allow to cook for 5 mins.");
		recipe.addPreparationStep("Serve the garlic in shallow bowls, put the salmon on the top and add the juices. you can eat it with rice or noodle.");


//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_11() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Noodles", 2, 5, 10);
		recipe.addIngredient(new Ingredient("soba noodles", 150 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("raw prawns", 180 , "gram"," important flavor"));
		recipe.addIngredient(new Ingredient("soy sauce", 3 , "tbsp", "important flavor"));
		recipe.addIngredient(new Ingredient("wasabi", 1 , "tbsp", "important flavor"));

		recipe.addPreparationStep("Mix the wasabi, soy sauce and garlic in a small bowl. Bring a large pan of water to the boil.");
		recipe.addPreparationStep("in the meanwhile, heat the butter in a frying pan. Once steaming, cook for a few mins until it become pink. Stir in the wasabi mixture with a couple of spoonfuls of the noodle cooking water and heat through.");
		recipe.addPreparationStep("Add the noodles to the pan with the onions, toss together and divide between two plates.");


//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_12() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Sandwich", 2, 2, 6);
		recipe.addIngredient(new Ingredient("pack raw peeled king prawns", 150 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("can kidney beans in chilli sauce", 400 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("rice", 250 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("jerk seasoning", 1.5 , "tbsp"," important flavor"));
		
		recipe.setDescription("This quick, lazy food can reserve for 2 days");

		recipe.addPreparationStep("Heat 1 tbsp oil in a large frying pan. Add the jerk seasoning, and cook for 1-2 mins. Drain the beans, add 3 tbsp of the chilli sauce.");
		recipe.addPreparationStep("Add the beans to the pan along with the reserved sauce and the coconut rice. Fry for 3-4 mins, then season with salt to taste and spoon into two bowls to eat.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_13() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Penne with tuna sauce", 4, 5, 15);
		recipe.addIngredient(new Ingredient("penne", 350 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("pouch coconut rice", 250 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("jerk seasoning", 1.5 , "tbsp"," important flavor"));

		recipe.setDescription("easy to handle");

		recipe.addPreparationStep("pour half pot of water into a empty pot and heat it to boiling.");
		recipe.addPreparationStep("keep heating for 5 minutes and season it with jerk.");
		recipe.addPreparationStep("pour the water and mix the penne with rice.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_14() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("banane pie", 2, 25, 35);
		recipe.addIngredient(new Ingredient("banane", 200 , "gram","main material"));
		recipe.addIngredient(new Ingredient("dumpling warpper", 250 , "gram"," Main material "));

		recipe.setDescription("easy but time consuming.");

		recipe.addPreparationStep("Mash the banane");
		recipe.addPreparationStep("Prepare the dumling warppers and place them on a platform.");
		recipe.addPreparationStep("Warp the banane with dumpling warppers, you can stick the warpper edges with some water");
		recipe.addPreparationStep("Heat a pan and fry the pie, each for 1 minute");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_15() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("pineapple rice", 4, 10, 15);
		recipe.addIngredient(new Ingredient("pineapple", 140 , "gram","chopped into bite-sized chunks"));
		recipe.addIngredient(new Ingredient("spring onions", 250 , "gram","both sliced"));
		recipe.addIngredient(new Ingredient("Thai green curry paste", 3 , "tbsp"," important flavor"));
		recipe.addIngredient(new Ingredient("egg", 2 , "piece","beaten"));
		recipe.addIngredient(new Ingredient("pea", 140 , "gram","frozen"));

		recipe.setDescription("Cook your rice in advance to get ahead, suitable for busy time.");

		recipe.addPreparationStep("Heat the oil in a pot or non-stick frying pan and fry the onion whites for 2 mins until softened. ");
		recipe.addPreparationStep("Stir in the pepper for 1 min, followed by the pineapple for 1 min more, then stir in the green curry paste and soy sauce.");
		recipe.addPreparationStep("Add the rice, then push the rice to one side of the pan and scramble the eggs on the other side. ");
		recipe.addPreparationStep("pare the pea and cut it into 1cm cube, and add them to the rice");
		

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_16() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Vegetarian chilli", 2, 2, 30);
		recipe.addIngredient(new Ingredient("oven-roasted vegetable", 400 , "gram","Main material"));
		recipe.addIngredient(new Ingredient("can kidney bean", 1 , "piece","in chilli sauce"));
		recipe.addIngredient(new Ingredient("tomatoe", 1 , "piece","chopped"));

		recipe.setDescription("The easiest chilli you will ever make");

		recipe.addPreparationStep("Heat the pot. Cook the vegetables in a dish for 15 mins. Tip in the beans and tomatoes, season, and cook for another 10-15 mins until piping hot.");
		recipe.addPreparationStep("Heat the plate in the microwave on 600W for 1 min and mix with the chilli.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	public static Recipe createRecipe_17() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("lemon chicken",6 ,20,60 );
		recipe.addIngredient(new Ingredient("charlotte potatoes", 1 , "kg" ,"large ones cut in half"));
		recipe.addIngredient(new Ingredient("lemon", 2 , "piece" ,""));
		recipe.addIngredient(new Ingredient("olive oil", 125 , "ml" ,""));
		recipe.addIngredient(new Ingredient("red-wine vinegar", 1 , "tbsp" ,""));
		recipe.addIngredient(new Ingredient("dried oregano", 0.5 , "tsp" ,""));
		recipe.addIngredient(new Ingredient("Salt and freshly ground black pepper", 1 ,"spoon",""));
		recipe.addIngredient(new Ingredient("chicken ", 1.6 , "kg" ,"medium"));
		recipe.addIngredient(new Ingredient("garlic cloves", 2 , "" ,""));
		recipe.addIngredient(new Ingredient(" green olives", 150 , "g" ,"stoned and halved"));
		recipe.addIngredient(new Ingredient("fresh thyme", 0.5 , "small bunch" ,"picked"));
		
		recipe.setDescription("This golden chicken and potato combo is made vibrant by its lemon and olive dressing.");
		
		recipe.addPreparationStep("Heat the oven to 200C mark 6. Steam the potatoes for 10-15 minutes,then drain and leave uncovered to steam dry.");
		recipe.addPreparationStep("Make the marinade by whisking the lemon juice and zest, half the oil, the vinegar and the oregano.");
		recipe.addPreparationStep("Spatchcock the chicken by cutting out the backbone with kitchen scissors.");
		recipe.addPreparationStep("Bash together the garlic, thyme and a teaspoon of salt in a mortar . ");
		recipe.addPreparationStep("Turn out the potatoes into a large baking tin and gently crush them with a potato masher.");
		recipe.addPreparationStep("Cook the chicken at the same time as the spuds. ");
		recipe.addPreparationStep("Let the chicken rest for five minutes and keep the potatoes warm, then carve and serve.");

		//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}
	public static Recipe createRecipe_18() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Cake ", 5, 30, 40);
		recipe.addIngredient(new Ingredient("butter", 140 , "g" ,"softened, plus extra for greasing"));
		recipe.addIngredient(new Ingredient("demerara sugar", 260 , "g",""));
		recipe.addIngredient(new Ingredient("egg", 5 , "piece",""));
		recipe.addIngredient(new Ingredient("Greek yoghurt", 125 , "g",""));
		recipe.addIngredient(new Ingredient("self-raising flour", 375 , "g",""));
		recipe.addIngredient(new Ingredient("baking powder", 1 , "tsp",""));
		recipe.addIngredient(new Ingredient("pinch salt", 1 , "pinch",""));
		recipe.addIngredient(new Ingredient("lemon", 2 , "piece",""));
		recipe.addIngredient(new Ingredient("amaretti biscuits", 75 , "g",""));
		recipe.addIngredient(new Ingredient("peach", 7, "piece","stoned and quartered"));
		recipe.setDescription("Full of the flavours of summer");

		recipe.addPreparationStep("To make the cake batter, cream the butter and sugar in a food processor.");
		recipe.addPreparationStep("Beat in the eggs one at a time, then incorporate the yoghurt.");
		recipe.addPreparationStep("Put the biscuits into a plastic bag and bash to a fine crumb, then toss the peach quarters in the crumbs");
		recipe.addPreparationStep("While the cake is baking, make the crumble.");
		recipe.addPreparationStep("Leave to cool completely, then remove from the tin, cut into slices and serve with creme fraiche.");
		return recipe;
	}
		public static Recipe createRecipe_19() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe("custard tart",6,30,60);
			recipe.addIngredient(new Ingredient(" plain flour", 225 , "g" ,"plus extra for dusting"));
			recipe.addIngredient(new Ingredient("icing sugar", 3 , "tbsp" ,""));
			recipe.addIngredient(new Ingredient("unsalted butter", 140 , "g" ,"diced and chilled"));
			recipe.addIngredient(new Ingredient("egg yolk", 1 , "medium" ,"plus 1 medium egg yolk beaten, for glazing"));
			recipe.addIngredient(new Ingredient("vanilla bean paste", 1, "tsp" ,""));
			recipe.addIngredient(new Ingredient("whole milk", 250 , "ml" ,""));
			recipe.addIngredient(new Ingredient("cornflour", 250 , "g" ,""));
			recipe.addIngredient(new Ingredient("thin forced rhubarb", 700 , "g" ,""));
			recipe.addIngredient(new Ingredient("pistachio", 1 , " tbsp" ,""));
			recipe.setDescription("The flavour of my favourite boiled sweet in a delicious dessert.  ");
			recipe.addPreparationStep("Put the flour, icing sugar and a pinch of salt in a large bowl and mix together.");
			recipe.addPreparationStep("Put the vanilla beans scraped from the pod  in a pan,add the milk and bring to the boil. ");
			recipe.addPreparationStep("Meanwhile, tip the egg, yolks, sugar and cornflour into a bowl and whisk together until smooth.  ");
			recipe.addPreparationStep("Chill for 30 mins or until the pastry is firm.");
			recipe.addPreparationStep("Heat oven to 180C the tart with a piece of crumpled baking parchment and fill with baking beans or rice and place on a baking tray.");
			recipe.addPreparationStep("emove the custard from the fridge, beat to loosen, then pour over the pastry and smooth with a spatula. ");
			recipe.addPreparationStep("Top with the roasted rhubarb, brushing a little of the syrup on top, then sprinkle over the pistachios.");
//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
		}
		public static Recipe createRecipe_20() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe(" Peanut butter chicken", 3,10,60 );
			recipe.addIngredient(new Ingredient(" vegetable oil", 2 , "tbsp" ,""));
			recipe.addIngredient(new Ingredient("skinless boneless chicken thighs", 8 , "piece" ,"cut into chunks"));
			recipe.addIngredient(new Ingredient("red chillies", 2 , "piece" ,"finely sliced "));
			recipe.addIngredient(new Ingredient("fresh ginger", 2 , "tsp" ,""));
			recipe.addIngredient(new Ingredient("garam masala", 2 , " tsp" ,""));
			recipe.addIngredient(new Ingredient("smooth peanut butter", 100 , "g" ,""));
			recipe.addIngredient(new Ingredient("coconut milk", 400 , "g" ,""));
			recipe.addIngredient(new Ingredient("hopped tomatoes", 400 , "g" ,""));
			recipe.addIngredient(new Ingredient("coriander", 1 , "bunch " ,""));
			recipe.setDescription("The whole family will love this new, budget chicken dish. Any leftovers freeze well and make a handy lunch");
			recipe.addPreparationStep("Heat 1 tbsp of the oil in a deep frying pan over a medium heat. Brown the chicken in batches. ");
			recipe.addPreparationStep("Fry the garlic, chilli and ginger in the other 1 tbsp oil for 1 min. ");
			recipe.addPreparationStep("Stir in the peanut butter, coconut milk and tomatoes, and bring to a simmer.");
			recipe.addPreparationStep("Return the chicken to the pan and add the chopped coriander.");
			recipe.addPreparationStep("Cook for 30 mins until the sauce thickens and the chicken is cooked through");
			recipe.addPreparationStep("Serve with the remaining coriander, roasted peanuts and rice, if you like.");

//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
		}
		public static Recipe createRecipe_21() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe("Secret",3,10 ,40 );
			recipe.addIngredient(new Ingredient("soft butter", 140 , "g" ,""));
			recipe.addIngredient(new Ingredient("caster sugar", 140 , "g" ,""));
			recipe.addIngredient(new Ingredient("large egg", 2 , "piece" ,"beaten"));
			recipe.addIngredient(new Ingredient("self-raising flour", 140 , "g" ,""));
			recipe.addIngredient(new Ingredient("baking powder", 1 , "tsp" ,""));
			recipe.addIngredient(new Ingredient("ripe bananas mashed", 2 , "piece" ,""));
			
			recipe.setDescription("This is an easy recipe that gives perfect results every time.  ");
			recipe.addPreparationStep("Preheat your oven to 180C .");
			recipe.addPreparationStep("Butter your loaf tin and line the base and sides with baking parchment paper.");
			recipe.addPreparationStep("Cream the butter and sugar until light and fluffy, then slowly add the eggs with a little flour.");
			recipe.addPreparationStep("Fold in the remaining flour, baking powder and mashed bananas.");
			recipe.addPreparationStep("Pour into the tin and bake for about 30 mins until a skewer comes out clean. ");
//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
		}
		public static Recipe createRecipe_22() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe("Banana blueberry smoothie",2 ,10 ,30 );
			recipe.addIngredient(new Ingredient("fresh blueberries", 1 , "cup" ,""));
			recipe.addIngredient(new Ingredient("banana", 1 , "piece" ,""));
			recipe.addIngredient(new Ingredient("Pomegranate juice", 50 , "ml" ,""));
			recipe.addIngredient(new Ingredient("Natural yogurt", 1 , "cup" ,""));
			recipe.addIngredient(new Ingredient(" Ground cinnamon", 1 , "tsp" ,""));
			recipe.addIngredient(new Ingredient(" Berry powder of your choice", 2 , "tsp" ,""));
			recipe.setDescription("Simple Summer Smoothie Recipe. Healthy, easy, and quick to prepare it is a refreshing treat.");
			recipe.addPreparationStep("Combine the ingredients in a blender and blend until smooth. ");

//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
		}
	public static Recipe createRecipe_23() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe("Sliced Boiled Chicken", 3, 20, 50);
			recipe.addIngredient(new Ingredient("chicken", 1.5 , "kg",""));
			recipe.addIngredient(new Ingredient("salt", 1 , "tsp",""));
			recipe.addIngredient(new Ingredient("ginger", 1 , "piece",""));
			recipe.addIngredient(new Ingredient("soya sauce", 1.5 , "tsp",""));
			recipe.addIngredient(new Ingredient("oil", 3 , "tsp",""));
			recipe.addIngredient(new Ingredient("garlic", 1 , "piece",""));
			
			recipe.setDescription("That is very nice chinese style food");

			recipe.addPreparationStep("prepare a pot of boiled water and put the chicken into the water ");
			recipe.addPreparationStep("put the garlic and salt into the water");
			recipe.addPreparationStep("Remove the chicken to cool or refrigerate refrigerated for up to 10 minutes, and finally into the chicken pieces");
			recipe.addPreparationStep("Combine all sauce ingredients juice, chicken with dipping sauce");

//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
	}
	public static Recipe createRecipe_24() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe("Fried Chicken Wings", 3, 20, 60);
			recipe.addIngredient(new Ingredient("chicken Wings", 1 , "kg",""));
			recipe.addIngredient(new Ingredient("cola", 300 , "ml",""));
			recipe.addIngredient(new Ingredient("ginger", 1 , "piece",""));
			recipe.addIngredient(new Ingredient("soya sauce", 2 , "tsp",""));
			recipe.addIngredient(new Ingredient("salt", 1 , "tsp",""));
			recipe.addIngredient(new Ingredient("oil", 3 , "tsp",""));
			recipe.addIngredient(new Ingredient("rice wine", 2, "tsp",""));
			
			recipe.setDescription("Home Dishes");

			recipe.addPreparationStep("Scratch wings on the back by knife, make it tasty and easy cooked");
			recipe.addPreparationStep("Add chicken wings and marinated with spices");
			recipe.addPreparationStep("put the chicken into the pot and add the cola,ginger and rice wine");
			recipe.addPreparationStep("keep fire until there is few water");

//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
		}
		public static Recipe createRecipe_25() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe("hong shao pai gu", 4, 30,45);
			recipe.addIngredient(new Ingredient("pork ribs", 2 , "kg",""));
			recipe.addIngredient(new Ingredient("ginger", 1 , "piece",""));
			recipe.addIngredient(new Ingredient("soya sauce", 2 , "tsp",""));
			recipe.addIngredient(new Ingredient("salt", 1 , "tsp",""));
			recipe.addIngredient(new Ingredient("oil", 3 , "tsp",""));
			recipe.addIngredient(new Ingredient("rice wine", 2, "tsp",""));
			
			recipe.setDescription("Home Dishes");

			recipe.addPreparationStep("Scratch pork on the back by knife, make it tasty and easy cooked");
			recipe.addPreparationStep("Add pork and marinated with spices");
			recipe.addPreparationStep("add oil and put the pork into the pot ");
			recipe.addPreparationStep("add the sauce,ginger,salt and rice wine");
			recipe.addPreparationStep("keep fire until there is few water");


//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
		}
		public static Recipe createRecipe_26() throws FileNotFoundException, IOException {
			Recipe recipe = new Recipe("Lion Head Soup", 2, 20, 50);
			recipe.addIngredient(new Ingredient("pound pork", 0.8 , "kg",""));
			recipe.addIngredient(new Ingredient("egg", 1 , "piece",""));
			recipe.addIngredient(new Ingredient("cornstarch", 1 , "tsp",""));
			recipe.addIngredient(new Ingredient("oil", 2 , "tsp",""));
			recipe.addIngredient(new Ingredient("ginger", 1 , "piece",""));
			recipe.addIngredient(new Ingredient("salt", 1 , "tsp",""));
			recipe.addIngredient(new Ingredient("chicken broth", 500 , "ml",""));

			
			recipe.setDescription("This is my family''s version of lion''s head soup ");

			recipe.addPreparationStep("Mix the ground pork, egg, cornstarch, 2 teaspoons of sesame oil, ginger, salt, and half of the chopped green onions together in a bowl. ");
			recipe.addPreparationStep(" Pour in the chicken broth, water, and soy sauce. Bring to a boil, then lower the heat to medium.");
			recipe.addPreparationStep("Drop them into the boiling soup. ");

//			recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
			return recipe;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
