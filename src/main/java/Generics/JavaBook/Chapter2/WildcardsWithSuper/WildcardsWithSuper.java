package Generics.JavaBook.Chapter2.WildcardsWithSuper;

import java.util.Arrays;
import java.util.List;

public class WildcardsWithSuper {
  public static <T> void copy(List<? super T> destination, List<? extends T> source) {
    for (int i = 0; i < source.size(); i++) {
      destination.set(i, source.get(i));
    }
  }

  public static <T> void copy_v2(List<T> destination, List<T> source) {}
  public static <T> void copy_v3(List<T> destination, List<? extends T> source) {}
  public static <T> void copy_v4(List<? super T> destination, List<T> source) {}
}

class WildcardsWithSuperTest {
  public static void main(String[] args) {
    List<Object> destination = Arrays.asList(2, 3.14, "Four");
    List<Integer> source = Arrays.asList(5, 6);

    WildcardsWithSuper.copy(destination, source);
    System.out.println(destination); // Prints: [5, 6, Four]

    // Remember that you can pass in the type parameter explicitly as well
    // What this means is that for the 'copy' call we made earlier,
    // we could have also written it like this:
    // We are explicitly saying that the type parameter T in the copy method
    // should now be considered as Integer. Hence we replace T with Integer
    // source is List<Integer> which follows the List<? extends Integer> requirement
    // destination is List<Object> which follows the List<? super Integer> requirement (Object is a supertype of Integer)
    // Hence this is a valid call:
    WildcardsWithSuper.<Integer>copy(destination, source);

    // But we could have also passed in different values for the type parameter T
    // and it would still have worked
    // source is List<Integer> which follows the List<? extends Object> requirement (Integer is a subtype of Object)
    // destination is List<Object> which follows the List<? super Object> requirement
    WildcardsWithSuper.<Object>copy(destination, source);


    // The below call is permitted because destination has type List<Object>, which is a subtype of List<? super Number>
    // (since Object is a supertype of Number, as required by the wildcard)
    // source has type List<Integer>, which is a subtype of List<? extends Number>
    // (since Integer is a subtype of Number, as required by the extends wildcard)

    // source is List<Integer> which follows the List<? extends Number> requirement (Integer is a subtype of Number)
    // destination is List<Object> which follows the List<? super Number> requirement (Object is a supertype of Number)
    WildcardsWithSuper.<Number>copy(destination, source);

    // That's not all.

    // We could have also defined the copy method itself with different signatures

    // ***************************************
    // copy_v2: Too restrictive, as it only permits calls when the destination and source have exactly the same type.
    // Hence none of the following are going to compile

    // Compiler complains about both, 'destination' and 'source'. Tells you to convert it into List<T> ???(Not generic question. Just question.)
//    WildcardsWithSuper.copy_v2(destination, source);
    // Compiler complains about 'destination'
//    WildcardsWithSuper.<Integer>copy_v2(destination, source); // Required type: List<Integer> Provided: List<Object>
    // Compiler complains about 'source'
//    WildcardsWithSuper.<Object>copy_v2(destination, source); // Required type: List<Object> Provided: List<Integer>
//    WildcardsWithSuper.<Number>copy_v2(destination, source);

    // The remaining three are equivalent for calls that use implicit type parameters, but differ for explicit type parameters.

    // ***************************************
    // copy_v3: works only when the type parameter is Object
    WildcardsWithSuper.copy_v3(destination, source); // Implicit call works without compile error
    // Compiler complains about 'destination'
//    WildcardsWithSuper.<Integer>copy_v3(destination, source); // Required type: List<Integer> Provided: List<Object>
    // Compiles without error
    WildcardsWithSuper.<Object>copy_v3(destination, source);
//    WildcardsWithSuper.<Number>copy_v3(destination, source); // Required type: List<Number> Provided: List<Object>

    // ***************************************
    // copy_v4: works only when the type parameter is Integer
    WildcardsWithSuper.copy_v4(destination, source); // Implicit call works without compile error
    // Compiles properly without error
    WildcardsWithSuper.<Integer>copy_v4(destination, source);
    // Compiler complains about source
//    WildcardsWithSuper.<Object>copy_v4(destination, source); // Required type: List<Object> Provided: List<Integer>
    // Compiler again complains about source
//    WildcardsWithSuper.<Number>copy_v4(destination, source); // Required type: List<Number> Provided: List<Integer>
  }
}

