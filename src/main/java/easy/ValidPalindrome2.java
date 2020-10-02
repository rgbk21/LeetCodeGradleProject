package easy;

public class ValidPalindrome2 {

    public static void main(String[] args) {

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
