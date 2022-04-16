package Generics.JavaBook.Chapter2.GetAndPut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Examples {
  public static double sum(Collection<? extends Number> numbers) {
    double sum = 0.0;
    for (Number number : numbers) {
      sum += number.doubleValue();
    }
    return sum;
  }

  public static void count(Collection<? super Integer> integers, int n) {
    for (int i = 0; i < n; i++) {
      integers.add(i);
    }
  }

  public static void countAndSum(Collection<Number> numbers) {
    sum(numbers);
    count(numbers, 3);
  }
}

class TestExamples {
  public static void main(String[] args) {
    // Testing getting elements from a structure
    List<Number> numbers = List.of(1, 2, 3.0);
    List<Double> doubles = List.of(1.0, 2.0, 3.0);
    List<Integer> integers = List.of(1, 2, 3);

    System.out.println(Examples.sum(numbers)); // 6.0
    System.out.println(Examples.sum(doubles)); // 6.0
    System.out.println(Examples.sum(integers)); // 6.0

    // Testing putting elements into a structure
    List<Number> numbers1 = new ArrayList<>();
    List<Double> doubles1 = new ArrayList<>();
    List<Integer> integers1 = new ArrayList<>();
    List<Object> objects = new ArrayList<>();

    Examples.count(integers1, 3);
    integers1.add(3);

    Examples.count(numbers1, 3);
    numbers1.add(3.00);

    Examples.count(objects, 3);
    objects.add("threePointZeroZero");

    // This would obviously not compile
//    Examples.count(doubles1, 3); // Required type: Collection<? super Integer> Provided: List<Double>

    System.out.println(numbers1); // [0, 1, 2, 3.0]
    System.out.println(doubles1); // []
    System.out.println(integers1); // [0, 1, 2, 3]
    System.out.println(objects); // [0, 1, 2, threePointZeroZero]

    // Testing both getting and putting elements into a structure
    Examples.countAndSum(numbers);
    // All of the below three will produce a compile error
//    Examples.countAndSum(doubles);
//    Examples.countAndSum(integers);
//    Examples.countAndSum(objects);

    // Testing the other way round

    List<Integer> integers2 = new ArrayList<>();
    integers2.add(1);
    integers2.add(2);
    List<? extends Number> numbers2 = integers2;
    // The call to sum is fine, because it gets values from the list, but the call to add is not,
    // because it puts a value into the list.
    Examples.sum(numbers2); // ok
//    numbers2.add(3.14); // compile error Required type: capture of ? extends Number Provided: double
    Number number = numbers2.get(0); // this is fine
    Object number2 = numbers2.get(0); // this is also fine
//    Integer integer = numbers2.get(0); // compile error Required type: Integer Provided: capture of ? extends Number

    List<Object> objects2 = new ArrayList<>();
    objects2.add("One");
    objects2.add(2);
    List<? super Integer> numbers3 = objects2;
    // Now the call to add is fine, because it puts a value into the list, but the call to sum is not,
    // because it gets a value from the list.
    numbers3.add(3); // Compiles.  Although it was failing above.
//    Examples.sum(numbers3); // Compile error. Required type: Collection<? extends Number> Provided: List<capture of ? super Integer>
    Examples.count(numbers3, 3); // ok

    // Also note that the following do not compile
//    numbers3.add(new Object()); // Required type: capture of ? super Integer Provided: Object
//    Number object = numbers3.get(0); // Required type: Number Provided: capture of ? super Integer
    Object object2 = numbers3.get(0); // Compiles
  }
}