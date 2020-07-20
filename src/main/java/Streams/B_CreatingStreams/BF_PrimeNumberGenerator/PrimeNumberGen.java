package Streams.B_CreatingStreams.BF_PrimeNumberGenerator;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class PrimeNumberGen {

    public static void main(String[] args) {

        PrimeNumberGen myGenerator = new PrimeNumberGen();

        //The filter() accepts a Predicate as an argument and then internally calls the test() method
        //that calls the body of the lambda expression in turn. Note how the Predicate is being used
        //in this scenario.
        //The lambda expression can be replaced by a method reference as well in this case.
        System.out.println("Using limit");
        Predicate<Integer> myTest = n -> myGenerator.isPrime(n);

        //Generate the first 50 prime numbers
        Stream.iterate(1, n -> n+1)
                .filter(myTest)
                .limit(10)
                .forEach(System.out::println);

        //Sometimes you may want to discard some elements of a stream. This is accomplished using the skip operation.
        //The skip(long n) method of the Stream interface discards (or skips) the first n elements of the stream.
        System.out.println("\nUsing skip");

        //Change the position of the skip to different stages of the pipeline to see how it affects the output
        Stream.iterate(1, n -> n+ 1)
                .skip(5)
                .filter(myTest)
                .limit(10)
                .forEach(System.out::println);

        //Print 5 prime numbers that are greater than 3000
        System.out.println("\nPrinting 5 prime numbers that are greater than 3000");

        Stream.iterate(1, n -> n+ 1)
                .filter(myTest)
                .filter(n -> n > 3000)
                .limit(5)
                .forEach(System.out::println);
    }

    public boolean isPrime(Integer num) {
        if (num == 2) { return true; }
        if (num % 2 == 0) { return false; }
        double largestDivisor = Math.sqrt(num);
        for (int i = 3; i <= largestDivisor; i+=2) {
            if (num % i == 0) { return false; }
        }
        return true;
    }
}
