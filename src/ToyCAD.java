import java.util.Scanner;
import java.util.HashMap;

public class ToyCAD {

    private static void setNewShape(String[] stdinArgs, HashMap<Integer, Shape> shapesMap) {
        Shape newShape = null;
        String shapeType = stdinArgs[1];
        String shapeColor = stdinArgs[2];

        switch (shapeType) {
            case "circle":
                double radius = Double.parseDouble(stdinArgs[5]);
                newShape = new Circle(shapeColor, radius);
        }

        if (newShape != null) {
            shapesMap.put(newShape.getID(), newShape);
            System.out.println("Shape ID: " + newShape.getID());
        }
    }

    private static String getInput(Scanner scanner) {
        String userCommand = scanner.nextLine();
        return userCommand.toLowerCase();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Shape> shapesMap = new HashMap<Integer, Shape>();
        String userCommand;
        String[] stdinParse;

        session: while (true) {
            userCommand = getInput(scanner);
            stdinParse = userCommand.split(" ");

            switch (stdinParse[0]) {
                case "new":
                    setNewShape(stdinParse, shapesMap);
                    break;
                case "delete":
                    //delete shape
                    break;
                case "move":
                    //move shape
                    break;
                case "copy":
                    //copy shape
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
        }

        scanner.close();
    }
}
