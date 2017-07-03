package de.fhl.overchef.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.fhl.overchef.db.DBOperation;
import de.fhl.overchef.model.Ingredient;
import de.fhl.overchef.model.Picture;
import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.view.CancelAlert;
import de.fhl.overchef.view.DeleteAlert;
import de.fhl.overchef.view.OverchefMainApp;
import de.fhl.overchef.view.RecipeView;
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

/**
 * Controller for modifying recipe and adding recipe
 * 
 * @author fangtian LI, Zhengjiang HU
 *
 */
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

	private FileChooser chooser;
	private String res = "/src/de/fhl/overchef/model/Pictures/";
	private String path = "default";
	private File chosenPicture;
	private Picture picture;
	private FileInputStream fileIn;

	@FXML
	private Label ingredientWarnLabel;
	@FXML
	private Label recipeNameWarnLabel;

	@FXML
	private TextField recipeName;

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
	private Button addStep;
	@FXML
	private Label warningText1;
	@FXML
	private Label warningText2;
	@FXML
	private Label warningText3;
	@FXML
	private VBox ingredientArea;
	@FXML
	private VBox stepArea;
	
	@FXML
	private List<HBox> stepContent = new ArrayList<>();

	@FXML
	private List<HBox> ingredientContent = new ArrayList<>();

	private int errorNumber = 0;
	private boolean recipeNamePreviousState;
	private List<Boolean> ingredientNamePreviousStateList = new ArrayList<>();
	private List<Boolean> ingredientQuantityPreviousStateList = new ArrayList<>();

	private Recipe recipe;

	/**
	 * // check if the recipe name are pure-letter words
	 */
	public void checkRecipeName() {
		String msg = recipeName.getText();
		String regex = "[\\w&'\\s]+";

		if (msg.matches(regex)) {
			recipeName.setStyle("");
			
			//if state turn from false to true, error - 1
			if (recipeNamePreviousState == false)
				errorNumber -= 1;

			// set warning label
			recipeNameWarnLabel.setText("");
			recipeNamePreviousState = true;

		} else {
			
			//if state turn from true to false, error + 1
			if (recipeNamePreviousState == true)
				errorNumber += 1;

			recipeName.setStyle("-fx-text-inner-color: #EE2C2C;");

			// set warning label
			recipeNameWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
			recipeNameWarnLabel.setText("Should Only Contain Letter,Number, & ' _ and Cannot be EMPTY");
			recipeNamePreviousState = false;
		}
	}

	/**
	 * Add a row in the ingredient area, including ingredient name, quantity,
	 * unit and description.
	 */
	@FXML
	public void addIngredient() {
		
		//initialize the previous state of the ingredient
		boolean ingredientNamePreviousState = true;
		ingredientNamePreviousStateList.add(ingredientNamePreviousState);
		boolean ingredientQuantityPreviousState = true;
		ingredientQuantityPreviousStateList.add(ingredientQuantityPreviousState);

		//use index to show where this ingredient are in the state list
		final int index = ingredientNamePreviousStateList.size() - 1;

		TextField newIngredientName = new TextField();
		TextField newIngredientQuantity = new TextField();
		TextField newIngredientUnit = new TextField();
		TextField newIngredientDescription = new TextField();

		newIngredientName.setPromptText("name");
		newIngredientQuantity.setPromptText("quantity");
		newIngredientUnit.setPromptText("unit");
		newIngredientDescription.setPromptText("description");

		// check ingredient name format
		newIngredientName.textProperty().addListener(e -> {
			String msg = newIngredientName.getText();
			String regex = "[\\w&'\\s]*";

			if (msg.matches(regex)) {
				
				//set font color to default
				newIngredientName.setStyle("");
				
				//if the state turn from false to true, error - 1
				if (ingredientNamePreviousStateList.get(index) == false)
					errorNumber -= 1;
				
				//set the exact state to true
				ingredientNamePreviousStateList.set(index, true);

				// decide what the warning label should show
				if (!ingredientNamePreviousStateList.contains(false)
						&& !ingredientQuantityPreviousStateList.contains(false)) {
					ingredientWarnLabel.setText("");
				} else if (!ingredientNamePreviousStateList.contains(false)
						&& ingredientQuantityPreviousStateList.contains(false)) {
					ingredientWarnLabel.setText("Ingredient Quantity Must be Pure Number!");
				} else if (ingredientNamePreviousStateList.contains(false)
						&& !ingredientQuantityPreviousStateList.contains(false)) {
					ingredientWarnLabel.setText("Ingredient Name Should Only Contain Letter,Number, & ' _");
				} else
					ingredientWarnLabel.setText("Ingredient Name Should Only Contain Letter,Number, & ' _");

			} else {

				// set warning label
				ingredientWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
				ingredientWarnLabel.setText("Ingredient Name Should Only Contain Letter,Number, & ' _");

				newIngredientName.setStyle("-fx-text-inner-color: #EE2C2C;");
				
				//if state turn from true to false, error + 1
				if (ingredientNamePreviousStateList.get(index) == true)
					errorNumber += 1;
				
				//set the exact state to false
				ingredientNamePreviousStateList.set(index, false);
			}
		});

		// check ingredient quantity format
		newIngredientQuantity.textProperty().addListener(e -> {
			String msg = newIngredientQuantity.getText();
			
			//check if the quantity is the pure number
			String regex = "\\d*[.]*\\d*";
			if (msg.matches(regex)) {
				newIngredientQuantity.setStyle("");
				
				//if the state turn from false to true, error - 1
				if (ingredientQuantityPreviousStateList.get(index) == false)
					errorNumber -= 1;
				
				//set the current state to true
				ingredientQuantityPreviousStateList.set(index, true);

				// set warning label
				if (!ingredientNamePreviousStateList.contains(false)
						&& !ingredientQuantityPreviousStateList.contains(false)) {
					ingredientWarnLabel.setText("");
				} else if (!ingredientNamePreviousStateList.contains(false)
						&& ingredientQuantityPreviousStateList.contains(false)) {
					ingredientWarnLabel.setText("Ingredient Quantity Must be Pure Number!");
				} else if (ingredientNamePreviousStateList.contains(false)
						&& !ingredientQuantityPreviousStateList.contains(false)) {
					ingredientWarnLabel.setText("Ingredient Name Should Only Contain Letter,Number, & ' _");
				} else
					ingredientWarnLabel.setText("Ingredient Name Should Only Contain Letter,Number, & ' _");


			} else {
				//when the input are validate
				// set warning label
				ingredientWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
				ingredientWarnLabel.setText("Ingredient Quantity Must be Pure Number!");

				newIngredientQuantity.setStyle("-fx-text-inner-color: #EE2C2C;");
				
				//if state turn from true to false, error + 1
				if (ingredientQuantityPreviousStateList.get(index) == true)
					errorNumber += 1;
				
				//set current state to false
				ingredientQuantityPreviousStateList.set(index, false);
			}
		});

		Button delete = new Button("-");
		HBox.setMargin(delete, new Insets(0, 5, 0, 104));

		//create a new area to contain the new ingredient in GUI
		HBox newIngredientBox = new HBox();
		ingredientArea.getChildren().add(newIngredientBox);
		
		//add the ingredient components to the new ingredient row
		newIngredientBox.getChildren().addAll(delete, newIngredientName, newIngredientQuantity, newIngredientUnit,
				newIngredientDescription);
		
		//add the new ingredient row HBox to a logical list
		ingredientContent.add(newIngredientBox);

		delete.setOnAction(e -> {
			//remove the specific row from GUI
			ingredientArea.getChildren().remove(delete.getParent());
			
			//remove the specific row from logical list
			ingredientContent.remove(newIngredientBox);
			
			//check if the errors are reduced when a ingredient row is deleted 
			if (ingredientNamePreviousStateList.get(index) == false
					&& ingredientQuantityPreviousStateList.get(index) == false) {
				errorNumber = errorNumber - 2;
			} else if (ingredientNamePreviousStateList.get(index) == false
					|| ingredientQuantityPreviousStateList.get(index) == false) {
				errorNumber -= 1;
			}
			
			//turn the deleted rows' state to true
			ingredientNamePreviousStateList.set(index, true);
			ingredientQuantityPreviousStateList.set(index, true);
			
			//final check if there is another error that should be informed to customer
			if (!ingredientNamePreviousStateList.contains(false)
					&& !ingredientQuantityPreviousStateList.contains(false)) {
				ingredientWarnLabel.setText("");
			} else if (!ingredientNamePreviousStateList.contains(false)
					&& ingredientQuantityPreviousStateList.contains(false)) {
				ingredientWarnLabel.setText("Ingredient Quantity Must be Pure Number!");
			} else if (ingredientNamePreviousStateList.contains(false)
					&& !ingredientQuantityPreviousStateList.contains(false)) {
				ingredientWarnLabel.setText("Ingredient Name Should Only Contain Letter,Number, & ' _");
			} else
				ingredientWarnLabel.setText("Ingredient Name Should Only Contain Letter,Number, & ' _");
		});
	}

	/**
	 * This method will add a preparation step row to UI after user click the
	 * +preparation step button
	 */
	@FXML
	public void addStep() {

		// create a new TextArea for the new step
		TextArea newStep = new TextArea();
		newStep.setWrapText(true);

		Button delete = new Button("-");
		HBox.setMargin(delete, new Insets(0, 5, 0, 104));

		//create a new step area HBox
		HBox newStepBox = new HBox();
		
		//add the new step row in GUI
		stepArea.getChildren().add(newStepBox);
		
		//add components to the new step row
		newStepBox.getChildren().addAll(delete, newStep);
		
		//add new row the logical list
		stepContent.add(newStepBox);

		delete.setOnAction(e -> {
			//delete the whole row of the specific delete button
			stepArea.getChildren().remove(delete.getParent());
			
			//delete the row from the logical list
			stepContent.remove(newStepBox);
		});
	}

	/**
	 * handle every operation when the save button is clicked
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 */
	@FXML
	public boolean handleSave() throws FileNotFoundException, IOException, SQLException {
		//checkRecipeName();
		if (errorNumber != 0) {
			return false;
		}
		if (!savePicture()) {
			return false;
		}
		saveData();
		
		//after we modify a recipe, delete this recipe from the DB according to the recipe id
		DBOperation.deleteRecipe(recipe.getRecipeID());
		
		//insert a new version of the recipe into DB with a new recipe id
		int rid = DBOperation.getMaxRid() + 1;
		recipe.setRecipeID(rid);
		DBOperation.addRecipeToDB(recipe);
		
		//if the main pane does not contain the information of new recipe
		//then add the information to the pane
		if (!OverchefMainApp.getRecipeData().contains(recipe)) {
			OverchefMainApp.getRecipeData().add(recipe);
		}
		return true;
	}

	/**
	 * save all the data into a recipe instance
	 */
	@FXML
	public void saveData() {

		// save preparation step to recipe
		List<String> prepStep = new ArrayList<>();
		for (int i = 0; i < stepContent.size(); i++) {
			String step = ((TextArea) (stepContent.get(i).getChildren().get(1))).getText();
			if(step.equals(""))
				continue;
			prepStep.add(modifyPunctuation(step));
		}
		recipe.setPreparationStep(prepStep);

		recipe.setRecipeName(modifyPunctuation(recipeName.getText()));

		recipe.setDescription(modifyPunctuation(description.getText()));

		// save ingredient information to recipe
		List<Ingredient> ingredientList = new ArrayList<>();
		for (int i = 0; i < ingredientContent.size(); i++) {
			if (((TextField) (ingredientContent.get(i).getChildren().get(1))).getText().equals(""))
				continue;
			String ingredientName = modifyPunctuation(((TextField) (ingredientContent.get(i).getChildren().get(1))).getText());
			
			//if customer does not input the value of ingredient, then set it to default value 0
			double quantity;
			try {
				quantity = Double.valueOf(((TextField) (ingredientContent.get(i).getChildren().get(2))).getText());
			} catch (Exception e) {
				quantity = 0;
			}
			String unit = modifyPunctuation(((TextField) (ingredientContent.get(i).getChildren().get(3))).getText());
			String description = modifyPunctuation(((TextField) (ingredientContent.get(i).getChildren().get(4))).getText());

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
	 * 
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
		if(recipe.getServeNumber()==0){
			serveNumber.setText("1");
		}
		else{
		serveNumber.setText(String.valueOf(recipe.getServeNumber()));
		}
		if(recipe.getPreparationTime()==0){
			preparationTime.setText("1");
		}
		else{
			preparationTime.setText(String.valueOf(recipe.getPreparationTime()));
		}
		if(recipe.getCookTime()==0)
		{
			cookTime.setText("1");
		}
		else{
		cookTime.setText(String.valueOf(recipe.getCookTime()));
		}
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

		//initialize the initial state of the recipeName
		if (recipeName.getText().equals("")) {
			recipeNamePreviousState = false;
			errorNumber += 1;
			recipeNameWarnLabel.setText("Should Only Contain Letter,Number, & ' _ and Cannot be EMPTY");
			recipeNameWarnLabel.setStyle("-fx-text-fill: #EE2C2C;");
		} else
			recipeNamePreviousState = true;
		
		//when the text of the recipe name changed, check its validity
		recipeName.textProperty().addListener(e->checkRecipeName());
		
	}
	
	/**
	 * In order to avoid DB error, transfer ' to ''
	 * @param string
	 * @return modified string
	 */
	public String modifyPunctuation(String string) {
		String regex = "'";
		return string.replaceAll(regex, "''");
	}


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
			imageView.setImage(new Image(fileIn = new FileInputStream(chosenPicture), imageView.getFitWidth(),
					imageView.getFitHeight(), true, true));
			imageView.setVisible(true);
			fileIn.close();

		} catch (NullPointerException e) {
			System.out.println("RMC: User doesn't choose a file");
			System.out.println("RMC: use default path: " + path);
		}
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * handle click event on "delete image" button, poping up an alert box when there's file to delete, otherwise printing out "no file to delete"
	 */
	public void deletePicture() {
		DeleteAlert deleteAlert = new DeleteAlert();
		try {
			deleteAlert.popUp("Deleting Picture", "Are you sure to delete the picture?",
					recipe.getPictures().lastElement(), imageView);
		} catch (Exception e) {
			Alert noFileAlert = new Alert(Alert.AlertType.INFORMATION);
			noFileAlert.setTitle("Reminder");
			noFileAlert.setHeaderText("No file to delete");
			imageView.setVisible(false);
			noFileAlert.showAndWait();

			System.out.println("From RecipeModify Controller: Deleting a file: No file to delete");
		}
		path = "default";
	}
	/**
	 * response to the click event on save button, checking and saving data and picture
	 * @throws IOException
	 */
	public void pressSave() throws IOException {
		try {
			try {
				if (handleSave()) {
					modifyStage.close();
					try {
						new RecipeView(recipe).start(new Stage());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if(recipeStage != null){
						recipeStage.close();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	/**
	 * handle click event on cancel button, poping up alert box to let user confirm
	 */
	public void pressCancel() {
		CancelAlert cancelAlert = new CancelAlert();
		cancelAlert.popUp("Close Recipe Modify View", "All the changes will be lost, are you sure to continue?",
				modifyStage);
	}
	/**
	 * check and save the picture selected by the user
	 * @return the return value shows if saving is successful. ture: successful false: failed
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean savePicture() throws FileNotFoundException, IOException {
		boolean saveState = true;
		if (!path.equals("default")) {
			if (!Picture.checkName(path)) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Warning");
				alert.setHeaderText("The name of the image already exists!");
				alert.setContentText("Please change the name and try again!");
				alert.showAndWait();
				saveState = false;

			} else {
				if (recipe.getPictures().isEmpty()) {
					recipe.addPicture(path);
				} else {
					recipe.getPictures().get(0).deletePicture();
					recipe.getPictures().remove(0);
					recipe.addPicture(path);
				}
				saveState = true;
			}
		}
		return saveState;
	}
	/**
	 * change the serving number given by the user
	 */
	@FXML
	private void changeServeNumber() {
		String textContent = serveNumber.getText();
		String indexString = "[1-9][0-9]*";
		if (textContent.matches(indexString)){
			warningText1.setText("");
		}
		else{
			warningText1.setText("the serving must be positive pure integer");
		}
	}
	/**
	 * check the format of cooking time
	 */
	@FXML
	private void checkCTFormatted(){
		String cookingTime = cookTime.getText();
		String index="[1-9][0-9]*";
		if(cookingTime.matches(index)){
			warningText3.setText("");
		}
		else{
			warningText3.setText("cook time must be positive pure number");
		}
	}
	/**
	 * check the format of preparation time
	 */
	@FXML
	private void checkPTFormatted(){
		String prepareTime = preparationTime.getText();
		String index="[1-9][0-9]*";
		if(prepareTime.matches(index)){
			warningText2.setText("");
		}
		else{
			warningText2.setText("cook time must be positive pure number");
		}
	}
	
	//getters and setters
	public Stage getRecipeStage() {
		return recipeStage;
	}

	public void setRecipeStage(Stage recipeStage) {
		this.recipeStage = recipeStage;
	}
	

	public Stage getPrimaryStage() {
		return modifyStage;
	}

	public void setPrimaryStage(Stage modifyStage) {
		this.modifyStage = modifyStage;
	}

	
}
