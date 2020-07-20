package Streams.D_ApplyingOperationsOnStreams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DE_ForEachOrdered {

    public static void main(String[] args) {

        List<String> namesAsList = Arrays.asList("Bob","Alice", "Charlie", "Dave");

        Set<String> names = new HashSet<>(namesAsList);
        System.out.println("Using a set that does not have a natural order");
        System.out.println("Note that names are printed out of order");
        names.stream().forEachOrdered(name -> System.out.println(name));

        System.out.println("\nUsing a set that does not have a natural order but sorting it");
        //Note in this example how sorted is changing the order of execution of the stages of the pipeline
        names.stream()
                .peek(name -> System.out.println("Stage1> " + name))
                .map(name -> name.toUpperCase())
                .peek(name -> System.out.println("Stage2> " + name))
                .sorted()
                .peek(name -> System.out.println("Stage3> " + name))
                .forEachOrdered(name -> System.out.println(name));

        System.out.println("\nUsing a List that does have a natural order");
        System.out.println("Names are printed in the order in which the list was created");
        namesAsList.stream().forEachOrdered(name -> System.out.println(name));

    }
}
/*
    Using a set that does not have a natural order
    Note that names are printed out of order
    Bob
    Alice
    Charlie
    Dave

    Using a set that does not have a natural order but sorting it
    Stage1> Bob
    Stage2> BOB
    Stage1> Alice
    Stage2> ALICE
    Stage1> Charlie
    Stage2> CHARLIE
    Stage1> Dave
    Stage2> DAVE
    Stage3> ALICE
    ALICE
    Stage3> BOB
    BOB
    Stage3> CHARLIE
    CHARLIE
    Stage3> DAVE
    DAVE

    Using a List that does have a natural order
    Names are printed in the order in which the list was created
    Bob
    Alice
    Charlie
    Dave
*/