package medium;

public class DiagonalTraverse {

    public static void main(String[] args) {

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
