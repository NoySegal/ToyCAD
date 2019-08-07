public class Ellipse extends Shape {
    private double a;
    private double b;

    public Ellipse(String color, Point[] focusPoints, double D) {
        super(color, focusPoints);
        this.a = D/2;
        this.b = Math.sqrt(Math.pow(a, 2) - Math.pow((focusPoints[0].distance(focusPoints[1]))/2 , 2));

    }

    private double getD() {
        return 2 * this.a;
    }

    public Ellipse copyShape() {
        Point[] clonedVertices = Point.copyPoints(this.getVertices());
        return new Ellipse(this.getColor(), clonedVertices, this.getD());
    }

}
