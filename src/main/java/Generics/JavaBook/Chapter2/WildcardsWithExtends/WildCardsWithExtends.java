package Generics.JavaBook.Chapter2.WildcardsWithExtends;

import java.util.*;

public class WildCardsWithExtends {
  public static void addAllWithoutWildCard() {

  }
}

class WildCardsWithExtendsTest {
  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>();
    List<Integer> integers = Arrays.asList(1,2,3);
    List<Double> doubles = Arrays.asList(3.14, 2.13);

    // 'numbers' is declared as a List<Number>, which is a subclass of Collection<Number>
    // so the 'addAll' method on 'numbers' can be triggered with an args of Collection<? extends Number>
    // and hence we can pass in 'integers', which is List<Integer>
    // We have already seen that List<Number> is a subtype of Collection<Number>.
    // Having the <? extends Number> allows us to pass-in List<Integer>.
    numbers.addAll(integers);
    numbers.addAll(doubles);
    System.out.println(numbers); // [1, 2, 3, 3.14, 2.13]

    // But what would have happened if the addAll() method on the interface was NOT declared with the wildcard
    // so what if we instead had just this: addAll(Collection<E> collection)
    // In that case we would not have been able to pass in List<Integer>,
    // because the collection 'numbers' was defined as List<Number>,
    // and we would have been trying to pass in List<Integer> instead
    // and we have already seen that List<Integer> is not a subtype of List<Number>.
    // So if that were the case, we would ONLY have been able to add Number types to 'numbers'

    // Here is a contrived example to show this
    MyCollection<Number> myNumberCollection = new MyCollectionImpl<>();

    Collection<Integer> integerCollection = Arrays.asList(1,2,3);
    // Compile error:
//    myNumberCollection.addAll(integerCollection); // Required type: Collection<Number> Provided: Collection<Integer>
    myNumberCollection.addAllExtends(integerCollection); // With wildcard, we ARE able to add Collection<Integer> to Collection<Number>

  }
}

interface MyCollection<E> extends Iterable<E> {
  boolean addAll(Collection<E> collection);
  boolean addAllExtends(Collection<? extends E> collection);
}

class MyCollectionImpl<E> implements MyCollection<E> {

  @Override
  public boolean addAll(Collection<E> collection) {
    return false;
  }

  @Override
  public boolean addAllExtends(Collection<? extends E> collection) {
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return null;
  }
}

class UsingWildcardsAsVariables {
  public static void main(String[] args) {
    List<Integer> integers = new ArrayList<>();
    integers.add(1);
    integers.add(2);
    // This line compiles properly now:
    List<? extends Number> extendedNumber = integers;
    // Compile Error:
//    extendedNumber.add(3.14); // Required type: capture of ? extends Number Provided: double

    // For the same reason the following line does not compile as well
//    extendedNumber.add(3); // Required type: capture of ? extends Number Provided: int
  }
}