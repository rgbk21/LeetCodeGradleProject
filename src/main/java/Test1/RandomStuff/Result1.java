package Test1.RandomStuff;

import java.util.Collections;
import java.util.List;

public class Result1 {

    //[1,3,2,2]

    public static int getHeight(List<Integer> arr) {

        if (arr == null || arr.size() == 0) {
            return 0;
        }

        Collections.sort(arr);

        if (arr.get(0) == 1) {

            for (int i = 1; i < arr.size(); i++){

                int prevVal = arr.get(i-1);
                int curVal = arr.get(i);

                if ((Math.abs(curVal - prevVal)) >= 1) {
                    arr.set(i, prevVal + 1);
                }
            }
        } else {
            return arr.size();
        }

        return arr.get(arr.size() - 1);

    }

}
