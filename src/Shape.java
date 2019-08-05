public abstract class Shape {

    private int ID;
    private static int counter = 0;
    private String color;

    public Shape(String color) {
        this.color = color;
        this.ID = counter;
        counter++;
    }

    public String getColor() {
        return this.color;
    }

    public int getID() {
        return this.ID;
    }
}
