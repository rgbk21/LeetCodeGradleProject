package easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/buddy-strings/
public class BuddyStrings {

    public static void main(String[] args) {

    }

    public boolean buddyStrings(String s, String goal) {

        // different lengths
        if (s.length() != goal.length()) {
            return false;
        }

        // abbc
        // abbc

        // two strings differ only in 2 positions
        int diffCount = 0;
        int leftIdx = -1;
        int rightIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffCount++;

                if (diffCount == 1) {
                    leftIdx = i;
                } else if (diffCount == 2) {
                    rightIdx = i;
                }
            }
            if (diffCount > 2) {
                return false;
            }
        }

        if (diffCount == 1) {
            return false;
        }

        // Strings are equal
        if (diffCount == 0) {
            Set<Character> letters = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (letters.contains(s.charAt(i))) {
                    return true;
                } else {
                    letters.add(s.charAt(i));
                }
            }
            return false;
        }

        if ((s.charAt(leftIdx) == goal.charAt(rightIdx)) && s.charAt(rightIdx) == goal.charAt(leftIdx)) {
            return true;
        } else {
            return false;
        }

    }

}
