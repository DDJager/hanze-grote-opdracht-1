import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;
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

        // Generate a random ArrayList
        ArrayList<Integer> list = generateArrayList(6, 3);

        // Perform the sorting algorithm
        sw.performSort("mergesort", list);
        
    }

    @Override
    public void start(Stage primaryStage) {

    }

    /**
     * Generate an ArrayList with random values, based on the number of values and max value
     *
     * @param numOfValues number of values (example: 5 values in the ArrayList)
     * @param maxValue maximum value (example: values can't be higher than 10)
     * @return
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
