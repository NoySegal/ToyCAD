import java.util.Scanner;
import java.util.HashMap;

public class ToyCAD {

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
            thisShape.moveShape(Double.parseDouble(stdinArgs[2]), Double.parseDouble(stdinArgs[3]));
        }
    }

    private static void copyShape(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        Shape originalShape = shapesMap.get(Integer.parseInt(stdinArgs[1]));
        validateDoubleFormat(stdinArgs);
        if (originalShape == null) {
            System.out.println("Shape ID not found.");
        } else {
            Shape copiedShape = originalShape.copyShape();

            shapesMap.put(copiedShape.getID(), copiedShape);
            stdinArgs[1] = String.valueOf(copiedShape.getID());
            moveShape(stdinArgs, shapesMap);

            System.out.println("Shape ID: " + copiedShape.getID());
        }
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
                        //area shape
                        break;
                    case "color":
                        //color shape
                        break;
                    case "circumference":
                        //circumference shape
                        break;
                    case "is_inside":
                        //is_inside shape
                        break;
                    case "exit":
                        //exit shape
                        break session;
                    default:
                        System.out.println("Command not found.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument provided.");
            }
        }

        scanner.close();
    }
}
