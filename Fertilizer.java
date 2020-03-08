
public class Fertilizer {

    NutrientLevel nutrientLevel = NutrientLevel.citical;

    Fertilizer(NutrientLevel nutrientLevel) {
        this.nutrientLevel = nutrientLevel;
    }

    public static void main(String args[]) {
        Fertilizer fertilizer = new Fertilizer(NutrientLevel.citical);
        // log: "A new fertilizer is created with the nutrient level of " + fertilizer.nutrientLevel.name()
        System.out.println(fertilizer.nutrientLevel.name());
    }

    NutrientLevel getSoilFertilizerLevel(Soil soil) {
        return soil.nutrientLevel;
    }

    NutrientLevel getFertilizerNutrientLevel() {
        //log message: "Viewing current nutrient level of the fertilizer. It is " + nutrientLevel.name()
        return nutrientLevel;
    }

    void updateNutrientLevelTo(NutrientLevel newLevel) {
        nutrientLevel = newLevel;
        //log message: "Nutrient level of the fertilizer is updated to " + nutrientLevel.name()
    }

    void spreadFertilizerOn(Soil soil) {
        //log: "The nutrient level of <soil> is now <nutrientLevel>."
        if (soil.nutrientLevel.getLevelValue() < nutrientLevel.getLevelValue()) {
            soil.nutrientLevel = nutrientLevel;
            return;
        }

        if (soil.nutrientLevel.getLevelValue() == nutrientLevel.getLevelValue()) {
            //log: "<soil> already has a nutrient level of <nutrientLevel>. Consider upgrading the nutrient level of the fertilizer if necessary."
            return;
        }
        
        if (soil.nutrientLevel.getLevelValue() > nutrientLevel.getLevelValue()) {
            //log: "<soil> has a nutrient level of <nutrientLevel>, which is higher than the current nutrient level of the fertilizer . 
            // Consider upgrading the nutrient level of the fertilizer if necessary."
            return;
        }
        
    }


}



