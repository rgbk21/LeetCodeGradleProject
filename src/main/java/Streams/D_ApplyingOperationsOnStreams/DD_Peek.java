package Streams.D_ApplyingOperationsOnStreams;

import java.util.stream.Stream;

public class DD_Peek {

    public static void main(String[] args) {

        Stream.of("Alice", "Bob", "Charlie", "Dave")
                .peek(myStr -> System.out.println("\nCurrent string in pipeline: " + myStr))
                .map(myStr -> myStr.toUpperCase())
                .peek(myStr -> System.out.println("After changing to uppercase: " + myStr))
                .forEach(myStr -> System.out.println("Final Output: " + myStr));
    }
}

/*
    Current string in pipeline: Alice
    After changing to uppercase: ALICE
    Final Output: ALICE

    Current string in pipeline: Bob
    After changing to uppercase: BOB
    Final Output: BOB

    Current string in pipeline: Charlie
    After changing to uppercase: CHARLIE
    Final Output: CHARLIE

    Current string in pipeline: Dave
    After changing to uppercase: DAVE
    Final Output: DAVE
*/