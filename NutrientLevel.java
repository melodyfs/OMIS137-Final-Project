public enum NutrientLevel {
    citical(0),
    sufficient(1),
    belowOptimum(2),
    aboveOptimum(3),
    luxurious(4),
    toxic(5);

    private final int level; 

    NutrientLevel(int level) { 
        this.level = level; 
    }  

    public int getLevelValue() { 
        return this.level; 
    } 
}