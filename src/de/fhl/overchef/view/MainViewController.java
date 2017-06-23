package de.fhl.overchef.view;

import de.fhl.overchef.db.DBConnector;
import de.fhl.overchef.model.Recipe;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainViewController {
	@FXML
	private Button searchButton = new Button();
	@FXML
	private Button addButton = new Button();
	@FXML
	private RadioButton byRecipe = new RadioButton("By recipe");
	@FXML
	private RadioButton byIngredient = new RadioButton("By ingreidnet");
	@FXML
	private RadioButton byBoth = new RadioButton("By both");
	@FXML
	final ToggleGroup group = new ToggleGroup();
	@FXML
	private TextField searchField = new TextField();
	@FXML
	private TableView<Recipe> recipeTable;
	@FXML
	private TableColumn<Recipe, String> recipeNameCol = new TableColumn<Recipe, String>();
	@FXML
	private TableColumn<Recipe, String> ingredientNameCol = new TableColumn<Recipe, String>();
	private OverchefMainApp OverchefMainApp;
	private ObservableList<Recipe> recipeData = FXCollections.observableArrayList();

	/**
	 * Compare a certain recipe's name with keywords and return their relevance.
	 * Will also do boundary check and replace characters which could cause
	 * exception.
	 * 
	 * @param keyword
	 *            user's input
	 * @return a relevance value
	 */
	public int relevanceByRecipe(int i) {
		String keyword = searchField.getText();
		int relevance = 0;
		for (char c : new char[] { '*', '(', ')', '[', ']', '{', '}', '.' }) {
			keyword = keyword.replaceAll("\\" + c, "\\\\" + c);
		}
		Recipe r = recipeData.get(i);
		String recipeName = r.getRecipeName();
		if (recipeName != null && !recipeName.equals("")) {
			if (recipeName.equalsIgnoreCase(keyword)) {
				relevance += 50;
			} else {
				String[] subKeywords = keyword.split("\\p{Blank}|-|,|;");
				for (String subKeyword : subKeywords) {
					if (recipeName != null
							&& recipeName.toLowerCase().matches(".*" + subKeyword.toLowerCase() + ".*")) {
						relevance++;
					}
				}
			}
		}
		return relevance;
	}

	/**
	 * Compare a certain recipe's ingredients' name with keywords and return
	 * their relevance. Will also do boundary check and replace characters which
	 * could cause exception.
	 * 
	 * @param keyword
	 *            user's input
	 * @return a relevance value
	 */
	public int relevanceByIngredient(int i) {
		String keyword = searchField.getText();
		int relevance = 0;
		for (char c : new char[] { '*', '(', ')', '[', ']', '{', '}', '.' }) {
			keyword = keyword.replaceAll("\\" + c, "\\\\" + c);
		}
		String allIngredients = recipeData.get(i).getIngredientNameListProperty();
		String[] ingredients = allIngredients.split(",");
		for (String ingredient : ingredients) {
			if (ingredient != null && !ingredient.equals("")) {
				if (ingredient.equalsIgnoreCase(keyword)) {
					relevance += 2;
				} else {
					String[] subKeywords = keyword.split("\\p{Blank}|-|,|;");
					for (String subKeyword : subKeywords) {
						if (ingredient != null
								&& ingredient.toLowerCase().matches(".*" + subKeyword.toLowerCase() + ".*")) {
							relevance++;
						}
					}
				}
			}
		}
		return relevance;
	}

	/**
	 * Searched result by keyword would be sorted according to the relevance.
	 * The search field is in recipe.
	 * 
	 * @return relevant recipes in order (or only total matched recipe if there is one)
	 */
	public ObservableList<Recipe> searchResultByRecipe() {
		if (searchField.getText().isEmpty()) {
			return recipeData;
		} else {
			ObservableList<Recipe> recipeData = OverchefMainApp.getRecipeData();
			Map<Recipe, Integer> tempMap = new HashMap<>();
			Map<Recipe, Integer> tempMapFinal = new HashMap<>();
			ObservableList<Recipe> resultList = null;
			for (int i = 0; i < recipeData.size(); i++) {
				Recipe r = recipeData.get(i);
				int relevance = 0;
				relevance = relevanceByRecipe(i);
				if (relevance > 0) {
					tempMap.put(r, relevance);
				}
				if (relevance >= 50) {
					tempMapFinal.put(r, relevance);
				}
			}
			if (tempMapFinal.size() > 0) {
				resultList = FXCollections.observableArrayList(tempMapFinal.keySet());
			} else {
				List<Entry<Recipe, Integer>> sortingList = new ArrayList<>(tempMap.entrySet());
				sortingList.sort((o1, o2) -> o2.getValue() - o1.getValue());
				Set<Recipe> tempSet = new LinkedHashSet<>();
				for (Map.Entry<Recipe, Integer> entry : sortingList) {
					tempSet.add(entry.getKey());
					resultList = FXCollections.observableArrayList(tempSet);
				}
			}
			return resultList;
		}
	}
	
	/**
	 * Searched result by keyword would be sorted according to the relevance.
	 * The search field is in ingredient.
	 * 
	 * @return relevant recipes in order
	 */
	public ObservableList<Recipe> searchResultByIngredient() {
		if (searchField.getText().isEmpty()){
			return recipeData;
	}else{
		ObservableList<Recipe> recipeData = OverchefMainApp.getRecipeData();
			Map<Recipe, Integer> tempMap = new HashMap<>();
			for (int i = 0; i < recipeData.size(); i++) {
				Recipe r = recipeData.get(i);
				int relevance = 0;
				relevance = relevanceByIngredient(i);
				if (relevance > 0) {
					tempMap.put(r, relevance);
				}
			}
			List<Entry<Recipe, Integer>> sortingList = new ArrayList<>(tempMap.entrySet());
			sortingList.sort((o1, o2) -> o2.getValue() - o1.getValue());
			Set<Recipe> tempSet = new LinkedHashSet<>();
			for (Map.Entry<Recipe, Integer> entry : sortingList) {
				tempSet.add(entry.getKey());
			}
			ObservableList<Recipe> resultList = FXCollections.observableArrayList(tempSet);
			return resultList;
	}
}

	
	/**
	 * Searched result by keyword would be sorted according to the relevance.
	 * The search fields are in recipe and ingredient.
	 * 
	 * @return relevant recipes in order (or only total matched recipe if there is one)
	 */
	public ObservableList<Recipe> searchResult() {
		if (searchField.getText().isEmpty()) {
			return recipeData;
		} else {
			ObservableList<Recipe> recipeData = OverchefMainApp.getRecipeData();
			Map<Recipe, Integer> tempMap = new HashMap<>();
			Map<Recipe, Integer> tempMapFinal = new HashMap<>();
			ObservableList<Recipe> resultList = null;
			for (int i = 0; i < recipeData.size(); i++) {
				Recipe r = recipeData.get(i);
				int relevance = 0;
				relevance = relevanceByRecipe(i) + relevanceByIngredient(i);
				if (relevance > 0) {
					tempMap.put(r, relevance);
				}
				if (relevance >= 50) {
					tempMapFinal.put(r, relevance);
				}
			}
			if (tempMapFinal.size() > 0) {
				resultList = FXCollections.observableArrayList(tempMapFinal.keySet());
			} else {
				List<Entry<Recipe, Integer>> sortingList = new ArrayList<>(tempMap.entrySet());
				sortingList.sort((o1, o2) -> o2.getValue() - o1.getValue());
				Set<Recipe> tempSet = new LinkedHashSet<>();
				for (Map.Entry<Recipe, Integer> entry : sortingList) {
					tempSet.add(entry.getKey());
					resultList = FXCollections.observableArrayList(tempSet);
				}
			}
			return resultList;
		}
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		byRecipe.setToggleGroup(group);
		byBoth.setSelected(true);
		byIngredient.setToggleGroup(group);
		byBoth.setToggleGroup(group);
	}

	private void searchedTableView(ObservableList<Recipe> RecipeData) {
		recipeTable.setItems(RecipeData);
		recipeNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRecipeName()));
		ingredientNameCol
				.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIngredientNameListProperty()));
	}


	public void showSearchResult() {
		RadioButton chk = (RadioButton)group.getSelectedToggle();
		if(chk == byRecipe){
    		searchedTableView(searchResultByRecipe());
    	}
    	if(chk == byIngredient){
    		searchedTableView(searchResultByIngredient());
    	}
    	if(chk == byBoth){
    		searchedTableView(searchResult());
    	}
	}

	public ObservableList<Recipe> getRecipeData() {
		return recipeData;
	}

	@FXML
	private void addNewRecipe() throws Exception {
		Recipe newRecipe = new Recipe("", 0, 0, 0);
		new RecipeModifyView(newRecipe).start(new Stage());
	}

	@FXML
	private void viewRecipeDetails() {
		if (recipeTable.getSelectionModel().getSelectedItem() != null) {
			recipeTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
				public void handle(MouseEvent event) {
					if (event.getClickCount() == 2) {
						Recipe clickedRecipe = recipeTable.getSelectionModel().getSelectedItem();
						try {
							new RecipeView(clickedRecipe).start(new Stage());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				}
			});
		}
	}

	public ObservableList<Recipe> sortRecipeData() {
		// sort the recipe alphabetically
		if (recipeData.size() > 0) {
			Collections.sort(recipeData, new Comparator<Recipe>() {
				@Override
				public int compare(final Recipe object1, final Recipe object2) {
					return object1.getRecipeName().compareTo(object2.getRecipeName());
				}
			});
		}
		return recipeData;
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(OverchefMainApp mainApp) {
		searchField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showSearchResult();
			}
		});
		
		searchButton.setStyle("-fx-background-color: #3498DB;");
		addButton.setStyle("-fx-background-color: #2C3E50;");
		this.OverchefMainApp = mainApp;
		recipeData = mainApp.getRecipeData();
		recipeTable.setItems(sortRecipeData());
		recipeNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRecipeName()));
		ingredientNameCol
				.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIngredientNameListProperty()));
		
		OverchefMainApp.getPrimaryStage().setOnCloseRequest(new EventHandler<WindowEvent>(){
			public void handle(WindowEvent event) {
				try {
					DBConnector.disconnect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	} 
}
