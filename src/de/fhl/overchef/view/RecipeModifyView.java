package de.fhl.overchef.view;

import de.fhl.overchef.model.Recipe;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
/**
 * The GUI of recipe modify view
 *
 */
public class RecipeModifyView extends Application {
	private Recipe recipe;
	private Stage recipeStage;
	
	public RecipeModifyView(Recipe recipe){
		this.recipe = recipe;		
	}

	public RecipeModifyView(Recipe recipe, Stage recipeStage){
		this.recipe = recipe;
		this.recipeStage = recipeStage;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("RecipeModifyView.fxml"));
		primaryStage.setTitle("Recipe Modify View");
		primaryStage.setScene(new Scene(loader.load(),800,600));
		primaryStage.initStyle(StageStyle.UNIFIED);
		
		RecipeModifyController controller = loader.getController();
		controller.setRecipe(recipe);
		controller.setRecipeStage(recipeStage);
		controller.setModifyView();
		controller.setPrimaryStage(primaryStage);
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent event) {
				// TODO Auto-generated method stub
				CloseAlert closeAlert = new CloseAlert();
				closeAlert.popUp("Close Recipe Modify View", "All the changes will be lost, are you sure to continue?", primaryStage, event);
			}
		});
		
		primaryStage.initModality(Modality.APPLICATION_MODAL);	
		primaryStage.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
