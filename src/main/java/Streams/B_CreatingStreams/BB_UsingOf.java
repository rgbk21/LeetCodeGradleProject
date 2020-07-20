package Streams.B_CreatingStreams;

import Streams.Person;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

public class BB_UsingOf {

    public static void main(String[] args) {

        //Creates a stream with ine String element
        Stream<String> singleStr = Stream.of("myStream");

        //Create a stream with four strings
        Stream<String> multipleStr = Stream.of("One", "Two", "Three", "Four");

        //Since Stream.of takes varargs as an argument, it can also take an array of objects
        //So this is valid:
        String[] myArray = new String[] {"One", "Two", "Three", "Four"};
        Stream<String> myStream = Stream.of(myArray);

        Person ken = new Person(1, "Ken", "" , Person.Gender.MALE, LocalDate.of(1970, Month.MAY, 4), 6000.0);
        Person jeff = new Person(2, "Jeff", "" , Person.Gender.MALE, LocalDate.of(1970, Month.JULY, 15), 7100.0);
        Person donna = new Person(3, "Donna", "" , Person.Gender.FEMALE, LocalDate.of(1962, Month.JULY, 29), 8700.0);

        Person[] people = new Person[]{ken, jeff, donna};

        //As well as this is valid:
        Stream<Person> anotherStream = Stream.of(people);
        Stream<Person> anotherStream2 = Stream.of(ken, jeff, donna);

        //creates a stream of strings from a String array returned from the split() method of the String class:
        Stream<String> myStream2 = Stream.of("One, Two, Three, Four".split(","));



    }
}
