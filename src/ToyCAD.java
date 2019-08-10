import java.util.Scanner;
import java.util.HashMap;

public class ToyCAD {
    //TODO make shapesMap public static
    //TODO add separate class for the project
    //TODO enable multiple projects feature
    private static void setNewShape(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        Shape newShape = null;
        String shapeType = stdinArgs[1];
        String shapeColor = stdinArgs[2];

        switch (shapeType) {
            case "circle": {
                double radius = Double.parseDouble(stdinArgs[5]);
                Point center = new Point(Double.parseDouble(stdinArgs[3]), Double.parseDouble(stdinArgs[4]));
                newShape = new Circle(shapeColor, radius, center);
                break;
            }
            case "ellipse": {
                Point focus1 = new Point(Double.parseDouble(stdinArgs[3]), Double.parseDouble(stdinArgs[4]));
                Point focus2 = new Point(Double.parseDouble(stdinArgs[5]), Double.parseDouble(stdinArgs[6]));
                double D = Double.parseDouble(stdinArgs[7]);
                newShape = new Ellipse(shapeColor, new Point[]{focus1, focus2}, D);
                break;
            }
            case "parallelogram": {
                Point vertex1 = new Point(Double.parseDouble(stdinArgs[3]), Double.parseDouble(stdinArgs[4]));
                Point vertex2 = new Point(Double.parseDouble(stdinArgs[5]), Double.parseDouble(stdinArgs[6]));
                Point vertex3 = new Point(Double.parseDouble(stdinArgs[7]), Double.parseDouble(stdinArgs[8]));
                newShape = new Parallelogram(shapeColor, new Point[]{vertex1, vertex2, vertex3});
                break;
            }
            case "rectangle": {
                Point vertex1 = new Point(Double.parseDouble(stdinArgs[3]), Double.parseDouble(stdinArgs[4]));
                Point vertex2 = new Point(Double.parseDouble(stdinArgs[5]), Double.parseDouble(stdinArgs[6]));
                newShape = new Rectangle(shapeColor, new Point[]{vertex1, vertex2});
                break;
            }
            case "square": {
                Point center = new Point(Double.parseDouble(stdinArgs[3]), Double.parseDouble(stdinArgs[4]));
                double side = Double.parseDouble(stdinArgs[5]);
                newShape = new Square(shapeColor, center, side);
                break;
            }
            case "triangle": {
                Point vertex1 = new Point(Double.parseDouble(stdinArgs[3]), Double.parseDouble(stdinArgs[4]));
                Point vertex2 = new Point(Double.parseDouble(stdinArgs[5]), Double.parseDouble(stdinArgs[6]));
                Point vertex3 = new Point(Double.parseDouble(stdinArgs[7]), Double.parseDouble(stdinArgs[8]));
                newShape = new Triangle(shapeColor, new Point[] {vertex1, vertex2, vertex3});
                break;
            }
            default:
                System.out.println("Shape not found.");
        }

        if (newShape != null) {
            shapesMap.put(newShape.getID(), newShape);
            System.out.println("Shape ID: " + newShape.getID());
        }
    }

    private static void delShape(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        int deleteID = Integer.parseInt(stdinArgs[1]);
        shapesMap.remove(deleteID);
    }

    private static void validateDoubleFormat(String[] stdinArgs) {
        double tempX = Double.parseDouble(stdinArgs[2]);
        double tempY = Double.parseDouble(stdinArgs[3]);
    }

    private static void moveShape(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        Shape thisShape = shapesMap.get(Integer.parseInt(stdinArgs[1]));
        if (thisShape == null) {
            System.out.println("Shape ID not found.");
        } else {
            thisShape.move(Double.parseDouble(stdinArgs[2]), Double.parseDouble(stdinArgs[3]));
        }
    }

    private static void copyShape(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        Shape originalShape = shapesMap.get(Integer.parseInt(stdinArgs[1]));
        validateDoubleFormat(stdinArgs);
        if (originalShape == null) {
            System.out.println("Shape ID not found.");
        } else {
            Shape copiedShape = originalShape.copy();

            shapesMap.put(copiedShape.getID(), copiedShape);
            stdinArgs[1] = String.valueOf(copiedShape.getID());
            moveShape(stdinArgs, shapesMap);

            System.out.println("Shape ID: " + copiedShape.getID());
        }
    }

