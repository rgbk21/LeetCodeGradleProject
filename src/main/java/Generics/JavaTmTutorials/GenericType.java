package Generics.JavaTmTutorials;

public class GenericType<T> {
  private T item;
  public void setItem(T item) {this.item = item;}
  public T getItem() {return item;}

  // In this context, extends is used in a general sense to mean either "extends" (as in classes) or "implements" (as in interfaces).
  public <U extends Number> void inspect(U u) {
    System.out.println("T: " + item.getClass().getName());
    System.out.println("U: " + u.getClass().getName());

    // Note:
    // In addition to limiting the types you can use to instantiate a generic type, bounded type parameters allow you to invoke methods defined in the bounds
    // Since we have defined u to extend Number, all the methods that are available on the Number class are also available on the reference u.
    System.out.println(u.intValue());
    System.out.println(u.byteValue());
  }
}

class GenericTypeTest {
  public static void main(String[] args) {
    GenericType<Integer> integerGenericType = new GenericType<>();
    integerGenericType.setItem(21);
//    integerGenericType.inspect("21"); // Compile Error. Required Type: U, Provided: String
  }
}
