package medium;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnes_2 {

    public static void main(String[] args) {

    }

    //{1,0,1,1,0}

    public int findMaxConsecutiveOnes_2(int[] nums){

        int leftIdx = 0;
        int rightIdx = 0;
        int nextLeftIdx = 0;
        int overallMaxlength = 0;
        int maxLengthSeenSoFar = 0;

        while (nextLeftIdx < nums.length && nums[nextLeftIdx] == 1) {
            nextLeftIdx++;
        }

        if (nums.length == nextLeftIdx) {
            return nums.length;
        }

        while (rightIdx < nums.length) {

            if (nums[rightIdx] == 1) {
                rightIdx++;
                maxLengthSeenSoFar++;

            } else {

                if (rightIdx > nextLeftIdx) {
                    overallMaxlength = Math.max(overallMaxlength, maxLengthSeenSoFar);
                    leftIdx = nextLeftIdx + 1;
                    nextLeftIdx = rightIdx;
                    maxLengthSeenSoFar = rightIdx - leftIdx + 1;
                    rightIdx++;

                } else {
                    rightIdx++;
                    maxLengthSeenSoFar++;
                }

            }

        }

        return Math.max(overallMaxlength, maxLengthSeenSoFar);

    }

    public int findMaxConsecutiveOnes(int[] nums) {

        List<Integer> zeroIndices = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndices.add(i);
            }
        }

        if (zeroIndices.isEmpty()) {
            return nums.length;
        }

        int maxLengthOfOnes = 0;

        for (int i = 0; i < zeroIndices.size(); i++){
            maxLengthOfOnes = Math.max(maxLengthOfOnes, checkMaxRunOfOnesOnReplacingIndex(zeroIndices.get(i), nums));
        }

        return maxLengthOfOnes;

    }

    private int checkMaxRunOfOnesOnReplacingIndex(int zeroIdx, int[] nums){

        int overallMaxRunOfOnes = 0;
        int currMaxRunOfOnes = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0 && (i != zeroIdx)) {
                overallMaxRunOfOnes = Math.max(overallMaxRunOfOnes, currMaxRunOfOnes);
                currMaxRunOfOnes = 0;
            } else {
                currMaxRunOfOnes++;
            }

        }

        return Math.max(overallMaxRunOfOnes, currMaxRunOfOnes);

    }

}
