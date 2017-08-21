# Digital-cookbook-OverChef

## What is OverChef
>*OverChef*, is a digital cooking software, providing functionalities such as quickly off-line searching, updating recipes based on users’ preference and add use’s own recipe. It helps users to cook a dish in an efficient and less wasting way.

## Gernaral Requirement
- Installed Eclipse and MySQL server (such as MAMP, MySQL Workbench)
- Installed JavaFX Runtime Environment
- Java SE Runtime Environment

## Instructions
### Before opening:
####  Database Requirement
  &emsp;&emsp;- Build connection between Eclipse and MySQL server (the port number and password can be changed in DBConnector.java).
  &emsp;&emsp;- Create or forward engineering a local database named 'overchefdb'in the created connection and then choose 'Import from self-contained file' to import the 'overchefdb.sql' file into the 'overchefdb'.
 &emsp;&emsp; - Buid your own mysql-connector.jar path to the project.
####  FX Requirement
  - Ensure you have installed the javafx runtime environment.

## *OverChef* provides following functions
  **Search recipes**
  - Search recipes by keywords (can be recipe's name or ingredient's name).
  - Choose keywords field (can be in recipes/ingredients/both).
  - Search results will be displayed by its degree of relevance.

  **View recipes** 
  - Double click a recipe will lead user to its details.
  - Serve number can be changed and the quantity of each ingredient will change automatically.
  - Click 'Back' button to go back to the main view.

  **Edit recipes** 
  - Click 'Edit' button to modify current recipe.
  - All the content of a recipe can be modified, including a picture.
  
  **Add recipe** 
  - Click the 'Add' button to create a new recipe.
  - A recipe name is a must for saving the newly-added recipe.

