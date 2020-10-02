package easy;

public class FindPivotIndex {

    //https://leetcode.com/problems/find-pivot-index/
    public static void main(String[] args) {


    }

    // 1,7,3,6,5,6
    // 1,2,3
    public int pivotIndex(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return -1;
        }

        int leftSum = 0;
        int rightSum = 0;
        int pivotIdx = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        while (pivotIdx < nums.length) {

            if (leftSum == rightSum) {
                return pivotIdx;
            }

            leftSum += nums[pivotIdx];
            pivotIdx++;
            rightSum = pivotIdx == nums.length ? 0 : (rightSum - nums[pivotIdx]);

        }

        return -1;

    }

}
