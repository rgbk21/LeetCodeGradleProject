package easy;

public class DuplicateZeroes {

    public static void main(String[] args) {

        duplicateZeros(new int[] {0,0,0,0,0,0,0});

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
