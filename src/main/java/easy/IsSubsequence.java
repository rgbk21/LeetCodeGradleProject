package easy;

public class IsSubsequence {

    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {

        //s = "abc", t = "ahbgdc"

        int leftIdx = 0;
        int rightIdx = 0;

        while (rightIdx < t.length()) {

            if (leftIdx >= s.length()) {
               return true;
            }

            if (s.charAt(leftIdx) == t.charAt(rightIdx)) {
                leftIdx++;
                rightIdx++;
            } else {
                rightIdx++;
            }

        }

        return leftIdx >= s.length();

    }

}
