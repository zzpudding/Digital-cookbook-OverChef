package de.fhl.overchef.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import de.fhl.overchef.model.Picture;
import de.fhl.overchef.model.Recipe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class RecipeModifyController {
	@FXML
	private ImageView imageView;
	@FXML
	private Pane imagePane;
	@FXML
	private Button deleteButton;
//	@FXML
//	private Label alertMessage;
//	private Stage alertWindow;
	

	@FXML
	private TextField recipeName;
	@FXML
	private TextField ingredientName1;
	@FXML
	private TextField ingredientQuantity1;
	@FXML
	private TextField ingredientUnit1;
	@FXML
	private TextField ingredientDescription1;
	
	@FXML
	private TextArea description;
	@FXML
	private TextArea step1;

	@FXML
	private Button saveButton;
	@FXML
	private Button addIngredient;
	@FXML
	private Button addStep;
	@FXML
	private Button delete1;

	@FXML
	private VBox stepContentArea;
	@FXML
	private VBox stepButtonArea;
	@FXML
	private VBox ingredientButtonArea;
	@FXML
	private VBox IngredientNameArea;
	@FXML
	private VBox IngredientQuantityArea;
	@FXML
	private VBox IngredientUnitArea;
	@FXML
	private VBox IngredientDescriptionArea;
	
	private FileChooser chooser;
	private String path;
	private File chosenPicture;
	private Picture picture;
	private Recipe recipe;
	
	public RecipeModifyController() {
		
	}
	
	public RecipeModifyController(Recipe recipe) {
		this.recipe = recipe;
	}
	
	
	private List<TextArea> stepList = new ArrayList<TextArea>();
	private List<TextField> ingredientNameList = new ArrayList<TextField>();
	private List<TextField> ingredientQuantityList = new ArrayList<TextField>();
	private List<TextField> ingredientUnitList = new ArrayList<TextField>();
	private List<TextField> ingredientDescriptionList = new ArrayList<TextField>();
	private List<Button> deleteStepList = new ArrayList<Button>();
	private List<Button> deleteIngredientList = new ArrayList<Button>();
	private static int count = 0;
	private static int count1 = 0;
	
	
	//check if the whole format of this view meet the requirement.
		public void checkFormat() {
			boolean allPass = false;

			checkRecipeName();
			checkIngredientName();
			checkIngredientQuantity();
			if (allPass) {
				// save the data and transmit to database.
			} else
				return;
		}

		// check if the recipe name are pure-letter words
		public void checkRecipeName() {
			String msg = recipeName.getText();
			String regex = "[\\s*\\p{Alpha}+\\s*]+";
			if (msg.matches(regex)) {
				recipeName.setStyle("");
			} else {
				recipeName.setStyle("-fx-text-inner-color: red;");
			}
		}

		// check if the ingredient name are pure-letter words
		public void checkIngredientName() {
			String msg = ingredientName1.getText();
			String regex = "[\\s*\\p{Alpha}+\\s*]+";
			if (msg.matches(regex)) {
				ingredientName1.setStyle("");
			} else {
				ingredientName1.setStyle("-fx-text-inner-color: red;");
			}
		}
		
		//check if the ingredient quantity is pure number
		@FXML
		//check if the ingredient quantity is a number
		public void checkIngredientQuantity() {
			String msg = ingredientQuantity1.getText();
			String regex = "\\d*";
			if (msg.matches(regex)) {
				ingredientQuantity1.setStyle("");
			} else {
				ingredientQuantity1.setStyle("-fx-text-inner-color: red;");
				System.out.println("Invalid quantity");
			}
		}
	
		@FXML
		public void addIngredient() {
			
			if(count1 == 0) {
				ingredientNameList.add(ingredientName1);
				ingredientQuantityList.add(ingredientQuantity1);
				ingredientUnitList.add(ingredientUnit1);
				ingredientDescriptionList.add(ingredientDescription1);
				count1++;
			}
			
			TextField newIngredientName = new TextField();
			TextField newIngredientQuantity = new TextField();
			TextField newIngredientUnit = new TextField();
			TextField newIngredientDescription = new TextField();
			
			newIngredientName.setPromptText("name");
			newIngredientQuantity.setPromptText("quantity");
			newIngredientUnit.setPromptText("unit");
			newIngredientDescription.setPromptText("description");
			
			IngredientNameArea.getChildren().add(newIngredientName);
			IngredientQuantityArea.getChildren().add(newIngredientQuantity);
			IngredientUnitArea.getChildren().add(newIngredientUnit);
			IngredientDescriptionArea.getChildren().add(newIngredientDescription);
			
			ingredientNameList.add(newIngredientName);
			ingredientQuantityList.add(newIngredientQuantity);
			ingredientUnitList.add(newIngredientUnit);
			ingredientDescriptionList.add(newIngredientDescription);
			
			//Button add = new Button("+");
			Button delete = new Button("-");
			
			ingredientButtonArea.getChildren().add(delete);
			deleteIngredientList.add(delete);
			ingredientButtonArea.setMargin(delete, new Insets(0, 5, 0, 0));
			//add.setOnAction(e -> addIngredient());
			delete.setOnAction(e -> {
				System.out.println("Delete ingredient");
			});
		}


		@FXML
		//add a step both to the step list and to the UI
		public void addStep() {
			//add the first step in the list and add delete button to UI
			if(count == 0) {
				stepList.add(step1);
				deleteIngredientList.add(delete1);
				count++;
			}
			//create a new TextArea for the new step
			TextArea newStep = new TextArea();
			stepContentArea.setMargin(newStep, new Insets(5, 10, 0, 0));
			stepContentArea.getChildren().add(newStep);
			stepList.add(newStep);

			
			Button delete = new Button("-");
			stepButtonArea.setMargin(delete, new Insets(17, 0, 0, 0)); //set upward margin to 10
			stepButtonArea.getChildren().add(delete);
			deleteIngredientList.add(delete);
			int index =0;
			
			//add.setOnAction(e -> addStep());
			delete.setOnAction(e -> {
				System.out.println("Delete step");
				deleteStep();
				});
		}
		
		@FXML
		public void deleteStep() {
			int index = 0; //we need a transfered index to show which one needed to be deleted
			stepList.remove(index);
			stepContentArea.getChildren().remove(index);
			
			/*
			for(int i = 0; i < stepList.size(); i++) {
				System.out.println(stepList.get(i).getText());
			}*/
		}
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	/**
	 * This method is used to handle the click event on "change image" button
	 * @throws IOException
	 */
	public void changePicture() throws IOException {	
		imageView.setVisible(true);
		chooser = new FileChooser();
		chooser.setTitle("Select Picture");
		chosenPicture = chooser.showOpenDialog(null);
		path = chosenPicture.getPath();
		imageView.fitWidthProperty().bind(imagePane.widthProperty());
		imageView.fitHeightProperty().bind(imagePane.heightProperty());
		
		
//		recipe.addPicture(path);
		picture = new Picture(path);
		if(!picture.checkName()) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Warning");
			alert.setHeaderText("The name of the image already exists!");
			alert.setContentText("Please change the name and try again!");
			alert.showAndWait();
			
		} else {
			picture.writePicture();
		    imageView.setImage(new Image(new FileInputStream(chosenPicture),imageView.getFitWidth(),imageView.getFitHeight(),true,true));
		    picture.deletePicture();
		}
	}
	
	/**
	 * handle click event on "delete image" button
	 */
	public void deletePicture() {
		DeleteAlert.popUp("Deleting Picture", "Are you sure to delete the picture?", picture, imageView);
	}
	
	public void changeServings() {
		System.out.println("change serving");
	}
	
	/**
	 * response to the click event on save button by generating an alert box to let user confirm
	 * @throws IOException
	 */
	public void pressSave() throws IOException {
		
		SaveAlert.popUp("Saving Confirmation", "Are you sure to continue?");
		
	}
	
	public static void addRecipeToDB() {
		System.out.println("Hello");
	}
}
