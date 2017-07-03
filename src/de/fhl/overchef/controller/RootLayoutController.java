package de.fhl.overchef.controller;

import de.fhl.overchef.view.FxDialogs;
import de.fhl.overchef.view.OverchefMainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author yujia Zhang
 */
public class RootLayoutController {
	@FXML
	private Menu about;
	// Reference to the main application
	private OverchefMainApp mainApp;

	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(OverchefMainApp mainApp) {
		this.mainApp = mainApp;
	}

	/**
	 * Display app's instruction.
	 */
	@FXML
	private void handleAbout() {
		FxDialogs.showInformation("Overchef Author:\n Yujia ZHANG,\n Jiacheng ZHOU,\n"
				+ " Zhengjiang HU,\n Fangtian LI,\n Bocheng HU", 
				"1.Search recipes \n -After the app is opened,user can search recipes by entering keywords in the txt field.\n "
				+ "-3 search type buttons can be chosen to search recipes only or search ingredients only or search both.\n "
				+ "-User can click 'search' button,when want to refresh the result list after some recipes are modified or deleted.\n \n "
				+ "2.View recipes \n -User can double click the certain recipe in the result list below the txt field to see recipe details.\n"
				+ "-User can change serve numbers in the serve number text field to view different ingredient quantities with entered number.\n"
				+ "-User can delete the opened recipe by clicking the 'delete' button and confirming choice by clicking 'confirm' button in alert box.\n"
				+ "-Click 'Back' button to go back to the main view.\n \n 3.Edit recipes\n-Click 'Edit' button to go to the recipe modify view.\n"
				+ "-User can edit all the content of a recipe\n-Click 'save' button to save a recipe.\n"
				+ "-Click 'cancel' button and then 'confirm' button to give up the edition and go back to the recipe view.\n\n"
				+ "4.Add recipe\n-User can click the 'Add' button,if want to add a new recipe.\n"
				+ "-A recipe name is necessary for saving the newly-added recipe.\n");
	}
}
