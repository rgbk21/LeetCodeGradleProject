package Generics.TestGoogleQuestion;

import java.util.*;

public class TestingGQuestion {

    List<Integer> mergedList;
    int readIdx = 0;

    TestingGQuestion(List<Integer> list1, List<Integer> list2) {
        mergedList = new ArrayList<>();
        mergeLists(list1, list2);
    }

    private void mergeLists(List<Integer> list1, List<Integer> list2) {
        list1.addAll(list2);
        Set<Integer> uniqueElmntsFromBothLists = new HashSet<>(list1);
        mergedList = new ArrayList<>(uniqueElmntsFromBothLists);
    }

    public Integer next(){
        if (readIdx < mergedList.size()) {
            return mergedList.get(readIdx++);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,6,7,8));
        TestingGQuestion test = new TestingGQuestion(list1, list2);
        Integer number = test.next();
        while (number != null) {
            System.out.println("Curr Number: " + number);
            number = test.next();
        }
    }

}
