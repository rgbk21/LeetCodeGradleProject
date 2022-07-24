package Generics.JavaBook.Chapter3.Comparable;

public class BasicCompare {}

class TestBasicCompare {
  public static void main(String[] args) {
    String s1 = "String1";
    String s2 = "String2";
    System.out.println(s1.compareTo(s2)); // -1
    System.out.println(s2.compareTo(s1)); // 1

    Integer int1 = 12;
    Integer int2 = 14;
    System.out.println(int1.compareTo(int2)); // -1
    System.out.println(int2.compareTo(int1)); // 1

    // Compile Error
//    System.out.println(int1.compareTo(s1)); // Required type: Integer Provided: String

    // Number does not implement the Comparable interface,
    // hence you cannot compare two numbers to each other
    Number n1 = 3.14;
    Number n2 = 3;
    // Compile Error
//    n1.compareTo(n2); // There is no such method on the Number class

    // You also cannot compare an Integer to a Number because the type definition is
    // defined as Comprable<Integer>, so the compareTo method NEEDS an Integer.
    // Compile Error:
//    int1.compareTo(n1); // Required type: Integer Provided: Number
  }
}