package Test1.RandomStuff;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FinalVariablesTest {

    public static void main(String[] args) {
        int[] myArray = new int[]{1, 2, 3, 4, 5};
        editArray(myArray);
        System.out.println(Arrays.toString(myArray));
    }

    static void editArray(final int[] input) {
        input[0] = 10; // Valid to change
//        input = new int[]{10, 2, 3, 4, 5}; // Compile Error: Cannot assign a value to final variable 'input'
    }

    static void editMap(final Map<String, String> input) {
        input.remove("One"); // Valid to change
//        input = new HashMap<>(); // Compile Error: Cannot assign a value to final variable 'input'
    }
}
