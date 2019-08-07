import java.awt.geom.Point2D;

public class Point extends Point2D.Double{

    public Point(double x, double y) {
        super(x, y);
    }

    public Point(Point point) {
        super(point.getX(), point.getY());
    }

    public static Point[] copyPoints(Point[] originalPoints) {
        Point[] copiedPoints = new Point[originalPoints.length];

        for (int i = 0; i < originalPoints.length; i++) {
            copiedPoints[i] = new Point(originalPoints[i]);
        }

        return copiedPoints;
    }
}
