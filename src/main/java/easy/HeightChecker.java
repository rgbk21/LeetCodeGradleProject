package easy;

public class HeightChecker {

    public static void main(String[] args) {
        heightChecker(new int[] {1,1,4,2,1,3});
    }

    /*

    heights: {1,1,4,2,1,3}
    heightFreq: {0,3,1,1,1,0}
    So based on the heightFreq, we are expecting the following array:
    expectedHeight: {1,1,1,2,3,4}

    */

    //TODO: Nice solution. Go over it again.
    //If the constraints given in the problem are really small, like the actual numbers are small
    //it might point to some caching mechanism that can be used in the solution.
    public static int heightChecker(int[] heights) {

        int[] heightFreq = new int[101];

        for (int height : heights) {
            heightFreq[height] = heightFreq[height] + 1;
        }

        int heightIdx = 0;
        int result = 0;

        for (int i = 0; i < heights.length; i++) {

            while (heightFreq[heightIdx] == 0) {
                heightIdx++;
            }

            if (heights[i] != heightIdx) {
                result++;
            }

            heightFreq[heightIdx] = heightFreq[heightIdx] - 1;

        }

        return result;


    }

}
