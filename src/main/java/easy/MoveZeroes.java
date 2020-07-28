package easy;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) {
            return;
        }

        int idx = 0;

        for (int i : nums) {
            if (i != 0) {
                nums[idx++] = i;
            }
        }

        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes1(int[] nums) {

        int writeIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIdx++] = nums[i];
            }
        }

        for (int i = writeIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
