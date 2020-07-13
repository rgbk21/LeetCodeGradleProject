package LambdaExpressions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class GG_StaticMethodReferences {

    public static void main(String[] args) {
        /*
        - Integer class has a static method called toBinaryString:
        - public static String toBinaryString(int i)
        - The method takes an integer as an argument, and converts it into a String
        - The method can be hence used as a Function type Function<Integer, String>
         */
        Function<Integer, String> myFunction = x -> Integer.toBinaryString(x);

        /*
        ** Example 1
        The same function can also be re-written as a method reference
        The compiler finds a static method reference to the toBinaryString() method of the Integer class on the
        right-hand side of the assignment operator. The toBinaryString() method takes an int as an argument and returns
        a String. The target type of the method reference is a function that takes an Integer as an argument and returns a
        String. The compiler verifies that after unboxing the Integer argument type of the target type to int, the method
        reference and target type are assignment compatible.
         */

        Function<Integer, String> myFunction2 = Integer::toBinaryString;
        System.out.println(myFunction2.apply(17));//Prints 10001

        /*
        ** Example 2
        Let's consider another example - this time a static method that has two input arguments
        public static int sum(int a, int b)
        Note that this time we are using the BiFunction interface, and not the Function interface
        */
        BiFunction<Integer, Integer, Integer> myFunction3 = Integer::sum;
        System.out.println(myFunction3.apply(10, 4));//Prints: 14

        /*
        ** Example 3
        - this shows usage of method References in Overloaded methods
        - valueOf method has 3 overloaded methods:
            - static Integer valueOf(int i)
            - static Integer valueOf(String s)
            - static Integer valueOf(String s, int radix)

         */

        // Uses Integer.valueOf(int)
        Function<Integer, Integer> func1 = Integer::valueOf;

        // Uses Integer.valueOf(String)
        Function<String, Integer> func2 = Integer::valueOf;

        // Uses Integer.valueOf(String, int)
        BiFunction<String, Integer, Integer> func3 = Integer::valueOf;

        System.out.println(func1.apply(17));//Prints: 17
        System.out.println(func2.apply("17"));//Prints: 17
        System.out.println(func3.apply("10001", 2));//Prints: 17

        //Example 4
        //Check how to use a Supplier in FunctionalUtilTest class
    }
}
