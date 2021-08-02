package Collections.Iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>(Arrays.asList("Alice","Bob","Charlie","Dave","Eva"));

        // ********************************************************************************************************************
        // Iterating over the list using an iterator
        // ********************************************************************************************************************
        Iterator<String> iter = nameList.iterator();
        while (iter.hasNext()){
            System.out.println("Next Person: " + iter.next());
        }

        // If you call the next() method and the iterator has no more elements to return, it throws a NoSuchElementException.
//        System.out.println("No next element but still calling iter.next(): " + iter.next()); // Throws: NoSuchElementException

        // You cannot reuse the same iterator again. If you want to iterate over the elements again
        // you need to create a new iterator
        while (iter.hasNext()){ // Warning: Condition 'iter.hasNext()' is always 'false'
            System.out.println("Next Person: " + iter.next()); // This line is not printed, because condition is false
        }

        // ********************************************************************************************************************
        // REMOVING ELEMENTS FROM A COLLECTION
        // ********************************************************************************************************************

        // You can simultaneously remove elements from a Collection as you iterate over the collection

        // Incorrect way of iterating. This throws NoSuchElementException.
        // This is because every time you call Iterator#next(), it moves the underlying cursor forward.
        // https://stackoverflow.com/a/19106760/8742428
        Iterator<String> iterRemove = nameList.iterator();
        while (iterRemove.hasNext()){
            if (iter.next().equals("Bob")) {
                System.out.println("Removing Bob");
                iterRemove.remove();
            }
        }
        System.out.println("List after removal: " + nameList);

        // Correct way of iterating and removing elements using the iterator
        System.out.println("List before removal: " + nameList); // [Alice, Bob, Charlie, Dave, Eva]
        Iterator<String> iterRemove2 = nameList.iterator();
        while (iterRemove2.hasNext()) {
            String currPerson = iterRemove2.next();
            if (currPerson.equals("Bob")) {
                iterRemove2.remove();
            }
        }
        System.out.println("List after removal: " + nameList); // [Alice, Charlie, Dave, Eva]

        // Alternatively, collections now have the removeIf which enables you to remove elements without too much code
        nameList.removeIf(currPerson -> currPerson.equals("Bob"));

        // ********************************************************************************************************************
        // You can reduce the scope of the iterator variable by using a for loop instead of a while loop
        // ********************************************************************************************************************
        // https://stackoverflow.com/questions/10431981/remove-elements-from-collection-while-iterating
        // Look in question comments
        for (Iterator<String> li = nameList.iterator(); li.hasNext(); ) {
            System.out.println("Next element is: " + li.next());
        }
    }
}
