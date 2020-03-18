import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Garden {

    ArrayList<Caterpillar> caterpillars = new ArrayList(); //create caterpillar ArrayList
    ArrayList<Ants> ants = new ArrayList();
    ArrayList<Aphid> aphids = new ArrayList();
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

    //master classes needed - plant grower, pesticide for bug killing and plant hurting
    //bug breeder done, bug eater done, initial bug creator, initial plant maker

    //MASTER METHODS THAT SHOULD BE USED IN SIMULATION MAIN CLASS

    void dayAdder() { //increment each day, and set isWeek to true if it has been a week
        dayNum++;
        dayPerWeek++;
        if (dayPerWeek ==7){
            isWeek=true;
            dayPerWeek = 0;
        }
        else {isWeek=false;}
    }

    public void initialBugMaker(int userChoice){ //take how many bugs the user wants and create that many bugs, randomized 
        for (int i=0; i<userChoice; i++){
            switch (randomNum()){
                case 1: caterpillarAdder(1); break;
                case 2: antsAdder(1); break;
                case 3: aphidAdder(1); break;
                case 4: mealyBugAdder(1); break;
                case 5: miteAdder(1); break;
                case 6: thripAdder(1); break;
                case 7: whiteflyAdder(1); break;
            }
        }
    }
    
    public void initialPlantMaker(int userChoice){ //take how many plants the user wants and create that many plants, randomized 
        for (int i=0; i<userChoice; i++){
            switch (randomNum()){
                case 1: roseAdder(1); break;
                case 2: daisyAdder(1); break;
                case 3: sunflowerAdder(1); break;
                case 4: tomatoAdder(1); break;
                case 5: basilAdder(1); break;
                case 6: cucumberAdder(1); break;
                case 7: strawberryAdder(1); break;
            }
        }
    }
    
    public void masterPlantReset(){ //this needs to be first when running, sets plant growth to original levels before bugs and presticides act on
        int numRoses=roses.size();
        roseReset(numRoses);
        int numDaisies=daisies.size();
        daisyReset(numDaisies);
        int numSunflowers=sunflowers.size();
        sunflowerReset(numSunflowers);
        int numTomatoes = tomatoes.size();
        tomatoReset(numTomatoes);
        int numBasil=basilList.size();
        basilReset(numBasil);
        int numCucumbers=cucumbers.size();
        cucumberReset(numCucumbers);
        int numStrawberries=strawberries.size();
        strawberryReset(numStrawberries);
    }

    public void masterBugBreeder(){ //only breed once a week.  Each pair of bugs breeds one offspring
        if (isWeek){
            int halfCaterpillars = caterpillars.size()/2;
            caterpillarAdder(halfCaterpillars);
            int halfAnts = ants.size()/2;
            antsAdder(halfAnts);
            int halfAphids = aphids.size()/2;
            aphidAdder(halfAphids);
            int halfMealyBugs = mealyBugs.size()/2;
            mealyBugAdder(halfMealyBugs);
            int halfMites = mites.size()/2;
            miteAdder(halfMites);
            int halfThrips = thrips.size()/2;
            thripAdder(halfThrips);
            int halfWhiteflies = whiteflies.size()/2;
            whiteflyAdder(halfWhiteflies);
        }
    }

    public void masterBugsEating(){ //find number of bug, pass it to each eating function which affects plant's growth
        int numCaterpillars = caterpillars.size();
        if (numCaterpillars > 0) {
            caterpillarsEating(numCaterpillars);
        }
        int numAphids = aphids.size();
        if (numAphids > 0) {
            aphidsEating(numAphids);
        }
        int numMites = mites.size();
        if (numMites > 0) {
            mitesEating(numMites);
        }
        int numWhiteflies = whiteflies.size();
        if (numWhiteflies > 0) {
            whitefliesEating(numWhiteflies);
        }
        int numMealyBugs = mealyBugs.size();
        if (numMealyBugs > 0) {
            mealyBugsEating(numMealyBugs);
        }
        int numThrips = thrips.size();
        if (numThrips > 0) {
            thripsEating(numThrips);
        }
        int numAnts = ants.size();
        if (numAnts > 0) {
            antsEating(numAnts);
        }
    }
    
    public void masterPesttoPlant(boolean hotPepperUsed, boolean insectSoapUsed, boolean rubAlcUsed){
        pestOnRoses(hotPepperUsed);
        pestOnDaisies(hotPepperUsed);
        pestOnSunflowers(insectSoapUsed);
        pestOnTomatoes(rubAlcUsed);
        pestOnBasil(insectSoapUsed);
        pestOnCucumbers(rubAlcUsed);
        pestOnStrawberries(insectSoapUsed);
    }
    
    public void growPlants(){
        int numRoses=roses.size();
        growRoses(numRoses);
        int numDaisies=daisies.size();
        growDaisies(numDaisies);
        int numSunflowers=sunflowers.size();
        growSunflowers(numSunflowers);
        int numTomatoes=tomatoes.size();
        growTomatoes(numTomatoes);
        int numBasil=basilList.size();
        growBasil(numBasil);
        int numCucumbers=cucumbers.size();
        growCucumbers(numCucumbers);
        int numStrawberries=strawberries.size();
        growStrawberries(numStrawberries);
    }

    public void masterBugKiller(boolean hotPepperUsed, boolean insectSoapUsed, boolean rubAlcUsed){
        killCaterpillars(insectSoapUsed);
        killAphids( insectSoapUsed);
        killMites(insectSoapUsed);
        killWhiteflies(hotPepperUsed);
        killMealyBugs(rubAlcUsed);
        killThrips(rubAlcUsed);
        killAnts(hotPepperUsed);
    }
    
    public int randomNum(){ //random number generator of 1-7, used in making random bugs and plannts
        int randomNum = ThreadLocalRandom.current().nextInt(1, 7);
        return randomNum;
    }

    //OTHER METHODS THAT THE MASTER ONES USE

    //Pesticides killing bugs
    public void killCaterpillars(boolean insectSoapUsed){
        if (insectSoapUsed){
            int halfCaterpillars=caterpillars.size()/2;
            for(int i=0; i<halfCaterpillars;i++){
                caterpillars.remove(i);
            }
        }
    }

    public void killAphids(boolean insectSoapUsed){
        if (insectSoapUsed){
            int halfAphids=aphids.size()/2;
            for(int i=0; i<halfAphids;i++){
                aphids.remove(i);   
             }
        }}
    public void killMites(boolean insectSoapUsed){
        if (insectSoapUsed){
            int halfMites=mites.size()/2;
            for(int i=0; i<halfMites;i++){
                mites.remove(i);   
             }
        }}
    public void killWhiteflies(boolean hotPepperUsed){
        if (hotPepperUsed){
            int halfWhiteflies=whiteflies.size()/2;
            for(int i=0; i<halfWhiteflies;i++){
                whiteflies.remove(i);   
             }
        }

    }
    public void killMealyBugs(boolean rubAlcUsed){
        if (rubAlcUsed){
            int halfMealyBugs = mealyBugs.size()/2;
            for (int i=0; i<halfMealyBugs; i++){
                mealyBugs.remove(i);
            }
        }
    }
    public void killThrips(boolean rubAlcUsed){
        if (rubAlcUsed){
            int halfThrips = thrips.size()/2;
            for (int i=0; i<halfThrips; i++){
                thrips.remove(i);
            }
        }
    }
    public void killAnts(boolean hotPepperUsed){
        if (hotPepperUsed){
            int halfAnts=ants.size()/2;
            for (int i=0; i<halfAnts; i++){
                ants.remove(i);
            }
        }
    }


    //Bugs eating plants - if I do pesticides first and set those to original don't need to change growth rates
    public void caterpillarsEating(int numCaterpillars){ //need to fix growth rate to start at base level
        int numBasil = basilList.size();
        if (numBasil == 0) {
            return;
        }
        for (int i = 0; i<numBasil; i++){
            Basil basil = (Basil) basilList.get(i);
            basil.setGrowthRate(basil.getGrowthRate()-(numCaterpillars*caterpillars.get(0).getDestructionRate())); 
        }
    }
    public void aphidsEating(int numAphids){
        int numStraw = strawberries.size();
        if (numStraw == 0) {
            return;
        }
        for (int i = 0; i<numStraw; i++){
            Strawberry strawberry = (Strawberry) strawberries.get(i);
            strawberry.setGrowthRate(strawberry.getGrowthRate()-(numAphids*aphids.get(0).getDestructionRate()));
        }
    }
    public void mitesEating(int numMites){
        int numSunflowers = sunflowers.size();
        if (numSunflowers == 0) {
            return;
        }
        for (int i = 0; i<numSunflowers; i++){
            Sunflower sunflower = (Sunflower) sunflowers.get(i);
            sunflower.setGrowthRate(sunflower.getGrowthRate()-(numMites*mites.get(0).getDestructionRate()));
        }
    }
    public void whitefliesEating(int numWhiteflies){
        int numDaisies = daisies.size();
        if (numDaisies == 0) {
            return;
        }
        for (int i = 0; i<numDaisies; i++){
            Daisy daisy = (Daisy) daisies.get(i);
            daisy.setGrowthRate(daisy.getGrowthRate()-(numWhiteflies*whiteflies.get(0).getDestructionRate()));
        }
    }
    public void mealyBugsEating(int numMealyBugs){
        int numCucumbers = cucumbers.size();
        if (numCucumbers == 0) {
            return;
        }
        for (int i = 0; i<numCucumbers; i++){
            Cucumber cucumber = (Cucumber) cucumbers.get(i);
            cucumber.setGrowthRate(cucumber.getGrowthRate()-(numMealyBugs*mealyBugs.get(0).getDestructionRate()));
        }
    }
    public void thripsEating(int numThrips){
        int numTomatoes = tomatoes.size();
        if (numTomatoes == 0) {
            return;
        }
        for (int i = 0; i<numTomatoes; i++){
            Tomato tomato = (Tomato) tomatoes.get(i);
            tomato.setGrowthRate(tomato.getGrowthRate()-(numThrips*thrips.get(0).getDestructionRate()));
        }
    }
    public void antsEating(int numAnts){
        int numRoses = roses.size();
        if (numRoses == 0) {
            return;
        }
        for (int i=0; i<numRoses; i++){
            Rose rose = (Rose) roses.get(i);
            rose.setGrowthRate(rose.getGrowthRate()-(numAnts*ants.get(0).getDestructionRate()));
        }
    }
    
    //Bugs being made
    public void caterpillarAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ caterpillars.add(new Caterpillar()); }}
    public void antsAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ ants.add(new Ants()); }}
    public void aphidAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ aphids.add(new Aphid()); }}
    public void mealyBugAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ mealyBugs.add(new mealyBug()); }}
    public void miteAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ mites.add(new Mite()); }}
    public void thripAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ thrips.add(new Thrips()); }}
    public void whiteflyAdder(int numToAdd) { for (int i=0; i<numToAdd; i++){ whiteflies.add(new Whiteflies()); }}
    
    //Plants being made 
    public void roseAdder(int numToAdd){for (int i=0; i<numToAdd; i++){roses.add(new Rose());}}
    public void daisyAdder(int numToAdd){for (int i=0; i<numToAdd; i++){daisies.add(new Daisy());}}
    public void sunflowerAdder(int numToAdd){for (int i=0; i<numToAdd; i++){sunflowers.add(new Sunflower());}}
    public void tomatoAdder(int numToAdd){for (int i=0; i<numToAdd; i++){tomatoes.add(new Tomato());}}
    public void basilAdder(int numToAdd){for (int i=0; i<numToAdd; i++){basilList.add(new Basil());}}
    public void cucumberAdder(int numToAdd){for (int i=0; i<numToAdd; i++){cucumbers.add(new Cucumber());}}
    public void strawberryAdder(int numToAdd){for (int i=0; i<numToAdd; i++){strawberries.add(new Strawberry());}}
    
    //set plants to original growth value each day, so that pesticides and bugs can affect after.  needs to be first
    public void roseReset(int numRoses){
            for (int i =0; i<numRoses; i++){
                Rose rose = (Rose) roses.get(i);
                rose.setGrowthRate(0.01);
        }
    }
    public void daisyReset(int numDaisies){
            for (int i =0; i<numDaisies; i++){
                Daisy daisy = (Daisy) daisies.get(i);
                daisy.setGrowthRate(0.02);
            }
    }
    public void sunflowerReset(int NumSunflowers){
            for (int i =0; i<NumSunflowers; i++){
                Sunflower sunflower = (Sunflower) sunflowers.get(i);
                sunflower.setGrowthRate(0.075);
            }
    }
    public void tomatoReset(int numTomatoes){
            for (int i =0; i<numTomatoes; i++){
                Tomato tomato = (Tomato) tomatoes.get(i);
                tomato.setGrowthRate(0.175);
            }
    }
    public void basilReset(int numBasil){
        for (int i =0; i<numBasil; i++){
            Basil basil = (Basil) basilList.get(i);
            basil.setGrowthRate(0.0125);
        }
    }
    public void cucumberReset(int numCucumbers){
        for (int i =0; i<numCucumbers; i++){
            Cucumber cucumber = (Cucumber) cucumbers.get(i);
            cucumber.setGrowthRate(0.04);
        }
    }
    public void strawberryReset(int numStrawberries){
        for (int i =0; i<numStrawberries; i++){
            Strawberry strawberry = (Strawberry) strawberries.get(i);
            strawberry.setGrowthRate(0.02);
        }
    }


    //Affect plant growth rate with pesticides
    public void pestOnRoses(boolean hotPepperUsed){
        if (hotPepperUsed){
            int numRoses = roses.size();
            for (int i =0; i<numRoses; i++){
                Rose rose = (Rose) roses.get(i);
                rose.setGrowthRate(rose.getGrowthRate()*0.9);
            }
        }
    }
    public void pestOnDaisies(boolean hotPepperUsed){
        if (hotPepperUsed){
            int numDaisies = daisies.size();
            for (int i =0; i<numDaisies; i++){
                Daisy daisy = (Daisy) daisies.get(i);
                daisy.setGrowthRate(daisy.getGrowthRate()*0.9);
            }
        }
    }
    public void pestOnSunflowers(boolean insectSoapUsed){
        if (insectSoapUsed){
            int numSunflowers = sunflowers.size();
            for (int i =0; i<numSunflowers; i++){
                Sunflower sunflower = (Sunflower) sunflowers.get(i);
                sunflower.setGrowthRate(sunflower.getGrowthRate()*0.9);
            }
        }
    }
    public void pestOnTomatoes(boolean rubAlcUsed){
        if (rubAlcUsed){
            int numTomatoes = tomatoes.size();
            for (int i =0; i<numTomatoes; i++){
                Tomato tomato = (Tomato) tomatoes.get(i);
                tomato.setGrowthRate(tomato.getGrowthRate()*0.9);
            }
        }
    }
    public void pestOnBasil(boolean insectSoapUsed){
        if (insectSoapUsed){
            int numBasil = basilList.size();
            for (int i =0; i<numBasil; i++){
                Basil basil = (Basil) basilList.get(i);
                basil.setGrowthRate(basil.getGrowthRate()*0.9);
            }
        }
    }
    public void pestOnCucumbers(boolean rubAlcUsed){
        if (rubAlcUsed){
            int numCucumbers = cucumbers.size();
            for (int i =0; i<numCucumbers; i++){
                Cucumber cucumber = (Cucumber) cucumbers.get(i);
                cucumber.setGrowthRate(cucumber.getGrowthRate()*0.9);
            }
        }
    }
    public void pestOnStrawberries(boolean insectSoapUsed){
        if (insectSoapUsed){
            int numStrawberries = strawberries.size();
            for (int i =0; i<numStrawberries; i++){
                Strawberry strawberry = (Strawberry) strawberries.get(i);
                strawberry.setGrowthRate(strawberry.getGrowthRate()*0.9);
            }
        }
    }

    //Grow plants each day, this should be last function after growth rate has been affected
    public void growRoses(int numRoses){
        for (int i=0; i<numRoses; i++){
            Rose rose = (Rose) roses.get(i);
            rose.setHeight(rose.getHeight()+rose.getGrowthRate()); //add current height with growth rate
        }
    }
    public void growDaisies(int numDaisies){
        for (int i=0; i<numDaisies; i++){
            Daisy daisy = (Daisy) daisies.get(i);
            daisy.setHeight(daisy.getHeight()+daisy.getGrowthRate()); //add current height with growth rate
        }
    }
    public void growSunflowers(int numSunflowers){
        for (int i=0; i<numSunflowers; i++){
            Sunflower sunflower = (Sunflower) sunflowers.get(i);
            sunflower.setHeight(sunflower.getHeight()+sunflower.getGrowthRate()); //add current height with growth rate
        }
    }
    public void growTomatoes(int numTomatoes){
        for (int i=0; i<numTomatoes; i++){
            Tomato tomato = (Tomato) tomatoes.get(i);
            tomato.setHeight(tomato.getHeight()+tomato.getGrowthRate()); //add current height with growth rate
        }
    }
    public void growBasil(int numBasil){
        for (int i=0; i<numBasil; i++){
            Basil basil = (Basil) basilList.get(i);
            basil.setHeight(basil.getHeight()+basil.getGrowthRate()); //add current height with growth rate
        }
    }
    public void growCucumbers(int numCucumbers){
        for (int i=0; i<numCucumbers; i++){
            Cucumber cucumber = (Cucumber) cucumbers.get(i);
            cucumber.setHeight(cucumber.getHeight()+cucumber.getGrowthRate()); //add current height with growth rate
        }
    }
    public void growStrawberries(int numStrawberries){
        for (int i=0; i<numStrawberries; i++){
            Strawberry strawberry = (Strawberry) strawberries.get(i);
            strawberry.setHeight(strawberry.getHeight()+strawberry.getGrowthRate()); //add current height with growth rate
        }
    }

    static int dayNum = 0;
    static int dayPerWeek = 0;
    static boolean isWeek=false;

    public int dayGetter() {
        return dayNum;
    }
}
