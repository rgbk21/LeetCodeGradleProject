package easy;

// https://leetcode.com/problems/duplicate-zeros/
public class DuplicateZeroes {

    public static void main(String[] args) {

//        duplicateZeros_v4(new int[]{0, 0, 0, 0, 0, 0, 0});
        duplicateZeros_v4(new int[] {1,0,2,3,0,0,5,0});

    }

    // Run the v3 code with the following input to see why we had to write the v4: {1,0,2,3,0,0,5,0}
    // There is an edge case scenario that is really causing a lot of trouble
    public static void duplicateZeros_v4(int[] arr) {

        // If there are no zeroes in the array, then no changes need to be done in the array
        boolean zeroesInArr = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroesInArr = true;
                break;
            }
        }
        if (!zeroesInArr) return;

        // Count the number of zeroes that need to be pushed to the end of the array
        // and push them.
        // [1,0,2,3,0,4,5,0] => [1,0,2,3,0,4,0,0]
        // At the end of the loop, the writeIdx will be at element 4.
        int readIdx = 0;
        int writeIdx = arr.length - 1;
        while (readIdx < writeIdx) {
            int currNum = arr[readIdx++];
            if (currNum == 0) {
                arr[writeIdx--] = 0;
            }
        }

        // This if condition is satisfied in the edge case scenario
        // In other scenarios readIdx is greater than the writeIdx
        boolean edgeCaseScenario = false;
        if (readIdx == writeIdx && arr[readIdx] == 0) {
            edgeCaseScenario = true;
        }

        // [1,0,2,3,0,4,0,0]
        // The writeIdx is at element 4
        int swapIdx = writeIdx;
        writeIdx = arr.length - 1;
        while (swapIdx >= 0) {
            int currNum = arr[swapIdx--];
            if (currNum == 0) {
                // If it is the edgeCaseScenario, then we know that there is no extra space for the right most 0
                // In that case, we just shift the 0 to the rightmost position of the array without duplicating it
                // That is why we are only writing the currNum once.
                if (edgeCaseScenario) {
                    arr[writeIdx--] = currNum;
                    edgeCaseScenario = false;
                } else {
                    arr[writeIdx--] = currNum;
                    arr[writeIdx--] = currNum;
                }
            } else {
                arr[writeIdx--] = currNum;
            }
        }
    }

    public static void duplicateZeros_v3(int[] arr) {

        // If there are no zeroes in the array, then no changes need to be done in the array
        boolean zeroesInArr = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroesInArr = true;
                break;
            }
        }
        if (!zeroesInArr) return;

        // Count the number of zeroes that need to be pushed to the end of the array
        // and push them.
        // [1,0,2,3,0,4,5,0] => [1,0,2,3,0,4,0,0]
        // At the end of the loop, the writeIdx will be at element 4.
        int readIdx = 0;
        int writeIdx = arr.length - 1;
        while (readIdx < writeIdx) {
            int currNum = arr[readIdx++];
            if (currNum == 0) {
                arr[writeIdx--] = 0;
            }
        }

        // [1,0,2,3,0,4,0,0]
        // The writeIdx is at element 4
        int swapIdx = writeIdx;
        writeIdx = arr.length - 1;
        while (swapIdx >= 0) {
            int currNum = arr[swapIdx--];
            if (currNum == 0) {
                arr[writeIdx--] = currNum;
                arr[writeIdx--] = currNum;
            } else {
                arr[writeIdx--] = currNum;
            }
        }
    }

    // [1,0,2,3,0,4,5,0]
    // [1,0,0,3,0,4,5,2]
    // [1,0,0,2,0,4,5,3]
    // [1,0,0,2,3,0,4,5]
    // [1,0,0,2,3,0,0,4]
    // [1,0,0,2,3,0,0,4]
    public static void duplicateZeros_v2(int[] arr) {

        int readIdx = 0;
        int writeIdx = 0;
        int swapIdx = arr.length - 1;
        boolean zeroesInArr = false;

        // If there are no zeroes in the array, then no changes need to be done in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroesInArr = true;
                break;
            }
        }

        if (!zeroesInArr) return;

        // If we reach here, it means there is at least one zero in the input arr
        // Check the equality condition
        while (readIdx < swapIdx) {
            int currNum = arr[readIdx];
            if (currNum == 0) {
                arr[swapIdx] = arr[readIdx + 1];
                arr[readIdx + 1] = 0;
                swapIdx--;
            }
        }


    }

    public static void duplicateZeros(int[] arr) {

        //figure out the number of elements that are going to be cut off

        int leftIdx = 0;
        int rightIdx = arr.length - 1;
        boolean extraLastElement = false;

        while (leftIdx <= rightIdx) {

            if (arr[leftIdx] == 0) {

                if (leftIdx == rightIdx) {
                    leftIdx++;
                    extraLastElement = true;
                    break;
                }

                rightIdx--;
            }
            leftIdx++;
        }

        //TODO: Go over this problem again
        //When you break out of the loop, the value for leftIdx will be one greater than the value for the rightIdx
        //Hence you have to subtract 1 from the leftIdx to get the correct index.
        int subArrayIdx = leftIdx - 1;

        for (int writeIdx = arr.length - 1; writeIdx >= 0; writeIdx--) {

            int currNum = arr[subArrayIdx--];

            arr[writeIdx] = currNum;

            if (currNum == 0) {

                if (!extraLastElement) {
                    arr[--writeIdx] = currNum;
                } else {
                    extraLastElement = false;
                }

            }
        }

    }

}
