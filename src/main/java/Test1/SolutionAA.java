package Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolutionAA {

    public static void main(String[] args) {
        System.out.println("Result: " + solution(-8000));
    }

    public static int solution(int N) {

        String inputNumber = Integer.toString(Math.abs(N));
        List<Integer> numList = new ArrayList<>();
        StringBuilder sb = null;

        for (int i = 0; i <= inputNumber.length(); i++) {
            sb = new StringBuilder(inputNumber);
            String modNumber = sb.insert(i, 5).toString();
            numList.add(Integer.parseInt(modNumber));
        }

        Collections.sort(numList);

        return N >= 0 ? numList.get(inputNumber.length()) : (-1 * numList.get(0));


    }

}
