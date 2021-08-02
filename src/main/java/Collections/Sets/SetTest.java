package Collections.Sets;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Set<String> names = new HashSet<>(Arrays.asList("Alice","Bob","Charlie","Dave"));

        // This method can modify the names set.
        int totalCharsInNames = calculateTotalCharsInSet(names);

        // Now this method will throw a UnsupportedOperationException if the method using this set tries to modify it
        int result = calculateTotalCharsInSet(Collections.unmodifiableSet(names));
    }

    // This method can modify the names set.
    private static int calculateTotalCharsInSet(Set<String> names) {
        int totalChars = 0;
        for (String name : names) {
            totalChars += name.length();
        }

        // Try and Modify the set, because why not
        // Now this throws UnsupportedOperationException
        names.removeIf(name -> name.equals("Bob"));

        return totalChars;
    }
}
