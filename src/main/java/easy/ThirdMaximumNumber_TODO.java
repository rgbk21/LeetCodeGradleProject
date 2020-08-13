package easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThirdMaximumNumber_TODO {

    //https://leetcode.com/problems/third-maximum-number/solution/

    public static void main(String[] args) {

        thirdMax(new int[] {1,2,3,4,5,6,7,8,9});

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
