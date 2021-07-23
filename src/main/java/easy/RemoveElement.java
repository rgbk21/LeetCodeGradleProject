package easy;

//https://leetcode.com/problems/remove-element/
public class RemoveElement {

    public static void main(String[] args) {
        removeElement2(new int[] {0,1,2,2,3,0,4,2}, 2);
    }

    // [0,1,2,2,3,0,4,2] Removing 2
    // [2,2,2,2,2,2]
    // [3,2,2,3] 3 [2,2,3,3]
    public static int removeElement_v3(int[] nums, int val) {

        int leftIdx = 0;
        int rightIdx = nums.length - 1;

        while (leftIdx <= rightIdx) {
            int currNum = nums[leftIdx];
            if (currNum == val) {
                int temp = nums[rightIdx];
                nums[rightIdx] = nums[leftIdx];
                nums[leftIdx] = temp;
                rightIdx--;
            } else {
                leftIdx++;
            }
        }

        return rightIdx + 1;
    }

    /*
    A very convoluted way of NOT doing something...

    public static int removeElement(int[] nums, int val) {

        int writeIdx = -1;
        boolean diffNumSeen = true;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == val && diffNumSeen){
                writeIdx = i;
                diffNumSeen = false;
            } else if (nums[i] != val) {
                if(writeIdx != -1){
                    diffNumSeen = true;
                    nums[writeIdx++] = nums[i];
                }
            }
        }
        return writeIdx-1;
    }
    */

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int idx = 0;

        for (int i : nums) {
            if (i != val) {
                nums[idx++] = i;
            }
        }
        return idx;

    }

}
