package Streams.B_CreatingStreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class BC_UsingBuilder {

    public static void main(String[] args) {

        //Using the static Builder method on Stream
        Stream.Builder<String> myStrBuilder = Stream.builder();

        myStrBuilder.add("Alice")
                .add("Bob")
                .add("Charlie");

        Stream<String> myStream = myStrBuilder.build();

        myStream.forEach(System.out::println);

        // Create an IntStream containing 1, 2, 3, 4, and 5
        System.out.println("Creating an intStream from 1 to 5, 6 not inclusive");
        IntStream oneToFive = IntStream.range(1, 6);
        oneToFive.forEach(System.out::print);

        //Create an containing 1, 2, 3, 4, and 5
        System.out.println("\nCreating an intStream from 1 to 5");
        IntStream oneToFiveClosed = IntStream.rangeClosed(1, 5);
        oneToFiveClosed.forEach(System.out::print);

        //Like the IntStream interface, the LongStream class also contains range() and rangeClosed() methods that
        //takes arguments of type long and return a LongStream.
        System.out.println("\nCreating a LongStream from 1 to 5, 6 not inclusive");
        LongStream longStream = LongStream.range(1, 6);
        longStream.forEach(System.out::print);

        System.out.println("\nCreating a LongStream from 1 to 5");
        LongStream longStream2 = LongStream.rangeClosed(1, 5);
        longStream2.forEach(System.out::print);

    }
}

/*
Alice
Bob
Charlie
Creating an intStream from 1 to 5, 6 not inclusive
12345
Creating an intStream from 1 to 5
12345
Creating a LongStream from 1 to 5, 6 not inclusive
12345
Creating a LongStream from 1 to 5
12345
*/