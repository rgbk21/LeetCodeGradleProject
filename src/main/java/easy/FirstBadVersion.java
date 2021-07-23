package easy;

// https://leetcode.com/problems/first-bad-version/
public class FirstBadVersion {

    public static void main(String[] args) {

    }

    public int firstBadVersion_v2(int n){

        int left = 1;
        int right = n;
        int mid;

        if (n == 1) return isBadVersion(n) ? 1 : -1;
        if (n == 2) {
            if (isBadVersion(1)) return 1;
            if (isBadVersion(2)) return 2;
        }

        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            boolean currVersionBad = isBadVersion(mid);
            if (currVersionBad) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (isBadVersion(left)) return left;
        if (isBadVersion(right)) return right;

        return -1;
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
