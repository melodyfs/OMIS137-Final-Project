import java.util.ArrayList;

public class Bug {
    protected BugType type;
    protected PlantType whichPlantEats;
    protected double destructionRate;

    public Bug(BugType t, PlantType w, double d) {
        type = t;
        whichPlantEats = w;
        destructionRate = d;
    }

    BugType getType() {
        return type;
    }

    PlantType getWhichPlantEats() {
        return whichPlantEats;
    }

    double getDestructionRate() {
        return destructionRate;
    }
}
    class Aphid extends Bug{
        Aphid(){
            super(BugType.aphid, PlantType.strawberry, 0.001); //picked a plant for each bug to eat and made destruction rate
            }} //to be 1/10 of growth rate ie. if more than of type of bug than neg growth

    class Caterpillar extends Bug {
        public Caterpillar(){
            super(BugType.caterpillar, PlantType.basil, 0.000625); }}

    class Mite extends Bug{
        Mite(){
            super(BugType.mite, PlantType.sunflower,0.0075); }}

    class Ants extends Bug{
        Ants(){
            super(BugType.ants, PlantType.rose, 0.001); }}

    class Whiteflies extends Bug{
        Whiteflies(){
            super(BugType.whiteflies, PlantType.daisy, 0.002); }}

    class mealyBug extends Bug{
        mealyBug(){
            super(BugType.mealyBug, PlantType.cucumber, 0.004); }}

    class Thrips extends Bug{
        Thrips(){
            super(BugType.thrips, PlantType.tomato, 0.0175); }}


enum BugType {
    aphid,
    caterpillar,
    mite,

    ants,
    whiteflies,

    mealyBug,
    thrips,
    none
}