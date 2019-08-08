import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTestCopy {

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
    public void copy() {

        //Circle
        Shape copiedCircle = circle.copy();
        assertEquals(circle.getColor(), copiedCircle.getColor());
        assertArrayEquals(circle.getVertices(), copiedCircle.getVertices());
        assertEquals(circle.area(), copiedCircle.area(), 0);

        //Ellipse
        Shape copiedEllipse = ellipse.copy();
        assertEquals(ellipse.getColor(), copiedEllipse.getColor());
        assertArrayEquals(ellipse.getVertices(), copiedEllipse.getVertices());
        assertEquals(ellipse.area(), copiedEllipse.area(), 0);

        //Parallelogram
        Shape copiedParallelogram = parallelogram.copy();
        assertEquals(parallelogram.getColor(), copiedParallelogram.getColor());
        assertArrayEquals(parallelogram.getVertices(), copiedParallelogram.getVertices());
        assertEquals(parallelogram.area(), copiedParallelogram.area(), 0);

        //Rectangle
        Shape copiedRectangle = rectangle.copy();
        assertEquals(rectangle.getColor(), copiedRectangle.getColor());
        assertArrayEquals(rectangle.getVertices(), copiedRectangle.getVertices());
        assertEquals(rectangle.area(), copiedRectangle.area(), 0);

        //Square
        Shape copiedSquare = square.copy();
        assertEquals(square.getColor(), copiedSquare.getColor());
        assertArrayEquals(square.getVertices(), copiedSquare.getVertices());
        assertEquals(square.area(), copiedSquare.area(), 0);

        //Triangle
        Shape copiedTriangle = triangle.copy();
        assertEquals(triangle.getColor(), copiedTriangle.getColor());
        assertArrayEquals(triangle.getVertices(), copiedTriangle.getVertices());
        assertEquals(triangle.area(), copiedTriangle.area(), 0);
    }
}