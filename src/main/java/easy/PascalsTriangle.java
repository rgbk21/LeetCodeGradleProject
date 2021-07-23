package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

    //https://leetcode.com/problems/pascals-triangle/

    public static void main(String[] args) {

        generate(5);

    }

    /*
    [
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1],
 [1,5,10,10,5,1]
]
     */

    public static List<List<Integer>> generate_v3(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        if (numRows == 1) {
            result.add(new ArrayList<>());
            result.get(0).add(1);
            return result;
        }
        if (numRows == 2) {
            result.add(new ArrayList<>());
            result.add(new ArrayList<>());
            result.get(0).add(1);
            result.get(1).add(1);
            result.get(1).add(1);
            return result;
        }

        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        result.get(0).add(1);
        result.get(1).add(1);
        result.get(1).add(1);

        for (int i = 2; i < numRows; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    result.get(i).add(1);
                } else {
                    List<Integer> upperLevel = result.get(i - 1);
                    int sumOfUpperLevelEl = upperLevel.get(j-1) + upperLevel.get(j);
                    result.get(i).add(sumOfUpperLevelEl);
                }
            }
        }

        return result;
    }


    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                result.add(Collections.singletonList(1));
            } else if (i == 1) {
                result.add(Arrays.asList(1, 1));
            } else {
                List<Integer> level = new ArrayList<>();

                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) {
                        level.add(1);
                    } else if (j == i) {
                        level.add(1);
                    } else {
                        level.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                    }
                }

                result.add(level);
            }


        }
        return result;
    }

    public static List<List<Integer>> generate_v0(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) {
            return result;
        }

        //You do not really need a separate condition for these:
        /*
        if (numRows == 1) {
            result.add(Arrays.asList(1));
            return result;
        }

        if (numRows == 2) {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
            return result;
        }

        result.add(Arrays.asList(1));
        result.add(Arrays.asList(1, 1));

         */

        for (int i = 0; i < numRows; i++) {

            List<Integer> list = new ArrayList<>(Collections.nCopies(i + 1, 0));

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.set(j, 1);
                    continue;
                }
                list.set(j, (result.get(i - 1).get(j - 1) + result.get(i - 1).get(j)));
            }
            result.add(list);
        }
        return result;
    }

}
