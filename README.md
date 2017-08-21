# Digital-cookbook-OverChef

## What is *OverChef*
>*OverChef*, a digital cookbook software, provides functionalities such as quickly off-line searching and add/delete recipes. It helps users to cook a dish in an efficient and less wasting way.

## Requirement
- Install Eclipse and MySQL server (such as MAMP, MySQL Workbench)
- Java SE Runtime Environment
- JavaFX Runtime Environment<br>

**Database Requirement**
 - Build connection between Eclipse and MySQL server (the port number and password can be changed in `DBConnector.java`).
 - Create or forward engineering a local database named 'overchefdb'in the created connection and then choose 'Import from self-contained file' to import the `overchefdb.sql` file into the 'overchefdb'.
 - Buid your own `mysql-connector.jar` path to the project.
 
## Function 
  **Search recipes**
  - Search recipes by keywords (can be recipe's or ingredient's name).
  - Choose keywords field (can be in recipes/ingredients/both).
  - Search results will be sorted and displayed according to its degree of relevance.

  **View recipes** 
  - Double click a recipe will lead user to its details.
  - Serve number can be changed and the quantity of each ingredient will change automatically.
  - Click 'Back' button to go back to the main view.

  **Edit recipes** 
  - Click 'Edit' button to modify current recipe.
  - All the content of a recipe can be modified, including a picture.
  
  **Add a recipe** 
  - Click the 'Add' button to create a new recipe.
  - A recipe name is a must for saving the newly-added recipe.
  
  **Delete a recipe**
  - Click 'Delete' button and confirm.

## More About *OverChef*
- A FHL software engineering project
- An immature software which cannot run independently (which means you need to run it in Eclipse)
- Contact me if you have any suggestion or not
&emsp;&emsp; [Yujia Zhang] <yujia.zhang@stud.fh-luebeck.de>

