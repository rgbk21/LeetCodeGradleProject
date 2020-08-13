package easy;

public class SquaresOfASortedArray {

    //https://leetcode.com/problems/squares-of-a-sorted-array/

    public static void main(String[] args) {

    }

    //This is the stupidity that you were doing earlier
    public int[] sortedSquares(int[] A) {

        int[] result = new int[A.length];
        int idx1 = -1;
        int idx2Start = A.length;

        //Do you remember?
        //The index was not updating as you wanted.
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                idx2Start = i;
                idx1 = i - 1;
                break;
            }
        }

        int writeIdx = 0;
        int idx2 = idx2Start;

        while (idx1 >= 0 && idx2 < A.length) {

            if (Math.abs(A[idx1]) <= A[idx2]) {
                result[writeIdx++] = A[idx1--];
            } else {
                result[writeIdx++] = A[idx2++];
            }
        }

        //TODO: Note that the check for idx < 0 is not really required over here.
        //The check in the while loop of idx2 < A.length is going to take care that we do no execute
        //the code in the case that idx1 < 0. Makes sense?
        //The same holds for the second else if check as well.

        if (idx1 < 0) {
            while (idx2 < A.length) {
                result[writeIdx++] = A[idx2++];
            }
        } else if (idx2 == A.length) {
            while (idx1 >= 0) {
                result[writeIdx++] = A[idx1--];
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * result[i];
        }

        return result;

    }

    //Correct Solution
    public int[] sortedSquares2(int[] A) {

        int[] result = new int[A.length];
        int idx1 = -1;
        int idx2Start = A.length;

        //Do you remember?
        //The index was not updating as you wanted.
        for (int i = 0; i < A.length; i++) {
            idx2Start = i;
            idx1 = i - 1;
            if (A[i] >= 0) break;
        }

        int writeIdx = 0;
        int idx2 = idx2Start;

        while (idx1 >= 0 && idx2 < A.length) {

            if (Math.abs(A[idx1]) <= A[idx2]) {
                result[writeIdx++] = A[idx1--];
            } else {
                result[writeIdx++] = A[idx2++];
            }
        }

        if (idx1 < 0) {
            while (idx2 < A.length) {
                result[writeIdx++] = A[idx2++];
            }
        } else if (idx2 == A.length) {
            while (idx1 >= 0) {
                result[writeIdx++] = A[idx1--];
            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * result[i];
        }

        return result;

    }

}
