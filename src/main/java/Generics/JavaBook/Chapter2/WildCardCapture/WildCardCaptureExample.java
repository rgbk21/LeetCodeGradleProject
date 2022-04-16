package Generics.JavaBook.Chapter2.WildCardCapture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WildCardCaptureExample {
  // Implementation of reverse using type parameters
  public static <T> void typeParameterReverse(List<T> sourceList) {
    List<T> temp = new ArrayList<>(sourceList);
    for (int i = 0; i < sourceList.size(); i++) {
      sourceList.set(i, temp.get(sourceList.size() - 1 - i));
    }
  }

  // Wildcard reverse
  public static void wildCardReverse_err1(List<?> sourceList) {
    List<?> temp = new ArrayList<>(sourceList);
    for (int i = 0; i < sourceList.size(); i++) {
      // Compile error on the next line
      // The error is not a typo. It is in fact telling that the required and the provided types are the same,
      // but still generating an error. Why is that?
      // Source: https://stackoverflow.com/a/40403745/8742428
      // The Java compiler internally represents the value of a wildcard by capturing it in an anonymous type variable,
      // which it calls "capture of ?" (actually, javac calls them "capture #1 of ?" because
      // different uses of ? may refer to different types, and therefore have different captures).
      // So I think what is happening is that since the sourceList and temp are both declared as wildcards,
      // and you are trying to 'get' a value from temp which of type List<?> and then
      // 'set' it into sourceList, which is another List<?>,
      // The two types are unknown, and they could be possibly different.
      // you are getting the following error:
//      sourceList.set(i, temp.get(sourceList.size() - 1 - i)); // Required type: capture of ? Provided: capture of ?
    }
  }

  // Using Object instead of ? in the 'temp' list doesn't work either, as shown here
  public static void wildCardReverse_err2(List<?> sourceList) {
    List<Object> temp = new ArrayList<>(sourceList);
    for (int i = 0; i < sourceList.size(); i++) {
      // Compile error on the next line
      // This doesn't work either, becouse now you are trying to add a Object type to a List<?>
      // And Java doesn't allow that?
//      sourceList.set(i, temp.get(sourceList.size() - 1 - i)); // Required type: capture of ? Provided: Object
    }
  }


  // So we get around this problem by "capturing" the ? in T.
  public static void wildCardReverse(List<?> sourceList) {
    reverse(sourceList);
  }

  // Here we say that the type variable T has captured the wildcard. This is a generally useful
  // technique when dealing with wildcards, and it is worth knowing.
  private static <T> void reverse(List<T> sourceList) {
    // And now we can just do what we did in the typeParameterReverse()
    List<T> temp = new ArrayList<>(sourceList);
    for (int i = 0; i < sourceList.size(); i++) {
      sourceList.set(i, temp.get(sourceList.size() - 1 - i));
    }
  }
}

class TestWildCardCaptureExample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    Collections.reverse(numbers);
    System.out.println(numbers); // [5, 4, 3, 2, 1]

    System.out.println("Before reverse: " + numbers);
    WildCardCaptureExample.typeParameterReverse(numbers);
    System.out.println("After reverse: " + numbers); // [1, 2, 3, 4, 5]

    WildCardCaptureExample.wildCardReverse(numbers);
    System.out.println("After wildcardReverse: " + numbers); // [5, 4, 3, 2, 1]
  }
}
