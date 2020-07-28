package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

//        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = new int[][]{{1}, {2}, {3}};

        spiralOrder_2(matrix);

    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }

            System.out.println();
        }

        return l;
    }

    public static List<Integer> spiralOrder_2(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) return result;

        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int i = colBegin; i <= colEnd; i++) {
                result.add(matrix[rowBegin][i]);
            }

            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }

            colEnd--;

            if (rowBegin <= rowEnd) {//this if condition is important: https://www.youtube.com/watch?v=3joo9yAZVh8
                for (int i = colEnd; i >= colBegin; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }

            rowEnd--;

            if (colBegin <= colEnd) {//this if condition is important
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result.add(matrix[i][colBegin]);
                }
            }

            colBegin++;

        }

        return result;
    }

}
