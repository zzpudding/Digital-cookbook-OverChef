package de.fhl.overchef.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import de.fhl.overchef.model.Recipe;
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

	Recipe recipe;
	@FXML
	Stage stage;
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
		this.stage = stage;
	}

	/**
	 * initiate the content for the recipe view
	 * 
	 * @param recipe
	 * @throws IOException 
	 */
	public void initializeRecipeView(Recipe recipe) throws IOException {
		this.recipe = recipe;
		recipeNameText.setText(recipe.getRecipeName());
		descriptionText.setText(recipe.getDescription());
		ingredientText.setText(recipe.toGetIngredients());
		preparationStepText.setText(recipe.toGetPreparationStep());
		serveNumberText.setText(String.valueOf(recipe.getServeNumber()));
		totalTimeText.setText(String.valueOf(recipe.getPreparationTime() + recipe.getCookTime()));
		preparationTimeText.setText(String.valueOf(recipe.getPreparationTime()));
		cookTimeText.setText(String.valueOf(recipe.getCookTime()));

		if (!recipe.getPictures().isEmpty()) {
			imageView.fitWidthProperty().bind(imagePane.widthProperty());
			imageView.fitHeightProperty().bind(imagePane.heightProperty());
			imageView.setImage(new Image(fileIn = new FileInputStream(recipe.getPictures().get(0).getRoot())));
			imageView.setVisible(true);
			fileIn.close();
		}
	}

	/**
	 * realize the action for the textField serve number
	 */
	@FXML
	private void changeServeNumber() {
		try {
			int changeNumber = Integer.valueOf(serveNumberText.getText()).intValue();
			String indexString = "[1-9]*[a-zA-z][a-zA-z]*[1-9]*";
			if (serveNumberText.getText().matches(indexString)) {
				warnLabel.setText("serve number must be number");
			}
			else
			if ((serveNumberText.getText() != "") && (changeNumber != 0)) {

				recipe.changeQuantity(changeNumber);
				ingredientText.setText(recipe.toGetIngredients());

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
		new RecipeModifyView(recipe, stage).start(new Stage());
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
	 * 
	 * @throws Exception
	 */
	@FXML
	public void delete() throws Exception {
		new RecipeView().confirmDelete(recipe, stage);
	}

}
