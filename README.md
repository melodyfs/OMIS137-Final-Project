# Computerized Garden
Group members: Melody Yang, Connor Collins, Robert Mitchell
## Usage
- Compile all the modules by running `javac *.java`
- Run the main program with `java GardenSimulation`

## Documentations
### Objects
- Plant
- Bug (BugType
- BugType
  - `enum` type
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
