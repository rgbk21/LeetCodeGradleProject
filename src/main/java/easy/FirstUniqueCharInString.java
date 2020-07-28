package easy;

import java.util.*;

//https://leetcode.com/problems/first-unique-character-in-a-string/

public class FirstUniqueCharInString {

    public static void main(String[] args) {
        firstUniqChar_2("loveleetcode");
    }

    public static int firstUniqChar(String s) {

        Set<Character> allChars = new HashSet<>();
        boolean isRepeat = false;

        for (int i = 0; i < s.length(); i++) {

            if (!allChars.contains(s.charAt(i))) {

                allChars.add(s.charAt(i));

                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == s.charAt(i)){
                        isRepeat = true;
                        break;
                    }
                }

                if (!isRepeat) {
                    return i;
                }
            }
            isRepeat = false;
        }

        return -1;
    }

    public static int firstUniqChar_2(String s){

        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for (Character c : s.toCharArray()) {
            //Note that if you replace the (count + 1) with count++, the updated value is never stored in the map.
            charMap.computeIfPresent(c, ((character, count) -> count + 1));
            charMap.putIfAbsent(c, 1);
        }

        //Iterating over the Map instead of the String like an idiot
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            if (entry.getValue() ==  1) {
                return s.indexOf(entry.getKey());
            }
        }

        return -1;
    }

    public static int firstUniqChar_3(String s){

        Map<Character, Integer> charMap = new LinkedHashMap<>();

        for (Character c : s.toCharArray()) {
            //Note that if you replace the (count + 1) with count++, the updated value is never stored in the map.
            charMap.computeIfPresent(c, ((character, count) -> count + 1));
            charMap.putIfAbsent(c, 0);
        }

        for (Character c : s.toCharArray()) {
            if (charMap.get(c) == 1) {
                return s.indexOf(c);
            }
        }

        return -1;
    }

    public static int firstUniqChar_4(String s){

        Map<Character, Integer> charMap = new LinkedHashMap<>();

        //In Java 8 you can merge
        //https://stackoverflow.com/a/42648785/8742428
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charMap.merge(c, 1, (character, count) -> count + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.get(c) == 1) {
                return s.indexOf(c);
            }
        }

        return -1;
    }

    public static int firstUniqChar_5(String s) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            charMap.merge(currentChar, 1, (prevValue, value) -> prevValue + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (charMap.get(currentChar) == 1) {
                return i;
            }
        }

        return -1;

    }


}
