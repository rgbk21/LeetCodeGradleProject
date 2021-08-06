package JoshuaBloch.Chapter2.Item4;

import java.util.*;

public class TestClass {

    public static void main(String[] args) {
        double val = Math.log10(100);
        List<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob"));
        String firstName = UtilityClass.extractFirstName("Alice Doe");
        System.out.println("First Name: " + firstName); // Alice
        String allCaps = "Do, or do not. There is no 'try'";
        System.out.println(allCaps.toUpperCase());

        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new LinkedList<>();
        Queue<String> queue3 = new PriorityQueue<>();

    }
}
