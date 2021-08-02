package JoshuaBloch.Chapter2.Item3.enumType;

// This is basically a Singleton
// But how does this work?
public enum Elvis {

    // Some constant has to be the very first thing in an Enum.
    // Removing this is a compile error.
    INSTANCE;

    private final String name = "Elvis";
    private final int age = 32;
    public void doSomething() {
        System.out.println("Doing something in the method");
    }
}

class TestClass {
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        // We can call methods on the object as follows:
        elvis.doSomething();
        // Or we can also do this. Both will work
        Elvis.INSTANCE.doSomething();

        String enumName = elvis.name(); // This is accessing the name() method, and not the 'name' field
        System.out.println("Enum name is: " + enumName); // Enum name is: INSTANCE
        // private variables cannot be accessed. As expected.
        // Nothing funny going on over here.
//        System.out.println("Enum age is: " + elvis.age);
    }
}