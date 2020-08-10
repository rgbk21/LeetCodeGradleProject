package easy;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {

    }

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxSeenSoFar = 0;
        int overallMax = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i]==1) {
                maxSeenSoFar++;
            } else {
                overallMax = Math.max(overallMax, maxSeenSoFar);
                maxSeenSoFar = 0;
            }

        }

        return Math.max(overallMax, maxSeenSoFar);

    }

}
