package Collections.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BasicExample {

    public static void main(String[] args) {

        Map<String, Integer> names = new HashMap<>();
        names.put("Alice", 27);
        names.put("Bob", 28);
        names.put("Charlie", 29);
        names.put("Dave", 30);

        //https://stackoverflow.com/questions/10993403/how-to-replace-hashmap-values-while-iterating-over-them-in-java#
        //A contrived example, but you get the idea.
        //When they say that you are not allowed to make changes to the elements of a HashMap while you iterate over them
        //what they mean is that
        //you should not add or remove elements to the Map as you are iterating over it.
        //i.e. you cannot make structural changes.
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().equals("Alice")) {
                //Note the use of the setValue method on the Map.Entry interface
                entry.setValue(entry.getValue() + 1);
            }
        }

        System.out.println("New age of Alice is: " + names.get("Alice"));//Prints: 28

        //You could also have used the put method to do the same thing.
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().equals("Bob")) {
                names.put("Bob", entry.getValue() + 1);
            }
        }

        System.out.println("\nNew age of Bob is: " + names.get("Bob"));//Prints: 29

    }

}
