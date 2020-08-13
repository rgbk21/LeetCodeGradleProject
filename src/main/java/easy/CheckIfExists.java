package easy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfExists {

    public static void main(String[] args) {

    }

    //Bad Solution
    //TODO: Go over why this is sucha crappy solution and see the correct one below this
    public boolean checkIfExist(int[] arr) {

        if (arr == null || arr.length == 0) {
            return false;
        }

        Set<Integer> intMap = new HashSet<>();

        int zeroCount = 0;

        for (int i : arr) {
            intMap.add(i);
            if (i==0) zeroCount++;
        }

        if (zeroCount >= 2) return true;

        for (int i = 0; i < arr.length; i++) {

            int currNum = arr[i];

            // Remember to check if currNum is even or not before dividing it by 2
            // Else it will give you wronfg answer
            // Consider {1,2,3,7} 7/2 = 3 which is not what we want
            if ((intMap.contains(currNum * 2) && currNum != 0) || (currNum % 2 == 0 && intMap.contains(currNum / 2) && currNum != 0)) {
                return true;
            }

        }

        return false;

    }

    //Correct Solution
    public boolean checkIfExist_2(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int i : arr) {
            if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
                return true;
            seen.add(i);
        }
        return false;
    }



}
