# Computerized Garden
Group members: Melody Yang, Connor Collins, Robert Mitchell
## Usage
- Compile all the modules by running `javac *.java`
- Run the main program with `java GardenSimulation`

## Operating the Simulation
 The program runs one day at a time.  To begin, click start on the left hand tool bar.  The tool bar is where you can access everything you need to interact with the garden.  The other tools include watering, applying pesticides, viewing the activity log, and exiting.  

 ### Rules
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
    - `String name;`: variable name of type String
    - `String species;`: variable species of type String
    - `public Plant()`: Plant constructor

- Bug 
    - `String name;`: variable name of type String
    - `BugType type;`: variable type of enum type BugType
    - `public Bug()`: Bug Constructor
    - `void updateBugInfo(String var1, BugType var2)`: constructor for this. reference variables for updating bug name and type
    
- BugType
  - `enum BugType { 
    `aphid,
    `caterpillar,
    `mite,
    `ants,
    `whiteflies,
    `mealyBug,
    `thrips,
    `none;`:constants of enum BugType
    
   - `private BugType()`: BugType constructor
    
    
- Soil
  - `nutrientLevel`(NutrientLevel): Record the level of nutrients in the soil
  - `setNutrientLevel(NutrientLevel nutrientLevel)`: Update `nutrientLevel`
  - `getNutrientLevel()`: To retrieve `nutrientLevel`

- NutrientLevel 
  - `enum NutrientLevel {
    `citical(0),
    `sufficient(1),
    `belowOptimum(2),
    `aboveOptimum(3),
    `luxurious(4),
    `toxic(5);`: Levels of nutrient are assigned an `int` value. 0 means the lowest level; 5 is the highest.
  
   -  `private final int level;`: declaration of level

   -  `private NutrientLevel(int var3)`: NutrientLevel constructor
     
   -  `public int getLevelValue()`: to retrieve level value


### Classes

- GardenSimulation

- Garden
    - `static int dayNum = 0;`: static initialization of dayNum 
    - `public int dayGetter()`: method for returning the days of garden simulation
    - `void dayAdder()`: method of adding the days of garden simulation
  
- Garden_Test
  - `public Garden_Test()`: Garden_Test constructor
  - `private void initUI()`: intUI method that contains list of arguments

- GardenLog
  - Display of logging.java
  - Provides updates of garden progress of specific class
  - `Mar 15, 2020 1:54:27 PM Logging log INFO: fertilizer log`: GardenLog log entry

- Fertilizer 
  - `NutrientLevel nutrientLevel;`: nutrientLevel variable of enum type NutrientLevel
  - `private static Logging logger = Logging.getInstance();`: Logger function
  - `Fertilizer(NutrientLevel var1)`: Fertilizer constructor
  - `getSoilFertilizerLevel(Soil var1): to retrieve soilFertilzerLevel`: to retrieve SoilFerilizerLevel
  - `getSoilNutrientLevel(): to retrieve soilNutrientLevel`: to retrieve SoilNutrientLevel
  - `updateNutrientLevelTo(NutrientLevel var1)`: to update NutrientLevel after getter of SoilNutrientLevel
  
- Growth
  - `Double growthRate;`: variable growthRate of type double
  - `Double planHeight;`: variable planHeight of type double
  - `public Growth()`: Growth constructor
 
  - `getGrowthRate:` to retrieve the growth rate
  - `getPlantHeight:` to retrieve the plant height
  
- Pesticide
  - `PesticideType pesticideType;`: pesticideType variable of enum type PesticideType 
  - `Bug bug;`: bug variable of enum Bug type Bug
  - `Pesticide(Bug var1)`: Pesticide constructor
  
  - `void choosePesticide(Bug var1)`: ChoosePesticide constructor, case-switch method of choosing pesticide
  - `void spreadPesticide()`: spreadPesticide constructor

- PesticideType
  - `enum PesticideType {
    `insectSoap,
    `hotPepperBugRepellent,
    `rubbingAlcoholBugSpray;`: declared constants of enum PesticideType
    
  - `private PesticideType()`: PesticideType constructor

- Watering
  -  `private double width;`: declaration of width variable of type double
  -  `private double length;`: declaration of length variable of type double
  -  `private double gallons;`: declaration of gallons variable of type double
  -  `private double hours;`: declaration of hours variable of type double
  -  `private double emitter;`: declaration of emitter variable of type double
  
  - `setWidth:` to set the width of the garden size 
  - `setLength:` to set the length of the garden size
  - `setGallons:` to set the number of gallons of water
  - `setHours:` to set the number of hours for watering
  - `setEmitter`: to set the number of emitters that will determine the rate of water (Gallons per Hour)`
  - `getWidth`: to get the width of the garden
  - `getLength`: to get the length of the garden
  - `getGallons`: to get the number of gallons you use to water your garden
  - `getHours`: to get the number of hours you spent gardening
  - `getEmitter`: to get the number of emitters(which shoot the water) to determing the rate of gallons per hour
  - `getArea`: to get the area(length * width) of the garden size`
  
- Logging
  - All the logs are recorded in `GardenLog.log`
  - This helper class can be accessed through singleton for global usage: </br>
    ```java
    private static Logging logger = Logging.getInstance();
    logger.log(<your logging message here>)
    ```
