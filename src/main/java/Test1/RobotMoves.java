package Test1;

import java.util.Scanner;

class Robot {

    private int currentX;
    private int currentY;
    private int previousX;
    private int previousY;
    private String lastMovedCoordinate = "";
    private int lastMovedDistance = 0;

    public Robot () {
        this.currentX = 0;
        this.currentY = 5;
    }

    public Robot(int currentX, int currentY) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.previousX = 0;
        this.previousY = 5;
    }

    public void moveX (int dx){
        this.previousX = this.currentX;
        this.previousY = this.currentY;
        this.currentX += dx;
        this.lastMovedCoordinate = "x";
        this.lastMovedDistance = dx;
    }

    public void moveY (int dy){
        this.previousY = this.currentY;
        this.previousX = this.currentX;
        this.currentY += dy;
        this.lastMovedCoordinate = "y";
        this.lastMovedDistance = dy;
    }

    public void printCurrentCoordinates() {
        System.out.println(this.currentX + " " + this.currentY);
    }

    public void printLastCoordinates() {
        System.out.println(this.previousX + " " + this.previousY);
    }

    public void printLastMove() {
        System.out.println(this.lastMovedCoordinate + " " + this.lastMovedDistance);
    }
}

public class RobotMoves {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int x = 1;
        int y = 5;
        int dx = 1;
        int dy = 1;

        Robot firstRobot = new Robot();
        firstRobot.printCurrentCoordinates();

        Robot secondRobot = new Robot(x, y);
        secondRobot.printCurrentCoordinates();

        for (int i = 1; i < 3; i++) {
            secondRobot.moveX(dx);
            secondRobot.printLastMove();
            secondRobot.printCurrentCoordinates();
            secondRobot.moveY(dy);
            secondRobot.printLastCoordinates();

            dx += i * i;
            dy -= i * i;
        }
    }
}
