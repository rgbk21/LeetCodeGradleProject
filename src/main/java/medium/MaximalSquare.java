package medium;

public class MaximalSquare {

    public static void main(String[] args) {

        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        maximalSquare(matrix);

    }

    public static int maximalSquare(char[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int overallMaxVal = 0;

        int[][] values = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            values[i][0] = Character.getNumericValue(matrix[i][0]);
            if (values[i][0] == 1) {
                overallMaxVal = 1;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            values[0][j] = Character.getNumericValue(matrix[0][j]);
            if (values[0][j] == 1) {
                overallMaxVal = 1;
            }
        }


        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {

                if (matrix[i][j] == '1') {
                    values[i][j] = Math.min(Math.min(values[i - 1][j], values[i][j - 1]), values[i - 1][j - 1]) + 1;
                    overallMaxVal = Math.max(overallMaxVal, values[i][j]);
                }
            }
        }

        return overallMaxVal * overallMaxVal;


    }

}
