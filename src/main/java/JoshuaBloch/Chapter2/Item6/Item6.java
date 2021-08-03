package JoshuaBloch.Chapter2.Item6;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Item6 {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        int numOfSets = 100;
        int numOfStrsToCreate = 1_000_000;
        long averageTime = 0;

        // Creating Strings using the new() operator
        for (int i = 0; i < numOfSets; i++) {
            Instant start = Instant.now();
            for (int j = 0; j < numOfStrsToCreate; j++) {
                String str = new String("String");
                stringList.add(str);
            /*
            The statement creates a new String instance each time it is executed, and none of those object creations is necessary.
            The argument to the String constructor ("String") is itself a String instance,
            functionally identical to all of the objects created by the constructor.
            If this usage occurs in a loop or in a frequently invoked method, millions of String instances can be created needlessly.
            */
            }
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toNanos();
            System.out.println("Total Time taken: " + timeElapsed); // Total Time taken: 45_655_789
            averageTime = averageTime + (timeElapsed);
        }

        // Prevents VM from optimizing away everything.
        // https://stackoverflow.com/a/53683915/8742428
        if (!stringList.isEmpty()) {
            System.out.println("Average time calculated: " + (averageTime / numOfSets));
            System.out.println("\nStarting Experiment 2");
        }

        // Resetting stringList
        stringList.clear();
        averageTime = 0;
        System.out.println("Size: " + stringList.size()); // Size of list becomes 0 after calling clear() on it.

        // Creating the strings using the String Literal
        for (int i = 0; i < numOfSets; i++) {
            Instant start = Instant.now();
            for (int j = 0; j < numOfStrsToCreate; j++) {
                String str = "String";
                stringList.add(str);
            /*
            This version uses a single String instance, rather than creating a new one each time it is executed.
            Furthermore, it is guaranteed that the object will be reused by any other code running in the same virtual machine
            that happens to contain the same string literal
            */
            }
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toNanos();
            System.out.println("Total Time taken: " + timeElapsed); // Total Time taken: 12_182_231
            averageTime = averageTime + (timeElapsed);
        }

        if (!stringList.isEmpty()) {
            System.out.println("Average time calculated: " + (averageTime / numOfSets));
            System.out.println("\nStarting Experiment 2");
        }
    }
}
