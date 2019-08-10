public abstract class Polygon extends Shape {

    public Polygon(String color, Point[] vertices) {
        super(color, vertices);
    }

    public double circumference() {
        Point[] vertices = this.getVertices();
        double sum = 0;

        for (int i = 0; i < vertices.length; i++) {
            sum += vertices[i].distance(vertices[(i + 1) % vertices.length]);
        }
        return sum;
    }
}
