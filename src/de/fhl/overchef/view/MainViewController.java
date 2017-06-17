package de.fhl.overchef.view;

import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.view.OverchefMainApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainViewController {
	@FXML
	private TextField searchField = new TextField();
	@FXML
	private TableView<Recipe> recipeTable;
	@FXML
	private TableColumn<Recipe, String> recipeNameCol = new TableColumn<Recipe, String>("RecipeName");
	@FXML
	private TableColumn<Recipe, String> ingredientNameCol = new TableColumn<Recipe, String>("Ingredients");

	private OverchefMainApp OverchefMainApp;
	private ObservableList<Recipe> RecipeData = FXCollections.observableArrayList();
	
	/**
	 * Search strings with given keyword in recipe list. Will also do boundary
	 * check and replace characters which could cause exception.
	 * 
	 * @param keyword
	 *            user's input
	 * @return a relevance value
	 */
	public int relevanceByRecipe(int i) {
		String keyword = searchField.getText();
		int relevance = 0;
		for (char c : new char[] { '*', '(', ')', '[', ']', '{', '}', '.' }) {
			keyword = keyword.replaceAll("\\" + c, "\\" + c);
		}
		RecipeData = OverchefMainApp.getRecipeData();
		Recipe r = RecipeData.get(i);
		String recipeName = r.getRecipeName();
		if (recipeName != null && !recipeName.equals("")) {
			if (recipeName.equalsIgnoreCase(keyword)) {
				relevance += 10;
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
	 * Search strings with given keyword in ingredient list. Will also do boundary
	 * check and replace characters which could cause exception.
	 * 
	 * @param keyword
	 *            user's input
	 * @return a relevance value
	 */
	public int relevanceByIngredient(int i) {
		String keyword = searchField.getText();
		int relevance = 0;
		for (char c : new char[] { '*', '(', ')', '[', ']', '{', '}', '.' }) {
			keyword = keyword.replaceAll("\\" + c, "\\" + c);
		}
		RecipeData = OverchefMainApp.getRecipeData();
		String allIngredients = RecipeData.get(i).getIngredientNameListProperty();
		String[] ingredients = allIngredients.split(",");
		for (String ingredient : ingredients) {
			if (ingredient != null && !ingredient.equals("")) {
				if (ingredient.equalsIgnoreCase(keyword)) {
					relevance += 10;
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
	 * Search result by keyword would be sorted
	 * according to the relevance.
	 * 
	 * @param recipeData
	 *            giving recipes
	 * @param keyword
	 *            user's input
	 * @return the search result containing relevant recipes
	 */
	public ObservableList<Recipe> searchResult() {
		ObservableList<Recipe> recipeData = OverchefMainApp.getRecipeData();
		Map<Recipe, Integer> tempMap = new HashMap<>();
		for (int i = 0; i < recipeData.size(); i++) {
			Recipe r = recipeData.get(i);
			int relevance = relevanceByRecipe(i) + relevanceByIngredient(i);
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

	public void setRecipeData(ObservableList<Recipe> recipeData) {
		RecipeData = recipeData;
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		recipeNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRecipeName()));
		ingredientNameCol
				.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIngredientNameListProperty()));
	}

	private void searchedTableView(ObservableList<Recipe> RecipeDatas) {
		initialize();
		recipeTable.setItems(RecipeDatas);
		recipeNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRecipeName()));
		ingredientNameCol
				.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIngredientNameListProperty()));
	}

	public void showSearchResult() {
		searchedTableView(searchResult());
	}

	public ObservableList<Recipe> getRecipeData() {
		return RecipeData;
	}
	
	@FXML
	private void addNewRecipe() throws Exception{
		Recipe newRecipe = new Recipe("",0,0,0);
		new RecipeModifyView(newRecipe).start(new Stage());
	}
	
	@FXML
	private void viewRecipeDetails(){
		recipeTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        	Recipe clickedRecipe = recipeTable.getSelectionModel().getSelectedItem();
		    		try {
						new RecipeView(clickedRecipe).start(new Stage());
					} catch (IOException e) {
						e.printStackTrace();
					}
		    }
		});
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(OverchefMainApp mainApp) {
		this.OverchefMainApp = mainApp;
		// Add observable list data to the table
		recipeTable.setItems(mainApp.getRecipeData());
	}
}
