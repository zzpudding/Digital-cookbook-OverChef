package de.fhl.overchef.controller;

import java.io.FileInputStream;
import java.io.IOException;

import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.view.RecipeModifyView;
import de.fhl.overchef.view.RecipeView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * realize action for the required component and the based function of the
 * recipe view
 * 
 * @author Bocheng Hu
 *
 */
public class RecipeViewController {
	private String res = "/src/de/fhl/overchef/model/Pictures/";
	private Recipe recipe;
	@FXML
	Stage primaryStage;
	@FXML
	private Label recipeNameText;
	@FXML
	private Label descriptionText;
	@FXML
	private Label warnLabel;
	@FXML
	private Label ingredientText;
	@FXML
	private Label preparationStepText;
	@FXML
	private TextField serveNumberText;
	@FXML
	private Label totalTimeText;
	@FXML
	private Label preparationTimeText;
	@FXML
	private Label cookTimeText;
	@FXML
	private Button delete;
	@FXML
	private Button modify;
	@FXML
	private Button back;
	@FXML
	private Pane imagePane;
	@FXML
	private ImageView imageView;
	private FileInputStream fileIn;

	/**
	 * provide the living stage to the controller
	 * 
	 * @param stage
	 */
	public void setPrimaryStage(Stage stage) {
		this.primaryStage = stage;
	}

	/**
	 * initiate the content for the recipe view
	 * 
	 * @param recipe
	 * @throws IOException 
	 */
	public void initializeRecipeView(Recipe recipe) throws IOException {
		this.recipe = recipe;

		String regex = "''";
		recipeNameText.setText(recipe.getRecipeName().replaceAll(regex, "'"));
		
		String description = recipe.getDescription();
		descriptionText.setText(description.replaceAll(regex, "'"));
		
		String ingredient = recipe.toGetIngredients();
		ingredientText.setText(ingredient.replaceAll(regex, "'"));
		
		String preparationStep = recipe.toGetPreparationStep();
		preparationStepText.setText(preparationStep.replaceAll(regex, "'"));
		
		serveNumberText.setText(String.valueOf(recipe.getServeNumber()));
		totalTimeText.setText(String.valueOf(recipe.getPreparationTime() + recipe.getCookTime()));
		preparationTimeText.setText(String.valueOf(recipe.getPreparationTime()));
		cookTimeText.setText(String.valueOf(recipe.getCookTime()));
		warnLabel.setText("");
		if (!recipe.getPictures().isEmpty()) {
			imageView.fitWidthProperty().bind(imagePane.widthProperty());
			imageView.fitHeightProperty().bind(imagePane.heightProperty());
			imageView.setImage(new Image(fileIn = new FileInputStream(recipe.getPictures().get(0).getRoot())));
			imageView.setVisible(true);
			fileIn.close();
		}else {
			imageView.fitWidthProperty().bind(imagePane.widthProperty());
			imageView.fitHeightProperty().bind(imagePane.heightProperty());
			imageView.setImage(new Image(fileIn = new FileInputStream(System.getProperty("user.dir") + res + "OverChefDefaultPicture.jpg")));
			imageView.setVisible(true);
			fileIn.close();
		}
		
	}
	public void recipeViewLayout(){
		modify.setStyle("-fx-background-color: #E6E6E6;");
		delete.setStyle("-fx-background-color: 	#E6E6E6;");
		back.setStyle("-fx-background-color: 	#E6E6E6 ;");

	}
	/**
	 * realize the action for the textField serve number
	 */
	@FXML
	private void changeServeNumber() {
		try {
			String numberContent = serveNumberText.getText();
			int changeNumber;

			try {
				changeNumber = Integer.valueOf(numberContent).intValue();
			} catch (Exception e) {
				changeNumber = 1;
			}
			String indexString = "[1-9][0-9]*";
			if (numberContent.matches(indexString)) {
				recipe.changeQuantity(changeNumber);
				ingredientText.setText(recipe.toGetIngredients());
				warnLabel.setText("");

			} else {
				warnLabel.setText("the serving number must be pure positive integer");
			}
		} catch (Exception e) {
		}
	}


	/**
	 * realize the action for the button modify
	 * 
	 * @throws Exception
	 */
	@FXML
	private void modify() throws Exception {
		new RecipeModifyView(recipe, primaryStage).start(new Stage());
	}

	/**
	 * realize the action for the button cancel
	 */
	@FXML
	public void back() {
		primaryStage.close();
	}

	/**
	 * realize the action for the button delete
	 * 
	 * @throws Exception
	 */
	@FXML
	public void delete() throws Exception {
		new RecipeView().confirmDelete(recipe, primaryStage);
	}

}
