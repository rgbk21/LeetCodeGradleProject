package easy;

public class RemoveElement {

    public static void main(String[] args) {
        removeElement(new int[] {0,1,2,2,3,0,4,2}, 2);
    }

    /*

    A very convoluted way of NOT doing something...

    public static int removeElement(int[] nums, int val) {

        int writeIdx = -1;
        boolean diffNumSeen = true;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == val && diffNumSeen){
                writeIdx = i;
                diffNumSeen = false;
            } else if (nums[i] != val) {
                if(writeIdx != -1){
                    diffNumSeen = true;
                    nums[writeIdx++] = nums[i];
                }
            }
        }
        return writeIdx-1;
    }


    */

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
