package Test1;

import java.util.HashMap;
import java.util.Map;

public class AmILosingMyMind {

    public static void main(String[] args) {

        Map<String, Integer> names = new HashMap<>();
        names.put("Alice", 27);
        names.put("Bob", 28);
        names.put("Charlie", 29);
        names.put("Dave", 30);

        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().equals("Alice")) {
                //Note the use of the setValue method on the Map.Entry interface
                entry.setValue(entry.getValue() + 1);
            }
        }

        System.out.println("New age of Alice is: " + names.get("Alice"));//Prints: 28


        Map<String, Integer> myMap2 = new HashMap<>();
        myMap2.put("Alice", 111);
        myMap2.put("Bob", 222);
        for (Map.Entry<String, Integer> oneEntry : myMap2.entrySet()) {
            if (oneEntry.getKey().equals("Alice")) {
                 oneEntry.setValue(oneEntry.getValue()+1); // No exception is thrown here even though we are changing the value of the entry
            }
        }


    }

}
