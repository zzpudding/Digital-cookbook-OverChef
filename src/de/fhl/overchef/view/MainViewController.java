package de.fhl.overchef.view;

import de.fhl.overchef.model.Recipe;
import de.fhl.overchef.view.OverchefMainApp;

import java.io.IOException;
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
	private TableColumn<Recipe, String> recipeNameCol = new TableColumn<Recipe, String>();
	@FXML
	private TableColumn<Recipe, String> ingredientNameCol = new TableColumn<Recipe, String>();

	private OverchefMainApp OverchefMainApp;
	private ObservableList<Recipe> recipeData = FXCollections.observableArrayList();
	
	/**
	 * Compare a certain recipe's name with keywords and return their relevance. 
	 * Will also do boundary check and replace characters which could cause exception.
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
				relevance += 20;
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
	 * Compare a certain recipe's ingredients' name with keywords and return their relevance. 
	 * Will also do boundary check and replace characters which could cause exception.
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
					relevance += 5;
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
	 * 
	 * @param recipeData
	 *            all recipes
	 * @param keyword
	 *            user's input
	 * @return the search result containing relevant recipes in order
	 */
	public ObservableList<Recipe> searchResult() {
		if (searchField.getText().isEmpty()){
				return recipeData;
		}else{
				
			ObservableList<Recipe> recipeData = OverchefMainApp.getRecipeData();
				Map<Recipe, Integer> tempMap = new HashMap<>();
				for (int i = 0; i < recipeData.size(); i++) {
					Recipe r = recipeData.get(i);
					int relevance = 0;
					relevance = relevanceByRecipe(i) + relevanceByIngredient(i);
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
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}
	
	
	private void searchedTableView(ObservableList<Recipe> RecipeDatas) {
		recipeTable.setItems(RecipeDatas);
		recipeNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRecipeName()));
		ingredientNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIngredientNameListProperty()));
	}
	
	
	public void showSearchResult() {
		searchedTableView(searchResult());
	}

	public ObservableList<Recipe> getRecipeData() {
		return recipeData;
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

	public ObservableList<Recipe> sortRecipeData(){
		//sort the recipe alphabetically
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
		this.OverchefMainApp = mainApp;
		recipeData=mainApp.getRecipeData();
		recipeTable.setItems(sortRecipeData());
		recipeNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getRecipeName()));
		ingredientNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getIngredientNameListProperty()));
	}
}
