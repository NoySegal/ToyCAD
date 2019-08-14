import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Visual {
    private String[][] sketchBoard;
    private HashMap<Integer, Shape> shapesMap;
    private double frameWidthScaled;
    private double frameHeightScaled;
    private Point frameReference;
    private static final Map<String, String> colorMap;
    static {
        Map<String, String> colors = new HashMap<>();
        colors.put("red", "\u001B[41m \u001B[0m");
        colors.put("green", "\u001B[42m \u001B[0m");
        colors.put("blue", "\u001B[44m \u001B[0m");
        colors.put("yellow", "\u001B[43m \u001B[0m");
        colorMap = Collections.unmodifiableMap(colors);
    }

    public Visual(int xLength, int yLength, HashMap<Integer, Shape> shapesMap) {
        initBoard(xLength, yLength);
        this.shapesMap = shapesMap;
        scaleFrame(xLength, yLength);
    }

    private void initBoard(int xLength, int yLength) {
        this.sketchBoard = new String[yLength][xLength];
        for (int i = 0; i < sketchBoard.length; i++) {
            for (int j = 0; j < sketchBoard[0].length; j++) {
                this.sketchBoard[i][j] = " ";
            }
        }
    }

    private void scaleFrame(int xLength, int yLength) {
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();
        for (Integer key : shapesMap.keySet()) {
            for (Point point : shapesMap.get(key).getVertices()) {
                xValues.add(point.getX());
                yValues.add(point.getY());
            }
        }

        double minX = Collections.min(xValues);
        double maxX = Collections.max(xValues);
        double minY = Collections.min(yValues);
        double maxY = Collections.max(yValues);

        this.frameWidthScaled = (maxX - minX) / xLength;
        this.frameHeightScaled = (maxY - minY) / yLength;

        this.frameReference = new Point(minX, minY);
    }

    public void sketch() {
        for (Shape shape : shapesMap.values()) {
            fillBoard(shape);
        }

        displayBoard();
    }

    private void fillBoard(Shape shape) {
        for (int i = 0; i < sketchBoard.length; i++) {
            for (int j = 0; j < sketchBoard[0].length; j++) {

                double x = (j + 0.5) * frameWidthScaled + frameReference.getX();
                double y = (i + 0.5) * frameHeightScaled + frameReference.getY();

                if (shape.isInside(new Point(x, y))) {
                    this.sketchBoard[i][j] = colorMap.get(shape.getColor());
                    if (sketchBoard[i][j] == null) {
                        this.sketchBoard[i][j] = "X"; //non-valid color
                    }
                }
            }
        }
    }

    private void displayBoard() {
        for (int i = 0; i < sketchBoard.length; i++) {
            for (int j = 0; j < sketchBoard[0].length; j++) {
                System.out.print(this.sketchBoard[sketchBoard.length - i - 1][j]);
            }
            System.out.println();
        }
    }
}
