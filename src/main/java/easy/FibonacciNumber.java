package easy;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    public static void main(String[] args) {

        // Note that Map.entry() returns an UNMODIFIABLE
        // What that means is that:
        // They are unmodifiable. Calls to Entry.setValue() on a returned Entry result in UnsupportedOperationException.
        Map.Entry<Integer, Integer> entry = Map.entry(1, 111);
        // So this operation is not allowed
        // entry.setValue(222); // Immutable object is modified (throws exception)

        // But the setValue method works when the entry is associated with a backing Map
        // What that means is that this operation is perfectly legal
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(1, 111);
        myMap.put(2, 222);
        for (Map.Entry<Integer, Integer> oneEntry : myMap.entrySet()) {
            if (oneEntry.getKey() == 2) {
                oneEntry.setValue(oneEntry.getValue()+1); // No exception is thrown here even though we are changing the value of the entry
            }
        }
        System.out.println("Value mapped to key 2: " + myMap.get(2)); // Value mapped to key 2: 223

        Map<String, Integer> myMap2 = new HashMap<>();
        myMap2.put("Alice", 111);
        myMap2.put("Bob", 222);
        for (Map.Entry<String, Integer> oneEntry : myMap2.entrySet()) {
            if (oneEntry.getKey().equals("Alice")) {
                // entry.setValue(entry.getValue()+1); // No exception is thrown here even though we are changing the value of the entry
            }
        }
//
//        myMap2.forEach((k,v) -> {
//            System.out.println("Key: " + k + ", Value: " + v);
//            if (k.equals("Alice")) {
//                v = v+1;
//            }
//        });

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
        for (Map.Entry<String, Integer> e : names.entrySet()) {
            if (e.getKey().equals("Alice")) {
                //Note the use of the setValue method on the Map.Entry interface
                e.setValue(e.getValue() + 1);
            }
        }
        System.out.println("New age of Alice is: " + names.get("Alice"));//Prints: 28



    }

    public int fib(int n) {
        int[] sum = new int[1];
        int result = calculateFibVal_v2(n, sum);
        return result;
    }

    private int calculateFibVal_v2(int n, int[] sum) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        sum[0] = calculateFibVal(n - 1, sum) + calculateFibVal(n - 1, sum);
        return sum[0];
    }


    // *********************************************************************************
    // Code using plain recursion. This runs only 5% faster than all of the submissions.
    public int fib_recursion(int n) {
        int[] sum = new int[1];
        int result = calculateFibVal(n, sum);
        return result;
    }

    private int calculateFibVal(int n, int[] sum) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        sum[0] = calculateFibVal(n - 1, sum) + calculateFibVal(n - 1, sum);
        return sum[0];
    }

}
