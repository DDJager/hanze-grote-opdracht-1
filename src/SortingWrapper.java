import java.util.HashMap;
import java.util.List;

public class SortingWrapper {

    // This field stores all the Sortable objects into a HashMap
    private HashMap<String, Sortable> sortingAlgorithms;

    /**
     * Default contstructor
     */
    public SortingWrapper() {
        sortingAlgorithms = new HashMap<String, Sortable>();
    }

    /**
     * Alternative constructor
     *
     * @param map a HashMap
     */
    public SortingWrapper(HashMap<String, Sortable> map) {
        sortingAlgorithms = map;
    }

    /**
     * Add a Sortable object to the sortingAlgorithms field
     *
     * @param key A name for the
     * @param value A sorting object from the Sortable interface
     */
    public void addNewSortingAlgorithm(String key, Sortable value) {
        sortingAlgorithms.put(key, value);
    }


    /**
     * Perform a sorting algorithm on a dataset using the algorithm of the given key. If it exists
     *
     * @param key the key
     * @param dataSet the dataset
     */
    public void performSort(String key, List dataSet) {
        try {
            Sortable sortableObject = sortingAlgorithms.get(key);
            sortableObject.sort(dataSet);
        } catch (NullPointerException e) {
            System.out.println("Deze sorteer algorithme bestaat niet!");
        }
    }


}
