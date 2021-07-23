package easy;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumbersWithEvenNumbersOfDigits {

    public static void main(String[] args) {

    }

    // By extracting each of the digit in the number
    public int findNumbers_v3(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int numOfDigits = countDigitsInNum(currNum);
            if (numOfDigits % 2 == 0) result++;
        }
        return result;
    }

    private int countDigitsInNum(int num) {
        int numOfDigits = 0;
        while (num > 0) {
            // This is how you extract the right most digit of a number if required (not in this case)
            int currDigit = num % 10;
            numOfDigits++;
            num = num / 10;
        }
        return numOfDigits;
    }

    // Using logarithms
    public int findNumbers_v2(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            // Using log to the base 10 to count the number of digits
            // Note that Math.log(num) is the natural log of num (log to the base e)
            // Here we are using log to the base 10
            int numOfDigits = (int) Math.floor(Math.log10(currNum)+1);
            if (numOfDigits % 2 == 0) result++;
        }
        return result;
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
