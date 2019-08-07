public abstract class Shape {
    private int ID;
    private static int counter = 0;
    private String color;
    private Point[] vertices;

    public Shape(String color, Point[] vertices) {
        this.color = color;
        this.vertices = vertices;
        this.ID = counter;
        counter++;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String newColor) { this.color = newColor; }

    public int getID() {
        return this.ID;
    }

    public Point[] getVertices() { return this.vertices; }

    public void moveShape(double xOffset, double yOffset) {
        for (Point point : this.vertices) {
            System.out.format("X should be %f", point.getX() + xOffset);
            point.setLocation(point.getX() + xOffset, point.getY() + yOffset);
        }
    }
}
