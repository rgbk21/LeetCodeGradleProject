package Generics.JavaBook.Chapter2.GetAndPut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionToTheRule {}

class TestExceptionToTheRule {
  public static void main(String[] args) {
    // with extends
    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    List<? extends Number> numbers = integers;
    // This produces a compile error, like we have seen
//    numbers.add(3.14); // Required type: capture of ? extends Number Provided: double
    // But this works. No error here
    numbers.add(null);

    // with super
    List<Object> objects = Arrays.<Object>asList(1, "two");
    List<? super Integer> ints = objects;
    String str = "";
    for (Object object : ints) {
      str += object.toString();
    }
    System.out.println(str); // Prints: 1two
    // But this doesn't work. Compile error here
//    for (Number number : ints) { // Required type: capture of ? super Integer Provided: Number
//      str += number.toString();
//    }
  }
}
