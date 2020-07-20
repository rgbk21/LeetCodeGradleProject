package Streams;

import java.util.Arrays;
import java.util.List;

public class A_BasicExample {

    public static void main(String[] args) {

        //Program to square and then sum all odd numbers in a list
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);

        Integer result = intList.stream()
                .filter(myInt -> myInt % 2 == 1)
                .map(myInt -> myInt * myInt)
                //.reduce(0, (int1, int2) -> int1 + int2)  //as a lambda
                .reduce(0, Integer::sum);           //as a method reference

        System.out.println("Final Result: " + result);

        // The reduce operation in the above example is important.
        //
        // As a final step, you need to add the squares of all odd integers to get the result. The
        // reduce(T identity, BinaryOperator<T> accumulator) method of the Stream interface performs a reduction operation on the stream
        // to reduce the stream to a single value. It takes an initial value and an accumulator that is a BinaryOperator<T> as
        // arguments.
        //
        // Recall the BinaryOperator from lambdas. It inherits from BiFunction<T,T,T>.
        // BinaryOperator<T> Represents a function that takes two arguments of the same type (T)
        // and returns a result of the same type (T).
        //
        // The first time, the accumulator receives the initial value and the first element of the stream as arguments,
        // and returns a value. The second time, the accumulator receives the value returned from its previous call and the second
        // element from the stream. This process continues until all elements of the stream have been passed to the accumulator.
        // The returned value from the last call of the accumulator is returned from the reduce() method.

    }

}
