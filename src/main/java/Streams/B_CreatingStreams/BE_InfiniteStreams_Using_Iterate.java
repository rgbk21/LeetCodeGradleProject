package Streams.B_CreatingStreams;

import java.util.stream.Stream;

public class BE_InfiniteStreams_Using_Iterate {

    public static void main(String[] args) {

        // Creates a stream of odd natural numbers
        Stream<Integer> myIntStream = Stream.iterate(1, i -> i + 2);

        //So this will produce an infinite stream of numbers now
        //myIntStream.forEach(System.out::println);

        //You can limit the numebr of elements that are printed
        Stream<Integer> limitedStream = Stream.iterate(1, n -> n+2)
                .limit(50);

        limitedStream.forEach(System.out::println);

        //Remember that you can chain the above two statements
        System.out.println("\nAfter chaining the above 2 statements");
        Stream.iterate(1, n -> n+2)
                .limit(50)
                .forEach(System.out::println);



    }

}
