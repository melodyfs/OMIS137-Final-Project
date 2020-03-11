# Computerized Garden

## Usage
- Complile all the modules by running `javac *.java`
- Run the main program with `java Main`

## Documentations
### Objects
- Plant
  - `name`:
    - `String` type
  - `species`
    - `String` type
- Bug
  - `name`:
    - `String` type
    - To record the name of the bug
  - `type`: 
    - `BugType` type
    - To record the type of the bug
- BugType
  - `enum` type
- Soil
  - `nutrientLevel`
    - `NutrientLevel` type
    - Recod the level of nutrient in the soil
  - `setNutrientLevel(NutrientLevel nutrientLevel)`
    - Update `nutrientLevel`
  - `getNutrientLevel()`
    - To retrieve `nutrientLevel`
- NutrientLevel
  - `enum` type
  - Levels of nutrient are assigned an `int` value. 0 means the lowest level; 5 is the highest.
  

### Classes
- Main
- Growth
- Fertilizer 
- Pesticide
- Watering
- Logging
  - All the logs are recorded in `GardenLog.log`
  - This helper class can be access through singleton for global usage: </br>
    ```java
    private static Logging logger = Logging.getInstance();
    logger.log(<your logging message here>)
    ```
