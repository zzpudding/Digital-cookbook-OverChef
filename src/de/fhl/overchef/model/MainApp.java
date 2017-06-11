package de.fhl.overchef.model;

import java.io.IOException;

import de.fhl.overchef.controller.MainViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp {
	//The data as an observable list of Persons.
    private ObservableList<Recipe> recipeData = FXCollections.observableArrayList();
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public MainApp() {
        // Add some sample data
    }
    
    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
	public ObservableList<Recipe> getRecipeData() {
		return recipeData;
	}

	public void setRecipeData(ObservableList<Recipe> recipeData) {
		this.recipeData = recipeData;
	}
	
	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showRecipeOverview() {
	    try {
	        // Load person overview.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/Mainview.fxml"));
	        AnchorPane MainView = (AnchorPane) loader.load();

	        // Set MainView into the center of root layout
	        rootLayout.setCenter(MainView);

	        // Give the controller access to the main app
	        MainViewController controller = loader.getController();
	        controller.setMainApp(this);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
