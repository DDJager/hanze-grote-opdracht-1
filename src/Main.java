import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main extends Application {

    public static void main(String[] args) {

        // Instantiate a SortingWrapper
        SortingWrapper sw = new SortingWrapper();

        // Add new sorting algorithms
        sw.addNewSortingAlgorithm("quicksort", new QuickSort());
        sw.addNewSortingAlgorithm("bubblesort", new BubbleSort());
        sw.addNewSortingAlgorithm("insertionsort", new InsertionSort());
        sw.addNewSortingAlgorithm("mergesort", new MergeSort());

        // Generate a random array or ArrayList
        int[] list = generateArray(6, 10);
        for (int v : list) {
            System.out.print(v + " ");
        }

        System.out.println();

        // Perform the sorting algorithm
        sw.performSort("insertionsort", list);
        for (int v : list) {
            System.out.print(v + " ");
        }

        // Launch the JavaFX window
        //launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        // Generate a random array or ArrayList
        ArrayList<Integer> list = generateArrayList(6, 3);
        System.out.println(list);

        // Create a FlowPane
        Pane pane = new FlowPane();

        // For every value in the ArrayList, create a new line
        for (int i = 0; i < list.size(); i++) {
            Line line = new Line(10, 10, 10, 10);
            line.setStrokeWidth(10);
            pane.getChildren().add(line);
            pane.getChildren().add(new Text(String.valueOf(list.get(i))));
        }


        // Add the pane to the scene and set the primaryStage
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


}
