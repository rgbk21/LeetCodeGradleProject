package medium;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/submissions/

public class RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {

        int[] nums = new int[] {1,1,1,2,2,3};
        removeDuplicates(nums);

    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lastUniqueElement = nums[0];
        int idx = 1;
        int count = 1;

        for (int j = 1; j < nums.length; j++) {

            int i = nums[j];

            if (i != lastUniqueElement){
                nums[idx++] = i;
                lastUniqueElement = i;
                count = 1;
            } else {
                if (count == 1) {
                    nums[idx++] = i;
                    count++;
                }
            }
        }
        return idx;
    }

}
