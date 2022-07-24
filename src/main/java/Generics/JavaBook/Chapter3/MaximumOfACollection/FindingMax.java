package Generics.JavaBook.Chapter3.MaximumOfACollection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FindingMax {
  // What this method is saying is that, you can pass in a Collection<T> as args,
  // but that type T should extend/implement the Comparable interface. Hence in the
  // main method, you can call this method with Collection<Integer> or Collection<String>,
  // but NOT with Collection<Number>, because Number does not implement the Comparable interface.
  public static <T extends Comparable<T>> T findMax(Collection<T> collection) {
    T candidate = collection.iterator().next();
    for (T element : collection) {
      if (element.compareTo(candidate) > 0) {
        candidate = element;
      }
    }
    return candidate;
  }

  // But note that doing the following does not compile
//  public static <T extends Comparable<T>> T findMaxButBroken(Collection<T> collection) {
//    T candidate = collection.iterator().next();
//    for (T element : collection) {
//      // Compile error on this line
//      // Operator '>' cannot be applied to 'T', 'T'
//      if (element > candidate) {
//        candidate = element;
//      }
//    }
//    return candidate;
//  }
}

class TestFindingMax {
  public static void main(String[] args) {
    List<Integer> someList = Arrays.asList(1, 2, 3, 4, 5);
    List<Integer> allPositives = List.of(1, 2, 4, 5, 7);
    List<Integer> allNegatives = List.of(-1, -2, -4, -5, -7);

    System.out.println(FindingMax.findMax(allPositives)); // 7
    System.out.println(FindingMax.findMax(allNegatives)); // -1

    // Similar to using Integer, you could also use List<String>
    List<String> strings = List.of("Bob", "Dave", "Charlie", "Alice");
    System.out.println(FindingMax.findMax(strings)); // Dave

    // But you would NOT have been able to do it with a List<Number>,
    // because like we have seen, Number does not implement the Comparable<T> interface
    List<Number> numbers = List.of(3.14, 2.18, 6);
//    FindingMax.findMax(numbers); // Required type: Collection<T> Provided: List<Number> reason: no instance(s) of type variable(s) T exist so that Number conforms to Comparable<T>
  }
}
