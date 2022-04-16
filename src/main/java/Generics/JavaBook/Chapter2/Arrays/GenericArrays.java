package Generics.JavaBook.Chapter2.Arrays;

import java.util.List;

public class GenericArrays {
}

class TestGenericArrays {
  public static void main(String[] args) {
    // Array subtyping is covariant
    Integer[] integers = new Integer[]{1, 2, 3};
    Number[] numbers = integers;
    // Intellij does generate a warning here though: Storing element of type 'java.lang.Double'
    // to array of 'java.lang.Integer' elements will produce 'ArrayStoreException'
    numbers[2] = 3.14; // This line throws a ArrayStoreException

    // But lists are invariant
    List<Integer> integerList = List.of(1, 2, 3);
    // Compile error
//    List<Number> numberList = integerList; // Required type: List<Number> Provided: List<Integer>

    // But wildcards reintroduce covariant subtyping
    List<Integer> integerList1 = List.of(1, 2, 3);
    List<? extends Number> numberList1 = integerList1;
    // We now have a compile error on this line, like we saw earlier
    // But note that now the error is generated on the same line
    // as was being generated in the case of the arrays example above, ie.
    // while trying to add element to the structure, the difference being that
    // in the case of list, the error is captured at compile-time rather than at runtime.
//    numberList1.add(4); // Required type: capture of ? extends Number Provided: int
  }
}
