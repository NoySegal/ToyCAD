public class Ellipse extends Shape {
    private double a;
    private double b;
    private double D;

    public Ellipse(String color, Point[] focusPoints, double D) {
        super(color, focusPoints);
        this.D = D;
        //this.a = D/2;
        //this.b = Math.sqrt(Math.pow(a, 2) - Math.pow((focusPoints[0].distance(focusPoints[1]))/2 , 2));
    }

    private double getA() {
        return D / 2;
    }

    private double getB() {
        double focalLength = this.getVertices()[0].distance(this.getVertices()[1]);
        return Math.sqrt(Math.pow(this.getA(), 2) - Math.pow((focalLength)/2 , 2));
    }

    private double getD() {
        return 2 * this.getA();
    }

    public Ellipse copy() {
        Point[] clonedVertices = Point.copyPoints(this.getVertices());
        return new Ellipse(this.getColor(), clonedVertices, this.getD());
    }

    public double area() {
        return Math.PI * this.getA() * this.getB();
    }

    public double circumference() {
        double a = this.getA();
        double b = this.getB();
        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }
}
