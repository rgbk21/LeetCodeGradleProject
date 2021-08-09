package easy;

import java.util.*;

//https://leetcode.com/problems/find-pivot-index/
public class FindPivotIndex {

    public static void main(String[] args) {

        // ********* CREATING A NEW LIST ************************************************************************************

        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};

        // We can convert the Integer[] to List<Integer>. We have already seen that there is no easy way to convert int[] to List<Integer>.
        // Returns a fixed-size list backed by the specified array.
        List<Integer> list2 = Arrays.asList(arr);
        // What this means is that elements cannot be added or removed from the array
        // Both of the below operations will throw an UnsupportedOperationException
        // list2.add(6);
        // list2.remove(3);
        // But you should be able to change the element.
        // Note that the changes made to the list are copied through to the array.
        list2.set(2, 10);
        System.out.println(list2); // [1, 2, 10, 4, 5]
        System.out.println(Arrays.toString(arr)); // [1, 2, 10, 4, 5]

        // You can avoid changes to the underlying array by creating a new List that is an actual copy
        List<Integer> list3 = new ArrayList<>(Arrays.asList(arr));
        // Now you can add and remove elements to the list, unlike the case above
        list3.add(6);
        System.out.println(list3); // [1, 2, 10, 4, 5, 6]

        // You can also create a list from a Set
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1); numbers.add(2); numbers.add(3); numbers.add(4);
        List<Integer> numsAsList = new ArrayList<>(numbers);
        System.out.println("numsAsList: " + numsAsList); // [1, 2, 3, 4]

        // You can convert a List<String> back to an String[] as well
        List<String> stringList = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "Dave"));
        String[] strArray = stringList.toArray(String[]::new);

        // You can add multiple null values to a List
        List<String> listOfNulls = new ArrayList<>();
        listOfNulls.add(null);
        listOfNulls.add(null);
        listOfNulls.add(null);
        System.out.println("List of nulls: " + listOfNulls); // [null, null, null]

        // ********* REMOVING AN ELEMENT ************************************************************************************

        // Note that removing an element from a list has a time complexity of O(n).
        // remove() will remove ONLY the first occurrence of the element. If the element does not occur in the list, the list remains unchanged.
        // Note the remove() case carefully. The remove() method is overloaded.
        // You can either pass in the index of the object that you want to remove the object from.
        // Or you can pass in the actual object if you do not know the index, and the list will remove it for you.
        // But in the case of List<Integer>, the list treats the passed in number args to the remove() method as index by default
        // and NOT as object. Hence when we try to remove(2), it is the element at the 2nd index that is removed and not the element 2 itself.
        list3.remove(2);
        System.out.println(list3); // [1, 2, 4, 5, 6]

        // So what do you do when you want to remove the element itself?
        // https://stackoverflow.com/questions/21795376/java-how-to-remove-an-integer-item-in-an-arraylist
        boolean result1 = list3.remove((Integer) 2);
        System.out.println("After Removing 2: " + list3); // [1, 4, 5, 6]
        System.out.println("When the element is found: " + result1); // true
        boolean result2 = list3.remove(Integer.valueOf(2));
        System.out.println("When the element is not found: " + result2); // false

        // ********* ADDING AN ELEMENT ************************************************************************************

        // add() will add an element to the end of the list
        // arr [1, 2, 10, 4, 5]
        List<Integer> list4 = new ArrayList<>(Arrays.asList(arr));
        list4.add(6);
        System.out.println("After adding element: " + list4); // [1, 2, 10, 4, 5, 6]
        // You can also add element to a specific index. Remaining elements are shifted to the right
        list4.add(3, 7);
        System.out.println("After adding element: " + list4); // [1, 2, 10, 7, 4, 5, 6]

        // ********* SORTING THE LIST ************************************************************************************

        // You can also pass in an optional comparator to change the natural ordering sort over here.
        Collections.sort(list4);
        System.out.println("After sorting: " + list4); // [1, 2, 4, 5, 6, 7, 10]
        // or you can use
        Collections.shuffle(list4);
        System.out.println("After shuffling: " + list4); // [7, 6, 10, 5, 2, 4, 1]
        // Note that passing in a comparator is mandatory if using the sort() method
        list4.sort((num1, num2) -> {
            return num1 - num2;
        });
        System.out.println("After sorting: " + list4); // [1, 2, 4, 5, 6, 7, 10]

        // ********* REVERSING THE LIST ************************************************************************************
        // This will reverse the order of the elements in the list
        System.out.println("Original list: " + list4); // [1, 2, 4, 5, 6, 7, 10]
        List<Integer> list5 = new ArrayList<>(list4);
        Collections.reverse(list4);
        System.out.println("After reversing the list: " + list4); // [10, 7, 6, 5, 4, 2, 1]

        // ********* SWAPPING ELEMENTS IN THE LIST ************************************************************************************
        System.out.println("Original list: " + list4); // [10, 7, 6, 5, 4, 2, 1]
        List<Integer> list6 = new ArrayList<>(list4);
        Collections.swap(list6, 2, 5);
        System.out.println("List after swapping elements at idx 2 and 5: " + list6); // [10, 7, 2, 5, 4, 6, 1]

        // ********* ROTATING ELEMENTS OF THE LIST ************************************************************************************
        /*
        Rotating involves moving all elements of a List forward or backward by a distance.
        Suppose you have a List as [a, b, c, d].
        If you rotate this List by a distance of 1, the resulting List becomes [d, a, b, c].
        If you rotate the [a, b, c, d] list by a distance of 2, the List becomes [c, d, a, b].
        You can also rotate a List backwards by using a negative distance. If you rotate the [a, b, c, d] list by a distance of -2, the List becomes [c, d, a, b].
         */
        System.out.println("Original list: " + list4); // [10, 7, 6, 5, 4, 2, 1]
        List<Integer> list7 = new ArrayList<>(list4);
        Collections.rotate(list7, 3);
        System.out.println("Rotate list4 by a distance of 3: " + list7); // [4, 2, 1, 10, 7, 6, 5]
        List<Integer> list8 = new ArrayList<>(list4);
        Collections.rotate(list8, -2);
        System.out.println("Rotate list4 by a distance of -2: " + list8); // [6, 5, 4, 2, 1, 10, 7]

        // ********* FINDING MIN AND MAX IN THE LIST ************************************************************************************
        // You can directly find the min and the max in the list
        int minEl = Collections.min(list5);
        int maxEl = Collections.max(list5);
        System.out.println("Max: " + maxEl); // 10
        System.out.println("Min: " + minEl); // 1

        // ********* CHECKING IF TWO LISTS ARE EQUAL ************************************************************************************
        // Returns true if and only if the specified object is also a list, both lists have the same size,
        // and all corresponding pairs of elements in the two lists are equal, and also they are in the same order.
        List<Integer> list10 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list11 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list12 = new ArrayList<>(Arrays.asList(1,2,3,4,6,5));
        System.out.println("Are list10 and list11 equal: " + list10.equals(list11)); // true
        System.out.println("Are list11 and list12 equal: " + list11.equals(list12)); // false
        // Returns true if the arguments are equal to each other and false otherwise.
        // Consequently, if both arguments are null, true is returned and if exactly one argument is null, false is returned.
        // Internally it is still calling list10.equals(list11). It's just providing additional null checks as advantage.
        System.out.println("Are list10 and list11 equal: " + Objects.equals(list10, list11)); // true
        System.out.println("Are list11 and list12 equal: " + Objects.equals(list11, list12)); // false

        // If order does not matter and you just want to check if the two lists contain the same elements
        // then you can put the two lists in HashSet s of their own and check if the hash sets are equal.
        // But note that this will remove any duplicates in the List
        Set<Integer> set10 = new HashSet<>(list10);
        Set<Integer> set11 = new HashSet<>(list11);
        Set<Integer> set12 = new HashSet<>(list12);
        System.out.println("Are set10 and set11 equal: " + Objects.equals(set10, set11)); // true
        System.out.println("Are set11 and set12 equal: " + Objects.equals(set11, set12)); // true

        // ******** UNION OF TWO LISTS ********************************************************************************************
        List<Integer> list13 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list14 = new ArrayList<>(Arrays.asList(7,8,6,5));
        // Appends all of the elements in the specified collection to the end of this list,
        // in the order that they are returned by the specified collection's iterator (optional operation).
        list13.addAll(list14);
        System.out.println("Union of two lists: " + list13); // [1, 2, 3, 4, 5, 6, 7, 8, 6, 5]
        // Note that in the case of lists, the addAll() operation is NOT union per se, because as you can see
        // elements are repeated. To calculate exact union, you should add the list elements to a hashset and then union them
        // and convert the result back to a list
        Set<Integer> set13 = new HashSet<>(list13);
        Set<Integer> set14 = new HashSet<>(list14);
        set13.addAll(set14);
        List<Integer> list13UnionList14 = new ArrayList<>(set13);
        System.out.println("list13UnionList14: " + list13UnionList14); // [1, 2, 3, 4, 5, 6, 7, 8]

        // ******** INTERSECTION OF TWO LISTS ********************************************************************************************

        // In the case of sets, we were using retainAll() to calculate the intersection.
        // But note that using retainAll() in the case of lists, is a O(n^2) algorithm.
        // You are better off adding all the elements of the second list in a set and then iterating over oll the elements in the first list
        // to check if the given element occurs in the other set or not.
        List<Integer> list15 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list16 = new ArrayList<>(Arrays.asList(7,8,6,5));
        Set<Integer> set16 = new HashSet<>(list16);
        List<Integer> l15IntersL16 = new ArrayList<>();
        for (Integer num : list15) {
            if (set16.contains(num)) {
                l15IntersL16.add(num);
            }
        }
        System.out.println("Intersection of the two lists is: " + l15IntersL16); // [5, 6]

        // But be very careful of repeated values when you are using this.
        // For example what should be the intersection of the following two lists
        // Note the default behavior of the retainAll() method. Even though the two cases below have different elements
        // the intersection of the two is still the same.
        List<Integer> list17 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,6));
        List<Integer> list19 = new ArrayList<>(Arrays.asList(7,8,6,5));
        list17.retainAll(list19); // [5, 6, 6]
        System.out.println("Intersection of List 17 and 19: " + list17);

        List<Integer> list18 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,6));
        List<Integer> list20 = new ArrayList<>(Arrays.asList(7,8,6,6,5));
        list18.retainAll(list20);
        System.out.println("Intersection of List 18 and 20: " + list18); // [5, 6, 6]

        // Same applies when you are calculating the DIFFERENCE of two lists as well.

        // ********* BINARY SEARCH IN THE LIST ************************************************************************************
        // The list must be sorted into ascending order according to the natural ordering of its elements
        // If it is not sorted, the results are undefined.
        // If the list contains multiple elements equal to the specified object, there is no guarantee which one will be found.
        // Returns: the index of the search key, if it is contained in the list; otherwise, (-(insertion point) - 1).
        // The insertion point is defined as the point at which the key would be inserted into the list:
        // the index of the first element greater than the key, or list.size() if all elements in the list are less than the specified key.
        // Note that this guarantees that the return value will be >= 0 if and only if the key is found.
        System.out.println("List 5: " + list5); // [1, 2, 4, 5, 6, 7, 10]
        int elmIdxFound = Collections.binarySearch(list5, 5);
        int elmIdxNotFound1 = Collections.binarySearch(list5, 3);
        int elmIdxNotFound2 = Collections.binarySearch(list5, 11);
        System.out.println("elmIdxFound: " + elmIdxFound); // 3
        System.out.println("elmIdxNotFound1: " + elmIdxNotFound1); // -3
        System.out.println("elmIdxNotFound2: " + elmIdxNotFound2); // -8
    }

    // [1,7,3,6,5,6]
    public int pivotIndex_2(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                leftSum += nums[i - 1];
            }
            if (i != nums.length - 1) {
                rightSum -= nums[i];
            } else {
                rightSum = 0;
            }

            if (leftSum == rightSum) return i;
        }


        return -1;
    }

    // 1,7,3,6,5,6
    // 1,2,3
    public int pivotIndex(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return -1;
        }

        int leftSum = 0;
        int rightSum = 0;
        int pivotIdx = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        while (pivotIdx < nums.length) {

            if (leftSum == rightSum) {
                return pivotIdx;
            }

            leftSum += nums[pivotIdx];
            pivotIdx++;
            rightSum = pivotIdx == nums.length ? 0 : (rightSum - nums[pivotIdx]);

        }

        return -1;

    }

}
