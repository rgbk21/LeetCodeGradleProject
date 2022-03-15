//package Generics.JavaTmTutorials;
//
//public class Box<T> {
//  private T item;
//  Box(T item) {this.item = item;}
//
//  public T getItem() {return item;}
//  public void setItem(T item) { this.item = item;}
//
//  public Number someMethod(Number number) {return number;}
//
//  public void printBoxItem(Box<Number> boxNumber) {}
//}
//
//class ExtendedBox extends Box<T> {
//
//  ExtendedBox(T item) {super(item);}
//
//  public void show() {
//
//  }
//
//  @Override
//  public Number someMethod(Number number) {
//    super.someMethod(number);
//    return number;
//  }
//}
//
//
//class BoxTest {
//  public static void main(String[] args) {
////    Box<Number> numberBox = new Box<>();
//  }
//}
//
//class NumberTest {
//   public static void main(String[] args) {
//
//     // Just to jog your memory...
//     // How does overloading work when we are NOT dealing with generics?
//     // And just using normal types instead?
//
//     Object someObject = new Object();
//     Integer someInteger = new Integer(21);
//
//     // You can assign someInteger to someObject because there is an "IS A" kind of relationship between Object and Integer i.e.
//     // Integer "IS A" type of Object. Hence, this is valid code:
//     someObject = someInteger;
//     // Integer is also a type of Number. So we can do the following as well:
//     Number someNumber = someInteger;
//
//     // What type of Box we create is not relevant to the discussion because
//     // the method that we are calling on it is not generic
//     Box<String> stringBox = new Box<>("10");
//     // You can call the method in the Box class with any of the args
//     // Super type cannot be passed as args (as we have seen on the Java Notes page at the top)
////     stringBox.someMethod(new Object()); // Required type: Number Provided: Object
//     // But Number and any of its subtypes can be passed in as args (as we have seen on the Java Notes page at the top)
//     stringBox.someMethod(someNumber);
//     stringBox.someMethod(new Integer(21));
//
//
//     // Now if we introduce generics into the picture
//     Box<Number> numberBox = new Box<>(12);
//     Box<Integer> integerBox = new Box<>(12);
//     stringBox.printBoxItem(numberBox); // works fine
////     stringBox.printBoxItem(integerBox); // compile error. Required type: Box<Number> Provided: Box<Integer>
//   }
//}