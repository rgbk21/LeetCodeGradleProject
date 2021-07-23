package Generics.TestGoogleQuestion;

import java.util.*;

public class WithGenerics<T> {

    List<T> mergedList;
    int readIdx = 0;

    WithGenerics(List<T> list1, List<T> list2) {
        mergedList = new ArrayList<>();
        mergeLists(list1, list2);
    }


    public void mergeLists(List<T> list1, List<T> list2) {
        list1.addAll(list2);
        Set<T> uniqueElmntsFromBothLists = new HashSet<>(list1);
        mergedList = new ArrayList<>(uniqueElmntsFromBothLists);
    }

    public T next(){
        if (readIdx < mergedList.size()) {
            return mergedList.get(readIdx++);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        // With Numbers
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5,6,7,8));
        WithGenerics<Integer> test = new WithGenerics<>(list1, list2);
        Integer number = test.next();
        while (number != null) {
            System.out.println("Curr Number: " + number);
            number = test.next();
        }

        // With Strings
        List<String> list3 = new ArrayList<>(Arrays.asList("A","B","C","D"));
        List<String> list4 = new ArrayList<>(Arrays.asList("C","D","F","E"));
        WithGenerics<String> test2 = new WithGenerics<>(list3, list4);
        String str = test2.next();
        while (str != null) {
            System.out.println("Curr String: " + str);
            str = test2.next();
        }

    }

}
