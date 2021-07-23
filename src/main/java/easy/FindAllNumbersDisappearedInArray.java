package easy;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInArray {

    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers_v2(int[] nums){
        // [4,3,2,7,8,2,3,1] => [5,6]
        List<Integer> missingNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int mappedIdx = Math.abs(nums[i]) - 1;
            // If the
            nums[mappedIdx] = nums[mappedIdx] > 0 ? -nums[mappedIdx] : nums[mappedIdx];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missingNums.add(i+1);
            }
        }
        return missingNums;
    }

    //TODO: Good question, with good technique.
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //{3,3,2,1,4,5,6,4}

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int currNum = nums[i];

            if (currNum > 0 && nums[currNum-1] > 0) {

                nums[currNum-1] = nums[currNum-1] * (-1);

            } else if (currNum < 0 && nums[Math.abs(currNum) - 1] > 0) {

                nums[Math.abs(currNum) - 1] = nums[Math.abs(currNum) - 1] * (-1);
            }

        }

        for (int i = 0; i < nums.length; i++) {

            //If the number is positive, it means that the number i+1 never occurred in the array
            if (nums[i] > 0) {
                result.add(i+1);
            }

        }

        return result;




    }

}
