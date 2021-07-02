package easy;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger.reverse(-123);
    }

    // Copied from LeetCode Comments
    public static int reverse_v3(int x){
        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int reverse_v2(int x){

        boolean numberIsNegative = x < 0;
        int input = numberIsNegative ? -x : x;
        StringBuilder sb = new StringBuilder();

        String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();

        while (input >= 1) {
            int rightMostDigit = input % 10;
            sb.append(rightMostDigit);
            input = input / 10;
        }

        // This will not work because you are converting the string to an integer which is 32 bits. So the overflow would have already happened by now
        if (Integer.valueOf(sb.toString()) > Integer.MAX_VALUE || Integer.valueOf(sb.toString()) < Integer.MIN_VALUE) {

        }

        return 0;

    }

    public static int reverse(int x) {

        int newNum = Math.abs(x);
        int base = 10;
        int runningTotal = 0;
        int digit = 0;
        int numOfDigits = (int)(Math.log10(newNum) + 1);
        int loopCount = numOfDigits - 1;

        while (newNum >= 1) {
            digit = newNum % base;
            newNum /= base;
            runningTotal += (digit * (Math.pow(base, loopCount--)));
        }

        return x > 0 ? runningTotal : -runningTotal;
    }
}
