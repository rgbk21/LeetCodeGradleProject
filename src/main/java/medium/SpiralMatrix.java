package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SpiralMatrix {

    public static void main(String[] args) {

        // *********************************************************************
        // How to check if two arrays are equal?
        // *********************************************************************
        String[] firstArray = {"a", "b", "c"};
        String[] secondArray = {"a", "b", "c"};

        // IntelliJ is smart enough to warn you about using the equals method in the case of array
        // Warning: 'equals()' between arrays should probably be 'Arrays.equals()'
        System.out.println("Are they equal 1: " + firstArray.equals(secondArray)); // false
        System.out.println("Are they equal 2: " + Objects.equals(firstArray, secondArray)); // false

        // Arrays.equals prints true. So this gives the correct answer.
        System.out.println("Are they equal 3: " + Arrays.equals(firstArray, secondArray)); // true


        // *********************************************************************
        // How to check if two multi-dimensional arrays are equal?
        // *********************************************************************
        int a[][] = new int[2][2];
        int b[][] = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = i + j;
                b[i][j] = i + j;
            }
        }
        System.out.println("Deep Equals: " + Arrays.deepEquals(a, b)); // return true
        System.out.println("Simple Equals: " + Arrays.equals(a, b)); // return false
        // Note that Arrays.equals returns false in the case of multi-dimensional arrays.

        // *********************************************************************
        // How to sort an array?
        // *********************************************************************
        String[] names = new String[]{"Dave", "Charlie", "Bob", "Alice"};
        int[] numbers = new int[] {1,9,3,4,8,2,5,5};
        Arrays.sort(names);
        Arrays.sort(numbers);
        System.out.println("Names Sorted: " + Arrays.toString(names)); // [Alice, Bob, Charlie, Dave]
        System.out.println("Numbers Sorted: " + Arrays.toString(numbers)); // [1, 2, 3, 4, 5, 5, 8, 9]

        // You can also pass in a custom comparator
        // You cannot directly sort primitives in reverse order.
//         Arrays.sort(numbers, (num1, num2) -> {
//          return num1 - num2;
//         });

    }

    /*
    1 2 3 4
    4 5 6 4
    7 8 9 4
    1 2 3 4
     */

    // [0,4] [] [1,4] [2,4] [3,4] [] [3,3] [3,2] [3,1]

    public static List<Integer> spiralOrder_v3(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int rightBorder = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                result.add(matrix[i][j]);

            }


        }


        return result;
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
