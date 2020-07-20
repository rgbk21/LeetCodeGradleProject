package Streams.C_Optional;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class CC_OptionalBasics {

    public static void main(String[] args) {

        //3 ways to create an Optional

        //1) Create an empty Optional
        Optional<String> empty = Optional.empty();

        //2) Create an Optional for the String "Hello" using of()
        Optional<String> optStr = Optional.of("Hello");

        //3) Create an optional using ofNullable()
        Optional<String> ofNullableStr = Optional.ofNullable("");

        //The isPresent() checks if the Optional is empty or not
        //The get() gets the value inside the Optional
        if (optStr.isPresent()) {
            System.out.println("Optional value of String is: " + optStr.get());
        } else {
            System.out.println("Optional is empty");
        }

        //NOTE: The earlier was isPresent(). This is ifPresent().
        //ifPresent has an overloaded method that takes a Consumer as an arg
        //Note that if the Optional were empty, the code would not print anything.
        optStr.ifPresent(value -> System.out.println("\nOptional value is : " + value));

        // Create an empty OptionalInt
        OptionalInt emptyInt = OptionalInt.empty();

        // Use an OptionaInt to store 287
        //Note the usage of getAsInt() method to get the value of the int
        OptionalInt number = OptionalInt.of(287);
        if (number.isPresent()) {
            int value = number.getAsInt();
            System.out.println("Number is " + value);
        } else {
            System.out.println("Number is absent.");
        }

        //Equivalent to the OptionalInt, we have the OptionalDouble and OptionalLong
        OptionalDouble optionalDouble = OptionalDouble.of(3.14);
        if (optionalDouble.isPresent()){
            double d = optionalDouble.getAsDouble();
        }

        //Example
        Stream<String> names = Stream.of("Alice", "Bob", "Charlie", "Dave");
        Optional<String> longestName = names.max(Comparator.comparingInt(str -> str.length()));

        if(longestName.isPresent()){
            System.out.println("The longest name: " + longestName.get());
        } else {
            System.out.println("Stream is empty");
        }
    }
}
