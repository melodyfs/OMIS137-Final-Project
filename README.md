# Computerized Garden
Group members: Melody Yang, Connor Collins, Robert Mitchell
## Usage
- Compile all the modules by running `javac *.java`
- Run the main program with `java GardenSimulation`

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
  - `initUI`: 

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
