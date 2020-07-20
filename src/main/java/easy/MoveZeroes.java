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

}
