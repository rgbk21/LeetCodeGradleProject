package easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-anagram/

public class ValidAnagram {

    public static void main(String[] args) {
        isAnagram("a", "b");
    }

    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            charCount.merge(c, 1, (oldValue, value) -> oldValue + 1);
        }

        for (int i = 0; i < t.length(); i++) {

            Character c = t.charAt(i);

            Integer value = charCount.get(c);

            //Do not forget the value == null test over here
            if (value == null || value == 0) {
                return false;
            } else {
                value = value - 1;
                charCount.put(c, value);
            }
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }

        return true;
    }

}
