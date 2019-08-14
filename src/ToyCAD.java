import java.util.Scanner;
import java.util.HashMap;

public class ToyCAD {
    public static HashMap<Integer, Shape> shapesMap;

    private static void setNewShape(String[] stdinArgs) {
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

    private static void delShape(String[] stdinArgs) {
        int deleteID = Integer.parseInt(stdinArgs[1]);
        shapesMap.remove(deleteID);
    }

    private static Point validateDoubleFormat(String[] stdinArgs) {
        double tempX = Double.parseDouble(stdinArgs[2]);
        double tempY = Double.parseDouble(stdinArgs[3]);
        return new Point(tempX, tempY);
    }

    private static void moveShape(String[] stdinArgs) {
        Shape thisShape = shapesMap.get(Integer.parseInt(stdinArgs[1]));
        if (thisShape == null) {
            System.out.println("Shape ID not found.");
        } else {
            thisShape.move(Double.parseDouble(stdinArgs[2]), Double.parseDouble(stdinArgs[3]));
        }
    }

    private static void copyShape(String[] stdinArgs) {
        Shape originalShape = shapesMap.get(Integer.parseInt(stdinArgs[1]));
        validateDoubleFormat(stdinArgs);
        if (originalShape == null) {
            System.out.println("Shape ID not found.");
        } else {
            Shape copiedShape = originalShape.copy();

            shapesMap.put(copiedShape.getID(), copiedShape);
            stdinArgs[1] = String.valueOf(copiedShape.getID());
            moveShape(stdinArgs);

            System.out.println("Shape ID: " + copiedShape.getID());
        }
    }

    private static void calcColorArea(String[] stdinArgs) {
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

    private static void changeColor(String[] stdinArgs) {
        Shape shape = shapesMap.get(Integer.parseInt(stdinArgs[2]));
        if (shape == null) {
            System.out.println("Shape ID not found.");
        } else {
            shape.setColor(stdinArgs[1]);
        }
    }

    private static void calcColorCircumference(String[] stdinArgs) {
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

    private static void isInsideShape(String[] stdinArgs) {
        Shape shape = shapesMap.get(Integer.parseInt(stdinArgs[1]));
        Point point = validateDoubleFormat(stdinArgs);

        if (shape == null) {
            System.out.println("Shape ID not found.");
        } else {

            if (shape.isInside(point)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    private static void printSketch(String[] stdinArgs) {
        Visual work = new Visual(Integer.parseInt(stdinArgs[1]), Integer.parseInt(stdinArgs[2]), shapesMap);
        work.sketch();
    }

    private static void printRules() {
        System.out.println("                \u001B[36mWelcome to ToyCAD\u001B[0m");
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
        System.out.println("    Delete shape:");
        System.out.println("    -   delete ID");
        System.out.println("            >>> Deletes shape with given #ID.");
        System.out.println("    Move shape:");
        System.out.println("    -   move ID offset_in_x offset_in_y");
        System.out.println("            >>> Moves shape with given #ID by the given offsets.");
        System.out.println("    Copy shape:");
        System.out.println("    -   copy ID offset_in_x offset_in_y");
        System.out.println("            >>> Copies shape with given #ID and moves it by the given offsets.");
        System.out.println("            >>> The Copy command keeps the original shape untouched.");
        System.out.println("    Calculate area by color:");
        System.out.println("    -   area color");
        System.out.println("            >>> Calculates area of all shapes with the specified color.");
        System.out.println("    Change shape color:");
        System.out.println("    -   color color_select ID");
        System.out.println("            >>> Changes shae color with the given ID to the specified color.");
        System.out.println("    Calculate circumference by color:");
        System.out.println("    -   circumference color");
        System.out.println("            >>> Calculates circumference of all shapes with the specified color.");
        System.out.println("    Determine if a point (x, y) is inside a given shape:");
        System.out.println("    -   is_inside ID x y");
        System.out.println("            >>> Determines if the given coordinate is within the shape with given ID.");
        System.out.println("    Print the sketch to the screen:");
        System.out.println("    -   print width height");
        System.out.println("            >>> Prints a visualisation to the screen.");
        System.out.println("            >>> width is the number of characters in a line.");
        System.out.println("            >>> height is the number of lines.");
        System.out.println("    Exit program:");
        System.out.println("    -   exit");
        System.out.println("            >>> Exits the program.");
    }

    private static String getInput(Scanner scanner) {
        String userCommand = scanner.nextLine();
        return userCommand.toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        shapesMap = new HashMap<>();
        String userCommand;
        String[] stdinParse;

        printRules();

        session: while (true) {
            userCommand = getInput(scanner);
            stdinParse = userCommand.split(" ");

            try {
                switch (stdinParse[0]) {
                    case "new":
                        setNewShape(stdinParse);
                        break;
                    case "delete":
                        delShape(stdinParse);
                        break;
                    case "move":
                        moveShape(stdinParse);
                        break;
                    case "copy":
                        copyShape(stdinParse);
                        break;
                    case "area":
                        calcColorArea(stdinParse);
                        break;
                    case "color":
                        changeColor(stdinParse);
                        break;
                    case "circumference":
                        calcColorCircumference(stdinParse);
                        break;
                    case "is_inside":
                        isInsideShape(stdinParse);
                        break;
                    case "print":
                        printSketch(stdinParse);
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
