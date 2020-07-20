package Streams.B_CreatingStreams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BF_Using_Arrays {

    public static void main(String[] args) {

        //Create an IntStream from an Array of ints
        IntStream myIntStream = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        //Create a Stream from Array of Strings
        Stream<String> myStringStream = Arrays.stream(new String[]{"Alice", "Bob", "Charlie", "Dave"});

        //https://github.com/stavalfi/lectures/blob/master/Java%20Streams%20-%20Series/Java%20streams%20-%20Part%202%20-%20Primitive%20steams.md
        Arrays.asList(3, 2, 1).stream()
                // notice that map get function with Integer parameter because
                // the parameter type is generic and the return type must be
                // int because we convert the stream to IntStream.
                .mapToInt((Integer x) -> x)
                // notice that map get function with int parameter instead of
                // Integer and the return type must be int.
                .map((int x) -> x * 10)
                .forEach(System.out::println);

        // the above is equivalent:
        // Arrays.asList(3,2,1).stream()
        //          .mapToInt(Integer::intValue)
        //          .map((int x)->x*10)
        //          .forEach(System.out::println);

        // output:
        // 30
        // 20
        // 10

        // example to show:
        //mapToObj create from each integer an object from type U.
        // This method only purpose is to convert IntStream to Stream.
        Arrays.asList(1, 2, 3).stream()
                // convert Stream<Integer> to IntStream.
                .mapToInt(Integer::intValue)
                // invoke some intermediate operations on IntStream.
                // ...
                // convert IntStream to Stream<String>.
                .mapToObj((int x) -> "element value is: " + x)
                .forEach(System.out::println);

                // output:
                // element value is: 1
                // element value is: 2
                // element value is: 3
    }

}
