package easy;

import java.util.*;

public class ThirdMaximumNumber_TODO {

    //https://leetcode.com/problems/third-maximum-number/solution/

    public static void main(String[] args) {

        int[] arr = new int[] {3,2,1,4,5,6,7,8,9};

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        System.out.println("The priority queue returns: " + priorityQueue.poll()); // The priority queue returns: 1

        // Note that the Set interface does not have a first() or last() or pollFirst() or pollLast() or
        // any other such methods. Hence do not use the Set type to assign an object of the TreeSet().
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        // Prints: 1,2,3,4,5,6,7,8,9 in order
        for (int num : set) {
            System.out.println(num);
        }

        // Use the TreeSet or the SortedSet interface instead, as shown below.
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            treeSet.add(arr[i]);
        }
        // TreeSet interface has additional methods that are not present in the Set interface
        Integer first = treeSet.first();
        System.out.println("Peek the first element: " + first); // 1
        Integer removedElm = treeSet.pollFirst();
        System.out.println("Remove the first element: " + removedElm); // 1. Since the array is sorted in the ascending order, this will also be the smallest element
        first = treeSet.first();
        System.out.println("First element is now: " + first); // 2
        Integer last = treeSet.last();
        System.out.println("Peek the last element: " + last); // 9
        removedElm = treeSet.pollLast();
        System.out.println("Remove the last element: " + removedElm); // 9. Since the array is sorted in the ascending order, this will also be the largest element
        last = treeSet.last();
        System.out.println("Last element is now: " + last); // 8


        thirdMax(arr);
    }

    // [2,2,3,1]
    public static int thirdMax_v2(int[] nums){

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        Set<Integer> uniqueNums = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            uniqueNums.add(nums[i]);
        }

        int numOfElementsToRemove = 2;
        int removalIdx = 0;
        int firstMax = Collections.max(uniqueNums);
        while (removalIdx < numOfElementsToRemove && !uniqueNums.isEmpty()) {
            uniqueNums.remove(Collections.max(uniqueNums));
            removalIdx++;
        }

        return !uniqueNums.isEmpty() ? Collections.max(uniqueNums) : firstMax;
    }

    //TODO: Your initial process of thinking for this one was to store the 3 largest numbers in an array
    //and then compare each number currently in the array with the 3 largest numbers seen so far.
    //Which was honestly pretty bad
    //So use this method instead.

    //This code is still pretty slow. There are faster methods. Read solution.
    public static int thirdMax(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int largestNum;

        largestNum = Collections.max(numSet);

        if (numSet.size() < 3) return largestNum;

        numSet.remove(largestNum);
        largestNum = Collections.max(numSet);
        numSet.remove(largestNum);
        largestNum = Collections.max(numSet);
        return largestNum;

    }

}
