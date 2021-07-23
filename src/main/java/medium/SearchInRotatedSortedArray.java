package medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            if (nums[1] == target) return 1;
            return -1;
        }

        // Find the Pivot Index in the Array
        int pivotIdx = findPivotIdx(nums);

        System.out.println("Pivot Index: " + pivotIdx);

        int foundIdx;

        // Search in the LEFT array
        foundIdx = searchForElmntInSubArr(0, pivotIdx, nums, target);
        if (foundIdx != -1) return foundIdx;
        // Search in the RIGHT array
        // But only if the pivotIdx + 1 is less than the length of the array.
        // The pivot index can be the last element of the array in which case the below statement is going to throw a IndexOutOfBound
        // For example in this array: [3,5,1]
        if (pivotIdx + 1 < nums.length) {
            foundIdx = searchForElmntInSubArr(pivotIdx + 1, nums.length - 1, nums, target);
        }
        return foundIdx;
    }

    private int searchForElmntInSubArr(int left, int right, int[] nums, int target) {

        int mid;

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;

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

    private int findPivotIdx(int[] nums) {
        // [0,1,2,4,5,6,7]
        // [7,0,1,2,4,5,6]
        // [4,5,6,7,0,1,2]
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                left = mid;
            } else if (nums[mid] < nums[left]) {
                right = mid;
            }
        }

        if (nums[left] < nums[right]) return left;
        if (nums[left] > nums[right]) return right;

        return -1;
    }

}
