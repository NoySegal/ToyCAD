public class Triangle extends Polygon {

    public Triangle(String color, Point[] vertices) {
        super(color, vertices);
    }

    public Triangle copy() {
        Point[] clonedVertices = Point.copyPoints(this.getVertices());
        return new Triangle(this.getColor(), clonedVertices);
    }

    public double area() {
        Parallelogram triangleToParallelogram = completeToParallelogram();
        return triangleToParallelogram.area() / 2;
    }

    private Parallelogram completeToParallelogram() {
        return new Parallelogram(this.getColor(), this.getVertices());
    }
}