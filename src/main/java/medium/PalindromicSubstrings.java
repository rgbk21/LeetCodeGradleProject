package medium;

public class PalindromicSubstrings {

    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {

        int strLen = s.length();
        int result = 0;

        for (int center = 0; center <= 2 * strLen - 1; center++) {

            int leftEdge = center / 2;
            int rightEdge = leftEdge + center % 2;

            while (leftEdge >= 0 && rightEdge < strLen && s.charAt(leftEdge) == s.charAt(rightEdge)) {
                result++;
                leftEdge--;
                rightEdge++;
            }
        }

        return result;
    }

}
