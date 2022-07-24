package Generics.JavaBook.Chapter3.FruityExample.ProhibitingComparison;

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

    // Now these two will compile because we are passing in oranges, which is List<Orange>
    // so the method declaration evaluates to
    // Orange extends Comparable<Orange>
    // which is true
    AnotherMaxFinding.findMax(oranges);
    AnotherMaxFinding.findMax(apples);
    // However this will not compile because Fruit no longer implements Comparable
    // Required type: Collection<T> Provided: List<Fruit>
    // reason: no instance(s) of type variable(s) T exist so that Fruit conforms to Comparable<T>
//    AnotherMaxFinding.findMax(fruits);

    // For the same reason, these two pass compile
    AnotherMaxFinding.findMaxExtended(apples);
    AnotherMaxFinding.findMaxExtended(oranges);
    // But this one fails compile
//    AnotherMaxFinding.findMaxExtended(fruits);
  }
}
