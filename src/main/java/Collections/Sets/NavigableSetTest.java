package Collections.Sets;

import java.util.*;

public class NavigableSetTest {

    public static void main(String[] args) {

        // *********************************************************************************
        // Create a NavigableSet and add some strings to it
        // *********************************************************************************
        // Note that the creation of the NavigableSet is done using the TreeSet
        // which is also the implementation that we used for SortedSet interface
        NavigableSet<String> namesSet = new TreeSet<>(Arrays.asList("Bob","Alice","Charlie","Dave"));
        System.out.println("In normal order: " + namesSet); // [Alice, Bob, Charlie, Dave]

        // *********************************************************************************
        // Get a reverse view of the Navigable Set
        // *********************************************************************************
        NavigableSet<String> namesInReverseOrder = namesSet.descendingSet();
        System.out.println("In reverse order: " + namesInReverseOrder); // [Dave, Charlie, Bob, Alice]

        // *********************************************************************************
        // Get and print a subset of the NavigableSet
        // *********************************************************************************
        // The second args lets you decide whether you want to include the element at the boundary
        NavigableSet<String> namesGreaterThanBIncl = namesSet.tailSet("Bob", true);
        System.out.println("Names greater than B: " + namesGreaterThanBIncl); // [Bob, Charlie, Dave]

        NavigableSet<String> namesGreaterThanBExcl = namesSet.tailSet("Bob", false);
        System.out.println("Names greater than B: " + namesGreaterThanBExcl); // [Charlie, Dave]

        // *********************************************************************************
        // lower, floor, higher, ceiling
        // *********************************************************************************

        // These methods return null if no such element is found
        // The lower() method returns the greatest element in the NavigableSet that is less than the specified element.
        // Note that the passed in args need not necessarily be IN the set
        System.out.println("lower(Charlie): " + namesSet.lower("Charlie")); // Bob
        System.out.println("lower(Chxxx): " + namesSet.lower("Chxxx")); // Charlie

        // The floor() method is similar to the lower() method that returns the greatest element in the
        // NavigableSet that is less than or equal to the specified element.
        System.out.println("floor(Charlie): " + namesSet.floor("Charlie")); // Charlie
        System.out.println("floor(Chxxx): " + namesSet.floor("Chxxx")); // Charlie

        // The higher() method returns the least element in the NavigableSet that is greater than the specified element.
        System.out.println("higher(Charlie): " + namesSet.higher("Charlie")); // Dave
        System.out.println("higher(Ch): " + namesSet.higher("Ch")); // Charlie

        // The ceiling() method is similar to the higher() method that returns the least element in the
        // NavigableSet that is greater than or equal to a specified element.
        System.out.println("ceiling(Charlie): " + namesSet.ceiling("Charlie")); // Charlie
        System.out.println("ceiling(Chxxx): " + namesSet.ceiling("Chxxx")); // Dave

        // *********************************************************************************
        // poll ing the NavigableSet in order to remove elements from the different positions
        // *********************************************************************************

        System.out.println("pollFirst(): " + namesSet.pollFirst()); // Alice
        System.out.println(namesSet); // [Bob, Charlie, Dave]

        System.out.println("pollLast(): " + namesSet.pollLast()); // Dave
        System.out.println(namesSet); // [Bob, Charlie]

        System.out.println("pollFirst(): " + namesSet.pollFirst()); // Bob
        System.out.println(namesSet); // [Charlie]

        System.out.println("pollLast(): " + namesSet.pollLast()); // Charlie
        System.out.println(namesSet); // []

        // Since no more elements to poll, we now return null
        System.out.println("pollFirst(): " + namesSet.pollFirst()); // null
        System.out.println(namesSet);
    }
}
