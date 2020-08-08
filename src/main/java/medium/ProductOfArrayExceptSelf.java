package medium;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

    }

    public int[] productExceptSelf(int[] nums) {

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftProduct[i] = 1;
            } else {
                leftProduct[i] = nums[i-1] * leftProduct[i-1];//check indices
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                rightProduct[i] = 1;
            } else {
                rightProduct[i] = nums[i+1] * rightProduct[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;

    }

}
