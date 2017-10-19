import java.awt.*;

public class LineTester {
    public static void main(String[] args) {
        Line verticalLine = new Line(3);
        System.out.println("Expected: true, Got: " + verticalLine.isVertical());
        System.out.println("Expected: false, Got: " + verticalLine.isHorizontal());

        Line verticalLineUsingPoints = new Line(new Point(2, 4), new Point(2, 3));
        System.out.println("Expected: true, Got: " + verticalLineUsingPoints.isVertical());
        System.out.println("Expected: false, Got: " + verticalLineUsingPoints.isHorizontal());

        Line pointAndSlopeLine = new Line(new Point(0, 2), 2);
        Line slopeLine = new Line(2, 2);
        System.out.println("Expected: true, Got: " + slopeLine.equals(pointAndSlopeLine));
        System.out.println("Expected: true, Got: " + slopeLine.isParallel(pointAndSlopeLine));
    }
}
