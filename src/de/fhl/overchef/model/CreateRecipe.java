package de.fhl.overchef.model;

import java.io.FileNotFoundException;
import java.io.IOException;

import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;
/**
 * This class is used to edit recipes to be saved in the database at the first time when the software is set up
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
		recipe.addIngredient(new Ingredient("Mushroom", 100, "g","make the chicken soup better"));
		recipe.addIngredient(new Ingredient("Mu er", 100, "g"," a traditional Chinese ingredient"));
		recipe.addIngredient(new Ingredient("salt", 5, "g", ""));
		recipe.addIngredient(new Ingredient("green onion", 200, "g","important flavor"));
		recipe.addIngredient(new Ingredient("ginger", 10, "g","important flavor"));

		recipe.addPreparationStep("Clean and cut the chicken into pieces");
		recipe.addPreparationStep("Put these pieces into boiling water for 5 minutes and then take them out");
		recipe.addPreparationStep("Cut the mushroom into pieces");
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
		Recipe recipe = new Recipe("Mexican chicken burger", 1, 10, 8);
		recipe.addIngredient(new Ingredient("chicken breast", 500 , "g"," Main material "));
		recipe.addIngredient(new Ingredient("tsp chipotle paste", 100, "g","Main material"));
		recipe.addIngredient(new Ingredient("lime juiced", 10 , "g"," important flavor"));
		recipe.addIngredient(new Ingredient("slices cheese", 2 , "piece", "important flavor"));
		recipe.addIngredient(new Ingredient("cherry tomatoes", 2 , "piece", "important flavor"));

		recipe.addPreparationStep("Put the chicken breast between two pieces of cling film and bash with a rolling pin or pan to about 1cm thick.");
		recipe.addPreparationStep("Mix the chipotle paste with half the lime juice and spread over the chicken.");
		recipe.addPreparationStep("Heat a griddle pan over a high heat. Once hot, cook the chicken for 3 mins each side until cooked through, adding the cheese for the final 2 mins of cooking. ");
		recipe.addPreparationStep(" Add the bun, cut-side down, to the griddle pan to toast lightly. Season the chicken.");
		recipe.addPreparationStep(" Meanwhile, mash the avocado with the remaining lime juice. Stir in the cherry tomatoes, jalape帽o and garlic, and season with a little salt. ");
		recipe.addPreparationStep(" Spread over the base of the bun, then add the chicken followed by the top of the bun.");
//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_10() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Teriyaki salmon with sesame pak choi", 2, 10, 10);
		recipe.addIngredient(new Ingredient("skinless salmon fillets", 2 , "piece"," Main material "));
		recipe.addIngredient(new Ingredient("sweet chilli sauce", 1 , "tbsp"," important flavor"));
		recipe.addIngredient(new Ingredient("honey", 1 , "tbsp", "important flavor"));
		recipe.addIngredient(new Ingredient("sesame oil", 1 , "tbsp", "important flavor"));


		recipe.addPreparationStep("Heat oven to 200C/180C fan/gas 6 and put the salmon in a shallow baking dish. ");
		recipe.addPreparationStep("Mix the sweet chilli, honey, sesame oil, mirin, soy and ginger in a small bowl and pour over the salmon so the steaks are completely covered. Bake for 10 mins while you cook the pak choi.");
		recipe.addPreparationStep("Cut a slice across the base of the pak choi so the leaves separate. Heat the oils in a wok, add the garlic and stir-fry briefly to soften. Add the pak choi and fry until the leaves start to wilt.");
		recipe.addPreparationStep("Pour over the stock, tightly cover the pan and allow to cook for 5 mins 鈥� you are aiming for the stems of the pak choi to be tender but still have a bit of bite.");
		recipe.addPreparationStep("Serve the pak choi in shallow bowls, top with the salmon steaks and spoon over the juices. Scatter with the toasted sesame seeds and serve on its own or with brown rice or noodles.");


//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_11() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Soba noodles with wasabi garlic prawns", 2, 5, 10);
		recipe.addIngredient(new Ingredient("soba noodles", 150 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("raw peeled king prawns", 180 , "gram"," important flavor"));
		recipe.addIngredient(new Ingredient("soy sauce", 3 , "tbsp", "important flavor"));
		recipe.addIngredient(new Ingredient("wasabi", 1 , "tbsp", "important flavor"));

		recipe.addPreparationStep("Mix the wasabi, soy sauce and garlic in a small bowl. Bring a large pan of water to the boil and cook the noodles following pack instructions.");
		recipe.addPreparationStep("Meanwhile, heat the butter in a frying pan. Once foaming, stir in the prawns and cook for a few mins until pink. Stir in the wasabi mixture with a couple of spoonfuls of the noodle cooking water and heat through.");
		recipe.addPreparationStep("Add the noodles to the pan with the spring onions, toss together and divide between two plates.");


//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_12() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Jerk prawn coconut rice bowls", 2, 2, 6);
		recipe.addIngredient(new Ingredient("pack raw peeled king prawns", 150 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("can kidney beans in chilli sauce", 400 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("pouch coconut rice", 250 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("jerk seasoning", 1.5 , "tbsp"," important flavor"));

		recipe.addPreparationStep("Heat 1 tbsp flavourless oil in a large frying pan. Add the prawns and the jerk seasoning, and cook for 1-2 mins. Drain the beans, reserving 3 tbsp of the chilli sauce.");
		recipe.addPreparationStep("Add the beans to the pan along with the reserved sauce and the coconut rice. Fry for 3-4 mins, then season with salt to taste and spoon into two bowls to serve.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_13() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Penne with a punchy tuna sauce", 4, 5, 15);
		recipe.addIngredient(new Ingredient("penne", 350 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("pouch coconut rice", 250 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("jerk seasoning", 1.5 , "tbsp"," important flavor"));

		recipe.setDescription("This quick, zesty supper is packed with Mediterranean flavours. Leftovers will keep well for lunch the next day");

		recipe.addPreparationStep("Heat 1 tbsp flavourless oil in a large frying pan. Add the prawns and the jerk seasoning, and cook for 1-2 mins. Drain the beans, reserving 3 tbsp of the chilli sauce.");
		recipe.addPreparationStep("Add the beans to the pan along with the reserved sauce and the coconut rice. Fry for 3-4 mins, then season with salt to taste and spoon into two bowls to serve.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_14() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Frying pan pizza with aubergine, ricotta and mint", 2, 25, 35);
		recipe.addIngredient(new Ingredient("strong white bread flourstrong white bread flour", 200 , "gram"," plus a little for dusting "));
		recipe.addIngredient(new Ingredient("pouch coconut rice", 250 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("jerk seasoning", 1.5 , "tbsp"," important flavor"));

		recipe.setDescription("This recipe ensures a crispy-bottomed pizza without ever turning on the oven. It is easy, veggie and 2 of your 5-a-day");

		recipe.addPreparationStep("Weigh the ingredients for the dough into a large bowl and add 1/2 tsp salt and 125ml warm water. Mix to form a soft dough, then tip onto your work surface and knead for 5 mins or until the dough feels stretchy. ");
		recipe.addPreparationStep("Clean and grease the bowl and return the dough. Cover with cling film and leave somewhere warm to rise for 1 hr, or until the dough has doubled in size.");
		recipe.addPreparationStep("Meanwhile, make the sauce. Heat 1 tbsp olive oil in a pan and add the garlic. Sizzle gently for 30 secs, making sure the garlic doesn鈥檛 brown, then add the passata. ");
		recipe.addPreparationStep("Season well and bubble for 8-10 mins until you have a rich sauce 鈥� add a pinch of sugar if it tastes a little too tart. Set aside.");
		recipe.addPreparationStep("When the dough has risen, knock out the air and roll it into a pizza base the same size as a large frying pan. Oil the surface of the dough, cover with cling film , then leave on the work surface for 15 mins to puff up a little. ");
		recipe.addPreparationStep("Meanwhile, heat 2 tbsp oil in the frying pan and add the aubergines in a single layer (you may have to cook in batches). Season well and cook for 4-5 mins on each side until really tender and golden. Transfer to a dish and cover with foil to keep warm.");
		recipe.addPreparationStep("Heat the remaining 1 tbsp of oil in the pan and carefully lift the dough into it. You may have to reshape it a little to fit. Cook over a low-medium heat until the underside is golden brown and the edges of the dough are starting to look dry and set 鈥� this should take about 6 mins, but it鈥檚 best to go by eye. ");
		recipe.addPreparationStep("Flip over, drizzle a little more oil around the edge of the pan so it trickles underneath the pizza base, and cook for another 5-6 mins until golden and cooked through. ");
		recipe.addPreparationStep("Reheat the sauce if you need to and spread it over the base. Top with the warm aubergines and dot with spoonfuls of ricotta. Scatter with mint and drizzle with a little extra virgin olive oil just before serving.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_15() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Thai fried prawn and pineapple rice", 4, 10, 15);
		recipe.addIngredient(new Ingredient("pineapple", 140 , "gram","chopped into bite-sized chunks"));
		recipe.addIngredient(new Ingredient("spring onions", 250 , "gram","both sliced"));
		recipe.addIngredient(new Ingredient("Thai green curry paste", 3 , "tbsp"," important flavor"));
		recipe.addIngredient(new Ingredient("egg", 2 , "piece","beaten"));
		recipe.addIngredient(new Ingredient("pea", 140 , "gram","frozen"));
		recipe.addIngredient(new Ingredient("light soy sauce", 4 , "tbsp","plus extra to serve"));
		recipe.addIngredient(new Ingredient("coriander leave", 0 , "handful","optional"));

		recipe.setDescription("This quick, low calorie supper is perfect for a busy weeknight. Cook your rice in advance to get ahead - run it under cold water to chill quickly, then freeze in a food bag for up to one month");

		recipe.addPreparationStep("Heat the oil in a wok or non-stick frying pan and fry the spring onion whites for 2 mins until softened. ");
		recipe.addPreparationStep("Stir in the pepper for 1 min, followed by the pineapple for 1 min more, then stir in the green curry paste and soy sauce.");
		recipe.addPreparationStep("Add the rice, stir-frying until piping hot, then push the rice to one side of the pan and scramble the eggs on the other side. ");
		recipe.addPreparationStep("Stir the peas, bamboo shoots and prawns into the rice and eggs, then heat through for 2 mins until the prawns are hot and the peas tender.");
		recipe.addPreparationStep("Finally, stir in the spring onion greens, lime juice and coriander, if using. Spoon into bowls and serve with extra lime wedges and soy sauce.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

	public static Recipe createRecipe_16() throws FileNotFoundException, IOException {
		Recipe recipe = new Recipe("Vegetarian chilli", 2, 2, 30);
		recipe.addIngredient(new Ingredient("pack oven-roasted vegetable", 400 , "gram"," Main material "));
		recipe.addIngredient(new Ingredient("can kidney bean", 1 , "piece","in chilli sauce"));
		recipe.addIngredient(new Ingredient("can chopped tomatoe", 1 , "piece",""));

		recipe.setDescription("The easiest chilli you will ever make, with ready-to-eat grains, kidney beans in chilli sauce and summer veggies - it is 4 of your 5-a-day too!");

		recipe.addPreparationStep("Heat oven to 200C/180C fan/ gas 6. Cook the vegetables in a casserole dish for 15 mins. Tip in the beans and tomatoes, season, and cook for another 10-15 mins until piping hot.");
		recipe.addPreparationStep("Heat the pouch in the microwave on High for 1 min and serve with the chilli.");

//		recipe.addPicture(System.getProperty("user.dir") + "\\src\\de\\fhl\\overchef\\model\\Pictures\\IMG_3578.PNG");
		return recipe;
	}

}
