import java.util.ArrayList;
import java.util.List;

public class InsertionSort implements Sortable {

    /**
     * InsertionSort with a List dataset
     *
     * @param dataSet The dataset
     */
    public ArrayList<Integer> sort(List<Integer> dataSet) {
        // @todo Work In Progress
        //for (int i = 1; i < dataSet.size(); i++) {
            //int currentElement = (int) dataSet.get(i);
            //int k;
            //System.out.println("i: " + currentElement);
            //for (k = i - 1; k >= 0 && dataSet.get(k) > currentElement; k--) {
                //System.out.println("K: " + dataSet.get(k));
                //System.out.println("inner for");
                //System.out.println(k);
                //dataSet.add(k+1, dataSet.get(k));
            //}

            // Insert the current element into list[k+1]
            //dataSet.add(k + 1, currentElement);
        //}

        // Cast the List to an ArrayList and return it
        //return (ArrayList<Integer>) dataSet;
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

}
