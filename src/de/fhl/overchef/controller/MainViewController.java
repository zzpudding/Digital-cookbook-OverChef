package de.fhl.overchef.controller;

import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.MainApp;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController {
	private TableView<Recipe> recipeTable;
	private TableColumn<Recipe, String> recipeNameCol = new TableColumn<Recipe, String>("Recipe");
	private TableColumn<Ingredient, String> ingredientNameCol = new TableColumn<Ingredient, String>("Ingredient");

	private MainApp mainApp;

	public void MainViewController() {
		//empty
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	private void initialize() {
		recipeNameCol.setCellValueFactory(new PropertyValueFactory<Recipe, String>("recipeName"));
		// Initialize the recipe table with the two columns.
		recipeNameCol.setCellValueFactory(cellData -> cellData.getValue().recipeNameProperty());
		ingredientNameCol.setCellValueFactory(cellData -> cellData.getValue().ingredientNameProperty());
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		recipeTable.setItems(mainApp.getRecipeData());
	}
}
