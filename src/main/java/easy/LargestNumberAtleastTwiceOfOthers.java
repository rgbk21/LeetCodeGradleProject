package easy;

public class LargestNumberAtleastTwiceOfOthers {

    public static void main(String[] args) {

    }

    public int dominantIndex(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int maxNum = Integer.MIN_VALUE;
        int maxIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != maxIdx && (2 * nums[i] > maxNum)) {
                return -1;
            }
        }

        return maxIdx;

    }

}
