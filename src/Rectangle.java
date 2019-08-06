public class Rectangle extends Parallelogram {

    public Rectangle(String color, Point[] vertices) {
        super(color, new Point[]{vertices[0], vertices[1], new Point(vertices[0].getX(), vertices[1].getY())});

    }
}
