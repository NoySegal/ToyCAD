public class Parallelogram extends Shape {

    public Parallelogram(String color, Point[] vertices) {
        super(color, new Point[] {vertices[0], vertices[1], vertices[2], getFourthVertex(vertices)});
    }

    private static Point getFourthVertex(Point[] p) {
        Point diagonalPoint = new Point((p[0].getX() + p[2].getX()) / 2, (p[0].getY() + p[2].getY()) / 2);
        return new Point(2 * diagonalPoint.getX() - p[1].getX(), 2 * diagonalPoint.getY() - p[1].getY());
    }
}
