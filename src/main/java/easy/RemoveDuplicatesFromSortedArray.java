package easy;

public class RemoveDuplicatesFromSortedArray {

    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/

    public static void main(String[] args) {
        // removeDuplicates_v3(new int[] {0,1,2,3,4});
        // removeDuplicates_v3(new int[] {0,0,1,2,3,4});
         removeDuplicates_leetcodeSoln(new int[] {0,0,1,2,3,4});
         // removeDuplicates_v3(new int[] {1,1,2});
//         removeDuplicates_v3(new int[] {1,2});
    }

    // [0,0,1,1,1,2,2,3,3,4]
    // [0,0,1,1,1,2,2,3,3,4]
    // [0,1,2,3,4]
    public static int removeDuplicates_v3(int[] nums){

        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int leftIdx = 0;
        int rightIdx = leftIdx + 1;
        int prevNum = nums[leftIdx++];
        while (rightIdx < nums.length) {
            int currNum = nums[rightIdx];
            if (currNum == prevNum) {
                // Note here that if you are iterating over the array in another loop inside the parent loop
                // You need to make sure that you are breaking out of the loop either by having a condition in the loop
                // or using break
                while (currNum == prevNum) {
                    rightIdx++;
                    if (rightIdx >= nums.length) break;
                    currNum = nums[rightIdx];
                }
            } else {
                nums[leftIdx] = nums[rightIdx];
                prevNum = nums[leftIdx];
                leftIdx++; rightIdx++;
            }
        }

        // If we have reached this point, it means that there already are atleast 2 elements in the array.
        // Hence there has to be atleast one unique element in the array.
        // In a sorted array, find the first element that is either equal to or less than the previous element
        // You were trying to do this with a for loop and failed miserably.
        int numOfUniqueElmnts = 1;
        int idx = 1;
        while (idx < nums.length) {
            if (nums[idx - 1] >= nums[idx]) {
                break;
            }
            numOfUniqueElmnts++;
            idx++;
        }
        return numOfUniqueElmnts;
    }

    public static int removeDuplicates_leetcodeSoln(int[] nums) {

        // Check for edge cases.
        if (nums == null) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }

        // This turns out to be the correct length value.
        return writePointer;
    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lastUniqueIdx = 0;
        int lastUniqueNum = nums[0];

        for (int i = 0; i < nums.length; i++){
            if (lastUniqueNum != nums[i]){
                lastUniqueNum = nums[i];
                nums[++lastUniqueIdx] = lastUniqueNum;
            }
        }
        return lastUniqueIdx + 1;
    }

    public static int removeDuplicates2(int[] nums){

        if(nums == null || nums.length == 0) {
            return 0;
        }

        int lastUniqueElement = nums[0];
        int idx = 1;

        for (int i : nums){
            if (i != lastUniqueElement){
                lastUniqueElement = i;
                nums[idx++] = i;
            }
        }

        return idx;

    }

}
