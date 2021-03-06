package de.fhl.overchef.view;

import java.io.IOException;

import de.fhl.overchef.controller.DeleteConfirmViewController;
import de.fhl.overchef.controller.RecipeViewController;
import de.fhl.overchef.model.Recipe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * realize recipe view and the pop-up box
 *
 */
public class RecipeView extends Application {
	private Recipe recipe;
	private Stage primaryStage;
	/**
	 * get the recipe from the main view
	 * @param recipe
	 */
	 public RecipeView(Recipe recipe){
	 this.recipe=recipe;
	 }
	 public RecipeView(){
		 
	 }
/**
 * start the recipe view and initiate recipe for this view
 */
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("RecipeView.fxml"));
		Scene scene = new Scene(loader.load(),Color.RED);
		primaryStage.getIcons().add(new Image( "file:src/de/fhl/overchef/view/recipeViewPicture/overChef.PNG"));
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.setTitle("Recipe");
		RecipeViewController controller = loader.getController();
		controller.recipeViewLayout();
		controller.initializeRecipeView(recipe);
		controller.setPrimaryStage(primaryStage);
		primaryStage.show();
	}
	
/**
 * realize pop-up box
 * @param recipe
 */
	public void confirmDelete(Recipe recipe,Stage stage) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(this.getClass().getResource("DeleteConfirmView.fxml"));

			Stage confirmStage = new Stage();
			confirmStage.setTitle("Confirm");
			confirmStage.initModality(Modality.APPLICATION_MODAL);
			confirmStage.initOwner(primaryStage);
			Scene scene = new Scene(loader.load());
			confirmStage.setScene(scene);
			//confirmStage.initStyle(StageStyle.UNIFIED);
			DeleteConfirmViewController controller = loader.getController();
			controller.setPrimaryStage(stage);
			controller.setStage(confirmStage);
			controller.setRecipe(recipe);
			confirmStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
