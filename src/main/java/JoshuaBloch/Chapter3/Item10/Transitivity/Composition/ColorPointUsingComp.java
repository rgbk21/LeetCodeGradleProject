package JoshuaBloch.Chapter3.Item10.Transitivity.Composition;

import JoshuaBloch.Chapter3.Item10.Transitivity.Color;
import JoshuaBloch.Chapter3.Item10.Transitivity.Point;

import java.util.Objects;

public class ColorPointUsingComp {

    private final Point point;
    private final Color color;

    public ColorPointUsingComp(int x, int y, Color color) {
        this.point = new Point(x,y);
        this.color = Objects.requireNonNull(color);
    }

    // Return the point-view of this color point
    public Point getPointView() {
        return this.point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorPointUsingComp)) return false;
        ColorPointUsingComp that = (ColorPointUsingComp) o;
        if (!point.equals(that.point)) return false;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = point.hashCode();
        result = 31 * result + color.hashCode();
        return result;
    }
}

class TestClass {

    public static void main(String[] args) {
        Point point = new Point(1,2);
        ColorPointUsingComp redColorPoint = new ColorPointUsingComp(1,2,Color.RED);
        ColorPointUsingComp blueColorPoint = new ColorPointUsingComp(1,2,Color.BLUE);

        // Now the equals method is symmetric.
        System.out.println("point.equals(redColorPoint): " + point.equals(redColorPoint)); // false
        System.out.println("redColorPoint.equals(point): " + redColorPoint.equals(point)); // false

        // And also transitive
        System.out.println("blueColorPoint.equals(point): " + blueColorPoint.equals(point)); // false
        System.out.println("point.equals(redColorPoint): " + point.equals(redColorPoint)); // false
        System.out.println("blueColorPoint.equals(redColorPoint): " + blueColorPoint.equals(redColorPoint)); // false
    }
}
