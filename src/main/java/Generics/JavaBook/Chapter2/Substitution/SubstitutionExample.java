package Generics.JavaBook.Chapter2.Substitution;

import java.util.ArrayList;
import java.util.List;

public class SubstitutionExample {


}

class SubstitutionExampleTest {
  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(3.14);
    System.out.println(numbers); // [1, 3.14]

    // List<Integer> is not a subtype of List<Number>
    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    List<Number> numbers1 = new ArrayList<>();
    // Compile Error
//    numbers1 = integers; // Required type: List<Number>, Provided: List<Integer>
    // If the above line were legal code, then we could do this:
    numbers1.add(3.14);
    // since numbers1 points to integers, that would mean we have ended up adding a double value
    // into a List<Integer>, which breaks everything. Hence, the operation of assigning a
    // List<Integer> to a List<Double> is not allowed.
  }
}
