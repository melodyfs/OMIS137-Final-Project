import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class garden {
    static int dayNum = 0;

    public int dayGetter() {
        return dayNum;
    }

    void dayAdder() {
        dayNum++;
    }

    ArrayList<Caterpillar> caterpillars = new ArrayList(); //create caterpillar ArrayList
    ArrayList<Ants> ants = new ArrayList();
    ArrayList<Aphid> aphid = new ArrayList();
    ArrayList<mealyBug> mealyBugs = new ArrayList();
    ArrayList<Mite> mites = new ArrayList();
    ArrayList<Thrips> thrips = new ArrayList();
    ArrayList<Whiteflies> whiteflies = new ArrayList();

    ArrayList<Plant> roses = new ArrayList();
    ArrayList<Plant> daisies = new ArrayList();
    ArrayList<Plant> sunflowers = new ArrayList();
    ArrayList<Plant> tomatoes = new ArrayList();
    ArrayList<Plant> basilList = new ArrayList();
    ArrayList<Plant> cucumbers = new ArrayList();
    ArrayList<Plant> strawberries = new ArrayList();

    public void caterpillarAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ caterpillars.add(new Caterpillar()); }}
    public void antsAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ ants.add(new Ants()); }}

    public void hotPepperTest(boolean hotPepperUsed){ //just an idea, not sure how melody wants
        if (hotPepperUsed){
            int numAnts = ants.size();
            for (int i=0; i<numAnts/2; i++){
                ants.remove(i);
            }
            int numRoses=roses.size(); //reduce plant growth by 10% everytime pesticides used
            for (int i=0; i<numRoses; i++){
                Rose rose = (Rose) roses.get(i);
                rose.setGrowthRate(rose.getGrowthRate()*0.9);
            }
        }
    }

    public void roseAdder(int numToAdd){for (int i=0; i<numToAdd; i++){roses.add(new Rose());}}
    public void daisyAdder(int numToAdd){for (int i=0; i<numToAdd; i++){daisies.add(new Daisy());}}


    public void updatePlantGrowth(){
        int numCaterpillars=caterpillars.size();
        caterpillarsEating(numCaterpillars);
        int numAnts=ants.size();
        antsEating(numAnts);
    }

    public void caterpillarsEating(int numCaterpillars){ //this takes input from above method on num caterpillars and adjusts growth rate per num
        int numBasil = basilList.size();
        for (int i = 0; i<numBasil; i++){
            Basil basil = (Basil) basilList.get(i);
            basil.setGrowthRate(basil.getGrowthRate()-(numCaterpillars*caterpillars.get(0).getDestructionRate()));
        }
    }

    public void aphidsEating(int numAphids){ //this takes input from above method on num caterpillars and adjusts growth rate per num
        int numStraw = strawberries.size();
        for (int i = 0; i<numStraw; i++){
            Strawberry straw = (Strawberry) strawberries.get(i);
            basil.setGrowthRate(basil.getGrowthRate()-(numCaterpillars*caterpillars.get(0).getDestructionRate()));
        }
    }
    public void antsEating(int numAnts){
        int numRoses = roses.size();
        for (int i=0; i<numRoses; i++){
            Rose rose = (Rose) roses.get(i);
            rose.setGrowthRate(rose.getGrowthRate()-(numAnts*ants.get(0).getDestructionRate()));
        }
    }





public static void main(String[] args){

    Caterpillar cat = new Caterpillar();
        System.out.println(cat.getDestructionRate());
}
}