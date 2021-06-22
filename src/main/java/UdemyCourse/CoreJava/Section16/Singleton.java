package UdemyCourse.CoreJava.Section16;

public class Singleton {

    private String name;
    private int value;
    private static Singleton instance;

    private Singleton() {
        name = "Singleton Class";
        value = 0;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonTest {

    public static void main(String[] args) {

        Singleton item1 = Singleton.getInstance();
        Singleton item2 = Singleton.getInstance();
        Singleton item3 = Singleton.getInstance();

        if (item1 == item2 && item2 == item3) {
            System.out.println("Same instances"); // This IS printed
        }
    }
}
