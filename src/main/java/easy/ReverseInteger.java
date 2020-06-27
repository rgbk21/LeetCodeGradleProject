package easy;

public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger.reverse(-123);
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
