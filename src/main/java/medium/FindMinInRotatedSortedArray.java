package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        // [4,5,6,7,0,1,2]
        // [41,5,3,2,1,0]
        // [12,14,16,18,20,22,24,26]
        // [26,12,14,16,18,20,22,24]
        // [16,18,20,22,24,26,12,14]
        FindMinInRotatedSortedArray f = new FindMinInRotatedSortedArray();
//        f.findMin(new int[]{3,4,5,1,2});
//        f.findMin(new int[]{11,13,15,17});
        f.findMin(new int[]{2,1});
        List<String> list = new ArrayList<>();
    }

    // Refer this card in order to understand why we are using the (left + 1 < right) condition on the while loop
    // https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/935/
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int mid;

        // If the input array contains a single element then we can return that single element as the min one
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        // If the array is continuously increasing then we can directly return the element at the 0th index
        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        // [12,14,16,18,20,22,24,26]
        // [26,12,14,16,18,20,22,24]
        // [16,18,20,22,24,26,12,14]
        while (left + 1 < right) {
            mid = (left + right) / 2;
            if (nums[left] < nums[mid]) {
                // inflection point is to the right of mid
                // Hence we drop the array from 0 to left - 1
                left = mid;
            } else if (nums[left] > nums[mid]) {
                // inflection point is to the left of mid
                // Hence we drop the array from mid + 1 to right
                right = mid;
            }
        }

        return Math.min(nums[left], nums[left + 1]);
        // You were incorrectly using three elements to compare. This is Template #3. At the end of the while loop,
        // you will only have 2 elements. Not 3.
        // return Math.min(Math.min(nums[left], nums[left + 1]), nums[right]);
    }

}
