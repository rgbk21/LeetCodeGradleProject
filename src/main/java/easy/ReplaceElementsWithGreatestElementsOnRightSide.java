package easy;

// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
public class ReplaceElementsWithGreatestElementsOnRightSide {

    public static void main(String[] args) {

    }

    // [17,18,5,4,6,1]
    // [18,6,6,6,1,-1]
    public int[] replaceElements_v2(int[] arr){

        int maxElmntOnTheRight = arr[arr.length - 1];
        int rightIdx = arr.length - 2;
        while (rightIdx >= 0) {
            int currNum = arr[rightIdx];
            arr[rightIdx] = maxElmntOnTheRight;
            if (currNum > maxElmntOnTheRight) {
                maxElmntOnTheRight = currNum;
            }
            rightIdx--;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    //17,18,5,4,6,1
    //TODO: Note how we are iterating from the right-hand side of the array
    public int[] replaceElements(int[] arr) {

        if (arr == null || arr.length == 0) return arr;

        int maxElmnt = arr[arr.length - 1];
        arr[arr.length - 1] = -1;

        for (int i = arr.length - 2; i >= 0; i--) {

            int temp = arr[i];

            arr[i] = maxElmnt;

            if (temp > maxElmnt) {
                maxElmnt = temp;
            }

        }

        return arr;

    }

}
