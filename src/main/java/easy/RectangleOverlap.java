package easy;

public class RectangleOverlap {

    public static void main(String[] args) {

    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // check if either rectangle is actually a line
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            // the line cannot have positive overlap
            return false;
        }

        // This handles the cases where the rectangle R1 is 'outside' or 'touching' R2
        // R1 is above R2
        if (rec1[1] >= rec2[3]){
            return false;
        }

        // R1 is below R2
        if (rec1[3] <= rec2[1]) {
            return false;
        }

        // R1 is to the right of R2
        if (rec1[0] >= rec2[2]) {
            return false;
        }

        // R1 is to the left of R2
        if (rec1[2] <= rec2[0]) {
            return false;
        }

        // If it reaches here, then that means that R1 is not entirely outside R2, and hence there should be some overlap
        return true;
    }
}
