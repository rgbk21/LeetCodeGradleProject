package Collections.CreatingEmptyCollections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmptyCollections {

    public static void main(String[] args) {

        // Note that all the empty datastructures that are returned by the Collections class are also immutable

        // Creating an empty list. Note that the list is also immutable.
        List<String> emptyList = Collections.emptyList();

        // Creating an empty map.
        Map<String, Integer> emptyMap = Collections.emptyMap();

        // Creating an empty set
        Set<String> emptySet = Collections.emptySet();

        // Similarly, you have empty datastructures for the others as well
        // Collections.emptyNavigableMap()
        // Collections.emptyNavigableSet()
        // Collections.emptySortedSet()
        // Collections.emptySortedMap()
    }
}
