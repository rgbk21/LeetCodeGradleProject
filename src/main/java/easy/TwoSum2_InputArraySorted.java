package easy;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2_InputArraySorted {

    public static void main(String[] args) {

        // 1. initialize a hash map
        Map<String, Integer> hashmap = new HashMap<>();

        // 2. insert a new (key, value) pair
        hashmap.put("Alice", 25);
        hashmap.put("Bob", 26);
        hashmap.put("Charlie", 27);
        hashmap.put("Dave", 28);
        System.out.println("HashMap after insertions: " + hashmap); // {Bob=26, Alice=25, Charlie=27, Dave=28}

        // 3. insert a new (key, value) pair or update the value of existed key
        // So if the key already exists in the HashMap, put() will replace the value with the new value that you provided
        hashmap.put("Alice", 29);
        System.out.println("HashMap after change: " + hashmap); // {Bob=26, Alice=29, Charlie=27, Dave=28}

        // Another point to note is the return value of the put() method. If the key was already associated with a value,
        // then the put() method returns the previous value
        Integer aliceVal = hashmap.put("Alice", 31);
        System.out.println("The previous value that was associated with the key 'Alice': " + aliceVal); // 29
        System.out.println("HashMap after change: " + hashmap); // {Bob=26, Alice=31, Charlie=27, Dave=28}

        // If there was no such key present earlier in the HashMap, then the put() method just returns null
        Integer eveVal = hashmap.put("Eve", 33);
        Assertions.assertNull(eveVal); // true
        System.out.println("The previous value that was associated with the key 'Eve': " + eveVal); // null
        System.out.println("HashMap after adding Eve: " + hashmap); // {Bob=26, Eve=33, Alice=31, Charlie=27, Dave=28}

        // 3.1. putIfAbsent - will add the <key, value> pair to the Map only if the key was not already present in the map
        // Alice is already present in the map. Hence it's not added/overwritten
        hashmap.putIfAbsent("Alice", 30);
        System.out.println("HashMap after Alice putIfAbsent: " + hashmap); // {Bob=26, Eve=33, Alice=31, Charlie=27, Dave=28}
        // But Frank is added because it was not already present in the Hash Map.
        hashmap.putIfAbsent("Frank", 36);
        System.out.println("HashMap after Frank putIfAbsent: " + hashmap); // {Bob=26, Eve=33, Alice=31, Charlie=27, Dave=28, Frank=36}

        // 4. get the value of specific key
        Integer aliceVal2 = hashmap.get("Alice");
        System.out.println("The value of key 'Alice' is: " + aliceVal2); // 31

        // If the key is not present, we get null
        Integer asd = hashmap.get("Asd");
        Assertions.assertNull(asd); // true

        // 5. delete a key
        // Returns the value mapped to the key. If there was no value mapped to the key (i.e. key did not exist, then returns null)
        Integer daveVal = hashmap.remove("Dave");
        Integer daveValAfterRemoval = hashmap.remove("Dave");
        System.out.println("Value returned after removing Dave: " + daveVal); // 28
        Assertions.assertNull(daveValAfterRemoval); // true
        System.out.println("HashMap after removing Dave: " + hashmap); // {Bob=26, Eve=33, Alice=31, Charlie=27, Frank=36}

        // 6. check if a key is in the hash map
        if (hashmap.containsKey("Charlie")) {
            System.out.println("Key Charlie is in the hash map.");
        }

        // 7. get the size of the hash map
        System.out.println("The size of hash map is: " + hashmap.size());

        // 8. iterate the hash map
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            System.out.print("(" + entry.getKey() + "," + entry.getValue() + ") ");
        }

        // 9. clear the hash map
        hashmap.clear();

        // 10. check if the hash map is empty
        if (hashmap.isEmpty()) {
            System.out.println("hash map is empty now!");
        }
    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left <= right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

}
