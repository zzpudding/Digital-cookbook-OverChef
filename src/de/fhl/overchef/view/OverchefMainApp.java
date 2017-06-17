package de.fhl.overchef.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.model.Relationship;

public class OverchefMainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Relationship r;
    private ObservableList<Recipe> recipeData = FXCollections.observableArrayList();
	private Map<Ingredient, Relationship> ingredients = new HashMap<Ingredient, Relationship>();

    
	@Override
	public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("OverchefApp");
        initializeMainViewRootLayout();
        showMainView();
	}
	
	
	
	/**
     * Initializes the root layout.
	 * @throws IOException 
     */
    public void initializeMainViewRootLayout() throws IOException {
        // Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(OverchefMainApp.class.getResource("MainViewRootLayout.fxml"));
		rootLayout = (BorderPane) loader.load();

		//Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
    
    
    /**
     * Shows the person overview inside the root layout.
     */
    public void showMainView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(OverchefMainApp.class.getResource("MainView.fxml"));
            AnchorPane MainView = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(MainView);

            // Give the controller access to the main app.
            MainViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
 
	public static void main(String[] args) {
		launch(args);
		
	}
	private static Recipe createHongShaoRou() {
		Recipe recipe = new Recipe("Hong Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}
	private static Recipe createHongShaoRou2() {
		Recipe recipe = new Recipe("Iong Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}
	private static Recipe createHongShaoRou3() {
		Recipe recipe = new Recipe("Mong Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}
	private static Recipe createHongShaoRou4() {
		Recipe recipe = new Recipe("Fong Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("salt", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}
	private static Recipe createHongShaoRou5() {
		Recipe recipe = new Recipe("Vong Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		return recipe;
	}
	private static Recipe createHongShaoRou6() {
		Recipe recipe = new Recipe("Wong Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}
	private static Recipe createHongShaoRou7() {
		Recipe recipe = new Recipe("Qong Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}
	private static Recipe createHongShaoRou8() {
		Recipe recipe = new Recipe("Hong Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}private static Recipe createHongShaoRou9() {
		Recipe recipe = new Recipe("Hong Shao", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}private static Recipe createHongShaoRou10() {
		Recipe recipe = new Recipe("HMng Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}private static Recipe createHongShaoRou11() {
		Recipe recipe = new Recipe("HONG Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}private static Recipe createHongShaoRou12() {
		Recipe recipe = new Recipe("Hog Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}private static Recipe createHongShaoRou13() {
		Recipe recipe = new Recipe("HongME Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}private static Recipe createHongShaoRou14() {
		Recipe recipe = new Recipe("HongSD Shao Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}private static Recipe createHongShaoRou15() {
		Recipe recipe = new Recipe("Hong ShaoOI Rou", 20, 20, 30);
		recipe.addIngredient(new Ingredient("cornstarch", 1.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("soy sauce", 4.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		return recipe;
	}
	private static Recipe createGongBaoJiding() {
		Recipe recipe = new Recipe("Gong Bao Jiding", 20,20,30);
		recipe.addIngredient(new Ingredient("chicken breast", 0.5, "kg"," "));
		recipe.addIngredient(new Ingredient("Shaoxin rice wine", 3.0, "tablespoon"," "));
		recipe.addIngredient(new Ingredient("sugar", 2.0, "tablespoon"," "));
		return recipe;
	}

	public void setRecipeData(ObservableList<Recipe> recipeData) {
		this.recipeData = recipeData;
	}

	public OverchefMainApp() {
        recipeData.add(createHongShaoRou());
        recipeData.add(createHongShaoRou2());
        recipeData.add(createHongShaoRou3());
        recipeData.add(createHongShaoRou4());
        recipeData.add(createHongShaoRou5());
        recipeData.add(createHongShaoRou6());
        recipeData.add(createHongShaoRou7());
        recipeData.add(createHongShaoRou8());
        recipeData.add(createHongShaoRou9());
        recipeData.add(createHongShaoRou10());
        recipeData.add(createHongShaoRou11());
        recipeData.add(createHongShaoRou12());
        recipeData.add(createHongShaoRou13());
        recipeData.add(createHongShaoRou14());
        recipeData.add(createHongShaoRou15());
        recipeData.add(createGongBaoJiding());
    }
	
	public ObservableList<Recipe> getRecipeData() {
        return recipeData;
    }
	

	public Map<Ingredient, Relationship> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<Ingredient, Relationship> ingredients) {
		this.ingredients = ingredients;
	}

	
	public void addIngredient(Ingredient i) {
		r.setUnit(i.getUnit());
		r.setIngredientDesp(i.getDescription());
		r.setQuantiy(i.getQuantity());
		this.ingredients.put(i, r);
	}
	
}
