package Generics.JavaBook.Chapter2.RestrictionsOnWildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstanceCreation {}

class TestInstanceCreation {
  public static void main(String[] args) {
//    List<?> list1 = new ArrayList<?>(); // Wildcard type '?' cannot be instantiated directly

    // This is usually not a hardship. The Get and Put Principle tells us that if a structure
    // contains a wildcard, we should only get values out of it (if it is an extends wildcard) or
    // only put values into it (if it is a super wildcard). For a structure to be useful, we must
    // do both.
    // Therefore, we usually create a structure with a precise type, even if we use wildcard types
    // to put values into or get values from the structure, as in the following example:
    List<Number> numbers = new ArrayList<>();
    List<? extends Number> source = numbers;
    List<? super Number> sink = numbers;
    // Putting items into the list
    for (int i = 0; i < 10; i++) {
      sink.add(i);
    }
    // Reading items from the list
    double sum = 0.0;
    for (Number number : source) {
      sum += number.doubleValue();
    }
    System.out.println(sum); // 45.0

    // Only top-level parameters in instance creation are prohibited from containing wildcards. Nested wildcards are permitted.
    // Hence, the following is legal.
    // Even though the list of lists is created at a wildcard type, each individual list within it
    // has a specific type: the first is a list of integers and the second is a list of strings.
    List<List<?>> lists = new ArrayList<List<?>>();
    lists.add(Arrays.asList(1,2,3));
    lists.add(Arrays.asList("four","five"));
    System.out.println(lists); // [[1, 2, 3], [four, five]]

    // But note that you won't be able to extract elements from the inner lists
    // as any type except Object
    // Compile error on this line
//    List<Integer> innerIntList = lists.get(0); // Required type: List<Integer> Provided: List<capture of ?>
//    List<Object> innerObjList = lists.get(0); // Required type: List<Object> Provided: List<capture of ?>
    Object something = lists.get(0); // Compiles
    Object integer1 = lists.get(0).get(0); // Compiles
  }
}
