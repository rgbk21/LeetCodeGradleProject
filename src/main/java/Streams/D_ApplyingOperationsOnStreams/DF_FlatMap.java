package Streams.D_ApplyingOperationsOnStreams;

import java.util.stream.Stream;

public class DF_FlatMap {

    public static void main(String[] args) {

        //Bad Way
        Stream.of(1,2,3)
                //In this case, the map() method produces a Stream<Integer> for each integer in the input stream.
                //It produces three Stream<Integer>s. The first stream contains 1 and 1; the second one contains 2 and 4; the third one contains 3 and 9
                .map(num -> Stream.of(num, num * num))
                //The forEach() method receives the Stream<Integer> object as its argument and prints the string returned from its
                //toString() method.
                .forEach(System.out::println);

        //Prints:
        //java.util.stream.ReferencePipeline$Head@3834d63f
        //java.util.stream.ReferencePipeline$Head@7907ec20
        //java.util.stream.ReferencePipeline$Head@546a03af

        System.out.println("\nNesting the forEach");
        Stream.of(1,2,3)
                .map(num -> Stream.of(num, num * num))
                //You can call the forEach() on a stream, so you can nest its call to print the elements of the stream of
                //streams
                .forEach(stream -> stream.forEach(System.out::println));
        //above prints what we want, but we have not generated a Stream<Integer> like we wanted.

        System.out.println("\nUsing flatMap instead: ");
        Stream.of(1, 2, 3)
                .flatMap(n -> Stream.of(n, n * n))
                .forEach(System.out::println);

        //Does this example make sense to you now?
        System.out.println("Counting the number of E's in a Stream");
        //It is easier to convert the Stream of strings into a Stream of characters instead,
        //and then count the number of characters
        long numOfE = Stream.of("Bob","Alice", "Charlie", "Dave")
                //chars() returns an IntStream of char values
                .map(str -> str.chars())
                //Recall what we read about mapToObj - its only purpose is to convert IntStream to Stream
                //The flatMap() method maps the Stream<IntStream> to Stream<Stream<Character>> and finally,
                //flattens it to produce a Stream<Character>.
                //So, the output of the flatMap() method is Stream<Character>
                .flatMap(intStream -> intStream.mapToObj(n -> (char) n))
                .filter(ch -> ch =='e' || ch == 'E')
                .count();

        System.out.println("Number of E's: " + numOfE);
    }
}
