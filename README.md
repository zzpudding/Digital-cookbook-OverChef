# Digital-cookbook-OverChef

## What is OverChef
>*OverChef*, is a digital cooking software, providing functionalities such as quickly off-line searching, updating recipes based on users’ preference and add use’s own recipe. It helps users to cook a dish in an efficient and less wasting way.

Instructions before opening the Overchef App.


Before opening:

  Database Requirement:
  -Create a connection with port number 3306,and password 1234(or can also use your own password by changing the password in DBConnector.java) .
  -Create or forward engineering a local database named 'overchefdb'in the created connection and then choose 'Import from self-contained file' to import the 'overchefdb.sql' file into the 'overchefdb'.
  -Buid your own mysql-connector.jar path to the project.
 
  FX Requirement:
  -Ensure you have installed the javafx runtime environment.


1.Open the App
  -Open the OverchefMainApp.java file in de.fhl.overchef.view package.


2.Search recipes
  -After the app is opened,user can search recipes by entering keywords in the txt field.
  -3 search type buttons can be chosen to search recipes only or search ingredients only or search both.
  -User can click 'search' button,when want to refresh the result list after some recipes are modified or deleted.


3.View recipes
  -User can double click the certain recipe in the result list below the txt field to see recipe details.
  -User can change serve numbers in the serve number text field to view different ingredient quantities with entered number.
  -User can delete the opened recipe by clicking the 'delete' button and confirming choice by clicking 'confirm' button in alert box.
  -Click 'Back' button to go back to the main view.
-----------------------------------------------------------------------------------------------------------------------
4.Edit recipes
  -Click 'Edit' button to go to the recipe modify view.
  -User can edit all the content of a recipe
  -Click 'save' button to save a recipe.
  -Click 'cancel' button and then 'confirm' button to give up the edition and go back to the recipe view.
-----------------------------------------------------------------------------------------------------------------------
5.Add recipe
  -User can click the 'Add' button,if want to add a new recipe.
  -A recipe name is necessary for saving the newly-added recipe.
-----------------------------------------------------------------------------------------------------------------------

Thank you for reading this file before using our app.
