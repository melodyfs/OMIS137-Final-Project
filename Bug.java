public class Bug {
    String name;
    BugType type;

    void updateBugInfo(String name, BugType type) {
        this.name = name;
        this.type = type;
    }
}

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