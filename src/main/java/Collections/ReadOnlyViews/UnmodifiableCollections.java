package Collections.ReadOnlyViews;

import java.util.*;

public class UnmodifiableCollections {

    public static void main(String[] args) {

        // Creating Read Only View of a List
        List<String> stringList = new ArrayList<>(Arrays.asList("Alice","Bob","Charlie"));
        List<String> unmodifiableStringList = Collections.unmodifiableList(stringList);

        // Creating Read Only View of a Map
        Map<String, Integer> stringMap = new HashMap<>();
        stringMap.put("Alice", 21);
        stringMap.put("Bob", 22);
        stringMap.put("Charlie", 23);
        Map<String, Integer> unmodifiableStringMap = Collections.unmodifiableMap(stringMap);

        // Creating Read Only View of a Set
        Set<String> stringSet = new HashSet<>(Arrays.asList("Alice","Bob","Charlie"));
        Set<String> unmodifiableStringSet = Collections.unmodifiableSet(stringSet);

        // You have similar methods for the other datastructures such as:
        // unmodifiableNavigableMap
        // unmodifiableNavigableSet
        // unmodifiableSortedSet
        // unmodifiableSortedMap
    }
}
