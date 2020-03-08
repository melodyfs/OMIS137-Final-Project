public class Pesticide {

    PesticideType pesticideType;
    Bug bug;

    Pesticide(Bug bug) {
        this.bug = bug;
    }
    public static void main(String args[]) {
        // testing bug. Remove it 
        Bug bug = new Bug();
        bug.updateBugInfo("testing bug", BugType.whiteflies);

        Pesticide pesticide = new Pesticide(bug);
        pesticide.choosePesticide(bug);
        pesticide.spreadPesticide();
    }

    void choosePesticide(Bug bug) {
        switch (bug.type) {
            case aphid: case caterpillar: case mite:
                pesticideType = PesticideType.insectSoap;
                break;
            case ants: case whiteflies:
                pesticideType = PesticideType.hotPepperBugRepellent;
                break;
            default:
                pesticideType = PesticideType.rubbingAlcoholBugSpray;
        }

       // log: "Pesticide of type " + pesticideType.name() + " was chosen"
    }

    void spreadPesticide() {
        // log: "Spreading pesticide of type " + pesticideType.name() + "..."
        // log: bug.name + " is killed."
        bug = null;
    }
}

enum PesticideType {
    insectSoap,
    hotPepperBugRepellent,
    rubbingAlcoholBugSpray
}