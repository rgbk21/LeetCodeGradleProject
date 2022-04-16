package Generics.JavaBook.Chapter1;

import java.util.Arrays;
import java.util.List;

public class AutoBoxing {
  public int calculateIntSum(List<Integer> nums) {
    int result = 0;
    for (int num : nums) {
      result += num;
    }
    return result;
  }

  public Integer calculateIntegerSum(List<Integer> nums) {
    Integer result = 0;
    for (Integer num : nums) {
      result += num;
    }
    return result;
  }
}

class AutoBoxingTest {
  public static void main(String[] args) {
    AutoBoxing bigSumTest = new AutoBoxing();
    List<Integer> nums = Arrays.asList(100, 200, 300, 400);

    // *** NEVER USE == TO COMPARE TWO BOXED VALUES. ALWAYS USE EQUALS
    // Unboxing causes values to be compared, so the results are equal.
    System.out.println(bigSumTest.calculateIntSum(nums) == bigSumTest.calculateIntegerSum(nums)); // Prints: true

    // There is no unboxing, and the two method calls return distinct Integer objects, so the results are unequal
    // even though both Integer objects represent the same value: 1000
    // Either unbox first, so == compares values of type int, or else use equals to compare values of type Integer.
    System.out.println(bigSumTest.calculateIntegerSum(nums) == bigSumTest.calculateIntegerSum(nums)); // Prints: false

    // Instead you should use .equals
    System.out.println(bigSumTest.calculateIntegerSum(nums).equals(bigSumTest.calculateIntegerSum(nums))); // Prints: true

    System.out.println("Testing Caching");

    AutoBoxing smallSumTest = new AutoBoxing();
    List<Integer> smallNums = Arrays.asList(1, 2, 3, 4);

    System.out.println(smallSumTest.calculateIntSum(smallNums) == smallSumTest.calculateIntegerSum(smallNums)); // Prints true

    System.out.println(smallSumTest.calculateIntegerSum(smallNums) == smallSumTest.calculateIntegerSum(smallNums)); // Prints true as well!!
  }
}
