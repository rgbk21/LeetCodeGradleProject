package Collections.CreatingSingletonCollections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SingletonCollections {

    public static void main(String[] args) {

        List<String> singletonList = Collections.singletonList("Alice");

        // Note this is just called 'singleton'
        Set<String> singletonSet = Collections.singleton("Alice");

        // Note that this accepts two args
        Map<String, Integer> singletonMap = Collections.singletonMap("Alice", 21);
    }
}
