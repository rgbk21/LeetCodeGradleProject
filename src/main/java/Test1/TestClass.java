package Test1;

public class TestClass {

    public static void main(String[] args) {

        /*
        - A contrived example to show that you can reference interfaces inside other interfaces directly
            by using the dot operator.
         */

        InterfaceA.InterfaceB myInterface = InterfaceA.getInterfaceB();
    }
}
