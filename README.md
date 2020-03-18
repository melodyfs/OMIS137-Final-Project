# Computerized Garden
Group members: Melody Yang, Connor Collins, Robert Mitchell
## Usage
- Compile all the modules by running `javac *.java`
- Run the main program with `java GardenSimulation`

### Operating the Simulation
The program runs one day at a time.  To begin, click start on the left hand tool bar.  The tool bar is where you can access everything you need to interact with the garden.  The other tools include watering, applying pesticides, viewing the activity log, and exiting.  

## Rules
There are some important relationships to understand in the garden.  The first is between bugs and plants.  Each bug eats a certain type of plant, based off of the bug's diets in real life.  Each bug has a variable called destruction rate (which you can view if you click on the bug while in the simulation) which is how much each bug slows down the growth rate of the plant it eats.  Each bug's destruction rate is 1/10 of the growth rate of the plant, so that if you have more than 10 bugs it will make the plant's growth rate negative and it will start shrinking on its way to death.  So make sure to keep an eye on how many bugs you have!  The bug-plant relationships are as follows:

Aphids eat strawberries
Caterpillars eat basil
Mites eat sunflowers
Ants eat roses
Whiteflies eat daisies
Mealybugs eat cucumbers
Thrips eat tomatoes

Each plant has some important characteristics that are not vital to know in order to play but the user may find interesting.  Each plant has its own starting height, maximum growth height, growth rate, and color, just like in real life.  The traits for each plant are as follows:

Plant: Starting height, max height, growth rate (in feet/day), color
Roses: 1, 5, 0.01, red
Daisies: 1, 2.5, 0.02, yellow
Sunflowers: 1, 10, 0,075, yellow
Tomatoes: 1, 8, 0.075, red
Basil: 0.5, 2, 0.0125, green
Cucumbers: 0.5, 3, 0.04, green
Strawberries: 0.25, 1, 0.02, red

There are three types of pesticides to choose from: insect soap, hot pepper bug repellent, and rubbing alcohol bug spray.  Each type kills certain bugs, just like in real life.  The relationships between pesticides and bugs are as follows: 

Insect soap kills aphids, caterpillars, and mites
Hot pepper bug repellent kills and and white flies
Rubbing alcohol bug spray kills mealybugs and thrips


## Documentations
### Objects
- Plant
  -enum PlantType
- Bug (BugType
- BugType
  - `enum` BugType
- Soil
  - `nutrientLevel`(NutrientLevel): Recod the level of nutrient in the soil
  - `setNutrientLevel(NutrientLevel nutrientLevel)`: Update `nutrientLevel`
  - `getNutrientLevel()`: To retrieve `nutrientLevel`
- NutrientLevel (enum)
  - Levels of nutrient are assigned an `int` value. 0 means the lowest level; 5 is the highest.
  

### Classes
- GardenSimulation
  - `initUI`: 
- Fertilizer 
- Pesticide
- Watering
  - The length and width give you the area of your garden 
- Logging
  - All the logs are recorded in `GardenLog.log`
  - This helper class can be accessed through singleton for global usage: </br>
    ```java
    private static Logging logger = Logging.getInstance();
    logger.log(<your logging message here>)
    ```
