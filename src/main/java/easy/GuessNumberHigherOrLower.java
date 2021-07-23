package easy;

// https://leetcode.com/problems/guess-number-higher-or-lower/
public class GuessNumberHigherOrLower {

    public static void main(String[] args) {

    }

    public int guessNumber(int n) {

        int left = 1;
        int right = n;
        int mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int resultOfGuessAPICall = guess(mid);
            if (resultOfGuessAPICall == -1) {
                right = mid - 1;
            } else if (resultOfGuessAPICall == 1) {
                left = mid + 1;
            } else if (resultOfGuessAPICall == 0) {
                return mid;
            }
        }

        return -1;
    }

    private int guess(int mid) {
        return -1;
    }

}
