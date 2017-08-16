-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: overchefdb
-- ------------------------------------------------------
-- Server version	5.6.24-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingredient` (
  `iid` int(11) unsigned NOT NULL,
  `rid` int(11) unsigned NOT NULL,
  `ingredientName` varchar(200) NOT NULL,
  `quantity` double NOT NULL,
  `unit` varchar(100) NOT NULL,
  `ingredientDesc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`iid`,`rid`),
  KEY `ingredient_iidx` (`iid`),
  KEY `fk_INGREDIENT_rid_idx` (`rid`),
  CONSTRAINT `fk_INGREDIENT_rid` FOREIGN KEY (`rid`) REFERENCES `recipe` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,1,'Chicken leg',1,'kg',' The legs of chicken are better '),(1,2,'pack raw peeled king prawns',150,'gram',' Main material '),(1,3,'banane',200,'gram','main material'),(1,4,'pound pork',0.8,'kg',''),(1,5,'Flour',1,'kg',' Main material '),(1,6,'beef',1,'kg',' Main material '),(1,7,'soba noodles',150,'gram',' Main material '),(1,8,'Chicken',500,'g',' Main material '),(1,9,'chicken Wings',1,'kg',''),(1,10,'Fruit',1,'kg',' You can choose all kinds of fruit you want '),(1,11,'Salmon fillets',2,'piece',' Main material '),(1,12,'chicken',1.5,'kg',''),(1,13,'Beef',500,'g',' Main material '),(1,14,'oven_roasted vegetable',400,'gram','Main material'),(1,15,'Pork',600,'g',' main material '),(1,16,'pork ribs',2,'kg',''),(1,17,'pineapple',140,'gram','chopped into bite-sized chunks'),(1,18,'chicken breast',500,'g',' Main material '),(1,19,' plain flour',225,'g','plus extra for dusting'),(1,20,'soft butter',140,'g',''),(1,21,'fresh blueberries',1,'cup',''),(1,22,'Chicken',1,'kg',' Main material '),(1,23,'penne',350,'gram',' Main material '),(1,24,'charlotte potatoes',1,'kg','large ones cut in half'),(1,25,' vegetable oil',2,'tbsp',''),(1,26,'butter',28,'g','softened, plus extra for greasing'),(2,1,'soy sauce',4,'tablespoon','can be used to eliminate the smell of the chicken '),(2,2,'can kidney beans in chilli sauce',400,'gram',' Main material '),(2,3,'dumpling warpper',250,'gram',' Main material '),(2,4,'egg',1,'piece',''),(2,5,'Chocolate podwer',150,'g','Main material'),(2,6,'salat',500,'g','Main material'),(2,7,'raw prawns',180,'gram',' important flavor'),(2,8,'Onion',500,'g','Main material'),(2,9,'cola',300,'ml',''),(2,10,'salad sauce',150,'g','Main flavor'),(2,11,'sweet chilli sauce',1,'tbsp',' important flavor'),(2,12,'salt',1,'tsp',''),(2,13,'Tomato',500,'g','Main material'),(2,14,'can kidney bean',1,'piece','in chilli sauce'),(2,15,'soy sauce',4,'tablespoon',' this can be used to eliminate the smell of the prok '),(2,16,'ginger',1,'piece',''),(2,17,'spring onions',250,'gram','both sliced'),(2,18,'chipotle paste',100,'g','Main material'),(2,19,'icing sugar',3,'tbsp',''),(2,20,'caster sugar',140,'g',''),(2,21,'banana',1,'piece',''),(2,22,'Marsroom',100,'g','make the chicken soup better'),(2,23,'pouch coconut rice',250,'gram',' Main material '),(2,24,'lemon',2,'piece',''),(2,25,'skinless boneless chicken thighs',8,'piece','cut into chunks'),(2,26,'demerara sugar',52,'g',''),(3,1,'pepper',100,'g','choose the spicy pepper'),(3,2,'rice',250,'gram',' Main material '),(3,4,'cornstarch',1,'tsp',''),(3,5,'yeast',3,'g',' necessary material'),(3,6,'tomato',500,'g',' Main material'),(3,7,'soy sauce',3,'tbsp','important flavor'),(3,8,'pepper',10,'g',' important flavor'),(3,9,'ginger',1,'piece',''),(3,11,'honey',1,'tbsp','important flavor'),(3,12,'ginger',1,'piece',''),(3,13,'Potato',500,'g',' Main'),(3,14,'tomatoe',1,'piece','chopped'),(3,15,'pepper',100,'g','choose the spicy pepper'),(3,16,'soya sauce',2,'tsp',''),(3,17,'Thai green curry paste',3,'tbsp',' important flavor'),(3,18,'lime juiced',10,'g',' important flavor'),(3,19,'unsalted butter',140,'g','diced and chilled'),(3,20,'large egg',2,'piece','beaten'),(3,21,'Pomegranate juice',50,'ml',''),(3,22,'Mu er',100,'g',' a traditional Chinese ingredient'),(3,23,'jerk seasoning',1.5,'tbsp',' important flavor'),(3,24,'olive oil',125,'ml',''),(3,25,'red chillies',2,'piece','finely sliced '),(3,26,'egg',1,'piece',''),(4,1,'Shaoxin rice wine',3,'tablespoon','make the chicken better'),(4,2,'jerk seasoning',1.5,'tbsp',' important flavor'),(4,4,'oil',2,'tsp',''),(4,5,'egg',100,'g','make the cake better'),(4,6,'hamburger sauce',100,'g','make the burger better'),(4,7,'wasabi',1,'tbsp','important flavor'),(4,8,'soy sauce',10,'g','important flavor'),(4,9,'soya sauce',2,'tsp',''),(4,11,'oil',1,'tbsp','important flavor'),(4,12,'soya sauce',1.5,'tsp',''),(4,13,'green onion',50,'g','important flavor'),(4,15,'Shaoxin rice wine',3,'tablespoon','make the pork better'),(4,16,'salt',1,'tsp',''),(4,17,'egg',2,'piece','beaten'),(4,18,'slices cheese',2,'piece','important flavor'),(4,19,'egg yolk',1,'medium','plus 1 medium egg yolk beaten, for glazing'),(4,20,'self_raising flour',140,'g',''),(4,21,'Natural yogurt',1,'cup',''),(4,22,'salt',5,'g',''),(4,24,'redwine vinegar',1,'tbsp',''),(4,25,'fresh ginger',2,'tsp',''),(4,26,'Greek yoghurt',25,'g',''),(5,1,'Garlic',30,'g','important flavor'),(5,4,'ginger',1,'piece',''),(5,5,'sugar',20,'g','important flavor'),(5,6,'pepper',20,'g','flavor'),(5,9,'salt',1,'tsp',''),(5,12,'oil',3,'tsp',''),(5,13,'ginger',20,'g','important flavor'),(5,15,'Garlic',30,'g','important flavor'),(5,16,'oil',3,'tsp',''),(5,17,'pea',140,'gram','frozen'),(5,18,'cherry tomatoes',2,'piece','important flavor'),(5,19,'vanilla bean paste',1,'tsp',''),(5,20,'baking powder',1,'tsp',''),(5,21,' Ground cinnamon',1,'tsp',''),(5,22,'green onion',200,'g','important flavor'),(5,24,'dried oregano',0.5,'tsp',''),(5,25,'garam masala',2,' tsp',''),(5,26,'selfraising flour',75,'g',''),(6,1,'pepper',5,'g','important flavor'),(6,4,'salt',1,'tsp',''),(6,9,'oil',3,'tsp',''),(6,12,'garlic',1,'piece',''),(6,15,'pepper',5,'g','important flavor'),(6,16,'rice wine',2,'tsp',''),(6,19,'whole milk',250,'ml',''),(6,20,'ripe bananas mashed',2,'piece',''),(6,21,' Berry powder of your choice',2,'tsp',''),(6,22,'ginger',10,'g','important flavor'),(6,24,'Salt and freshly ground black pepper',1,'spoon',''),(6,25,'smooth peanut butter',100,'g',''),(6,26,'baking powder',0.2,'tsp',''),(7,1,'green onion',200,'g','important flavor'),(7,4,'chicken broth',500,'ml',''),(7,9,'rice wine',2,'tsp',''),(7,15,'spicy pepper',5,'g','important flavor'),(7,19,'cornflour',250,'g',''),(7,24,'chicken ',1.6,'kg','medium'),(7,25,'coconut milk',400,'g',''),(7,26,'pinch salt',0.2,'pinch',''),(8,1,'ginger',10,'g','important flavor'),(8,15,'green onion',200,'g','important flavor'),(8,19,'thin forced rhubarb',700,'g',''),(8,24,'garlic cloves',2,'',''),(8,25,'hopped tomatoes',400,'g',''),(8,26,'lemon',0.4,'piece',''),(9,15,'ginger',10,'g','important flavor'),(9,19,'pistachio',1,' tbsp',''),(9,24,' green olives',150,'g','stoned and halved'),(9,25,'coriander',1,'bunch ',''),(9,26,'amaretti biscuits',15,'g',''),(10,24,'fresh thyme',0.5,'small bunch','picked'),(10,26,'peach',1.4,'piece','stoned and quartered');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `rid` int(11) unsigned NOT NULL,
  `pid` int(11) unsigned NOT NULL,
  `picPath` varchar(500) NOT NULL,
  PRIMARY KEY (`pid`,`rid`),
  KEY `fk_RECIPE1_idx` (`rid`),
  KEY `PICTURE_pidx` (`pid`),
  CONSTRAINT `fk_PICTURE_RECIPE1` FOREIGN KEY (`rid`) REFERENCES `recipe` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (5,1,'OverChefDefaultPicture.jpg'),(6,1,'OverChefDefaultPicture.jpg'),(7,1,'IMG_1788.JPG'),(8,1,'meat.jpg'),(9,1,'IMG_5510.JPG'),(10,1,'peppers.jpg'),(11,1,'couple of steaks 2.jpg'),(12,1,'couple of steaks.jpg'),(13,1,'tomato and egg.jpg'),(14,1,'IMG_5649.JPG'),(15,1,'IMG_5485.JPG'),(16,1,'IMG_5641.JPG'),(17,1,'manggo rice.JPG'),(18,1,'IMG_1258.JPG'),(19,1,'ice cream.jpg'),(20,1,'IMG_5647.JPG'),(21,1,'potato and pepper.jpg'),(22,1,'IMG_5646.JPG'),(23,1,'japanese-food-2199962_960_720.jpg'),(25,1,'garlic chicken.jpg');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preparationstep`
--

DROP TABLE IF EXISTS `preparationstep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preparationstep` (
  `stepNum` int(10) unsigned NOT NULL,
  `rid` int(11) unsigned NOT NULL,
  `step` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`stepNum`,`rid`),
  KEY `fk_RECIPE_idx` (`rid`),
  CONSTRAINT `fk_preparation_step_rid` FOREIGN KEY (`rid`) REFERENCES `recipe` (`rid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preparationstep`
--

LOCK TABLES `preparationstep` WRITE;
/*!40000 ALTER TABLE `preparationstep` DISABLE KEYS */;
INSERT INTO `preparationstep` VALUES (1,1,'Clean the chicken and cut chicken into pieces'),(1,2,'Heat 1 tbsp oil in a large frying pan. Add the jerk seasoning, and cook for 1-2 mins. Drain the beans, add 3 tbsp of the chilli sauce.'),(1,3,'Mash the banane'),(1,4,'Mix the ground pork, egg, cornstarch, 2 teaspoons of sesame oil, ginger, salt, and half of the chopped green onions together in a bowl. '),(1,5,'Porcess the flour'),(1,6,'Use the beef to make meat balls'),(1,7,'Mix the wasabi, soy sauce and garlic in a small bowl. Bring a large pan of water to the boil.'),(1,8,'Cut the chicken and onions into pieces'),(1,9,'Scratch wings on the back by knife, make it tasty and easy cooked'),(1,10,'Clean and cut all the fruit into pieces'),(1,11,'Heat the pan and put the salmon into it.'),(1,12,'prepare a pot of boiled water and put the chicken into the water '),(1,13,'Cut the beef, tomatoes and potatoes into pieces'),(1,14,'Heat the pot. Cook the vegetables in a dish for 15 mins. Tip in the beans and tomatoes, season, and cook for another 10-15 mins until piping hot.'),(1,15,'Clean and cut the pork into pieces'),(1,16,'Scratch pork on the back by knife, make it tasty and easy cooked'),(1,17,'Heat the oil in a pot or non-stick frying pan and fry the onion whites for 2 mins until softened. '),(1,18,'put the chicken on a plate and cut it into 1cm cube.'),(1,19,'Put the flour, icing sugar and a pinch of salt in a large bowl and mix together.'),(1,20,'Preheat your oven to 180C .'),(1,21,'Combine the ingredients in a blender and blend until smooth. '),(1,22,'Clean and cut the chicken into pieces'),(1,23,'pour half pot of water into a empty pot and heat it to boiling.'),(1,24,'Heat the oven to 200C mark 6. Steam the potatoes for 10-15 minutes,then drain and leave uncovered to steam dry.'),(1,25,'Heat 1 tbsp of the oil in a deep frying pan over a medium heat. Brown the chicken in batches. '),(1,26,'To make the cake batter, cream the butter and sugar in a food processor.'),(2,1,'Put these pieces into boiling water for 5- 10 minutes and then take them out'),(2,2,'Add the beans to the pan along with the reserved sauce and the coconut rice. Fry for 3-4 mins, then season with salt to taste and spoon into two bowls to eat.'),(2,3,'Prepare the dumling warppers and place them on a platform.'),(2,4,' Pour in the chicken broth, water, and soy sauce. Bring to a boil, then lower the heat to medium.'),(2,5,'add chocolate, yeast, egg and sugar into the flour'),(2,6,'Press the meat balls into pastries'),(2,7,'in the meanwhile, heat the butter in a frying pan. Once steaming, cook for a few mins until it become pink. Stir in the wasabi mixture with a couple of spoonfuls of the noodle cooking water and heat through.'),(2,8,'Heat up the pot and fry chicken and onions in order'),(2,9,'Add chicken wings and marinated with spices'),(2,10,'add salad into the pieces'),(2,11,'Mix the sweet chilli, honey, oil, in a small bowl and pour over the salmon. Bake for 10 mins.'),(2,12,'put the garlic and salt into the water'),(2,13,'Heat up the pot and fry beef, potatoes and tomatoes in order'),(2,14,'Heat the plate in the microwave on 600W for 1 min and mix with the chilli.'),(2,15,'Put these pieces into boiling water for 5- 10 minutes and then take them out'),(2,16,'Add pork and marinated with spices'),(2,17,'Stir in the pepper for 1 min, followed by the pineapple for 1 min more, then stir in the green curry paste and soy sauce.'),(2,18,'Mix the sauce in the ingredient and spread it on the chicken.'),(2,19,'Put the vanilla beans scraped from the pod  in a pan,add the milk and bring to the boil. '),(2,20,'Butter your loaf tin and line the base and sides with baking parchment paper.'),(2,22,'Put these pieces into boiling water for 5 minutes and then take them out'),(2,23,'keep heating for 5 minutes and season it with jerk.'),(2,24,'Make the marinade by whisking the lemon juice and zest, half the oil, the vinegar and the oregano.'),(2,25,'Fry the garlic, chilli and ginger in the other 1 tbsp oil for 1 min. '),(2,26,'Beat in the eggs one at a time, then incorporate the yoghurt.'),(3,1,'Cut pepper into small pieces, so do garlic, green onion and ginger'),(3,3,'Warp the banane with dumpling warppers, you can stick the warpper edges with some water'),(3,4,'Drop them into the boiling soup. '),(3,5,'put the cake into oven for 20 miniutes'),(3,6,'fry the meat pastries'),(3,7,'Add the noodles to the pan with the onions, toss together and divide between two plates.'),(3,8,'Put all the main materials together and fry them and add soy sauce'),(3,9,'put the chicken into the pot and add the cola,ginger and rice wine'),(3,10,'Stir them and prepare to enjoy it. You can also put some flavor you like'),(3,11,'Cut a slice across the base so the fish separate. Heat the oils in another pan, add the garlic briefly to soften.'),(3,12,'Remove the chicken to cool or refrigerate refrigerated for up to 10 minutes, and finally into the chicken pieces'),(3,13,'Put all the main materials together and fry them'),(3,15,'Cut pepper into small pieces, so do garlic, green onion and ginger'),(3,16,'add oil and put the pork into the pot '),(3,17,'Add the rice, then push the rice to one side of the pan and scramble the eggs on the other side. '),(3,18,'Heat a pan and cook the chicken chest for 3 minutes, then add the cheese at the last. '),(3,19,'Meanwhile, tip the egg, yolks, sugar and cornflour into a bowl and whisk together until smooth.  '),(3,20,'Cream the butter and sugar until light and fluffy, then slowly add the eggs with a little flour.'),(3,22,'Cut the marshroom and mu er into pieces'),(3,23,'pour the water and mix the penne with rice.'),(3,24,'Spatchcock the chicken by cutting out the backbone with kitchen scissors.'),(3,25,'Stir in the peanut butter, coconut milk and tomatoes, and bring to a simmer.'),(3,26,'Put the biscuits into a plastic bag and bash to a fine crumb, then toss the peach quarters in the crumbs'),(4,1,'Heat up the pot and fry the garlic and green onion at first '),(4,3,'Heat a pan and fry the pie, each for 1 minute'),(4,6,'Cut the salat and tomatoes into pieces to eat with hamburger'),(4,8,'Finally add pepper into the stuff'),(4,9,'keep fire until there is few water'),(4,11,'Pour over the oil, cover the pan and allow to cook for 5 mins.'),(4,12,'Combine all sauce ingredients juice, chicken with dipping sauce'),(4,13,'Add about 2 L water to boli the stuff for about 30 miniutes'),(4,15,'Put all the flavors except for pepper powder together and set aside and heat up the pot'),(4,16,'add the sauce,ginger,salt and rice wine'),(4,17,'pare the pea and cut it into 1cm cube, and add them to the rice'),(4,18,'Choose two bread, add the meat to the middle of the breads.'),(4,19,'Chill for 30 mins or until the pastry is firm.'),(4,20,'Fold in the remaining flour, baking powder and mashed bananas.'),(4,22,'Change the water in the pot and then put chicken back into the pot with green onion and ginger'),(4,24,'Bash together the garlic, thyme and a teaspoon of salt in a mortar . '),(4,25,'Return the chicken to the pan and add the chopped coriander.'),(4,26,'While the cake is baking, make the crumble.'),(5,1,'Then put chicken into the pot and fry it and put peppers also in the pot'),(5,11,'Serve the garlic in shallow bowls, put the salmon on the top and add the juices. you can eat it with rice or noodle.'),(5,15,'Put flavors first to fry and then the pork'),(5,16,'keep fire until there is few water'),(5,18,' Meanwhile, add some other sauce such as pepper.'),(5,19,'Heat oven to 180C the tart with a piece of crumpled baking parchment and fill with baking beans or rice and place on a baking tray.'),(5,20,'Pour into the tin and bake for about 30 mins until a skewer comes out clean. '),(5,22,'Boil the stuff for 20 minute and add marshroom and salt'),(5,24,'Turn out the potatoes into a large baking tin and gently crush them with a potato masher.'),(5,25,'Cook for 30 mins until the sauce thickens and the chicken is cooked through'),(5,26,'Leave to cool completely, then remove from the tin, cut into slices and serve with creme fraiche.'),(6,1,'Add soy sauce and Shaoxin rice wine into the stuff and boil it for 15-20 minutes'),(6,15,'Add soy sauce, Shaoxin rice wine and pepper podwer into the stuff and boil it for 10- 15 minutes'),(6,19,'emove the custard from the fridge, beat to loosen, then pour over the pastry and smooth with a spatula. '),(6,22,'Put mu er into the pot 10 minutes before the dish finished'),(6,24,'Cook the chicken at the same time as the spuds. '),(6,25,'Serve with the remaining coriander, roasted peanuts and rice, if you like.'),(7,19,'Top with the roasted rhubarb, brushing a little of the syrup on top, then sprinkle over the pistachios.'),(7,24,'Let the chicken rest for five minutes and keep the potatoes warm, then carve and serve.');
/*!40000 ALTER TABLE `preparationstep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipe` (
  `rid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `recipeName` varchar(200) NOT NULL,
  `servings` int(11) DEFAULT NULL,
  `preparationTime` int(10) unsigned DEFAULT NULL,
  `cookingTime` int(10) unsigned DEFAULT NULL,
  `recipeDesc` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `rid_UNIQUE` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,'Spicy Chicken',4,20,30,''),(2,'Sandwich',2,2,6,'This quick, lazy food can reserve for 2 days'),(3,'banane pie',2,25,35,'easy but time consuming.'),(4,'Lion Head Soup',2,20,50,'This is my family\'s version of lion\'s head soup '),(5,'Chocolate Cake',4,40,20,''),(6,'Hamburger',4,20,20,''),(7,'Noodles',2,5,10,''),(8,'Chicken with Onion',4,20,20,''),(9,'Fried Chicken Wings',3,20,60,'Home Dishes'),(10,'Fruit Salad',4,40,10,''),(11,'Salmon',2,10,10,''),(12,'Sliced Boiled Chicken',3,20,50,'That is very nice chinese style food'),(13,'Tomato and Beef Soup',4,20,40,''),(14,'Vegetarian chilli',2,2,30,'The easiest chilli you will ever make'),(15,'Xiao Chao Rou',4,20,20,''),(16,'hong shao pai gu',4,30,45,'Home Dishes'),(17,'pineapple rice',4,10,15,'Cook your rice in advance to get ahead, suitable for busy time.'),(18,'Chicken burger',1,10,8,''),(19,'custard tart',6,30,60,'The flavour of my favourite boiled sweet in a delicious dessert.  '),(20,'Secret',3,10,40,'This is an easy recipe that gives perfect results every time.  '),(21,'Banana blueberry smoothie',2,10,30,'Simple Summer Smoothie Recipe. Healthy, easy, and quick to prepare it is a refreshing treat.'),(22,'Chicken Soup',4,20,60,'delicious and nutrious'),(23,'Penne with tuna sauce',4,5,15,'easy to handle'),(24,'lemon chicken',6,20,60,'This golden chicken and potato combo is made vibrant by its lemon and olive dressing.'),(25,' Peanut butter chicken',3,10,60,'The whole family will love this new, budget chicken dish. Any leftovers freeze well and make a handy lunch'),(26,'Cake ',1,30,40,'Full of the flavours of summer');
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-02 22:12:43
