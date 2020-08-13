package easy;

public class ReplaceElementsWithGreatestElementsOnRightSide {

    public static void main(String[] args) {

    }

    //17,18,5,4,6,1
    //TODO: Note how we are iterating from the right-hadn side of the array
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
