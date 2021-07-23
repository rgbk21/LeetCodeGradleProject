package medium;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {

    }

    // This solution is slower than 93% of all the solutions on LC.
    // Read the official solution.
    public int[] searchRange(int[] nums, int target) {
        // [5,7,7,8,8,10] => [3,4]
        int[] result = new int[2];

        int someIdxOfTarget = findSomeIndexOfTarget(nums, target);
        System.out.println("Some Index of Target: " + someIdxOfTarget);

        if (someIdxOfTarget == -1) return new int[]{-1,-1};

        int leftmostIdxOfTarget = findLeftMostIndexOfTarget(nums, target, someIdxOfTarget);
        System.out.println("Left Most Index of Target: " + leftmostIdxOfTarget);

        int rightmostIdxOfTarget = findRightMostIndexOfTarget(nums, target, someIdxOfTarget);
        System.out.println("Right Most Index of Target: " + rightmostIdxOfTarget);

        result[0] = leftmostIdxOfTarget;
        result[1] = rightmostIdxOfTarget;

        return result;
    }

    private int findRightMostIndexOfTarget(int[] nums, int target, int targetIdx) {
        int left = targetIdx;
        int right = nums.length - 1;
        int mid;

        if (targetIdx == nums.length - 1) return nums.length - 1;
        if (targetIdx == nums.length - 2) {
            if (nums[nums.length - 1] == target) return nums.length - 1;
            return nums.length - 2;
        }

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[right] == target) return right;
        if (nums[left] == target) return left;

        return -1;
    }

    private int findLeftMostIndexOfTarget(int[] nums, int target, int targetIdx) {

        int left = 0;
        int right = targetIdx;
        int mid;

        if (targetIdx == 0) return 0;
        if (targetIdx == 1) {
            if (nums[0] == target) return 0;
            return 1;
        }

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;

        return -1;
    }

    private int findSomeIndexOfTarget(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

}
