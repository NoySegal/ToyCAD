import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeTest {
    private static final double EPSILON = 0.001;

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
    public void getColor() {
        //Circle
        assertEquals("red", circle.getColor());

        //Ellipse
        assertEquals("blue", ellipse.getColor());

        //Parallelogram
        assertEquals("yellow", parallelogram.getColor());

        //Rectangle
        assertEquals("green", rectangle.getColor());

        //Square
        assertEquals("red", square.getColor());

        //Triangle
        assertEquals("yellow", triangle.getColor());
    }

    @Test
    public void setColor() {
        //Circle
        circle.setColor("red");
        String circleColorRed = circle.getColor();
        assertEquals("red", circleColorRed);
        circle.setColor("green");
        assertNotEquals("green", circleColorRed);
        assertEquals("green", circle.getColor());

        //Triangle
        triangle.setColor("blue");
        assertNotEquals("yellow", triangle.getColor());
        String triangleColorRed = triangle.getColor();
        assertEquals("blue", triangleColorRed);
        triangle.setColor("green");
        assertEquals("green", triangle.getColor());
    }

    @Test
    public void getVertices() {
        Point[] verticesParallelogram = new Point[] {vertex1, vertex2, vertex3, vertex4};
        Point[] verticesTriangle = new Point[] {vertex1, vertex2, vertex3};
        Point[] verticesSquare = new Point[] {vertexSquare1, vertexSquare2, vertexSquare3, vertexSquare4};
        Point[] verticesCircle = new Point[] {center, center};

        //Parallelogram
        assertArrayEquals(verticesParallelogram, parallelogram.getVertices());

        //Triangle
        assertArrayEquals(verticesTriangle, triangle.getVertices());

        //Square
        assertArrayEquals(verticesSquare, square.getVertices());

        //Circle
        assertArrayEquals(verticesCircle, circle.getVertices());
    }

    @Test
    public void circumference() {
        //Circle
        assertEquals(110.332, circle.circumference(), EPSILON);

        //Ellipse
        assertEquals(45.814, ellipse.circumference(), EPSILON);

        //Parallelogram
        assertEquals(24.175, parallelogram.circumference(), EPSILON);

        //Rectangle
        assertEquals(12, rectangle.circumference(), EPSILON);

        //Square
        assertEquals(36, square.circumference(), EPSILON);

        //Triangle
        assertEquals(23.489, triangle.circumference(), EPSILON);
    }

    @Test
    public void isInside() {
        Point[] randomPoint = new Point[] {new Point(3,2), new Point(-3.5, 1.2), new Point(2, -2),
                                            new Point(15, 20), new Point(0, 20), new Point(1, 1)};

        //circle
        assertTrue(circle.isInside(randomPoint[0]));
        assertTrue(circle.isInside(randomPoint[1]));
        assertTrue(circle.isInside(randomPoint[2]));
        assertFalse(circle.isInside(randomPoint[3]));
        assertFalse(circle.isInside(randomPoint[4]));
        assertTrue(circle.isInside(randomPoint[5]));

        //Ellipse
        assertTrue(ellipse.isInside(randomPoint[0]));
        assertTrue(ellipse.isInside(randomPoint[1]));
        assertTrue(ellipse.isInside(randomPoint[2]));
        assertFalse(ellipse.isInside(randomPoint[3]));
        assertFalse(ellipse.isInside(randomPoint[4]));
        assertTrue(ellipse.isInside(randomPoint[5]));

        //Parallelogram
        assertTrue(parallelogram.isInside(randomPoint[0]));
        assertFalse(parallelogram.isInside(randomPoint[1]));
        assertTrue(parallelogram.isInside(randomPoint[2]));
        assertFalse(parallelogram.isInside(randomPoint[3]));
        assertFalse(parallelogram.isInside(randomPoint[4]));
        assertTrue(parallelogram.isInside(randomPoint[5]));

        //Rectangle
        assertFalse(rectangle.isInside(randomPoint[0]));
        assertFalse(rectangle.isInside(randomPoint[1]));
        assertFalse(rectangle.isInside(randomPoint[2]));
        assertFalse(rectangle.isInside(randomPoint[3]));
        assertFalse(rectangle.isInside(randomPoint[4]));
        assertFalse(rectangle.isInside(randomPoint[5]));

        //Square
        assertTrue(square.isInside(randomPoint[0]));
        assertFalse(square.isInside(randomPoint[1]));
        assertTrue(square.isInside(randomPoint[2]));
        assertFalse(square.isInside(randomPoint[3]));
        assertFalse(square.isInside(randomPoint[4]));
        assertTrue(square.isInside(randomPoint[5]));

        //Triangle
        assertTrue(triangle.isInside(randomPoint[0]));
        assertFalse(triangle.isInside(randomPoint[1]));
        assertFalse(triangle.isInside(randomPoint[2]));
        assertFalse(triangle.isInside(randomPoint[3]));
        assertFalse(triangle.isInside(randomPoint[4]));
        assertFalse(triangle.isInside(randomPoint[5]));
    }
}