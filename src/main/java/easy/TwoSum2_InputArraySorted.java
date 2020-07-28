package easy;

public class TwoSum2_InputArraySorted {

    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {

        int left = 0, right = numbers.length - 1;

        while (left <= right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }

}
