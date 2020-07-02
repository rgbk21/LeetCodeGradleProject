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

}
