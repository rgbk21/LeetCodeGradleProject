package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        int[] input = new int[] {3,4,7,2,-3,1,4,2};
        subarraySum(input, 7);

    }

    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> num_count = new HashMap<>();
        num_count.put(0,1);

        int sum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];
            int target = sum - k;

            if (num_count.containsKey(target)) {
                //Note that you are not just incrementing, but taking the prev value
                //and adding to that
                result = result + num_count.get(target);
            }

            num_count.put(sum, num_count.getOrDefault(sum, 0) + 1);
        }

        return result;

    }

}
