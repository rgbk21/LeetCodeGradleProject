package Streams.B_CreatingStreams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BE_InfiniteStreams_Using_Generate {

    public static void main(String[] args) {

        //A Supplier does not take any arguments and returns a value of type T
        //You can replace the lambda expression with a Method Reference
        System.out.println("Creating streams using generate(): ");
        Stream.generate(() -> Math.random())
                .limit(10)
                .forEach(System.out::println);

        //Java 8 has added methods to the Random class so that it can also create streams of random ints, longs, doubles
        //These return IntStream, LongStream, DoubleStream resp.
        System.out.println("\nPrinting 5 random integers using Streams");
        new Random().ints()
                .limit(5)
                .forEach(System.out::println);

        //You can use the nextInt() method of the Random class as the Supplier in the generate() method to achieve the same.
        System.out.println("\nUsing the nextInt() method");
        Stream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);

        //If you want to work only with primitive values
        System.out.println("\nWorking only with primitive values");
        IntStream.generate(() -> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);

        //Generate an infinite stream of a repeating value
        System.out.println("\nGenerating an infinite stream of repeating values");
        IntStream.generate(() -> 0)
                .limit(10)
                .forEach(System.out::println);
    }

}
