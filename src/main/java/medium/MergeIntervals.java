package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
    }

    public static int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return new int[0][0];

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, (arr1, arr2) -> {
            if (arr1[0] < arr2[0]) {
                return -1;
            } else if (arr1[0] > arr2[0]) {
                return 1;
            } else {
                return 0;
            }
        });

        result.add(0, intervals[0]);
        int resultReadIdx = 0;
        //{1,3},{2,6},{8,10},{15,18}
        for (int intervalReadIdx = 1; intervalReadIdx < intervals.length; ) {
            if (result.get(resultReadIdx)[1] >= intervals[intervalReadIdx][0]) {
                int[] add = new int[]{result.get(resultReadIdx)[0], Math.max(result.get(resultReadIdx)[1], intervals[intervalReadIdx][1])};
                result.remove(resultReadIdx);
                result.add(resultReadIdx, add);
                intervalReadIdx++;
            } else {
                result.add(++resultReadIdx, intervals[intervalReadIdx++]);
            }
        }


        return result.toArray(new int[result.size()][]);

    }

}
