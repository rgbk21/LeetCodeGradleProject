package Test1;

public class ClosedPaths {

    public static void main(String[] args) {
        closedPaths(630);
    }

    public static int closedPaths(int number) {
        // Write your code here
        int[] numOfClosedPaths = new int[] {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};

        int num = number;
        int result = 0;

        while (num >= 0) {
            int digit = num % 10;
            result += numOfClosedPaths[digit];

            num = num/10;
        }

        return result;

    }

}
