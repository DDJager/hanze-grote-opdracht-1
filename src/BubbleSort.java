import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort implements Sortable {

    // This field is used for the sortOneStep method
    // If the method performs one single step, it will save
    // the current increment in this variable for the next step
    private static int stepCounter = 1;

    /**
     * BubbleSort with a List dataset
     *
     * @param dataSet The dataset
     */
    public ArrayList<Integer> sort(List<Integer> dataSet) {
        System.out.println("Bubble sorting!");
        return new ArrayList<Integer>();
    }

    /**
     * BubbleSort with a standard array dataset
     *
     * @param dataSet The dataset
     */
    public void sort(int[] dataSet) {
        long start = System.currentTimeMillis();
        boolean needNextPass = true;

        for (int k = 1; k < dataSet.length && needNextPass; k++) {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < dataSet.length - k; i++) {
                if (dataSet[i] > dataSet[i + 1]) {
                    // Swap list[i] with list[i + 1]
                    int temp = dataSet[i];
                    dataSet[i] = dataSet[i + 1];
                    dataSet[i + 1] = temp;

                    needNextPass = true; // Next pass still needed
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public void sortOneStep(int[] dataSet) {
        // Clone ONLY the contents of the dataSet array to a temporary array
        int[] outerTemp = dataSet.clone();

        boolean needNextPass = true;

        for (int k = 1; k < dataSet.length && needNextPass; k++) {
            // Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < dataSet.length - k; i++) {
                if (dataSet[i] > dataSet[i + 1]) {
                    // Swap list[i] with list[i + 1]
                    int temp = dataSet[i];
                    dataSet[i] = dataSet[i + 1];
                    dataSet[i + 1] = temp;

                    needNextPass = true; // Next pass still needed
                }
            }
            // If the contents of the dataSet has been changed (so that there is always one step performed),
            // only then increment the stepCounter +1 and stop the current step
            if (!Arrays.equals(outerTemp, dataSet)) {
                stepCounter = (k + 1);
                break;
            }
        }
    }

    public void reset() {
        stepCounter = 1;
    }

}
