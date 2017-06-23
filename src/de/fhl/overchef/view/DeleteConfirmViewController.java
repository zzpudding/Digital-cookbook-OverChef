package de.fhl.overchef.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import de.fhl.overchef.model.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
		//primaryStage.close();
		OverchefMainApp.deleteRecipe(recipe);
		//RecipeView.closePrimaryStage();
		primaryStage.close();
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
