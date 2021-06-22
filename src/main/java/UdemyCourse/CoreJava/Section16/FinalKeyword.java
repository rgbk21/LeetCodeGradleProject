package UdemyCourse.CoreJava.Section16;

public class FinalKeyword {

    private final String ALPHA = "A";
    private final String BETA;
    private static final String GAMMA; // has to be declared static because this is being set in a static block

    FinalKeyword() {
        BETA = "B";
    }

    static {
        GAMMA = "C";
    }

    public static void main(String[] args) {
        // declaration of final variable and assigning it a value can be done in separate steps
        final String DELTA;
        DELTA = "D";
    }
}

