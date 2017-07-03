package de.fhl.overchef.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhl.overchef.db.DBConnector;
import de.fhl.overchef.db.DBOperation;
import de.fhl.overchef.model.Cookbook;
import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.model.Relationship;
import de.fhl.overchef.controller.MainViewController;

/**
 * Main class to initialize and open the app
 * 
 * @author Jiacheng Zhou,Yujia Zhang
 */
public class OverchefMainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Relationship r;
    private static ObservableList<Recipe> recipeData = FXCollections.observableArrayList();
	private Map<Ingredient, Relationship> ingredients = new HashMap<Ingredient, Relationship>();
	
	/**
	 * Start the primaryStage and show the main view on it
	 * 
	 * @param primaryStage
	 * @throws IOException
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("OverchefApp");
        initializeMainViewRootLayout();
        showMainView();
	}
	
	/**
     * Initializes the main view root layout.
	 * 
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
     * Shows the recipe data inside the root layout.
     */
    public void showMainView() {
        try {
            // Load main view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(OverchefMainApp.class.getResource("MainView.fxml"));
            AnchorPane MainView = (AnchorPane) loader.load();

            // Set main view into the center of root layout.
            rootLayout.setCenter(MainView);

            // Give the controller access to the main app.
            MainViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
    
    /**
     * default main class 
     * 
     * @param args
     */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Constructor to initialize the database connection and the main view
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public OverchefMainApp() throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException, SQLException {
		Cookbook ck = new Cookbook();
		
		try {
			DBConnector.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	ck.setRecipeList(ck.loadRecipesFromDB(DBOperation.selectAllRecipe()));
		setRecipeData(ck.getRecipeList());
    }
	
	/**
	 * Add ingredient to the relationship map
	 * 
	 * @param i
	 */
	public void addIngredient(Ingredient i) {
		r.setUnit(i.getUnit());
		r.setIngredientDesp(i.getDescription());
		r.setQuantiy(i.getQuantity());
		this.ingredients.put(i, r);
	}
	
	/**
	 * Delete recipe from the recipeData list
	 * 
	 * @param recipe
	 */
	public static void deleteRecipe(Recipe recipe){
		recipeData.remove(recipe);
	}
	
	public Map<Ingredient, Relationship> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<Ingredient, Relationship> ingredients) {
		this.ingredients = ingredients;
	}
	
	public static  void setRecipeData(List<Recipe> recipelist) {
		recipeData = FXCollections.observableArrayList(recipelist);
	}
	
    public static void setRecipeData(ObservableList<Recipe> recipeData) {
		OverchefMainApp.recipeData = recipeData;
	}
    
	public static ObservableList<Recipe> getRecipeData() {
        return recipeData;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

}
