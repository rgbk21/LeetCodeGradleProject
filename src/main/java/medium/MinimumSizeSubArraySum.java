package medium;

public class MinimumSizeSubArraySum {

    public static void main(String[] args) {
        MinimumSizeSubArraySum ms = new MinimumSizeSubArraySum();
        ms.minSubArrayLen(7, new int[] {2,3,1,2,4,3});
    }

    // [2,3,1,2,4,3] 7
    public int minSubArrayLen_v2(int target, int[] nums) {

        int result = Integer.MAX_VALUE;
        int leftIdx = 0;
        int rightIdx = 0;
        int currSum = 0;

        while (rightIdx < nums.length) {
            currSum += nums[rightIdx];
            while (currSum >= target) {
                result = Math.min(result, rightIdx - leftIdx + 1);
                currSum -= nums[leftIdx++];
            }
            rightIdx++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // [2,3,1,2,4,3] 7
    // [5,2,3,1,7] 4
    // Pathetic
    // You misunderstood the question and read that the sum of the window should be EQUAL to the target whereas really
    // the sum should be >= target
    // Go through this solution carefully to see how you were trying to create the window
    // and why it was wrong.
    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 1 : 0;
        }

        // If nums contains the target value itself
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return 1;
            }
        }

        // [2,3,1,2,4,3] 7
        // [5,2,3,1,7] 4

        int leftIdx = 0;
        int rightIdx = 1;
        int currSum = nums[0] + nums[1];
        int minLengthOfWindow = Integer.MAX_VALUE;

        // What happens to the window if all the elements in the array are larger than the target?
        // [3,4,5,6,7] target = 1
        while (rightIdx < nums.length && leftIdx < nums.length) {
            // currSum = currSum + nums[rightIdx];
            if (currSum > target) {
                currSum -= nums[leftIdx++];
            } else if (currSum < target) {
                currSum += nums[++rightIdx];
            } else if (currSum == target) {
                int currLenOfWindow = rightIdx - leftIdx + 1;
                minLengthOfWindow = Math.min(currLenOfWindow, minLengthOfWindow);
                rightIdx++;
                // Now what? What do you assign the currSum to?
                // You cannot just do
                // currSum += nums[rightIdx];
                // because what if the rightIdx is now == the length of the array after incrementing above?
                // It will throw exception
            }
        }

        if (rightIdx == nums.length && leftIdx < nums.length) {

            while (leftIdx < nums.length) {
                currSum -= nums[leftIdx++];
                int currLenOfWindow = rightIdx - leftIdx + 1;
                minLengthOfWindow = Math.min(currLenOfWindow, minLengthOfWindow);
            }
        }

        return minLengthOfWindow == Integer.MAX_VALUE ? 0 : minLengthOfWindow;
    }


}
