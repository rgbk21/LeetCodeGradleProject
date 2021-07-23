package easy;

public class SortArrayByParity {

    public static void main(String[] args) {

    }

    // [3,1,6,7,2,4]
    // [6,1,3,7,2,4]
    public int[] sortArrayByParity_v2(int[] A){
        int readIdx = 0;
        int writeIdx = 0;
        while (readIdx < A.length) {
            int currNum = A[readIdx];
            if (currNum % 2 == 1) {
                readIdx++;
            } else {
                int temp = A[writeIdx];
                A[writeIdx++] = currNum;
                A[readIdx] = temp;
                readIdx++;
            }
        }
        return A;
    }

    public int[] sortArrayByParity(int[] A) {

        if (A == null || A.length == 0) {
            return A;
        }

        int leftIdx = 0;
        int rightIdx = A.length - 1;

        //3,1,2,4

        while (leftIdx <= rightIdx) {

            if (A[leftIdx] % 2 == 0) {
                leftIdx++;
            } else {
                int temp = A[rightIdx];
                A[rightIdx] = A[leftIdx];
                A[leftIdx] = temp;
                rightIdx--;
            }


        }

        return A;

    }

}
