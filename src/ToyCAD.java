import java.util.Scanner;
import java.util.HashMap;

public class ToyCAD {

    private static String getInput(Scanner scanner) {
        String userCommand = scanner.nextLine();
        return userCommand.toLowerCase();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Shape> shapesMap = new HashMap<Integer, Shape>();
        String userCommand;
        String[] commandArgs;

        session: while (true) {
            userCommand = getInput(scanner);
            commandArgs = userCommand.split(" ");

            switch (commandArgs[0]) {
                case "new":
                    //create new shape
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
    }
}
