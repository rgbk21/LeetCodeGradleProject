package Generics.TestGoogleQuestion;

import java.util.*;

public class Testing2<T> implements GettingValues<T> {

    private List<T> mergedList;
    private int readIdx = 0;

    public Testing2() {}

    @Override
    public void mergeLists(List<T> list1, List<T> list2) {
        list1.addAll(list2);
        Set<T> uniqueElmntsFromBothLists = new HashSet<>(list1);
        mergedList = new ArrayList<>(uniqueElmntsFromBothLists);
    }

    @Override
    public T next() {
        if (readIdx < mergedList.size()) {
            return mergedList.get(readIdx++);
        } else {
            return null;
        }
    }
}

class Test {
    public static void main(String[] args) {
        List<String> list3 = new ArrayList<>(Arrays.asList("A","B","C","D"));
        List<String> list4 = new ArrayList<>(Arrays.asList("C","D","F","E"));
        Testing2<String> test2 = new Testing2<>();
        test2.mergeLists(list3, list4);
        String str = test2.next();
        while (str != null) {
            System.out.println("Curr String: " + str);
            str = test2.next();
        }
    }
}
