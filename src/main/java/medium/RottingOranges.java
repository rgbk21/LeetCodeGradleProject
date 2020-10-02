package medium;

//import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    //https://leetcode.com/problems/rotting-oranges/

    //TODO:
    //Good problem to practice BFS with the added condition of having to
    //traverse the graph in levels. Think about that Graph algorithm from Klienberg-Tardos.

    public static void main(String[] args) {

//        orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});

    }

//    public static int orangesRotting(int[][] grid) {
//
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//
//        int minutes = 0;
//        int freshOranges = 0;
//        int nRows = grid.length;
//        int nCols = grid[0].length;
//        int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
//
//        List<Queue<Pair<Integer, Integer>>> masterList = new ArrayList<>();
//        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 1) {
//                    freshOranges++;
//                } else if (grid[i][j] == 2) {
//                    queue.add(new Pair<>(i, j));
//                }
//            }
//        }
//
//        if (freshOranges == 0) {
//            return 0;
//        }
//
//        masterList.add(queue);
//
//        int level = 0;
//        boolean newElementsAdded = true;
//
//        for (; level < masterList.size(); level++) {
//
//            Queue<Pair<Integer, Integer>> currQueue = masterList.get(level);
//
//            if (newElementsAdded) {
//                masterList.add(new ArrayDeque<>());
//            }
//
//            newElementsAdded = false;
//
//            while (!currQueue.isEmpty()) {
//
//                Pair<Integer, Integer> currCell = currQueue.poll();
//                int currRow = currCell.getKey();
//                int currCol = currCell.getValue();
//
//                for (int[] direction : directions) {
//
//                    int nbrRow = currRow + direction[0];
//                    int nbrCol = currCol + direction[1];
//
//                    if (nbrRow >= nRows || nbrCol >= nCols || nbrRow < 0 || nbrCol < 0 || grid[nbrRow][nbrCol] != 1) {
//                        continue;
//                    }
//
//                    if (grid[nbrRow][nbrCol] == 1) {
//                        masterList.get(level+1).add(new Pair<>(nbrRow, nbrCol));
//                        freshOranges--;
//                        newElementsAdded = true;
//                        grid[nbrRow][nbrCol] = 2;
//                    }
//                }
//            }
//
//            if (freshOranges == 0) {
//                return level + 1;
//            }
//
//        }
//
//        return -1;
//    }

}
