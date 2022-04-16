package Generics.JavaBook.Chapter2.WildCardVsTypeParameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ComparisonOrSomethingIDK {
}

class TestComparisonOrSomethingIDK {
  public static void main(String[] args) {
    Collection<Integer> integers = Arrays.asList(1, 2, 3, 4);
    Collection<Integer> smallInts = Arrays.asList(1, 2);
    Collection<String> smallStrings = Arrays.asList("One", "Two");
    // We can search for strings in a Collection<Integer>
    System.out.println(integers.contains(3)); // true
    System.out.println(integers.contains("Three")); // false
    // And similarly we can pass in a Collection<String> to be searched in
    // a Collection<Integer>
    System.out.println(integers.containsAll(smallInts)); // true
    System.out.println(integers.containsAll(smallStrings)); // false

    System.out.println("....");

    Object object = "One";
    List<Object> objects = Arrays.asList("One", 2, 3.14, 4);
    List<Integer> tinyInts = Arrays.asList(2, 4);
    System.out.println(objects.contains(object)); // true
    System.out.println(objects.containsAll(tinyInts)); // true
    System.out.println(tinyInts.contains(object)); // false
    System.out.println(tinyInts.containsAll(objects)); // false

    // The above two tests that produced false may seem unnecessary.
    // After all, why would a List<Integer> contain elements from a List<Object>
    // and why would List<Integer> contain an object.
    // Well here is why. What if the object was an Integer.
    Object numberMasqueradingAsAnObject = 2;
    List<Object> listOfObjectsOrIsIt = Arrays.asList(2, 4);
    System.out.println(tinyInts.contains(numberMasqueradingAsAnObject)); // true
    System.out.println(tinyInts.containsAll(listOfObjectsOrIsIt)); // true
  }
}
