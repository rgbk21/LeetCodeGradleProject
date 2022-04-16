package Generics.JavaBook.Chapter2.WildCardVsTypeParameters;

import java.util.Collection;

public class TypedCollection {
  public static void main(String[] args) {
    MyCollection<Number> myNumberCollection = new MyList<>();
    MyCollection<Object> myObjectCollection = new MyList<>();

    myObjectCollection.containsAll(myNumberCollection);
    // Compile error
//    myNumberCollection.containsAll(myObjectCollection); // Required type: MyCollection<? extends Number> Provided: MyCollection<Object>

    myNumberCollection.contains(2);
    // Compile error
//    myNumberCollection.contains("Two"); // Required type: Number Provided:String
  }
}

interface MyCollection<E> {
  public boolean contains(E element);
  public boolean containsAll(MyCollection<? extends E> elements);
}

class MyList<E> implements MyCollection<E> {

  @Override
  public boolean contains(E element) {
    return false;
  }

  @Override
  public boolean containsAll(MyCollection<? extends E> elements) {
    return false;
  }
}
