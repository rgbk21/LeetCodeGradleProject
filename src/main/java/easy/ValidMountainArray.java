package easy;

public class ValidMountainArray {

    public static void main(String[] args) {

    }

    // 0,3,2,1
    public boolean validMountainArray_v2(int[] A) {

        if (A == null || A.length < 3) return false;
        boolean peakSeen = false;

        // The first element cannot be greater than the second element in order to create a proper peak
        if (A[0] > A[1]) return false;
        for (int i = 0; i < A.length - 1; i++) {

            // Two elements cannot be equal
            if (A[i] == A[i + 1]) return false;

            // Calculate when the peak has been seen
            if (!peakSeen) {
                if (A[i] > A[i+1]) {
                    peakSeen = true;
                    // Note this:
                    // You have a condition dependent on the same variable below
                    // hence continue
                    continue;
                }
            }
            if (peakSeen) {
                if (A[i] < A[i+1]) {
                    return false;
                }
            }
        }

        // You cannot directly return true over here because if you do so, you will return true in the following case as well:
        // [1,2,3,4,5,6,7,8]
        return peakSeen;
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

        for (int i = peakIdx + 1; i < A.length; i++) {

            if (A[i] >= A[i - 1]) {
                return false;
            }
        }

        return true;

    }
}
