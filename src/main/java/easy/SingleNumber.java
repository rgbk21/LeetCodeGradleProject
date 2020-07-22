package easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        singleNumber(new int[] {2,2,1});
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
