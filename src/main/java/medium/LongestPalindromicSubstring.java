package medium;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        lps.longestPalindrome("abbba");
    }

    public String longestPalindrome(String s) {

        String result = "";
        String overallResult = "";

        if (s == null || s.length() == 0) return result;

        for (int i = 0; i < s.length(); i++) {
            String s1 = expandAroundCenter(s, i);
            String s2 = expandAroundCenter(s, i, i+1);
            result = s1.length() > s2.length() ? s1 : s2;
            overallResult = result.length() > overallResult.length() ? result : overallResult;

        }

        return overallResult;

    }

    private String expandAroundCenter(String s, int i){

        int leftIdx = i - 1;
        int rightIdx = i + 1;
        StringBuilder result = new StringBuilder(Character.toString(s.charAt(i)));
        String result1 = Character.toString(s.charAt(i));

        while (leftIdx >= 0 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {

            result.insert(0, s.charAt(leftIdx));
            result.append(s.charAt(leftIdx));

            leftIdx--;
            rightIdx++;

        }

        return result.toString();

    }

    private String expandAroundCenter(String s, int i, int j){

        int leftIdx = i;
        int rightIdx = j;
        StringBuilder result = new StringBuilder();

        while (leftIdx >= 0 && rightIdx < s.length() && s.charAt(leftIdx) == s.charAt(rightIdx)) {

            result.insert(0, s.charAt(leftIdx));
            result.append(s.charAt(leftIdx));

            leftIdx--;
            rightIdx++;

        }

        return result.toString();

    }

}
