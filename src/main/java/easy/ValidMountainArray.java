package easy;

public class ValidMountainArray {

    public static void main(String[] args) {

    }

    public boolean validMountainArray(int[] A) {

        if (A == null || A.length < 3) return false;

        int peakValue = A[0];
        int peakIdx = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] > peakValue) {
                peakValue = A[i];
                peakIdx = i;
            }
        }

        if (peakIdx == 0 || peakIdx == A.length - 1) return false;

        for (int i = peakIdx - 1; i >= 0; i--) {
            if (A[i] >= A[i + 1]) {
                return false;
            }
        }

        for (int i = peakIdx + 1; i < A.length; i++ ) {

            if (A[i] >= A[i-1]) {
                return false;
            }
        }

        return true;

    }
}
