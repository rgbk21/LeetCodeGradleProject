package Generics.JavaBook.Chapter2.RestrictionsOnWildcards;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodCalls {
  public static <T> List<T> factory() {
    return new ArrayList<T>();
  }
}

class TestGenericMethodCalls {
  public static void main(String[] args) {
    List<?> answer = GenericMethodCalls.factory();
    // If you pass in an explicit type parameter, it cannot be a wildcard
    // Compile error on this line:
//    List<?> anotherAnswer = GenericMethodCalls.<?>factory(); // Unexpected wildcard
    // Nested wildcards are permitted
    List<?> anotherAnswer2 = GenericMethodCalls.<List<?>>factory();
  }
}
