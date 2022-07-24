package Generics.JavaBook.Chapter3.FruityExample.ProhibitingComparison;

import com.google.common.base.MoreObjects;

import javax.annotation.Nullable;

import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

// Now this class does not implement the Comparable interface
// Hence it will be illegal/compile error to place an @Override annotation
// on the compareTo method. Do note that we WERE able to place that annotation
// in Example 1, since that class DID implement the Comparable interface.
abstract class Fruit {
    protected String name;
  protected int size;

  protected Fruit(String name, int size) {
    this.name = checkNotNull(name);
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Fruit) {
      Fruit that = (Fruit) o;
      return this.name.equals(that.name) && this.size == that.size;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return name.hashCode() * 29 + size;
  }

  // Now we have declared this method as protected, and not public
  // as we did in Example 1.
  // @Override -> no override here. This method is place in the abstract class
  // only because we do not want to duplicate the code in the child classes
  protected int internalCompareTo(@Nullable Fruit that) {
    // Note that the below is equivalent to writing:
    // return Integer.compare(this.size, that.size);
    if (this.size > that.size) {
      return 1;
    } else if (this.size < that.size) {
      return -1;
    } else return 0;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("size", size)
        .toString();
  }
}

class Apple extends Fruit implements Comparable<Apple> {
  public Apple(int size) {
    super("Apple", size);
  }

  @Override
  public int compareTo(Apple apple) {
    return super.internalCompareTo(apple);
  }
}

class Orange extends Fruit implements Comparable<Orange> {
  protected Orange(int size) {
    super("Orange", size);
  }

  @Override
  public int compareTo(Orange orange) {
    return super.internalCompareTo(orange);
  }
}

class TestFruit {
  public static void main(String[] args) {
    Apple apple1 = new Apple(1);
    Apple apple2 = new Apple(2);
    Orange orange1 = new Orange(1);
    Orange orange2 = new Orange(2);

    List<Apple> apples = List.of(apple1, apple2);
    List<Orange> oranges = List.of(orange1, orange2);

    // Both of these work as expected
    System.out.println(Collections.max(apples)); // Apple{name=Apple, size=2}
    System.out.println(Collections.max(oranges)); // Orange{name=Orange, size=2}

    // But now when you try to create a mixed list, it will no longer work
    List<Fruit> mixed = List.of(apple1, orange2);
    // Compile error on the below line
//    System.out.println(Collections.max(mixed));
    // Required type: Collection<? extends T> Provided: List<Fruit>
    // reason: no instance(s) of type variable(s) T exist so that Fruit conforms to Comparable<? super T>

    System.out.println(apple1.compareTo(apple2)); // -1
    System.out.println(orange1.compareTo(orange2)); // -1

    // And this line now produces a compile error, as expected
//    System.out.println(apple1.compareTo(orange1)); // Required type: Apple Provided: Orange
//    System.out.println(orange1.compareTo(apple1)); // Required type: Orange Provided: Apple
  }
}