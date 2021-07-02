package easy;

import java.util.Random;

public class FirstBadVersion {

    public static void main(String[] args) {

    }

    // Review:
    // Binary Search Algo.
    // Using <= leads to an infinite loop. Use < instead if you want the program to terminate
    // Why are we returning 'low'? How do we know that it is 'low' that should be returned.
    public int firstBadVersion(int n) {

        int low = 0;
        int high = n;

        while (low <= high) {
            int mid = low + ((high - low)/2);
            boolean isBadVersion = isBadVersion(mid);
            if (isBadVersion) {
                // 1 2 3 4 5 6 7 8 9
                // G G G B B B B B B
                //
                high = mid;
            } else {
                low = mid+1;
            }
        }

        return low;
    }

    private boolean isBadVersion(int n) {
        return false;
    }

}
