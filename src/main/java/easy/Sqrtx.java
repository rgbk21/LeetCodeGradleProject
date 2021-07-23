package easy;

// https://leetcode.com/problems/sqrtx/
public class Sqrtx {

    public static void main(String[] args) {
        Sqrtx squareRoot = new Sqrtx();
        squareRoot.mySqrt_v2(2147483647);
    }

    public int mySqrt_v2(int targetSqr) {

        // [0,1,2,3,4,5,6,7,8,9,10]
        int left = 0;
        int right = targetSqr;
        int mid;

        if (targetSqr == 0) return 0;
        if (targetSqr == 1) return 1;

        while (left + 1 < right){
            mid = left + (right - left) / 2;
            long sqrOfMid = (long) mid * mid;
            if (sqrOfMid > targetSqr) {
                right = mid;
            } else if (sqrOfMid < targetSqr) {
                left = mid;
            } else if (sqrOfMid == targetSqr) {
                return mid;
            }
        }

        long sqrOfLeft = (long) left * left ;
        long sqrOfMid = (long) (left + 1) * (left+1);
        long sqrOfRight = (long) right * right;

        if (sqrOfLeft < targetSqr && targetSqr < sqrOfMid) return left;
        if (sqrOfMid < targetSqr && targetSqr < sqrOfRight) return left + 1;
        if (sqrOfRight < targetSqr) return right;

        return -1;
    }

    public int mySqrt(int x) {

        // [0,1,2,3,4,5,6,7,8,9,10]
        int[] nums = new int[x+1];
        for (int i = 0; i <= x; i++) {
            nums[i] = i;
        }

        int left = 0;
        int right = x + 1;
        int mid = 0;

        if (nums.length == 1) return 0;
        if (nums.length == 2) return 1;

        while (left + 1 < right){
            mid = left + (right - left) / 2;
            int sqrOfMid = nums[mid] * nums[mid];
            if (sqrOfMid > x) {
                right = mid - 1;
            } else if (sqrOfMid < x) {
                left = mid + 1;
            } else if (sqrOfMid == x) {
                return sqrOfMid;
            }
        }

        int sqrOfLeft = nums[left] * nums[left] ;
        int sqrOfMid = nums[mid] * nums[mid];
        int sqrOfRight = nums[right] * nums[right];

        if (sqrOfLeft < x && x < sqrOfMid) return left;
        if (sqrOfMid < x && x < sqrOfRight) return mid;

        return -1;
    }
}
