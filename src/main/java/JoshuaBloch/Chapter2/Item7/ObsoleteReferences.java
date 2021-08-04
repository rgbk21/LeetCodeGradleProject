package JoshuaBloch.Chapter2.Item7;

import org.junit.jupiter.api.Assertions;

public class ObsoleteReferences {

    public static void main(String[] args) {

        MyArray<String> strArr = MyArray.createArrWithSize(3);

        // Adding elements to array
        Assertions.assertTrue(strArr.addElmntToArr("Alice"));
        Assertions.assertTrue(strArr.addElmntToArr("Bob"));
        Assertions.assertTrue(strArr.addElmntToArr("Charlie"));
        Assertions.assertFalse(strArr.addElmntToArr("Dave"));

        // Removing elements from array
        Assertions.assertTrue(strArr.removeLastElmntOfArr());
        Assertions.assertTrue(strArr.removeLastElmntOfArr());
        Assertions.assertTrue(strArr.removeLastElmntOfArr());
        Assertions.assertFalse(strArr.removeLastElmntOfArr());
    }
}

class MyArray<T> {

    private int length;
    private final int size;
    private final T[] myArray;

    private MyArray(int size) {
        this.size = size;
        length = 0;
        myArray = (T[])new Object[size];
    }

    public static <T> MyArray<T> createArrWithSize(int size) {
        return new MyArray<T>(size);
    }

    public boolean removeLastElmntOfArr() {
        if (length <= 0) return false;
        length--;
//        myArray[size] = null; // Eliminate obsolete reference
        return true;
    }

    public boolean addElmntToArr(T elmnt) {
        if (length == size) return false;
        myArray[length++] = elmnt;
        return true;
    }
}
