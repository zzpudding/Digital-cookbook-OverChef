package de.fhl.overchef.view;

import java.io.IOException;

import javax.xml.ws.Action;

import de.fhl.overchef.controller.RecipeController;
import de.fhl.overchef.model.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * realize action for the required component and the based function of the
 * recipe view
 * 
 * @author Bocheng Hu
 *
 */
public class RecipeViewController {

	Recipe recipe;
	@FXML
	Stage stage;
	@FXML
	private TextField recipeNameText;
	@FXML
	private TextArea descriptionText;
	@FXML
	private TextArea ingredientText;
	@FXML
	private TextArea preparationStepText;
	@FXML
	private TextField serveNumberText;
	@FXML
	private TextField totalTimeText;
	@FXML
	private TextField preparationTimeText;
	@FXML
	private TextField cookTimeText;
	@FXML
	private Button delete;
	@FXML
	private Button modify;
	@FXML
	private Button back;

	/**
	 * provide the living stage to the controller
	 * 
	 * @param stage
	 */
	public void setPrimaryStage(Stage stage) {
		this.stage = stage;
	}

	/**
	 * initiate the content for the recipe view
	 * 
	 * @param recipe
	 */
	public void initializeRecipeView(Recipe recipe) {
		this.recipe = recipe;
		recipeNameText.setText(recipe.getRecipeName());
		//descriptionText.setText(recipe.getDescription());
		//ingredientText.setText(recipe.getIngredients());
		//preparationStepText.setText(recipe.getPreparationStep());
		serveNumberText.setText(String.valueOf(recipe.getServeNumber()));
		totalTimeText.setText(String.valueOf(recipe.getPreparationTime()+recipe.getPreparationTime()));
		preparationTimeText.setText(String.valueOf(recipe.getPreparationTime()));
		cookTimeText.setText(String.valueOf(recipe.getPreparationTime()));
	}

	/**
	 * realize the action for the textField serve number
	 */
	@FXML
	private void changeServeNumber() {
		int changeNumber = Integer.valueOf(serveNumberText.getText());
		recipe.changeQuantity(changeNumber);
		ingredientText.setText(recipe.getIngredients());
	}
/**
 * realize the action for the button modify
 * @throws Exception 
 */
	@FXML
	private void modify() throws Exception {
		new RecipeModifyView(recipe).start(new Stage());
	}
/**
 * realize the action for the button cancel 
 */
	@FXML 
	public void back() {
		stage.close();
	}
/**
 * realize the action for the button delete
 * @throws Exception
 */
	@FXML
	public void delete() throws Exception {
		new RecipeView(recipe).confirmDelete(recipe);
	}

}
