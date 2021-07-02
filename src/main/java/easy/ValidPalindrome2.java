package easy;

// https://leetcode.com/problems/valid-palindrome-ii/submissions/
public class ValidPalindrome2 {

    public static void main(String[] args) {

    }

    // Review
    public boolean validPalindrome_v4(String s){

        /*
        When you use v3 of the code, you run into Time Limit Exceeded on LeetCode.
        The crucial part that you are missing is that you can remove ONLY one character from the string.
        The thing to understand is in the case of below code, if the input string is already a palindrome, the if condition would never be triggered.
        Consider a string like: abbca vs bcfabadg
        abbca can be converted into palin by just removing c. But to convert bcfabadg you would have to remove multiple chars, and the problem does not allow that.
        So the loop would progress like this:
        abbca -> bbc -> left most and right most chars are no longer equal. Hence we delete the chars and branch
                        bb -> isPalindrome_v4 returns true
                        bc -> isPalindrome_v4 returns false
         Does this make any sense now?
         */

        int startIdx = 0;
        int endIdx = s.length() - 1;

        while (startIdx <= endIdx) {
            if (s.charAt(startIdx) != s.charAt(endIdx)) {
                return isPalindrome_v4(s, startIdx, endIdx - 1) || isPalindrome_v4(s, startIdx + 1, endIdx);
            }
            startIdx++;
            endIdx--;
        }
        return true;
    }

    private boolean isPalindrome_v4(String s, int startIdx, int endIdx) {

        while (startIdx <= endIdx) {
            if (s.charAt(startIdx) != s.charAt(endIdx)) {
                return false;
            }
            startIdx++;
            endIdx--;
        }
        return true;
    }

    public boolean validPalindrome_v3(String s){

        if (isPalindrome_v3(s)) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            String inputStr = sb.deleteCharAt(i).toString();
            boolean isPalindrome = isPalindrome_v3(inputStr);
            if (isPalindrome) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome_v3(String s) {
        if (s.length() % 2 == 0) {
            String leftStr = s.substring(0, s.length()/2);
            StringBuilder sb = new StringBuilder(s.substring(s.length()/2, s.length()));
            String rightStr = sb.reverse().toString();
            return leftStr.equalsIgnoreCase(rightStr);
        } else {
            String leftStr = s.substring(0, s.length()/2);
            StringBuilder sb = new StringBuilder(s.substring(s.length()/2 + 1, s.length()));
            String rightStr = sb.reverse().toString();
            return leftStr.equalsIgnoreCase(rightStr);
        }
    }

    public boolean validPalindrome(String s) {

        StringBuilder sb;

        for (int i = 0; i < s.length(); i++) {
            sb = new StringBuilder(s);
            sb = sb.deleteCharAt(i);

            if (isPalindrome(sb.toString())) {
                return true;
            }
        }

        return false;

    }

    private static boolean isPalindrome(String s) {

        int leftIdx = 0;
        int rightIdx = s.length() - 1;

        while (leftIdx <= rightIdx) {
            if (s.charAt(leftIdx) != s.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }

        return true;

    }

}
