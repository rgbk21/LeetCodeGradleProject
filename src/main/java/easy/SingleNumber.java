package easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        singleNumber_v2(new int[]{2, 2, 1});
    }

    public static int singleNumber_v2(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer prevVal = count.get(nums[i]);
            if (prevVal == null) {
                count.put(nums[i], 1);
            } else {
                count.put(nums[i], ++prevVal);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == 1) {
                return nums[i];
            }
        }

        // Note:
        // You were initially thinking about iterating over the entire Hash Map in order to find out
        // which one of the entries had a value of 1. Yes, that is correct, but remember that the order is
        // not preserved in the HashSet. Hence if the question was instead that -
        // there are multiple numbers that occur only once, and you had to find the leftmost number that occurred just once,
        // iterating over the HashMap would not have worked. You would have resorted to stuff like LinkedHashMap or something.
        // Point is: do not forget that the 'ORDER' of elements is already given to you in the question's DS.
        // Hence you ITERATE over the given DS. And you use the Map to FIND the correct answer

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i : nums) {
            myMap.merge(i, 1, (oldValue, value) -> oldValue + 1);
        }

        for (int i : nums) {
            if (myMap.get(i) == 1) return i;
        }

        return -1;
    }

}
