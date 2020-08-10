package Test1;

import java.util.*;

public class HashMapToArrayList {

    public static void main(String[] args) {

        Map<Character, int[]> charMap = new HashMap<>();

        List<Map.Entry<Character, int[]>> charList = new ArrayList<>(charMap.entrySet());

        //All of the below 3 statements do the same thing, in decreasing order of verbosity
        charList.sort( (entry1, entry2) -> {

            if (entry1.getValue()[0] > entry2.getValue()[0]) {
                return 1;
            } else if (entry1.getValue()[0] < entry2.getValue()[0]) {
                return  -1;
            } else {
                return 0;
            }

        });

        charList.sort( (entry1, entry2) -> {
            return Integer.compare(entry1.getValue()[0], entry2.getValue()[0]);
        });

        charList.sort(Comparator.comparingInt(entry -> entry.getValue()[0]));
    }

}
