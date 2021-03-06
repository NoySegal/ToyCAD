public class Circle extends Ellipse {
    private double radius;
    private Point center;

    public Circle(String color, double radius, Point center) {
        super(color, new Point[] {center, new Point(center)}, 2*radius);
        this.radius = radius;
        this.center = center;
    }

    public double getRadius() {
        return this.radius;
    }

    public Circle copy() {
        return new Circle(this.getColor(), this.getRadius(), new Point(center));
    }

    public double circumference() {
        return 2 * Math.PI * this.getRadius();
    }
}
