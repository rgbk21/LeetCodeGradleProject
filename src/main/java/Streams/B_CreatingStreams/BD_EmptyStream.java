package Streams.B_CreatingStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class BD_EmptyStream {

    public static void main(String[] args) {

        //Creating an empty Stream
        Stream<Integer> emptyStream = Stream.empty();

        // Creates an empty stream of integers
        IntStream emptyIntStream = IntStream.empty();

        //Create an empty stream of Long
        LongStream emptyLongStream = LongStream.empty();

    }
}
