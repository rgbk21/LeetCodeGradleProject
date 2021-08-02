package Generics.RecursiveGenerics.Attempt1;

public class TestClass {

    public static void main(String[] args) {

        // Now we can compare two apples
        Apple apple1 = new Apple(10);
        Apple apple2 = new Apple(12);
        System.out.println(apple1.compareTo(apple2)); // Prints: -1

        // And we can compare two oranges
        Orange orange1 = new Orange(5);
        Orange orange2 = new Orange(3);
        System.out.println(orange1.compareTo(orange2)); // Prints: 1

        // But also note that we DO NOT want to be able to compare an apple to an orange
        // which is what we see over here. Comparing an apple to an orange produces a compile error.
//        orange1.compareTo(apple1); // Compile Error Required type: Orange Provided: Apple
//        System.out.println(apple1.compareTo(orange1)); // Required type: Apple Provided: Orange
    }
}
