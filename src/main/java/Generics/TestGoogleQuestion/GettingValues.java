package Generics.TestGoogleQuestion;

import java.util.List;

public interface GettingValues<T> {
    void mergeLists(List<T> list1, List<T> list2);
    T next();
}
