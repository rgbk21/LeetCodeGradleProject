package easy;

import javax.print.attribute.HashDocAttributeSet;
import java.util.*;

public class ContainsDuplicates {

    public static void main(String[] args) {
        // 1. initialize the hash set
        Set<Integer> hashSet = new HashSet<>();

        hashSet.add(15);
        hashSet.add(3);
        hashSet.add(2);
        hashSet.add(1);

        // HashSet can be created from another HashSet
        Set<Integer> copyHashSet = new HashSet<>(hashSet);
        System.out.println("copyHashSet: " + copyHashSet); // [1, 2, 3, 15]

        // HashSet can also be created from another list
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 15));
        Set<Integer> setFromList = new HashSet<>(numbers);
        System.out.println("setFromList: " + setFromList); // [1, 2, 3, 4, 5, 15]

        // 3. remove the key
        hashSet.remove(2);

        // Removing element from HashSet while iterating over it
        boolean resultWhenKeyExists = hashSet.removeIf(key -> key == 15);
        boolean resultWhenKeyDoesNotExist = hashSet.removeIf(key -> key == 15);
        // Key Exists: true, Key Does Not Exist: false
        System.out.println("When Key Exists: " + resultWhenKeyExists + ", When Key Does Not Exist: " + resultWhenKeyDoesNotExist);

        // 4. check if the key is in the hash set
        if (!hashSet.contains(2)) {
            System.out.println("Key 2 is not in the hash set.");
        }

        // 5. get the size of the hash set
        System.out.println("The size of has set is: " + hashSet.size());

        // 6. iterate the hash set
        for (Integer i : hashSet) {
            System.out.print(i + " ");
        }
        System.out.println("are in the hash set.");

        // 7. clear the hash set
        hashSet.clear();

        // 8. check if the hash set is empty
        if (hashSet.isEmpty()) {
            System.out.println("hash set is empty now!");
        }

        // UNION, INTERSECTION, DIFFERENCE, EQUALS of SETS

        // You can perform union, intersection, and difference (or minus) operations on mathematical sets.
        // You can do the same operations on Java Sets as well.
        // Note that the following operations are destructive. So the contents of the set on the LHS of the operation will change.
        // Create a copy of the original if you do not want that to happen
        Set<String> set1 = new HashSet<>();
        set1.add("Alice");
        set1.add("Bob");
        set1.add("Charlie");
        set1.add("Dave");

        Set<String> set2 = new HashSet<>();
        set2.add("Dave");
        set2.add("Eve");
        set2.add("Fred");

        // ******** UNION OF TWO SETS *******************************************************************************
        Set<String> set1UnionSet2 = new HashSet<>(set1);

        set1UnionSet2.addAll(set2);
        // Set 1 changed. But Set2 remained the same.
        System.out.println("set1UnionSet2:" + set1UnionSet2); // [Bob, Eve, Alice, Charlie, Fred, Dave]
        System.out.println("set2:" + set2); // [Eve, Fred, Dave]

        // ******** INTERSECTION OF TWO SETS *******************************************************************************
        Set<String> set1IntersectionSet2 = new HashSet<>(set1);

        set1IntersectionSet2.retainAll(set2);
        // Set 1 changed. But Set2 remained the same.
        System.out.println("set1IntersectionSet2: " + set1IntersectionSet2); // [Dave]
        System.out.println("set2: " + set2); // [Eve, Fred, Dave]

        // Also, maybe this needs to be made explicit, but keep in mind that
        // if you are doing A ∩ B
        // and A and B are disjoint sets, then the result of the operation is going to be A as the empty set
        Set<String> set111 = new HashSet<>();
        set111.add("Alice");
        set111.add("Bob");

        Set<String> set222 = new HashSet<>();
        set222.add("Dave");
        set222.add("Eve");
        set222.add("Fred");

        set111.retainAll(set222);
        System.out.println("set111 is now empty: " + set111); // []

        // ******** DIFFERENCE OF TWO SETS *******************************************************************************
        Set<String> set1DiffSet2 = new HashSet<>(set1);

        set1DiffSet2.removeAll(set2);
        // Set 1 changed. But Set2 remained the same.
        System.out.println("set1DiffSet2: " + set1DiffSet2); // [Bob, Alice, Charlie]
        System.out.println("set2: " + set2); // [Eve, Fred, Dave]

        // Also, maybe this needs to be made explicit, but keep in mind that
        // if you are doing A - B
        // and A is a subset of B, then the result of the operation is is going to be A as the empty set.
        Set<String> set11 = new HashSet<>();
        set11.add("Alice");
        set11.add("Bob");

        Set<String> set22 = new HashSet<>();
        set22.add("Alice");
        set22.add("Bob");
        set22.add("Dave");
        set22.add("Eve");
        set22.add("Fred");

        set11.removeAll(set22);
        System.out.println("set11 is now empty: " + set11); // []

        // The point of this exercise is to remind you that when you are doing A - B, and the result is 0,
        // in the case of sets, this DOES NOT mean that A = B. It just means that every element of A is present in B. That's it.
        // If you want to check for equality, you want to use the equals() method instead.

        // ******** CHECKING IF TWO SETS ARE EQUAL *******************************************************************************
        Set<String> set3 = new HashSet<>();
        set3.add("Alice");
        set3.add("Bob");
        set3.add("Charlie");
        set3.add("Dave");

        Set<String> set4 = new HashSet<>();
        set4.add("Alice");
        set4.add("Bob");
        set4.add("Charlie");
        set4.add("Dave");

        Set<String> set5 = new HashSet<>();
        set5.add("Alice");
        set5.add("Bob");
        set5.add("Charlie");
        set5.add("Dave");
        set5.add("Eve");

        System.out.println("Are set3 and set4 equal: " + Objects.equals(set3, set4)); // true
        System.out.println("Are set4 and set5 equal: " + Objects.equals(set4, set5)); // false

        // ******** CHECKING IF ALL ELEMENTS OF ONE SET EXIST IN ANOTHER ********************************************************************
        Set<String> set6 = new HashSet<>();
        set6.add("Alice");
        set6.add("Bob");
        set6.add("Charlie");
        set6.add("Dave");

        Set<String> set7 = new HashSet<>();
        set7.add("Alice");
        set7.add("Bob");
        set7.add("Charlie");

        Set<String> set8 = new HashSet<>();
        set8.add("Alice");
        set8.add("Bob");
        set8.add("Charlie");
        set8.add("Dave");
        set8.add("Eve");

        System.out.println("Does set6 contain all elements of set7: " + set6.containsAll(set7)); // true
        System.out.println("Does set6 contain all elements of set8: " + set6.containsAll(set8)); // false


        // ******** OTHER IMPLEMENTATIONS OF THE SET INTERFACE *******************************************************************************

        // ******** LINKED HASH SET *******************************************************************************
        // The HashSet implementation does not guarantee the ordering of elements during iteration.
        // The LinkedHashSet implementation guarantees that the iterator of a Set will return the elements in the same order
        // the elements were inserted (insertion order).
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Charlie");
        linkedHashSet.add("Bob");
        linkedHashSet.add("Alice");
        linkedHashSet.add("Dave");
        System.out.println("linkedHashSet: " + linkedHashSet); // [Charlie, Bob, Alice, Dave]

        // ******** SORTED SET *******************************************************************************

        // It's a set that imposes ordering on its elements. The elements are ordered either by the compareTo() method of its elements.
        // Or they are ordered by using a custom Comparator that is passed in during the construction of the SortedSet
        SortedSet<String> sortedSet1 = new TreeSet<>(Arrays.asList("Bob", "Alice", "Eve", "Dave", "Charlie"));
        System.out.println("Sorted set when using the normal ordering of Strings: " + sortedSet1); // [Alice, Bob, Charlie, Dave, Eve]

        // Note that there is no Constructor of the TreeSet that takes both elements AND a custom comparator as input
        // !!! Note the following VERY carefully !!!
        // Bob is the only element that is added to the sortedSet that has length 3.
        // Eve is not added, because the SortedSet does not store duplicates, and since the comparator is comparing the lengths of the strings,
        // it treats 'Bob' and 'Eve' as the SAME strings. No duplicates allowed in Set, and hence no 'Eve' allowed in Set.
        SortedSet<String> sortedSet2 = new TreeSet<>((str1, str2) -> str1.length() - str2.length());
        sortedSet2.add("Alice");
        sortedSet2.add("Bob");
        sortedSet2.add("Charlie");
        sortedSet2.add("Dave");
        sortedSet2.add("Eve");
        System.out.println("Sorted set when using the custom comparator: " + sortedSet2); // [Bob, Dave, Alice, Charlie]

        // You can use SortedSet interface to use certain methods that are not available in the Set interface
        System.out.println("sortedSet1: " + sortedSet1); // [Alice, Bob, Charlie, Dave, Eve]
        System.out.println("Print the first element in the set: " + sortedSet1.first()); // Alice
        System.out.println("Print the last element in the set: " + sortedSet1.last()); // Eve
        // Note the inclusive and the exclusive element behavior in the below methods as well

        // headSet returns a view of the portion of this set whose elements are strictly less than toElement.
        // The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        SortedSet<String> headSet = sortedSet1.headSet("Charlie");
        System.out.println("Print all the elements BEFORE the specified element: " + headSet); // [Alice, Bob]

        // Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
        // The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        SortedSet<String> tailSet = sortedSet1.tailSet("Charlie");
        System.out.println("Print all the elements AFTER the specified element: " + tailSet); // [Charlie, Dave, Eve]

        // Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.
        // (If fromElement and toElement are equal, the returned set is empty.)
        // The returned set is backed by this set, so changes in the returned set are reflected in this set, and vice-versa.
        SortedSet<String> subSet = sortedSet1.subSet("Bob", "Eve");
        System.out.println("Print all the elements BETWEEN the specified elements: " + subSet); // [Bob, Charlie, Dave]
        System.out.println("Print all the elements BETWEEN the specified elements (right inclusive): " + sortedSet1.subSet("Bob", "Eve" + "\0")); // [Bob, Charlie, Dave, Eve]
        System.out.println("Print all the elements BETWEEN the specified elements (left exclusive): " + sortedSet1.subSet("Bob" + "\0", "Eve")); // [Charlie, Dave]
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // the add() operation returns true if this set did not already contain the specified element
            // If this set already contains the element, the call leaves the set unchanged and returns false.
            boolean newElementAdded = uniqueNums.add(nums[i]);
            if (!newElementAdded) return true;
        }
        return false;
    }

}
