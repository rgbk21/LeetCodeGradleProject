package Generics.JavaBook.Chapter1;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {

  public <T> List<T> convertArraysToList(T[] array) {
    List<T> list = new ArrayList<>();
    for (T item : array) {
      list.add(item);
    }
    return list;
  }

  public <T> List<T> convertToList(T... array) {
    List<T> list = new ArrayList<>();
    for (T item : array) {
      list.add(item);
    }
    return list;
  }
}



class GenericMethodsTest {
  public static void main(String[] args) {
    GenericMethods test = new GenericMethods();
    Integer[] numArray = new Integer[]{1,2,3,4};

    // The type parameter to the convertArraysToList is inferred in this case
    List<Integer> toList = test.convertArraysToList(numArray);

    // The type parameter can also be given explicitly.
    // The Java grammar requires that type parameters may appear only in method invocations that use a dotted form.
    List<Integer> anotherList = test.<Integer>convertArraysToList(numArray);

    // Using the varargs method
    test.convertToList(1, "2");

  }
}
