package easy;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

    public static void main(String[] args) {

    }

    public boolean isPathCrossing(String path) {

        Set<String> pointsVisited = new HashSet<>();
        String currPosition = "0:0";
        pointsVisited.add(currPosition);
        int x = 0; // left
        int y = 0; // right


        for (int i = 0; i < path.length(); i++) {
            StringBuilder sb = new StringBuilder();
            String newPosition = "";
            Character currDirection = path.charAt(i);

            if (currDirection == 'N') {
                y += 1;
            } else if (currDirection == 'E') {
                x += 1;
            } else if (currDirection == 'S') {
                y -= 1;
            } else {
                x -= 1;
            }

            newPosition = sb.append(x).append(":").append(y).toString();
            //newPosition = x + ":" + y;
            if (pointsVisited.contains(newPosition)) {
                return true;
            }
            pointsVisited.add(newPosition);
            // sb.setLength(0);
        }

        return false;

    }

}
