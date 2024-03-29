package medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        lengthOfLongestSubstring_v6("abcabcbb");
    }

    public static int lengthOfLongestSubstring_v6(String s){

        Set<Character> window = new HashSet<>();
        int leftIdx = 0;
        int rightIdx = 0;
        int maxSubstrLen = 0;
        int currSubstrLen = 0;

        while(rightIdx < s.length() && leftIdx < s.length()) {

            if (!window.contains(s.charAt(rightIdx))) {
                window.add(s.charAt(rightIdx));
                rightIdx++;
                currSubstrLen = rightIdx - leftIdx;
                if (currSubstrLen > maxSubstrLen) {
                    maxSubstrLen = currSubstrLen;
                }
            } else {
                char repeatedChar = s.charAt(rightIdx);
                while(s.charAt(leftIdx) != repeatedChar) {
                    window.remove(s.charAt(leftIdx));
                    leftIdx++;
                }
                leftIdx++;
                rightIdx++;
            }
        }

        return maxSubstrLen;

    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> window = new LinkedHashMap<>();
        int maxLengthSeenSoFar = 0;
        int overallMaxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            Character currentChar = s.charAt(i);

            if (!window.containsKey(currentChar)) {
                window.put(currentChar, i);
                maxLengthSeenSoFar = window.size();

                if (maxLengthSeenSoFar > overallMaxLength) {
                    overallMaxLength = maxLengthSeenSoFar;
                }

            } else {

                int charAlreadySeenAtIdx = window.get(currentChar);

                Iterator<Map.Entry<Character, Integer>> iter = window.entrySet().iterator();

                while (iter.hasNext()) {
                    Map.Entry<Character, Integer> entry = iter.next();

                    if (entry.getValue() < charAlreadySeenAtIdx) {
                        iter.remove();
                    }

                    if (entry.getValue() == charAlreadySeenAtIdx) {
                        iter.remove();
                        break;
                    }
                }

                currentChar = s.charAt(i);
                window.put(currentChar, i);
            }
        }

        return overallMaxLength;

    }

    public static int lengthOfLongestSubstring_2(String s) {

        Set<Character> window = new HashSet<>();
        int n = s.length();
        int i = 0, j = 0;
        int overallMaxLength = 0;
        int maxLengthSeenSoFar = 0;

        while (i < n && j < n) {

            if (!window.contains(s.charAt(j))) {
                window.add(s.charAt(j));
                maxLengthSeenSoFar = window.size();
                overallMaxLength = Math.max(overallMaxLength, maxLengthSeenSoFar);
                j++;
            } else {
                window.remove(s.charAt(i));
                i++;
            }
        }

        return overallMaxLength;

    }

    //Why the fuck do you even try
    public static int lengthOfLongestSubstring_3(String s) {

        Map<Character, Integer> window = new HashMap<>();
        int n = s.length();
        int overallMaxLength = 0;
        int maxLengthSeenSoFar = 0;

        for (int i = 0, j = 0; j < n; j++) {

            Character currentChar = s.charAt(j);
            Integer idx = window.get(currentChar);
            if (!(window.containsKey(currentChar))) {
                window.put(currentChar, j);
                maxLengthSeenSoFar++;
                overallMaxLength = Math.max(overallMaxLength, maxLengthSeenSoFar);
            } else {
                if (window.get(currentChar) >= i) {
                    i = window.get(currentChar) + 1;
                    maxLengthSeenSoFar = j - i + 1;
                    window.put(currentChar, j);
                } else {
                    window.put(currentChar, j);
                    maxLengthSeenSoFar++;
                    overallMaxLength = Math.max(overallMaxLength, maxLengthSeenSoFar);
                }
            }
        }

        return overallMaxLength;

    }

    //Leetcode Solution
    public static int lengthOfLongestSubstring_4(String s) {

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            Character currentChar = s.charAt(j);
            if (map.containsKey(currentChar)) {
                i = Math.max(map.get(currentChar), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(currentChar, j + 1);
        }
        return ans;
    }

    //
    public static int lengthOfLongestSubstring_5(String s){

        Map<Character, Integer> charMap = new HashMap<>();

        int leftIdx = 0;
        int rightIdx = 0;
        int windowSize = 0;
        int overallMax = 0;

        while (rightIdx < s.length()) {

            //tmmzuxt

            Character currChar = s.charAt(rightIdx);

            if (!charMap.containsKey(currChar)) {
                charMap.put(currChar, rightIdx);
                rightIdx++;
                windowSize++;
                overallMax = Math.max(windowSize, overallMax);
            } else {
                int prevIdx = charMap.get(currChar);
                if (prevIdx < leftIdx) {
                    rightIdx++;
                    windowSize++;
                    overallMax = Math.max(windowSize, overallMax);
                    charMap.put(currChar, rightIdx);
                } else {
                    overallMax = Math.max(windowSize, overallMax);
                    leftIdx = prevIdx + 1;
                    windowSize = rightIdx - leftIdx + 1;
                    charMap.put(currChar, rightIdx);
                    rightIdx++;
                }
            }
        }

        return overallMax;

    }

}
