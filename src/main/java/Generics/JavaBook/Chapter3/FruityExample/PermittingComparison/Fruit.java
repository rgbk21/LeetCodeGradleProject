package Generics.JavaBook.Chapter3.FruityExample.PermittingComparison;

import Generics.JavaBook.Chapter3.MaximumOfACollection.FindingMax;
import com.google.common.base.MoreObjects;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

abstract class Fruit implements Comparable<Fruit> {
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

  // Note here that we are passing in args type as Fruit,
  // unlike the equals methods where we had to pass in the type as Object
  // and then cast it to type Fruit.
  // Also note that the method is declared public. In the second example,
  // this will be declared as protected instead.
  @Override
  public int compareTo(@Nullable Fruit that) {
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

class Apple extends Fruit {
  protected Apple(int size) {
    super("Apple", size);
  }
}

class Orange extends Fruit {
  protected Orange(int size) {
    super("Orange", size);
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

    // But you can also create a mixed list of Orange and Apple
    List<Fruit> mixed = List.of(apple1, orange2);
    // and you are able to find a max in it because Fruit implements Comparable<Fruit>
    System.out.println(Collections.max(mixed)); // Orange{name=Orange, size=2}

    System.out.println(apple1.compareTo(apple2)); // -1
    System.out.println(orange1.compareTo(orange2)); // -1
    System.out.println(apple1.compareTo(orange2)); // -1

    ////////////////// Write about why this doesn't work.
//    FindingMax.findMax(apples);
//    FindingMax.findMax(oranges);
//    FindingMax.findMax(mixed);
  }
}
