package Generics.RecursiveGenerics.Attempt2;

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

        // But note that now we are able to compare an Apple to an Orange
        // Which is not what we want
        System.out.println(orange1.compareTo(apple1)); // Prints: -1
    }
}
