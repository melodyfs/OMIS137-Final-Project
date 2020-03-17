public class Plant {
    protected PlantType plantType;
    protected double Height; //these are all in feet //changed this from start height to height
    protected double maxHeight;
    protected double growthRate;
    protected String color;

    public Plant(PlantType t, double s, double m, double g, String c) {
        plantType=t;
        Height=s;
        maxHeight=m;
        growthRate=g;
        color=c;
    }
    PlantType getPlantType(){return plantType;}
    double getHeight() { return Height; }
    double getMaxHeight() { return maxHeight; }
    double getGrowthRate() { return growthRate; }
    String getColor() { return color; }

    void setGrowthRate(double g){growthRate=g;}
    void setHeight(double h) {Height=h;}
}
class Rose extends Plant{
    Rose(){super(PlantType.rose,1, 5, 0.01, "red");}}

class Daisy extends Plant{
    Daisy(){super(PlantType.daisy, 1, 2.5, 0.02, "yellow");}}

class Sunflower extends Plant{
    Sunflower(){super(PlantType.sunflower,1, 10, 0.075, "yellow");}}

class Tomato extends Plant{
    Tomato(){super(PlantType.tomato, 1, 8, 0.175, "red");}}

class Basil extends Plant{
    Basil(){super(PlantType.basil, 0.5, 2, 0.0125, "green");}}

class Cucumber extends Plant{
    Cucumber(){super(PlantType.cucumber, 0.5, 3, 0.04, "green");}}

class Strawberry extends Plant{
    Strawberry(){super(PlantType.strawberry, 0.25, 1, 0.02, "red");}}

    enum PlantType{rose, daisy, sunflower, tomato, basil, cucumber, strawberry}