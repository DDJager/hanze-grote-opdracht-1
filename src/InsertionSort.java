import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort implements Sortable {

    // This field is used for the sortOneStep method
    // If the method performs one single step, it will save
    // the current increment in this variable for the next step
    private static int stepCounter = 1;

    /**
     * InsertionSort with a List dataset
     *
     * @param dataSet The dataset
     */
    public ArrayList<Integer> sort(List<Integer> dataSet) {
        System.out.println("Insertion sorting!");
        return new ArrayList<>();
    }

    /**
     * InsertionSort with a standard array dataset
     *
     * @param dataSet The dataset
     */
    public void sort(int[] dataSet) {
        for (int i = 1; i < dataSet.length; i++) {
            int currentElement = dataSet[i];
            int k;
            for (k = i - 1; k >= 0 && dataSet[k] > currentElement; k--) {
                dataSet[k + 1] = dataSet[k];
            }

            // Insert the current element into list[k+1]
            dataSet[k + 1] = currentElement;
        }
    }

    /**
     * InsertionSort doing one step of the algorithm with a standard array dataset
     *
     * @param dataSet
     */
    public void sortOneStep(int[] dataSet) {
        // Clone ONLY the contents of the dataSet array to a temporary array
        int[] temp = dataSet.clone();

        for (int i = stepCounter; i < dataSet.length; i++) {
            int currentElement = dataSet[i];
            int k;
            for (k = i - 1; k >= 0 && dataSet[k] > currentElement; k--) {
                dataSet[k + 1] = dataSet[k];
            }

            // Insert the current element into list[k+1]
            dataSet[k + 1] = currentElement;

            // If the contents of the dataSet has been changed (so that there is always one step performed),
            // only then increment the stepCounter +1 and stop the current step
            if (!Arrays.equals(temp, dataSet)) {
                stepCounter = (i + 1);
                break;
            }
        }
    }

    /**
     * Reset the static field this.stepCounter back to 1
     */
    public void reset() {
        stepCounter = 1;
    }

}
