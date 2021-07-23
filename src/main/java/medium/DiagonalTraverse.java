package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

    public static void main(String[] args) {

        // Traversing a 2D Array
        int[][] matrix = new int[3][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        /* Prints:
        00000
        00000
        00000
         */

        // Traversing a 2D List
        List<List<Integer>> list = new ArrayList<>();
        // Suppose we were copying all the elements from the 2D array into the 2D List.
        // Note that we need to need to know the size of the parent list so that we can instantiate other lists within it without NPE.
        int limit = matrix.length;
        for (int i = 0; i < limit; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                list.get(i).add(matrix[i][j]);
            }
        }
        // Note that you were trying to do this earlier
        for (int i = 0; i < matrix.length; i++) {
            if (list.get(i) == null) {
                list.add(new ArrayList<>());
            }
            for (int j = 0; j < matrix[i].length; j++) {
                list.get(i).add(matrix[i][j]);
            }
        }
    }

    public int[] findDiagonalOrder_v2(int[][] matrix){

        /*
        1 2 3 4 5
        5 4 3 2 1
        1 2 3 4 5
        [0,0]
        [1,0] [0,1]
        [2,0] [1,1] [0,2]

         */
        // Create an array for storing all of the elements of the array
        int[] traversalResult = new int[matrix.length * matrix[0].length];
        List<List<Integer>> allNums = new ArrayList<>();
        // Figure out the right corner element of the array
        int limit = (matrix.length - 1) + (matrix[0].length - 1);
        // Instantiate all of the lists inside the parent list
        for (int i = 0; i <= limit; i++) {
            allNums.add(new ArrayList<>());
        }
        // Calculate the sum of the indices of the current element being visited
        // Add that element to the appropriate list number
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int idxSum = i+j;
                allNums.get(idxSum).add(matrix[i][j]);
            }
        }

        // Reverse the order of every alternate list
        for (int i = 0; i < allNums.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(allNums.get(i));
            }
        }

        int idx = 0;
        for (int i = 0; i < allNums.size(); i++) {
            for (int j = 0; j < allNums.get(i).size(); j++) {
                traversalResult[idx++] = allNums.get(i).get(j);
            }
        }

        return traversalResult;

    }

    public int[] findDiagonalOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }

        int nRows = matrix.length;
        int nCols = matrix[0].length;
        int writeIdx = 0;

        int[] result = new int[nRows * nCols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[writeIdx++] = matrix[i][j];
            }
        }

        return result;

    }

}
