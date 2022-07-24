package Generics.JavaBook.Chapter3.FruityExample.PermittingComparison;

import java.util.Collection;
import java.util.List;

public class AnotherMaxFinding {
  public static <T extends Comparable<T>> T findMax(Collection<T> collection) {
    T candidate = collection.iterator().next();
    for (T element : collection) {
      if (element.compareTo(candidate) > 0) {
        candidate = element;
      }
    }
    return candidate;
  }

  public static <T extends Comparable<? super T>> T findMaxExtended(Collection<T> collection) {
    T candidate = collection.iterator().next();
    for (T element : collection) {
      if (element.compareTo(candidate) > 0) {
        candidate = element;
      }
    }
    return candidate;
  }
}

class TestAnotherMaxFinding {
  public static void main(String[] args) {
    Apple apple1 = new Apple(1);
    Apple apple2 = new Apple(2);
    Orange orange1 = new Orange(1);
    Orange orange2 = new Orange(2);

    List<Apple> apples = List.of(apple1, apple2);
    List<Orange> oranges = List.of(orange1, orange2);
    List<Fruit> fruits = List.of(apple1, orange2);

    // Now these two do not compile
    // Consider the first example. We are passing in oranges which is declared as a List<Orange> as args.
    // This means T is Orange.
    // Hence, the method signature in the findMax method evaluates to:
    // <Orange extends Comparable<Orange>> Orange findMax(Collection<Orange> collection)
    // Now, Orange DOES NOT extend Comparable (look at the Orange class that we are passing in)
    // Hence the compiler is NOT happy when you pass in a List<Orange>, because the type T is DEFINED as
    // a type that extends Comparable in the findMax method. Does that make sense now?
    // This is the error that the compiler geenerates:
    // Required type: Collection<T> Provided: List<Orange>
    // reason: Incompatible equality constraint: Fruit and Orange
//    AnotherMaxFinding.findMax(oranges);
//    AnotherMaxFinding.findMax(apples);

    // But this does compile. Because fruits is declared as a List<Fruit>.
    // And when we try to pass in List<Fruit> to the findMax method,
    // the compiler evaluates T to be Fruit
    // so the method declaration for findMax evaluates to
    // <Fruit extends Comparable<Fruit>> Fruit findMax(Collection<Fruit> collection)
    // and since Fruit class DOES extend Comparable, the compiler is satisfied.
    AnotherMaxFinding.findMax(fruits);

    // And all the below three compile as well.
    // Because, now you are passing in a List<Orange> and hence T is Orange
    // So the method declaration evaluates to:
    // <Orange extends Comparable<? super Orange>> Orange findMaxExtended(Collection<Orange> collection)
    // -> Orange extends Comparable<? super Orange>
    // which plays out to: Orange should be a subclass of some class that implements
    // Comparable<AnyClassThatIsASuperClassOfOrange>
    // And this holds because both of the following hold:
    // Orange extends Comparable<Fruit> AND Fruit super Orange
    AnotherMaxFinding.findMaxExtended(apples);
    AnotherMaxFinding.findMaxExtended(oranges);
    AnotherMaxFinding.findMaxExtended(fruits);
  }
}
