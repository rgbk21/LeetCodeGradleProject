package easy;

import java.util.ArrayList;
import java.util.List;

public class PositionOfLargeGroups {

  public List<List<Integer>> largeGroupPositions(String s) {
    List<List<Integer>> result = new ArrayList<>();
    boolean similarCharSpotted = false;

    for (int i = 0; i < s.length() - 1; i++) {
      char currChar = s.charAt(i);
      char nextChar = s.charAt(i+1);
      if (currChar == nextChar && !similarCharSpotted) {
        similarCharSpotted = true;
          result.add(new ArrayList<>());
          result.get(result.size() - 1).add(i);
      } else {
        result.get(result.size() - 1).add(i);
        similarCharSpotted = false;
      }
    }

    System.out.println();


    List<List<Integer>> finalResult = new ArrayList<>();
    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).get(1) - result.get(i).get(0) + 1 >= 3) {
        finalResult.add(result.get(i));
      }
    }

    return finalResult;
  }

  private void identifyGroups(String s) {

  }

  public static void main(String[] args) {
    // What is the difference between these two definitions
    List myList = new ArrayList();
    List<String> myList2 = new ArrayList<>();

    myList.add("123");
    myList.add(1234);

    for (int i = 0; i < myList.size(); i++) {
    }

  }

}
