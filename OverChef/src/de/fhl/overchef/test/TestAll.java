package de.fhl.overchef.test;

import  org.junit.runner.RunWith;
import  org.junit.runners.Suite;
 
@RunWith(Suite. class )
@Suite.SuiteClasses( {
         //CookbookTest.class,  //unknown error: you can run this test individually
         IngredientTest.class,
         PictureTest.class,
         RecipeTest.class,
         DBConnectorTest.class,
         DBOperationTest.class
         } )

public class TestAll {
	
}
