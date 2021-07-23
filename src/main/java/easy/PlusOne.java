package easy;

import java.util.Arrays;
import java.util.List;

public class PlusOne {

    // https://leetcode.com/problems/plus-one/

    public static void main(String[] args) {

        int[] input = new int[]{4, 3, 2, 1};
        Arrays.toString(input);
        plusOne(input);

    }

    public static int[] plusOne(int[] digits) {

        int[] result = new int[digits.length + 1];
        boolean carryOver = false;

        for (int i = digits.length - 1; i >= 0; i--) {

            int currDigit = digits[i];
            if (currDigit == 9) {
                digits[i] = 0;
                carryOver = true;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        if (carryOver) {

            result[0] = 1;
            //TODO:
            //This for-loop is not really required because the only case in which the following scenario
            //will be triggered is number is something like 9999 -> which is then converted to 10000
            //So you can just change the first array element to 1 and leave the remaining as the default value which is 0.
            for (int i = 1; i < digits.length; i++) {
                result[i] = digits[i];
            }
        }

        return result;
    }

    //4,3,2,1 -> 4,3,2,2
    public int[] plusOne_2(int[] digits){

        int carry = 1;
        int idx = digits.length - 1;

        while (carry == 1 && idx >= 0) {

            digits[idx] = (digits[idx] + carry) % 10;

            if (digits[idx] == 0) {
                carry = 1;
            } else {
                carry = 0;
            }

            idx--;

        }

        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i-1];
            }
            return result;
        } else {
            return digits;
        }


    }

}