    private static void calcColorArea(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        double total = 0;
        String color = stdinArgs[1];
        for (HashMap.Entry entry : shapesMap.entrySet()) {
            Shape shape = (Shape) entry.getValue();

            if (shape.getColor().equals(color)) {
                total += shape.area();
            }
        }
        String strDouble = String.format("%.2f", total);
        System.out.println("Total area calculated for the color: " + color + ", equals: " + strDouble);
    }

    private static void changeColor(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        Shape shape = shapesMap.get(Integer.parseInt(stdinArgs[2]));
        if (shape == null) {
            System.out.println("Shape ID not found.");
        } else {
            shape.setColor(stdinArgs[1]);
        }
    }

    private static void calcColorCircumference(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        double total = 0;
        String color = stdinArgs[1];
        for (HashMap.Entry entry : shapesMap.entrySet()) {
            Shape shape = (Shape) entry.getValue();

            if (shape.getColor().equals(color)) {
                total += shape.circumference();
            }
        }
        String strDouble = String.format("%.2f", total);
        System.out.println("Total circumference calculated for the color: " + color + ", equals: " + strDouble);
    }

    private static void printRules() {
        System.out.println("                Welcome to ToyCAD");
        System.out.println("        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("        Editor notes:");
        System.out.println("    -   Shapes supported: Circle, Ellipse, Parallelogram, Rectangle, Square, Triangle.");
        System.out.println("    -   Colors supported: Blue, Red, Yellow, Green.");
        System.out.println("    -   No support for overlapping shapes.");
        System.out.println("    -   Support for one project per program.");
        System.out.println("        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("                How to use:");
        System.out.println("    Create new shape:");
        System.out.println("    -   new circle color x y radius");
        System.out.println("            >>> Creates new circle with center at (x,y) and radius.");
        System.out.println("    -   new ellipse color x1 y1 x2 y2 D");
        System.out.println("            >>> Creates new ellipse with focus points at (x1,y1) & (x2,y2) and D.");
        System.out.println("            >>> D is the sum of distances in the ellipse plain from the two focus points.");
        System.out.println("    -   new parallelogram color x1 y1 x2 y2 x3 y3");
        System.out.println("            >>> Creates new parallelogram with the given 3 vertices.");
        System.out.println("            >>> vertex1 and vertex3 must be opposing.");
        System.out.println("    -   new rectangle color x1 y1 x2 y2");
        System.out.println("            >>> Creates new rectangle with the given 2 vertices .");
        System.out.println("            >>> vertex1 and vertex2 must be opposing.");
        System.out.println("    -   new square color x y length");
        System.out.println("            >>> Creates new square with center at (x,y) and side length.");
        System.out.println("    -   new triangle color x1 y1 x2 y2 x3 y3");
        System.out.println("            >>> Creates new triangle with the given 3 vertices.");
        System.out.println("            >>> vertex1 and vertex3 must be opposing.");
        //TODO add documentations
    }

    private static String getInput(Scanner scanner) {
        String userCommand = scanner.nextLine();
        return userCommand.toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Shape> shapesMap = new HashMap<>();
        String userCommand;
        String[] stdinParse;

        printRules();

        session: while (true) {
            userCommand = getInput(scanner);
            stdinParse = userCommand.split(" ");

            try {
                switch (stdinParse[0]) {
                    case "new":
                        setNewShape(stdinParse, shapesMap);
                        break;
                    case "delete":
                        delShape(stdinParse, shapesMap);
                        break;
                    case "move":
                        moveShape(stdinParse, shapesMap);
                        break;
                    case "copy":
                        copyShape(stdinParse, shapesMap);
                        break;
                    case "area":
                        calcColorArea(stdinParse, shapesMap);
                        break;
                    case "color":
                        changeColor(stdinParse, shapesMap);
                        break;
                    case "circumference":
                        calcColorCircumference(stdinParse, shapesMap);
                        break;
                    case "is_inside":
                        //TODO is_inside shape
                        break;
                    case "exit":
                        break session;
                    default:
                        System.out.println("Command not found.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument provided.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Missing argument/s.");
            }
        }

        scanner.close();
    }
}
