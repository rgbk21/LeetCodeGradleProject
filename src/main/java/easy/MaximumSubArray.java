package easy;

public class MaximumSubArray {

    public static void main(String[] args) {

        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(input);

    }

    public static int maxSubArray(int[] nums) {

        int maxSoFar = nums[0], maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static int anotherAttempt(int[] input){

        int partialMaxSum = input[0];
        int overallMaxSum = input[0];

        for(int i = 1; i < input.length; i++){

            partialMaxSum = Math.max(partialMaxSum + input[i], input[i]);
            overallMaxSum = Math.max(overallMaxSum, partialMaxSum);

        }

        return overallMaxSum;

    }

}
