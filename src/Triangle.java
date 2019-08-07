public class Triangle extends Shape{

    public Triangle(String color, Point[] vertices) {
        super(color, vertices);
    }

    public Triangle copyShape() {
        Point[] clonedVertices = Point.copyPoints(this.getVertices());
        return new Triangle(this.getColor(), clonedVertices);
    }
}