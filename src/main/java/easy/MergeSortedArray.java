package easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[] {0};
        int[] nums2 = new int[] {1};
        merge_2(nums1, 0, nums2, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int idx1 = 0;
        int idx2 = 0;
        int writeIdx = 0;

        int[] copy_nums1 = Arrays.copyOfRange(nums1, 0, m);

        while (idx1 < copy_nums1.length && idx2 < nums2.length) {

            if (copy_nums1[idx1] < nums2[idx2]) {
                nums1[writeIdx++] = copy_nums1[idx1++];
            } else if (copy_nums1[idx1] > nums2[idx2]) {
                nums1[writeIdx++] = nums2[idx2++];
            } else {
                nums1[writeIdx++] = copy_nums1[idx1++];
            }

        }

        if (idx1 == copy_nums1.length) {
            while (idx2 < nums2.length) {
                nums1[writeIdx++] = nums2[idx2++];
            }
        } else if (idx2 == nums2.length) {
            while (idx1 < copy_nums1.length) {
                nums1[writeIdx++] = copy_nums1[idx1++];
            }
        }



    }

    public static void merge_2 (int[] nums1, int m, int[] nums2, int n) {

        int idx1 = m - 1;
        int idx2 = n - 1;
        int writeIdx = m+n-1;

        while (idx1 >= 0 && idx2 >= 0) {

            if (nums1[idx1] >= nums2[idx2]) {
                nums1[writeIdx--] = nums1[idx1--];
            } else {
                nums1[writeIdx--] = nums2[idx2--];
            }
        }

        //Note the <= sign. Earlier you had the == sign that was producing a bug
        if (idx1 <= 0) {
            while (idx2 >= 0) {
                nums1[writeIdx--] = nums2[idx2--];
            }
        } else if (idx2 <= 0) {
            while (idx1 >= 0) {
                nums1[writeIdx--] = nums1[idx1--];
            }
        }
    }

}
