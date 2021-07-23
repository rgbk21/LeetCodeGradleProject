package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays_2 {

    public static void main(String[] args) {

    }

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            int currNum = nums1[i];
            Integer currCount = map1.get(currNum);
            if (currCount == null) {
                map1.put(currNum, 1);
            } else {
                map1.put(currNum, ++currCount);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            int currNum = nums2[i];
            Integer currCount = map2.get(currNum);
            if (currCount == null) {
                map2.put(currNum, 1);
            } else {
                map2.put(currNum, ++currCount);
            }
        }

        List<Integer> intersectionList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int currNum = nums1[i];
            Integer countOfCurrNumInList2 = map2.get(currNum);
            if (countOfCurrNumInList2 != null && countOfCurrNumInList2 > 0) {
                intersectionList.add(currNum);
                map2.put(currNum, --countOfCurrNumInList2);
            }
        }

        // Copy values to a list
        int[] resultArr = new int[intersectionList.size()];
        int idx = 0;
        for (int num : intersectionList) {
            resultArr[idx++] = num;
        }

        return resultArr;

    }

}
