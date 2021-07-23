package easy;

import java.util.Arrays;
import java.util.List;

public class SquaresOfASortedArray {

    //https://leetcode.com/problems/squares-of-a-sorted-array/

    public static void main(String[] args) {
        // Can I convert an int[] to a List<Integer>
        int[] intArray = new int[]{-7,-3,2,3,11};
        List<Integer> intList = Arrays.asList();
        SquaresOfASortedArray squares = new SquaresOfASortedArray();
        squares.sortedSquares_v4(intArray);
    }

    // You were trying to find out a way in which we do not have to write the remaining items in the loop once the index limit has been reached
    // The test cases passs.
    // But the code is comicly slow. This on runs faster than only 10% of other submissions.
    // Then one below it runs faster than 100% of all submissions.
    public int[] sortedSquares_v4(int[] arr) {

        if (arr.length == 1) return computeSquaresOf(arr);

        int firstPositiveElmntIdx = getInflectionPointInArr(arr);

        // This is if all of the elements are in order
        if (firstPositiveElmntIdx == 0 && arr[0] >= 0) {
            return computeSquaresOf(arr);
        } else if (firstPositiveElmntIdx == 0 && arr[0] < 0) {
            int[] reverseArr = new int[arr.length];
            for (int i = arr.length - 1, idx = 0; i >= 0; i--) {
                reverseArr[idx++] = arr[i];
            }
            return computeSquaresOf(reverseArr);
        }

        // [-4,-1,0,3,10]
        int leftIdx = firstPositiveElmntIdx - 1;
        int rightIdx = firstPositiveElmntIdx;
        int[] sortedArr = new int[arr.length];
        int writeIdx = 0;

        while (leftIdx >= 0 || rightIdx < arr.length) {
            while (leftIdx >= 0 && (rightIdx >= arr.length || Math.abs(arr[leftIdx]) <= Math.abs(arr[rightIdx]))) {
                sortedArr[writeIdx++] = arr[leftIdx--];
            }
            while (rightIdx < arr.length && (leftIdx < 0 || Math.abs(arr[rightIdx]) < Math.abs(arr[leftIdx]))) {
                sortedArr[writeIdx++] = arr[rightIdx++];
            }
        }
        return computeSquaresOf(sortedArr);
    }

    public int[] sortedSquares_v3(int[] arr) {

        if (arr.length == 1) return computeSquaresOf(arr);

        int firstPositiveElmntIdx = getInflectionPointInArr(arr);

        // This is if all of the elements are in order
        if (firstPositiveElmntIdx == 0 && arr[0] >= 0) {
            return computeSquaresOf(arr);
        } else if (firstPositiveElmntIdx == 0 && arr[0] < 0) {
            int[] reverseArr = new int[arr.length];
            for (int i = arr.length - 1, idx = 0; i >= 0; i--) {
                reverseArr[idx++] = arr[i];
            }
            return computeSquaresOf(reverseArr);
        }

        // [-4,-1,0,3,10]
        int leftIdx = firstPositiveElmntIdx - 1;
        int rightIdx = firstPositiveElmntIdx;
        int[] result = new int[arr.length];
        int writeIdx = 0;

        while (leftIdx >= 0 && rightIdx < arr.length) {
            if (Math.abs(arr[leftIdx]) > arr[rightIdx]) {
                result[writeIdx++] = arr[rightIdx] * arr[rightIdx];
                rightIdx++;
            } else {
                result[writeIdx++] = arr[leftIdx] * arr[leftIdx];
                leftIdx--;
            }
        }

        if (rightIdx < arr.length) {
            while (rightIdx < arr.length) {
                result[writeIdx++] = arr[rightIdx] * arr[rightIdx];
                rightIdx++;
            }
        } else if (leftIdx >= 0) {
            while (leftIdx >= 0) {
                result[writeIdx++] = arr[leftIdx] * arr[leftIdx];
                leftIdx--;
            }
        }

        return result;
    }

    private int[] computeSquaresOf(int[] arr) {
        int[] squares = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            squares[i] = arr[i] * arr[i];
        }
        return squares;
    }

    private int getInflectionPointInArr(int[] arr) {
        int firstPositiveElmntIdx = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0 && arr[i + 1] >= 0) {
                firstPositiveElmntIdx = i + 1;
            }
        }

        return firstPositiveElmntIdx;
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
