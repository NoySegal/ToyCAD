import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTestArea {

    double EPSILON = 0.001;

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
    private Shape rectangle = new Rectangle("green", new Point[]{vertex1, vertex3});

    //Square
    private Shape square = new Square("red", vertex4, 9);

    //Triangle
    private Shape triangle = new Triangle("yellow", new Point[]{vertex1, vertex2, vertex3});

    @Test
    public void area() {

        //Circle
        assertEquals(968.721, circle.area(), EPSILON);

        //Ellipse
        assertEquals(167.007, ellipse.area(), EPSILON);

        //Parallelogram
        assertEquals(22, parallelogram.area(), EPSILON);

        //Rectangle
        assertEquals(63, rectangle.area(), EPSILON);

        //Square
        assertEquals(81, square.area(), EPSILON);

        //Triangle
        assertEquals(11, triangle.area(), EPSILON);
    }
}