package Test1;

import java.util.HashSet;
import java.util.Set;

public class Binary_Pattern_Matching {

    public static void main(String[] args) {
        binaryPatternMatching("00", "bbbbbbbbbb");
    }

    // pattern = "010", s = "amazing"
    static int binaryPatternMatching(String pattern, String s) {

        if (pattern.length() > s.length()) return 0;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');

        int strLength = pattern.length();
        int result = 0;

        for (int i = 0; i < s.length() - strLength + 1; i++) {
            String substr = s.substring(i, i + strLength);
            if (doesStringMatch(substr, pattern, vowels)) result++;
        }

        return result;



    }

    private static boolean doesStringMatch(String substr, String pattern, Set<Character> vowels) {


        for (int i = 0; i < substr.length(); i++) {

            if (pattern.charAt(i) == '0' && !vowels.contains(substr.charAt(i))) {
                return false;
            }

            if (pattern.charAt(i) == '1' && vowels.contains(substr.charAt(i))) {
                return false;
            }

        }

        return true;

    }


}
