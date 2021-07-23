package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicStrings {

    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {

        // Storing string in map
        Map<Character, List<Integer>> s_map = new HashMap<>();
        Map<Character, List<Integer>> t_map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);
            List<Integer> prevVal = s_map.get(currChar);
            if (prevVal == null) {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                s_map.put(currChar, positions);
            } else {
                prevVal.add(i);
                s_map.put(currChar, prevVal);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Character currChar = t.charAt(i);
            List<Integer> prevPositionsList = t_map.get(currChar);
            if (prevPositionsList == null) {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                t_map.put(currChar, positions);
            } else {
                prevPositionsList.add(i);
                t_map.put(currChar, prevPositionsList);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            Character s_currChar = s.charAt(i);
            Character t_currChar = t.charAt(i);
            List<Integer> s_positions = s_map.get(s_currChar);
            List<Integer> t_positions = t_map.get(t_currChar);
            boolean areEqual = s_positions.equals(t_positions);
            if (!areEqual) {
                return false;
            }
        }

        return true;
    }

}
