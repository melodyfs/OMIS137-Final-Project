
public class Fertilizer {

    NutrientLevel nutrientLevel = NutrientLevel.citical;
    private static Logging logger = Logging.getInstance();

    Fertilizer(NutrientLevel nutrientLevel) {
        this.nutrientLevel = nutrientLevel;
    }

    public static void main(String args[]) {
        Fertilizer fertilizer = new Fertilizer(NutrientLevel.citical);
        logger.log("A new fertilizer is created with the nutrient level of " + fertilizer.nutrientLevel.name());
    }

    NutrientLevel getFertilizerNutrientLevel() {
        logger.log("Viewing current nutrient level of the fertilizer. It is " + nutrientLevel.name());
        return nutrientLevel;
    }

    void updateNutrientLevelTo(NutrientLevel newLevel) {
        nutrientLevel = newLevel;
        logger.log("Nutrient level of the fertilizer is updated to " + nutrientLevel.name());
    }

    void spreadFertilizerOn(Soil soil) {
        logger.log("The nutrient level of current soil is now " + nutrientLevel.name());
        if (soil.nutrientLevel.getLevelValue() < nutrientLevel.getLevelValue()) {
            soil.nutrientLevel = nutrientLevel;
            return;
        }

        if (soil.nutrientLevel.getLevelValue() == nutrientLevel.getLevelValue()) {
            logger.log("Current soil already has a nutrient level of " + nutrientLevel.name() + ". Consider upgrading the nutrient level of the fertilizer if necessary.")
            return;
        }
        
        if (soil.nutrientLevel.getLevelValue() > nutrientLevel.getLevelValue()) {
            logger.log("Current soil has a nutrient level of " + nutrientLevel.name() + ", which is higher than the current nutrient level of the fertilizer. Consider upgrading the nutrient level of the fertilizer if necessary.");
            return;
        }
        
    }


}



