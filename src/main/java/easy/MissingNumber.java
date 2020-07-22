package easy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/missing-number/

public class MissingNumber {

    public static void main(String[] args) {

        missingNumber(new int[] {3,0,1});

    }

    public static int missingNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Boolean> myMap = new HashMap<>();

        int max = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }

        for (int i = 0; i <= max; i++) {
            myMap.put(i, false);
        }

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            myMap.computeIfPresent(currNum, (key, value) -> true);
        }

        for (Map.Entry<Integer, Boolean> entry : myMap.entrySet()) {
            if(!entry.getValue()){
                return entry.getKey();
            }
        }

        return max + 1;
    }
}
