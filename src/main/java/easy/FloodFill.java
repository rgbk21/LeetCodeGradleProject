package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class FloodFill {

    public static void main(String[] args) {
        floodFill(new int[][]{{0,0,1},{0,1,1}}, 1,1,1);
    }

    // BFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        int currentColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
        queue.add(Map.entry(sr, sc));
        visited[sr][sc] = true;
        image[sr][sc] = newColor;

        while (!queue.isEmpty()) {

            Map.Entry<Integer, Integer> entry = queue.pop();
            sr = entry.getKey();
            sc = entry.getValue();

            if (sr-1 >= 0 && (!visited[sr-1][sc]) && image[sr-1][sc]==currentColor) {
                queue.add(Map.entry(sr-1, sc));
                visited[sr-1][sc] = true;
                image[sr-1][sc] = newColor;
            }
            if (sc+1 < image[0].length && (!visited[sr][sc+1]) && image[sr][sc+1]==currentColor) {
                queue.add(Map.entry(sr, sc+1));
                visited[sr][sc+1] = true;
                image[sr][sc+1] = newColor;
            }
            if (sr+1 < image.length && (!visited[sr+1][sc]) && image[sr+1][sc]==currentColor) {
                queue.add(Map.entry(sr+1, sc));
                visited[sr+1][sc] = true;
                image[sr+1][sc] = newColor;
            }
            if (sc-1 >= 0 && (!visited[sr][sc-1]) && image[sr][sc-1]==currentColor) {
                queue.add(Map.entry(sr, sc-1));
                visited[sr][sc-1] = true;
                image[sr][sc-1] = newColor;
            }
        }
        return image;
    }
}
