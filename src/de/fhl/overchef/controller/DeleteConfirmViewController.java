package de.fhl.overchef.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import de.fhl.overchef.db.DBOperation;
import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.view.OverchefMainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 * Alert view for user to confirm when the user is deleting a recipe
 * @author Bocheng Hu
 *
 */
public class DeleteConfirmViewController {
	@FXML
	private Button cance;;
	@FXML
	private Button confirm;
	private Stage stage;
	private Recipe recipe;
	 Stage primaryStage;

	@FXML
	private void cancel() {
		stage.close();
	}

	@FXML
	private void confirm() throws FileNotFoundException, IOException {
		stage.close();
		OverchefMainApp.deleteRecipe(recipe);
		primaryStage.close();
		DBOperation.deleteRecipe(recipe.getRecipeID());
		if(!recipe.getPictures().isEmpty()) {
			recipe.getPictures().get(0).deletePicture();
		}
	}

	public void setStage(Stage confirmStage) {
		this.stage = confirmStage;

	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage=primaryStage;
	}
}
