package Test1;

import java.util.Iterator;

public class Addition {

    public static int add (int value1, int value2) {
        return value1 + value2;
    }

    // No need of doing all of this
    public static int sum_usingIterator (Iterable<Integer> values) {
        Iterator<Integer> iter = values.iterator();
        int sum = 0;
        while (iter.hasNext()) {
            sum = add(sum, iter.next());
        }
        return sum;
    }

    // Because we are using iterable, we can just do this:
    public static int sum (Iterable<Integer> values) {
        int sum = 0;
        for (int val : values) {
            sum = add(sum, val);
        }
        return sum;
    }
}
