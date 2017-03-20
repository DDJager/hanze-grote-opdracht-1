import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Sortable {

    // This field is used for the sortOneStep method
    // If the method performs one single step, it will save
    // the current increment in this variable for the next step
    private static int stepCounter = 1;

    /**
     * QuickSort with a List dataset
     *
     * @param dataSet The dataset
     */
    public ArrayList<Integer> sort(List<Integer> dataSet) {
        System.out.println("Quick sorting!");
        return new ArrayList<Integer>();
    }

    /**
     * QuickSort with a standard array dataset
     *
     * @param dataSet The dataset
     */
    public void sort(int[] dataSet) {
        quickSort(dataSet, 0, dataSet.length - 1);
    }

    public void sortOneStep(int[] dataSet) {

    }

    public void reset() {
        stepCounter = 1;
    }

    private void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    private int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }

}
