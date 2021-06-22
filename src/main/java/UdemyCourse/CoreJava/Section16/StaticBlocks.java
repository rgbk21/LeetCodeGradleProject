package UdemyCourse.CoreJava.Section16;

public class StaticBlocks {

    private static String NAME;

    static {
        System.out.println("Inside Static Block 1: " + NAME);
    }

    public static void main(String[] args) {
        System.out.println("Inside Main Method Block");
    }

    static {
        NAME = "ALICE";
        System.out.println("Inside Static Block 2: " + NAME);
    }
}

// Since this class is never loaded, the static block inside this class is not executed
class Test {
    static {
        System.out.println("Inside Test Class static block");
    }
}

/*
Prints:
Inside Static Block 1: null
Inside Static Block 2: ALICE
Inside Main Method Block
*/
