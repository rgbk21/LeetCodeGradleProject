package easy;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        //74, 80
//        int[] array1 = new int[]{21,47,80,4,3,24,87,12,22,11,48,6,89,80,74,71,74,55,58,56,4,98,40,66,49,53,62,27,3,66,78,24,48,69,88,12,80,63,98,65,46,35,72,5,64,72,7,29,37,3,2,75,44,93,79,78,13,39,85,26,15,41,87,47,29,93,41,74,6,48,17,89,27,61,2,68,99,57,45,73,25,33,38,32,58};
//        int[] array2 = new int[]{1,39,6,81,85,10,38,22,0,89,57,93,58,69,65,80,84,24,27,54,37,36,26,88,2,7,24,36,51,5,74,57,45,56,55,67,25,33,78,49,16,79,74,80,36,27,89,49,64,73,96,60,92,31,98,72,22,31,0,93,70,87,80,66,75,69,81,52,94,90,51,90,74,36,58,38,50,9,64,55,4,21,49,60,65,47,67,8,38,83};
        int[] array1 = new int[] {3,3,3,2};
        int[] array2 = new int[] {3,3,3,4};
        intersect(array1, array2);

    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> largerArrayAsMap = new HashMap<>();

        int[] largerArray = nums1.length >= nums2.length ? nums1 : nums2;
        int[] smallerArray = nums1.length < nums2.length ? nums1 : nums2;
        List<Integer> resultList = new ArrayList<>();
        int[] resultArray;

        for(Integer i : largerArray){
            //here x is the 'value' passed in as the second arg to the merge function
            largerArrayAsMap.merge(i, 1, (oldValue, x) ->  oldValue + 1);
        }

        for (Integer i : smallerArray) {
            largerArrayAsMap.computeIfPresent(i, (key, val) -> {
                if (val > 0){
                    val = val - 1;
                    resultList.add(key);
                }
                return val;
            });
        }

        resultArray = new int[resultList.size()];
        int idx = 0;
        for (Integer i : resultList) {
            resultArray[idx++] = i;
        }

        return resultArray;

    }


}
