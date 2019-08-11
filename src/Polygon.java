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

    public boolean isInside(Point point) {
        Point[] vertex = this.getVertices();
        boolean result = false;

        for (int i = 0, j = vertex.length - 1; i < vertex.length; j = i++ ) {

            if ( ((vertex[i].getY() > point.getY()) != (vertex[j].getY() > point.getY())) &&
                    (point.getX() < (vertex[j].getX() - vertex[i].getX()) * (point.getY() - vertex[i].getY()) /
                                    (vertex[j].getY() - vertex[i].getY()) + vertex[i].getX()) ) {
                result = !result;
            }
        }
        return result;
    }
}
