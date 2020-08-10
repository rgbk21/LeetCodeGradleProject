package easy;

public class FindNumbersWithEvenNumbersOfDigits {

    public static void main(String[] args) {

    }

    public int findNumbers(int[] nums) {

        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int currNum = nums[i];
            int numOfDigits = 0;

            while (currNum >= 1) {
                numOfDigits++;
                currNum = currNum / 10;
            }

            if (numOfDigits % 2 == 0) result++;

        }

        return result;

    }

}
