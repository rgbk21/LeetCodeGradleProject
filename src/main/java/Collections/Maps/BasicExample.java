package Collections.Maps;

import java.util.*;

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
        // But you can change the value associated with a <key, value> pair.

        // Removing an element from the Map is not allowed while iterating over it
        // Throws: ConcurrentModificationException
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().equals("Bob")) {
                // names.remove("Bob");
            }
        }

        // Adding an element to the Map is also not allowed while iterating over it
        // Throws: ConcurrentModificationException
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().equals("Bob")) {
                // names.put("Eve", 31);
            }
        }

        // But you can change the value of an element
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().equals("Alice")) {
                //Note the use of the setValue method on the Map.Entry interface
                entry.setValue(entry.getValue() + 1);
            }
        }
        System.out.println("New age of Alice is: " + names.get("Alice"));//Prints: 28

        //You could also have used the put() method to do the same thing.
        for (Map.Entry<String, Integer> entry : names.entrySet()) {
            if (entry.getKey().equals("Bob")) {
                names.put("Bob", entry.getValue() + 1);
            }
        }

        System.out.println("\nNew age of Bob is: " + names.get("Bob"));//Prints: 29

        // ********************************************************************************************************
        // Showing you cannot iterate over and simultaneously modify a Set either

        Set<String> nameSet = new HashSet<>();
        nameSet.add("Alice");
        nameSet.add("Bob");
        nameSet.add("Charlie");

        // Adding elements to a Set while iterating over it
        // Throws ConcurrentModificationException
        for (String name : nameSet) {
            if (name.equals("Alice")) {
                // nameSet.add("Dave");
            }
        }
        // Removing elements from a set while iterating over it
        // Throws ConcurrentModificationException
        for (String name : nameSet) {
            if (name.equals("Alice")) {
                // nameSet.remove("Bob");
            }
        }

        // ************************************************************************************************************
        // How do you remove elements from a Set while iterating over it then?
        // Similar to the List, you use the removeIf() method
        Set<String> nameSet2 = new HashSet<>();
        nameSet2.add("Alice");
        nameSet2.add("Bob");
        nameSet2.add("Charlie");
        nameSet2.add("Dave");
        nameSet2.add("Eve");

        // Using the removeIf() method on a Set.
        nameSet2.removeIf(name -> name.contains("a"));
        System.out.println(nameSet2); // [Bob, Eve, Alice]

        // Note that Set also has a forEach method, just like Map.
        // But I cannot think of a reason why you would prefer using forEach over a traditional for loop

        // ************************************************************************************************************
        // How do you remove elements from a Map while iterating over it then?
        Map<String, Integer> nameMap2 = new HashMap<>();
        nameMap2.put("Alice", 27);
        nameMap2.put("Bob", 28);
        nameMap2.put("Charlie", 29);
        nameMap2.put("Dave", 30);

        System.out.println(nameMap2); // {Bob=28, Alice=27, Charlie=29, Dave=30}
        nameMap2.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // Using the removeIf() method on a Map.
        nameMap2.entrySet().removeIf(entry -> entry.getValue() > 29);
        System.out.println(nameMap2); // {Bob=28, Alice=27, Charlie=29}

        // ************************************************************************************************************
        // All 3 ways of removing from a Map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "value 1");
        map.put(2, "value 2");
        map.put(3, "value 3");
        map.put(4, "value 4");
        map.put(5, "value 5");
        System.out.println("Original Map: " + map); // Original Map: {1=value 1, 2=value 2, 3=value 3, 4=value 4, 5=value 5}

        // remove by key
        map.keySet().removeIf(key -> key == 1);
        System.out.println(map); // {2=value 2, 3=value 3, 4=value 4, 5=value 5}

        // remove by value
        map.values().removeIf(value -> value.contains("2"));
        System.out.println(map); // {3=value 3, 4=value 4, 5=value 5}

        // remove by entry/combination of key + value
        map.entrySet().removeIf(entry -> entry.getKey() == 3);
        System.out.println(map); // {4=value 4, 5=value 5}
    }

    // This is fine.
    private List<String> findPeopleOlderThan29(Map<String, Integer> people) {
        List<String> result = new ArrayList<>();
        // Each element passed into the lambda function is an Entry type, with the key and value separated (?)
        people.forEach((name, age) -> {
            if (age > 29) {
                result.add(name);
            }
        });
        return result;
    }

    // But note that this does not compile
    private String findFirstPersonOlderThan29(Map<String, Integer> people) {
        // https://stackoverflow.com/a/47005706/8742428
        // The forEach method in a Collection expects a Consumer which means a function that takes a value, but doesn't return anything.
        // That's why you can't use return name; but a return; works fine.
        //If you want to break out of the loop when your condition is met, it's better to use a simple for(...) loop.
        // As shown in the method findFirstPersonOlderThan29_v2 below this on
        people.forEach((name, age) -> {
            if (age > 29) {
                // return name; // Compile Error: Unexpected return value
            }
        });
        return "Not Found";
    }

    // Use the traditional for loop instead
    private String findFirstPersonOlderThan29_v2(Map<String, Integer> people) {
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (entry.getValue() > 29) {
                return entry.getKey();
            }
        }
        return "Not Found";
    }

    // Ok, so I cannot return a value from a forEach method, but what would happen if I tried to return void from within the forEach loop?
    // Would it just exit the loop? NO!
    private List<String> test(Map<String, Integer> nameMap2) {
        List<String> result = new ArrayList<>();
        nameMap2.put("Alice", 27);
        nameMap2.put("Bob", 28);
        nameMap2.put("Charlie", 29);
        nameMap2.put("Dave", 30);
        // Each element passed into the lambda function is an Entry type, with the key and value separated (?)
        nameMap2.forEach((name, age) -> {
            System.out.println("Name: " + name + ", Age: " + age);
            // https://stackoverflow.com/a/47005706/8742428
            // In this example of a return; execution will simply exit the lambda and proceed to the next element in the collection.
            // The loop will not be ended.
            // So I guess it is same as continue?
            // Yes, it's effectively the same as a continue in a "standard" loop
            return;
            // System.out.println("-------");
        });
        return result;
    }
}
