package easy;

// https://leetcode.com/problems/binary-search/
public class BinarySearch {

    public static void main(String[] args) {
        // [-1,0,3,5,9,12]
        BinarySearch bs = new BinarySearch();
        bs.search_template1(new int[]{-1, 0, 3, 5, 9, 12}, 2);
        // Input to show why we need <= in the while loop and not just <
        bs.search_template3(new int[]{5}, 5);
    }

    // Binary Search implemented using template 3
    public int search_template3(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        if (nums.length == 2) {
            if (nums[0] == target) return 0;
            if (nums[1] == target) return 1;
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                // Note that using this causes a IndexOutOfBound Exception
                // right = mid - 1;
                // So use this instead
                right = mid;
            } else if (nums[mid] < target) {
                // Note that using this causes a IndexOutOfBound Exception
                // left = mid + 1;
                // So use this instead
                left = mid;
            } else if (nums[mid] == target) {
                return mid;
            }
        }

        // Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the condition.
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        // You were incorrectly using the below statement as well over here. This is not required.
        // At the point of termination of the loop, left + 1 == right
        // Hence checking this condition is redundant, since we are already checking above: if (nums[right] == target)
        // if (nums[left + 1] == target) return left+1;

        return -1;
    }

    // Binary Search implemented using template 1
    public int search_template1(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int mid;

        // <= over here, and not just < , because if the input array contains a single element then
        // the code straight away returns -1 which is incorrect
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // If you use this, you get an infinite loop
//                 right = mid;
                // Hence use this instead:
                right = mid - 1;
            } else if (nums[mid] < target) {
                // If you use this, you get an infinite loop
//                 left = mid;
                // Hence use this instead:
                left = mid + 1;
            }
        }
        return -1;
    }
}
