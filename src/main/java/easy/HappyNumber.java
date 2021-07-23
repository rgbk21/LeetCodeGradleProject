package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {

    }

    // 19
    public boolean isHappy(int n) {

        Set<Integer> sumOfSquaresOfDigits = new HashSet<>();
        boolean loopDetected = false;
        while (n != 1) {
            int sumOfSquares = calculateSumOfSquaresOf(n);
            n = sumOfSquares;
            boolean newValueAdded = sumOfSquaresOfDigits.add(sumOfSquares);
            if (!newValueAdded) {
                loopDetected = true;
                break;
            }
        }

        return !loopDetected;
    }

    private int calculateSumOfSquaresOf(int n) {
        int sumOfSquares = 0;
        while(n > 1) {
            int currDigit = n % 10;
            long squareOfCurrDigit = (long) currDigit * currDigit;
            sumOfSquares += squareOfCurrDigit;
            n = n / 10;
        }
        return sumOfSquares;
    }

}
