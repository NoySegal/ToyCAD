import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTestMove {

    //Coordinates for parallelogram, rectangle, square, triangle
    private Point vertex1 = new Point(-1, 5);
    private Point vertex2 = new Point(3, 3);
    private Point vertex3 = new Point(6, -4);
    private Point vertex4 = new Point(2, -2);

    //Square coordinates
    private Point vertexSquare1 = new Point(-2.5, 2.5);
    private Point vertexSquare2 = new Point(-2.5, -6.5);
    private Point vertexSquare3 = new Point(6.5, -6.5);
    private Point vertexSquare4 = new Point(6.5, 2.5);

    //Circle
    private Point center = new Point(1,1);
    private double radius = 17.56;
    private Shape circle = new Circle("red", radius, center);

    //Ellipse
    private Point[] focus = new Point[] {new Point(1,2), new Point(3,4)};
    private double D = 14.72;
    private Shape ellipse = new Ellipse("blue", focus, D);

    //Parallelogram
    private Shape parallelogram = new Parallelogram("yellow", new Point[]{vertex1, vertex2, vertex3});

    //Rectangle
    private Shape rectangle = new Rectangle("green", new Point[]{vertex1, vertex2});

    //Square
    private Shape square = new Square("red", vertex4, 9);

    //Triangle
    private Shape triangle = new Triangle("yellow", new Point[]{vertex1, vertex2, vertex3});

    @Test
    public void move() {

        //Circle
        Point[] coordinates = new Point[] {new Point(16.7, -15), new Point(11.2, 19.33)};
        double dx;
        double dy;

        for (int i = 0; i<coordinates.length; i++) {
            dx = coordinates[i].getX() - circle.getVertices()[0].getX();
            dy = coordinates[i].getY() - circle.getVertices()[0].getY();

            circle.move(dx, dy);

            assertEquals(coordinates[i], circle.getVertices()[0]);
            assertEquals(coordinates[i], circle.getVertices()[1]);
        }
        /*
        circle.move(15.7, -16);
        assertEquals(coordinates[0], circle.getVertices()[0]);
        assertEquals(coordinates[0], circle.getVertices()[1]);

        circle.move(-5.5, 34.33);
        assertEquals(coordinates[1], circle.getVertices()[0]);
        assertEquals(coordinates[1], circle.getVertices()[1]);
         */

        //Square
        dx = 5;
        dy = -4;

        square.move(dx, dy);

        Point movedVertex1 = new Point(2.5, -1.5);
        Point movedVertex2 = new Point(2.5, -10.5);
        Point movedVertex3 = new Point(11.5, -10.5);
        Point movedVertex4 = new Point(11.5, -1.5);
        Point[] movedVertices = new Point[] {movedVertex1, movedVertex2, movedVertex3, movedVertex4};

        assertArrayEquals(movedVertices, square.getVertices());

        //Triangle
        dx = -2;
        dy = 10;

        triangle.move(dx, dy);

        Point vertexTriangle1 = new Point(-3, 15);
        Point vertexTriangle2 = new Point(1, 13);
        Point vertexTriangle3 = new Point(4, 6);
        Point[] vertexTriangle = new Point[] {vertexTriangle1, vertexTriangle2, vertexTriangle3};
        assertArrayEquals(vertexTriangle, triangle.getVertices());
    }
}