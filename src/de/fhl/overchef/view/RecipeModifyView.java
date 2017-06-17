package de.fhl.overchef.view;

import de.fhl.overchef.model.Recipe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RecipeModifyView extends Application {
	private Recipe recipe;
	
	public RecipeModifyView(Recipe recipe){
		this.recipe = recipe;
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
		primaryStage.setTitle("Recipe Modify View");
		primaryStage.setScene(new Scene(root,800,600));
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.show();
		primaryStage.initModality(Modality.APPLICATION_MODAL);	
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
