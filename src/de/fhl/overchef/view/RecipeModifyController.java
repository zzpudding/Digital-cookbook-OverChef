package de.fhl.overchef.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Picture;
import de.fhl.overchef.model.Recipe;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RecipeModifyController {
	@FXML
	private ImageView imageView;
	@FXML
	private Pane imagePane;
	@FXML
	private Button deleteButton;
	@FXML
	private Button cancelButton;

	private Stage modifyStage;
	private Stage recipeStage;

	public Stage getRecipeStage() {
		return recipeStage;
	}

	public void setRecipeStage(Stage recipeStage) {
		this.recipeStage = recipeStage;
	}

	private FileChooser chooser;
	private String res = "/src/de/fhl/overchef/model/Pictures/";
	private String path = "default";
	private File chosenPicture;
	private Picture picture;
	private FileInputStream fileIn;
	// private Recipe recipe;
	// @FXML
	// private Label alertMessage;
	// private Stage alertWindow;

	public Stage getPrimaryStage() {
		return modifyStage;
	}

	public void setPrimaryStage(Stage modifyStage) {
		this.modifyStage = modifyStage;
	}

	@FXML
	private Label ingredientWarnLabel;
	@FXML
	private Label recipeNameWarnLabel;

	@FXML
	private TextField recipeName;/*
	@FXML
	private TextField ingredientName1;
	@FXML
	private TextField ingredientQuantity1;
	@FXML
	private TextField ingredientUnit1;
	@FXML
	private TextField ingredientDescription1;*/

	@FXML
	private TextArea description;
	@FXML

	private Button saveButton;
	@FXML
	private TextField serveNumber;
	@FXML
	private TextField totalTime;
	@FXML
	private TextField preparationTime;
	@FXML
	private TextField cookTime;
	@FXML
	private Button addIngredient;
	@FXML
	private Button addStep;/*
	@FXML
	private Button deleteIngredient1;
	@FXML
	private Button deleteStep1;*/

	@FXML
	private VBox ingredientArea;
	@FXML
	private VBox stepArea;
/*
	@FXML
	private HBox ingredientBox1;
	@FXML
	private HBox stepBox1;*/

	@FXML
	private List<HBox> stepContent = new ArrayList<>();

	@FXML
	private List<HBox> ingredientContent = new ArrayList<>();
/*
	private static int count = 0;
	private static int count1 = 0;*/
	private static boolean allPass = true;

	private Recipe recipe;

	/**
	 * //check if the whole format of this view meet the requirement.
	 *//*
	public void checkFormat() {

		checkRecipeName();
		checkIngredientName();
		checkIngredientQuantity();

	}*/

	/**
	 * // check if the recipe name are pure-letter words
	 */
	public void checkRecipeName() {
		String msg = recipeName.getText();
		String regex = "[\\s*\\p{Alpha}+\\s*]+";
		if (msg.matches(regex)) {
			recipeName.setStyle("");
			allPass = true;

			// set warning label
			recipeNameWarnLabel.setText("");

		} else {
			allPass = false;

			recipeName.setStyle("-fx-text-inner-color: #EE2C2C;");

			// set warning label
			recipeNameWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
			recipeNameWarnLabel.setText("Recipe Name Must Be Pure Letter And CANNOT Be Null!");
		}
	}

	/**
	 * check if the ingredient name are pure-letter words
	 *//*
	public void checkIngredientName() {
		String msg = ingredientName1.getText();
		String regex = "[\\s*\\p{Alpha}+\\s*]*";
		if (msg.matches(regex)) {
			ingredientName1.setStyle("");
			allPass = true;

			// set warning label
			ingredientWarnLabel.setText("");

		} else {

			// set warning label
			ingredientWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
			ingredientWarnLabel.setText("Ingredient Name Must be Pure Letter!");

			ingredientName1.setStyle("-fx-text-inner-color: #EE2C2C;");
			allPass = false;
		}
	}*/

	/**
	 * //check if the ingredient quantity is pure number
	 *//*
	@FXML
	public void checkIngredientQuantity() {
		String msg = ingredientQuantity1.getText();
		String regex = "\\d*.*\\d*";
		if (msg.matches(regex)) {
			ingredientQuantity1.setStyle("");
			allPass = true;

			// set warning label
			ingredientWarnLabel.setText("");

		} else {

			// set warning label
			ingredientWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
			ingredientWarnLabel.setText("Ingredient Quantity Must be Pure Number!");

			ingredientQuantity1.setStyle("-fx-text-inner-color: #EE2C2C;");
			allPass = false;
		}
	}
*/
	/**
	 * This method will add a ingredient row to UI after user click the
	 * +ingredient button
	 */
	@FXML
	public void addIngredient() {
/*
		if (count1 == 0) {

			ingredientContent.add(ingredientBox1);
			count1++;

			deleteIngredient1.setOnAction(e -> {
				ingredientArea.getChildren().remove(deleteIngredient1.getParent());
				ingredientContent.remove(ingredientBox1);
			});
		}
*/
		TextField newIngredientName = new TextField();
		TextField newIngredientQuantity = new TextField();
		TextField newIngredientUnit = new TextField();
		TextField newIngredientDescription = new TextField();

		newIngredientName.setPromptText("name");
		newIngredientQuantity.setPromptText("quantity");
		newIngredientUnit.setPromptText("unit");
		newIngredientDescription.setPromptText("description");

		// check ingredient name format
		newIngredientName.setOnKeyTyped(e -> {
			String msg = newIngredientName.getText();
			String regex = "[\\s*\\p{Alpha}+\\s*]*";
			if (msg.matches(regex)) {
				newIngredientName.setStyle("");
				allPass = true;

				// set warning label
				ingredientWarnLabel.setText("");

			} else {

				// set warning label
				ingredientWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
				ingredientWarnLabel.setText("Ingredient Name Must be Pure Letter!");

				newIngredientName.setStyle("-fx-text-inner-color: #EE2C2C;");
				allPass = false;
			}
		});

		// check ingredient quantity format
		newIngredientQuantity.setOnKeyTyped(e -> {
			String msg = newIngredientQuantity.getText();
			String regex = "\\d*[.]*\\d*";
			if (msg.matches(regex)) {
				newIngredientQuantity.setStyle("");
				allPass = true;

				// set warning label
				ingredientWarnLabel.setText("");

			} else {

				// set warning label
				ingredientWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
				ingredientWarnLabel.setText("Ingredient Quantity Must be Pure Number!");

				newIngredientQuantity.setStyle("-fx-text-inner-color: #EE2C2C;");
				allPass = false;
			}
		});

		Button delete = new Button("-");
		HBox.setMargin(delete, new Insets(0, 5, 0, 104));

		HBox newIngredientBox = new HBox();
		ingredientArea.getChildren().add(newIngredientBox);
		newIngredientBox.getChildren().addAll(delete, newIngredientName, newIngredientQuantity, newIngredientUnit,
				newIngredientDescription);
		ingredientContent.add(newIngredientBox);

		delete.setOnAction(e -> {
			ingredientArea.getChildren().remove(delete.getParent());
			ingredientContent.remove(newIngredientBox);
		});
	}

	/**
	 * This method will add a preparation step row to UI after user click the
	 * +preparation step button
	 */
	@FXML
	public void addStep() {/*
		// add the first step in the list and add delete button to UI
		if (count == 0) {
			stepContent.add(stepBox1);
			count++;
			deleteStep1.setOnAction(e -> {
				stepArea.getChildren().remove(deleteStep1.getParent());
				stepContent.remove(stepBox1);
			});
		}
		*/
		// create a new TextArea for the new step
		TextArea newStep = new TextArea();
		newStep.setWrapText(true);

		Button delete = new Button("-");
		HBox.setMargin(delete, new Insets(0, 5, 0, 104));

		HBox newStepBox = new HBox();
		stepArea.getChildren().add(newStepBox);
		newStepBox.getChildren().addAll(delete, newStep);
		stepContent.add(newStepBox);

		delete.setOnAction(e -> {
			stepArea.getChildren().remove(delete.getParent());
			stepContent.remove(newStepBox);
		});
	}

	/**
	 * handle every operation when the save button is clicked
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	@FXML
	public void handleSave() throws FileNotFoundException, IOException {

		//checkFormat();
		if (!allPass) {
			return;
		}
		savePicture();
		saveData();

	}

	/**
	 * save all the data into a recipe instance
	 */
	@FXML
	public void saveData() {

		// save preparation step to recipe
		List<String> prepStep = new ArrayList<>();
		for (int i = 0; i < stepContent.size(); i++) {
			prepStep.add(((TextArea) (stepContent.get(i).getChildren().get(1))).getText());
		}
		recipe.setPreparationStep(prepStep);

		recipe.setRecipeName(recipeName.getText());

		recipe.setDescription(description.getText());

		// save ingredient information to recipe
		List<Ingredient> ingredientList = new ArrayList<>();
		for (int i = 0; i < ingredientContent.size(); i++) {
			if(((TextField) (ingredientContent.get(i).getChildren().get(1))).getText().equals(""))
				continue;
			String ingredientName = ((TextField) (ingredientContent.get(i).getChildren().get(1))).getText();
			double quantity;
			try {
				quantity = Double.valueOf(((TextField) (ingredientContent.get(i).getChildren().get(2))).getText());
			} catch (Exception e) {
				quantity = 0;
			}
			String unit = ((TextField) (ingredientContent.get(i).getChildren().get(3))).getText();
			String description = ((TextField) (ingredientContent.get(i).getChildren().get(4))).getText();

			ingredientList.add(new Ingredient(ingredientName, quantity, unit, description));
		}
		recipe.setIngredientList(ingredientList);
		
		try {
			recipe.setServeNum(Integer.valueOf(serveNumber.getText()).intValue());
		} catch (Exception e) {
			recipe.setServeNum(1);
		}
		
		try {
			recipe.setPrepTime(Integer.valueOf(preparationTime.getText()).intValue());
		} catch (Exception e) {
			recipe.setPrepTime(0);
		}
		
		try {
			recipe.setCookTime(Integer.valueOf(cookTime.getText()).intValue());
		} catch (Exception e) {
			recipe.setCookTime(0);
		}
	}

	/**
	 * Initialize the modify view
	 * @throws IOException 
	 */
	public void setModifyView() throws IOException {

		// display the content of the recipe preparation step
		for (int i = 0; i < recipe.getPreparationStep().size(); i++) {
			addStep();
			((TextArea) (stepContent.get(i).getChildren().get(1))).setText(recipe.getPreparationStep().get(i));
		}

		// display recipe name
		recipeName.setText(recipe.getRecipeName());

		// display recipe description
		description.setText(recipe.getDescription());

		// display ingredients
		for (int i = 0; i < recipe.getIngredientList().size(); i++) {
			addIngredient();
			((TextField) (ingredientContent.get(i).getChildren().get(1)))
					.setText(recipe.getIngredientList().get(i).getIngredientName());
			((TextField) (ingredientContent.get(i).getChildren().get(2)))
					.setText(Double.toString(recipe.getIngredientList().get(i).getQuantity()));
			((TextField) (ingredientContent.get(i).getChildren().get(3)))
					.setText(recipe.getIngredientList().get(i).getUnit());
			((TextField) (ingredientContent.get(i).getChildren().get(4)))
					.setText(recipe.getIngredientList().get(i).getDescription());
		}
		serveNumber.setText(String.valueOf(recipe.getServeNumber()));
//		totalTime.setText(String.valueOf(recipe.getPreparationTime() + recipe.getPreparationTime()));
		preparationTime.setText(String.valueOf(recipe.getPreparationTime()));
		cookTime.setText(String.valueOf(recipe.getCookTime()));
		
		if(!recipe.getPictures().isEmpty()) {
			imageView.fitWidthProperty().bind(imagePane.widthProperty());
			imageView.fitHeightProperty().bind(imagePane.heightProperty());
			imageView.setImage(new Image(fileIn = new FileInputStream(recipe.getPictures().get(0).getRoot())));
			imageView.setVisible(true);
			fileIn.close();
		}

	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * This method is used to handle the click event on "change image" button
	 * 
	 * @throws IOException
	 */
	public void changePicture() throws IOException {
		try {
			chooser = new FileChooser();
			chooser.setTitle("Select Picture");
			chosenPicture = chooser.showOpenDialog(null);
			path = chosenPicture.getPath();
			
			imageView.fitWidthProperty().bind(imagePane.widthProperty());
			imageView.fitHeightProperty().bind(imagePane.heightProperty());
			imageView.setImage(new Image(fileIn = new FileInputStream(chosenPicture), imageView.getFitWidth(), imageView.getFitHeight(), true, true));
			imageView.setVisible(true);
			fileIn.close();
			
		} catch (NullPointerException e) {
			System.out.println("RMC: User doesn't choose a file");
			System.out.println("RMC: use default path: " + path);
		}
//		imageView.fitWidthProperty().bind(imagePane.widthProperty());
//		imageView.fitHeightProperty().bind(imagePane.heightProperty());
//		imageView.setImage(new Image(new FileInputStream(path), imageView.getFitWidth(), imageView.getFitHeight(), true, true));
//		imageView.setVisible(true);

//		picture = new Picture(path);
		
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * handle click event on "delete image" button
	 */
	public void deletePicture() {
		DeleteAlert deleteAlert = new DeleteAlert();
		try {
		deleteAlert.popUp("Deleting Picture", "Are you sure to delete the picture?", recipe.getPictures().lastElement(), imageView);
		}catch(Exception e) {
			Alert noFileAlert = new Alert(Alert.AlertType.INFORMATION);
			noFileAlert.setTitle("Reminder");
			noFileAlert.setHeaderText("No file to delete");
			noFileAlert.showAndWait();
			System.out.println("Deleting a file: No file to delete");
		}
	}

	public void changeServings() {
		System.out.println("change serving");
	}

	/**
	 * response to the click event on save button by generating an alert box to
	 * let user confirm
	 * 
	 * @throws IOException
	 */
	public void pressSave() throws IOException {
		SaveAlert saveAlert = new SaveAlert(this, recipe, modifyStage, recipeStage);
		saveAlert.popUp("Saving Confirmation", "Are you sure to continue?");
	}

	public void pressCancel() {
		CancelAlert cancelAlert = new CancelAlert();
		cancelAlert.popUp("Close Recipe Modify View", "All the changes will be lost, are you sure to continue?",
				modifyStage);
	}

	public void savePicture() throws FileNotFoundException, IOException {
		if (!path.equals("default")) {
			if (!Picture.checkName(path)) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("The name of the image already exists!");
				alert.setContentText("Please change the name and try again!");
				alert.showAndWait();

			} else {
				if (recipe.getPictures().isEmpty()) {
					recipe.addPicture(path);
				} else {
					recipe.getPictures().get(0).deletePicture();
					recipe.getPictures().remove(0);
					recipe.addPicture(path);
				}
			}
		}
	}

  @FXML
	private void changeServeNumber() {
		try {
			int changeNumber = Integer.valueOf(serveNumber.getText()).intValue();
			if ((serveNumber.getText() != "") && (changeNumber != 0)) {
				recipe.changeQuantity(changeNumber);
				for (int i = 0; i < recipe.getIngredientList().size(); i++) {
//					addIngredient();
					((TextField) (ingredientContent.get(i).getChildren().get(1)))
							.setText(recipe.getIngredientList().get(i).getIngredientName());
					((TextField) (ingredientContent.get(i).getChildren().get(2)))
							.setText(Double.toString(recipe.getIngredientList().get(i).getQuantity()));
					((TextField) (ingredientContent.get(i).getChildren().get(3)))
							.setText(recipe.getIngredientList().get(i).getUnit());
					((TextField) (ingredientContent.get(i).getChildren().get(4)))
							.setText(recipe.getIngredientList().get(i).getDescription());

				}
			}
		} catch (Exception e) {
		}
	}

	public void addRecipeToDB() {
		System.out.println("Hello");
	}
}
