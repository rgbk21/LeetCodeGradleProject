package easy;

// https://leetcode.com/problems/count-binary-substrings/
public class CountBinarySubstrings {

    public static void main(String[] args) {

    }

    public int countBinarySubstrings(String s) {

        // List<String> result = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < s.length()-1; i++) {

            int leftIdx = i;
            int rightIdx = i+1;
            char charAtLeftIdx = s.charAt(leftIdx);
            char charAtRightIdx = s.charAt(rightIdx);

            if (charAtLeftIdx != charAtRightIdx) {
                int l = leftIdx;
                int r = rightIdx;
                while (l >= 0 && r < s.length() && s.charAt(l) == charAtLeftIdx && s.charAt(r) == charAtRightIdx) {
                    result++;
                    // result.add(s.substring(l, r+1));
                    l--;
                    r++;
                }
            }
        }
        return result;
    }

}
