package easy;

public class PlusOne {

    public static void main(String[] args) {

        int[] input = new int[] {4,3,2,1};
        plusOne(input);

    }

    public static int[] plusOne(int[] digits) {

        int[] result = new int[digits.length + 1];
        boolean carryOver = false;

        for(int i = digits.length - 1; i >= 0; i--){

            int currDigit = digits[i];
            if (currDigit == 9){
                digits[i] = 0;
                if (i == 0 ) {
                    carryOver = true;
                }
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        if (carryOver){

            result[0] = 1;
            //This for-loop is not really required because the only case in which the following scenario
            //will be triggered is number is something like 9999 -> which is then converted to 10000
            //So you can just change the first array element to 1 and leave the remaining as the default value which is 0.

            for (int i = 1; i < digits.length; i++){
                result[i] = digits[i];
            }
        }

        return result;
    }
}
