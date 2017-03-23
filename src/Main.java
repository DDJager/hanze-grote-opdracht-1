import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    public static void main(String[] args) {

        // Launch the JavaFX window
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        // Instantiate a SortingWrapper
        SortingWrapper sw = new SortingWrapper();

        // Add new sorting algorithms
        sw.addNewSortingAlgorithm("quicksort", new QuickSort());
        sw.addNewSortingAlgorithm("bubblesort", new BubbleSort());
        sw.addNewSortingAlgorithm("insertionsort", new InsertionSort());
        sw.addNewSortingAlgorithm("mergesort", new MergeSort());

        // Generate a random array or ArrayList
        int[] list = generateArray(60, 10);

        // Create a root pane (VBox) and two sub-panes (GridPane and FlowPane)
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20); // Set a horizontal gap between the nodes
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setPadding(new Insets(20, 0, 0, 0));

        // Paint the GUI
        paintGUI(list, gridPane);

        // Add a button
        Button button = new Button("Sort step");
        button.setOnAction(e -> {
            // Clear the current GUI and perform the sorting, then repaint the GUI.
            gridPane.getChildren().clear();

            // Unlock one of these methods to perform a sorting algorithm
            //sw.performSort("insertionsort", list, true);
            sw.performSort("bubblesort", list, true);
            //sw.performSort("quicksort", list, false);

            paintGUI(list, gridPane);
        });
        flowPane.getChildren().add(button);

        // Add the pane to the scene and set the primaryStage
        pane.getChildren().addAll(gridPane, flowPane);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Generate an array with random values, based on the number of values and max value
     *
     * @param numOfValues
     * @param maxValue
     * @return int[]
     */
    public static int[] generateArray(int numOfValues, int maxValue) {
        int[] list = new int[numOfValues];

        for (int i = 0; i < numOfValues; i++) {
            int r = new Random().nextInt(maxValue);
            list[i] = r;
        }

        return list;
    }

    /**
     * Generate an ArrayList with random values, based on the number of values and max value
     *
     * @param numOfValues number of values (example: 5 values in the ArrayList)
     * @param maxValue maximum value (example: values can't be higher than 10)
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> generateArrayList(int numOfValues, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numOfValues; i++) {
            int r = new Random().nextInt(maxValue);
            list.add(r);
        }

        return list;
    }

    /**
     * This method paints the GUI. It adds new lines to the GridPane based on the
     * length of the array.
     *
     * @param list
     * @param gridPane
     */
    public static void paintGUI(int[] list, GridPane gridPane) {
        for (int i = 0; i < list.length; i++) {
            int calculatedHeight = ( (list[i] * 10) == 0 ) ? 10 : (list[i] * 10);
            Line line = new Line(10, calculatedHeight, 10, 10);
            line.setStrokeWidth(10);
            gridPane.add(line, i, 0);
            gridPane.add(new Text(String.valueOf(list[i])), i, 1);
        }
    }


}
