package easy;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray {

    public static void main(String[] args) {

        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(input);

    }

    // Review
    public static int maxSubArray_v3(int[] nums){

        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currNum = nums[i];
            // So what kinds of conditions are we eliminating over here?
            // a) [-2,-3,1] This will eliminate -2 and -3 from the window
            // b) [-2,-3,-1] This will eliminate -2 and -3 from the window
            // c) [2,3,7] This sub array will be kept
            // d) [2,3,-1] This sub array will also be kept
            // Kind of dynamic programmingy because we are choosing
            // whether we want to add the curr element to the total sum or we want to
            // replace the currSum with the current number
            currSum = Math.max(currNum, currNum + currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
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
