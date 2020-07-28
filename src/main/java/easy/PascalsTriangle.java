package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

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

    public static List<List<Integer>> generate(int numRows) {

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

            List<Integer> list = new ArrayList<>(Collections.nCopies(i+1, 0));

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.set(j, 1);
                    continue;
                }
                list.set(j, (result.get(i-1).get(j-1) + result.get(i-1).get(j)));
            }
            result.add(list);
        }
        return result;
    }

}
