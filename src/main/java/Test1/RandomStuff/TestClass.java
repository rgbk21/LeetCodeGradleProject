package Test1.RandomStuff;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) {

        /*
        - A contrived example to show that you can reference interfaces inside other interfaces directly
            by using the dot operator.
         */

        InterfaceA.InterfaceB myInterface = InterfaceA.getInterfaceB();

        Thread t1 = new Thread(() -> System.out.println("In Run method"));



        Map<String, Integer> myMap = new HashMap<>();

        myMap.forEach((k, v) -> {
            System.out.println("Key:" + k);
            System.out.println("Value:" + v);
        });
    }
}
