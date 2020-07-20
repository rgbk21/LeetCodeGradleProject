package Streams.B_CreatingStreams;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BG_Using_Collections {

    public static void main(String[] args) {

        Set<String> mySet = new HashSet<>();
        mySet.add("Alice");
        mySet.add("Bob");
        mySet.add("Charlie");
        mySet.add("Dave");

        //Create a sequential stream
        Stream<String> mySetStream = mySet.stream();

        //Create a parallel stream
        Stream<String> parallelStream = mySet.parallelStream();

    }

}
