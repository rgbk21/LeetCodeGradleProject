package medium;

public class RotateArray {

    public static void main(String[] args) {

    }

    // [1,2,3,4,5,6,7], k = 3
    // [5,6,7,1,2,3,4]
    public void rotate_v2(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int mappedIdx = (i + k) % nums.length;
            result[mappedIdx] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    // [1,2,3,4,5,6,7], k = 3
    // [5,6,7,1,2,3,4]
    public void rotate_v1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            pushElementsOnePlaceToRight(nums);
        }
    }

    private void pushElementsOnePlaceToRight(int[] nums) {
        int rightMostEl = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = rightMostEl;
    }

}
