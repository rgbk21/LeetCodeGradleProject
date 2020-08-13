package easy;

public class SortArrayByParity {

    public static void main(String[] args) {

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
