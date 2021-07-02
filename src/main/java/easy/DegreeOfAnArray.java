package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/degree-of-an-array/
public class DegreeOfAnArray {

    public static void main(String[] args) {
        DegreeOfAnArray.findShortestSubArray(new int[]{1,2,2,3,1});
    }

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> frequency = new HashMap<>();
        Map<Integer, Map.Entry<Integer, Integer>> positions = new HashMap<>();

        // Calculate the frequency of each of the elements in the Array
        // And also simultaneously find out the leftmost and rightmost positions of each of the elements
        for (int i = 0; i < nums.length; i++) {
            int currNumInArr = nums[i];
            if (frequency.containsKey(currNumInArr)) {
                int prevFreqValue = frequency.get(currNumInArr);
                frequency.put(currNumInArr, ++prevFreqValue);
                Map.Entry<Integer, Integer> prevEntryPosition = positions.get(currNumInArr);
                Map.Entry<Integer, Integer> entry = Map.entry(prevEntryPosition.getKey(), i);
                positions.put(currNumInArr, entry);
                // Immutable object is modified
                // entry.setValue(i);
            } else {
                frequency.put(currNumInArr, 1);
                Map.Entry<Integer, Integer> entry = Map.entry(i, i);
                positions.put(currNumInArr, entry);
            }
        }

        // Find max freq value in the array
        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
            }
        }

        // Elements that have the highest frequency
        List<Integer> highestFreq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == maxFreq) {
                highestFreq.add(entry.getKey());
            }
        }

        // Find the elements that have the smallest gap between their start and their end indexes
        int closestDist = Integer.MAX_VALUE;
        for (int i = 0; i < highestFreq.size(); i++) {
            int currElmnt = highestFreq.get(i);
            int leftIdx = positions.get(currElmnt).getKey();
            int rightIdx = positions.get(currElmnt).getValue();
            if (rightIdx - leftIdx < closestDist) {
                closestDist = rightIdx - leftIdx + 1;
            }
        }

        return closestDist;

    }

}
