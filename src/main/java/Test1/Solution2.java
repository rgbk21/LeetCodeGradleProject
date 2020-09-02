package Test1;

import java.util.*;

public class Solution2 {


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<Integer> lengthEachScene(List<Character> inputList) {

        List<Integer> result = new ArrayList<>();

        if (inputList == null || inputList.size() == 0) {
            return result;
        }

        Map<Character, List<Integer>> charPositions = new HashMap<>();

        for (int i = 0; i < inputList.size(); i++) {

            Character currChar = inputList.get(i);

            if (charPositions.containsKey(currChar)) {
                List<Integer> li = charPositions.get(currChar);
                li.add(i);
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(i);
                charPositions.put(currChar, li);
            }
        }

        List<Map.Entry<Integer, Integer>> sets = new ArrayList<>();


        Character currChar = inputList.get(0);
        List<Integer> posns = charPositions.get(currChar);
        Integer leftidx = posns.get(0);
        Integer rightIdx = posns.get(posns.size() - 1);
        Map.Entry<Integer, Integer> e = new AbstractMap.SimpleEntry<>(leftidx, rightIdx);
        sets.add(e);


        for (int i = 1; i < inputList.size(); i++) {

            currChar = inputList.get(i);
            posns = charPositions.get(currChar);
            leftidx = posns.get(0);
            rightIdx = posns.get(posns.size() - 1);
            e = new AbstractMap.SimpleEntry<>(leftidx, rightIdx);

            if (e.getKey() < sets.get(i-1).getValue()) {
                if (e.getValue() > sets.get(i-1).getValue()) {
                    sets.remove(i-1);
                }
            }

            sets.add(e);


        }



        return result;

    }
    // METHOD SIGNATURE ENDS


}
