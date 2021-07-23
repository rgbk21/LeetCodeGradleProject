package easy;

// https://leetcode.com/problems/array-partition-i/
public class ArrayPartition_1 {

    public static void main(String[] args) {

    }

    public int arrayPairSum(int[] nums) {

        int[] numsFreq = new int[20_001];

        // Count the number of occurrences of each element in the input array
        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i];
            int mappedIdx = currVal + 10_000;
            numsFreq[mappedIdx]++;
        }

        // Sort the array
        int[] result = new int[nums.length];
        int writeIdx = 0;
        for (int i = 0; i < numsFreq.length; i++) {
            while (numsFreq[i] != 0) {
                result[writeIdx++] = i - 10_000;
                numsFreq[i]--;
            }
        }

        // Calculating the min value
        int minSum = 0;
        for (int i = 0; i < result.length - 1; i += 2) {
            minSum += Math.min(result[i], result[i+1]);
        }

        return minSum;


    }

}
