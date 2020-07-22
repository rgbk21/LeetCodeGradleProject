package easy;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        removeDuplicates(new int[] {1,1,2});
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
