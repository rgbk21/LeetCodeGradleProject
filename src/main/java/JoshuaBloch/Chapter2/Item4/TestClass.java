package JoshuaBloch.Chapter2.Item4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        double val = Math.log10(100);
        List<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob"));
        String firstName = UtilityClass.extractFirstName("Alice Doe");
        System.out.println("First Name: " + firstName); // Alice
    }
}
