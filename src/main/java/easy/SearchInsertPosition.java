package easy;

public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition.searchInsert(new int[] {1,3,5,6}, 2);
    }

    public static int searchInsert(int[] nums, int target) {

        //https://stackoverflow.com/questions/249392/binary-search-in-array
        //https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html

        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        int midIdx = 0;

        while (leftIdx <= rightIdx){

            midIdx = leftIdx +  ((rightIdx - leftIdx ) / 2);

            if(nums[midIdx] == target){
                return midIdx;
            }

            if (nums[midIdx] < target){
                leftIdx = midIdx + 1;
            } else {
                rightIdx = midIdx - 1;
            }

        }

        return leftIdx;
        //Bad...
        //return nums[midIdx] < target ? midIdx + 1 : midIdx - 1;
    }

}
