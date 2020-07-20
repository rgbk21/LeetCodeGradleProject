package easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    //https://leetcode.com/problems/fizz-buzz/

    public static void main(String[] args) {



    }

    public static List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
                continue;
            }

            if (i % 3 == 0) {
                result.add("Fizz");
                continue;
            }

            if (i % 5 == 0){
                result.add("Buzz");
                continue;
            }

            result.add(Integer.toString(i));

        }

        return result;
    }

}
