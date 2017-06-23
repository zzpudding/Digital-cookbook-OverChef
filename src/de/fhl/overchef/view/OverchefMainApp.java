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
import de.fhl.overchef.model.CreateRecipe;
import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.model.Relationship;
import de.fhl.overchef.view.MainViewController;

public class OverchefMainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private Relationship r;
    private static ObservableList<Recipe> recipeData = FXCollections.observableArrayList();
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
	
	public static void deleteRecipe(Recipe recipe){
		recipeData.remove(recipe);
	}
	
	public void setRecipeData(List<Recipe> recipelist) {
		this.recipeData = FXCollections.observableArrayList(recipelist);
	}

	public OverchefMainApp() throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException, SQLException {

		
		Cookbook ck = new Cookbook();
		try {
			DBConnector.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		ck.addRecipe(CreateRecipe.createRecipe_01());
//		ck.addRecipe(CreateRecipe.createRecipe_02());
//		ck.addRecipe(CreateRecipe.createRecipe_03());
//		ck.addRecipe(CreateRecipe.createRecipe_04());
//		ck.addRecipe(CreateRecipe.createRecipe_05());
//		ck.addRecipe(CreateRecipe.createRecipe_06());
//		ck.addRecipe(CreateRecipe.createRecipe_07());
//		ck.addRecipe(CreateRecipe.createRecipe_08());
		ck.setRecipeList(ck.loadRecipesFromDB(DBOperation.selectAllRecipe()));
		setRecipeData(ck.getRecipeList());
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
