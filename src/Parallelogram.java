public class Parallelogram extends Shape {

    public Parallelogram(String color, Point[] vertices) {
        super(color, new Point[] {vertices[0], vertices[1], vertices[2], getFourthVertex(vertices)});
    }

    private static Point getFourthVertex(Point[] p) {
        Point diagonalPoint = new Point((p[0].getX() + p[2].getX()) / 2, (p[0].getY() + p[2].getY()) / 2);
        return new Point(2 * diagonalPoint.getX() - p[1].getX(), 2 * diagonalPoint.getY() - p[1].getY());
    }

    public Parallelogram copy() {
        Point[] clonedVertices = Point.copyPoints(this.getVertices());
        return new Parallelogram(this.getColor(), clonedVertices);
    }

    public double area() {
        Point[] vertices = this.getVertices();
        double[][] matrix = new double[2][2];
        matrix[0][0] = vertices[0].getX() - vertices[1].getX();
        matrix[0][1] = vertices[0].getY() - vertices[1].getY();
        matrix[1][0] = vertices[2].getX() - vertices[1].getX();
        matrix[1][1] = vertices[2].getY() - vertices[1].getY();

        return Math.abs(matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]);
    }
}
