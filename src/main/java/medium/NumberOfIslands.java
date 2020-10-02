package medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {

        int myInt2 = Integer.parseInt("12345");
    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int numOfIslands = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {

                if (grid[r][c] == '1') {
                    numOfIslands++;
                    grid[r][c] = 0;
                    Queue<String> neighbors = new ArrayDeque<>();
                    neighbors.add(r + "-" + c);

                    while (!neighbors.isEmpty()) {

                        String[] neighbor = neighbors.poll().split("-");
                        int nbrRow = Integer.parseInt(neighbor[0]);
                        int nbrCol = Integer.parseInt(neighbor[1]);

                        if (nbrRow + 1 < numRows && grid[nbrRow + 1][nbrCol] == '1') {
                            neighbors.add((nbrRow + 1) + "-" + nbrCol);
                            grid[nbrRow + 1][nbrCol] = '0';
                        }

                        if (nbrRow - 1 >= 0 && grid[nbrRow - 1][nbrCol] == '1') {
                            neighbors.add((nbrRow - 1) + "-" + nbrCol);
                            grid[nbrRow - 1][nbrCol] = '0';
                        }

                        if (nbrCol + 1 < numCols && grid[nbrRow][nbrCol + 1] == '1') {
                            neighbors.add((nbrRow) + "-" + (nbrCol + 1));
                            grid[nbrRow][nbrCol + 1] = '0';
                        }

                        if (nbrCol - 1 >= 0 && grid[nbrRow][nbrCol - 1] == '1') {
                            neighbors.add((nbrRow) + "-" + (nbrCol - 1));
                            grid[nbrRow][nbrCol - 1] = '0';
                        }

                    }

                }

            }
        }

        return numOfIslands;

    }

//    public int numIslands_2(char[][] grid) {
//
//        if (grid == null || grid.length == 0) return 0;
//
//        int numOfIslands = 0;
//        int numRows = grid.length;
//        int numCols = grid[0].length;
//
//        for (int r = 0; r < grid.length; r++) {
//            for (int c = 0; c < grid[r].length; c++) {
//
//                if (grid[r][c] == '1') {
//                    numOfIslands++;
//                    grid[r][c] = 0;
//                    Queue<Pair<Integer, Integer>> neighbors = new ArrayDeque<>();
//                    neighbors.add(new Pair<>(r, c));
//
//                    while (!neighbors.isEmpty()) {
//
//                        Pair<Integer, Integer> neighbor = neighbors.poll();
//                        int nbrRow = neighbor.getKey();
//                        int nbrCol = neighbor.getValue();
//
//                        if (nbrRow + 1 < numRows && grid[nbrRow + 1][nbrCol] == '1') {
//                            neighbors.add(new Pair<>(nbrRow + 1, nbrCol));
//                            grid[nbrRow + 1][nbrCol] = '0';
//                        }
//
//                        if (nbrRow - 1 >= 0 && grid[nbrRow - 1][nbrCol] == '1') {
//                            neighbors.add(new Pair<>(nbrRow - 1, nbrCol));
//                            grid[nbrRow - 1][nbrCol] = '0';
//                        }
//
//                        if (nbrCol + 1 < numCols && grid[nbrRow][nbrCol + 1] == '1') {
//                            neighbors.add(new Pair<>(nbrRow, nbrCol + 1));
//                            grid[nbrRow][nbrCol + 1] = '0';
//                        }
//
//                        if (nbrCol - 1 >= 0 && grid[nbrRow][nbrCol - 1] == '1') {
//                            neighbors.add(new Pair<>(nbrRow, nbrCol - 1));
//                            grid[nbrRow][nbrCol - 1] = '0';
//                        }
//
//                    }
//
//                }
//
//            }
//        }
//
//        return numOfIslands;
//
//    }

}
