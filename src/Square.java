public class Square extends Rectangle{
    private double side;
    private Point center;

    public Square(String color, Point center, double side) {
        super(color, getTwoOppositeVertices(center, side));
        this.side = side;
        this.center = center;
    }

    public static Point[] getTwoOppositeVertices(Point center, double side) {
        Point p1 = new Point(center.getX() - 0.5 * side, center.getY() + 0.5 * side);
        Point p2 = new Point(center.getX() + 0.5 * side, center.getY() - 0.5 * side);
        return new Point[]{p1, p2};
    }
}
