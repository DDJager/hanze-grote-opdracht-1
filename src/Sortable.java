import java.util.ArrayList;
import java.util.List;

/**
 * This interface is used for the Strategy Pattern.
 * Every sorting algorithm must implement this interface
 */
public interface Sortable {


    /**
     * A sort() method for every Java Collection that implements the List interface
     *
     * @param dataSet The dataset
     */
    public ArrayList<Integer> sort(List<Integer> dataSet);

    /**
     * An alternative method, if you want to use standard arrays instead of Lists
     *
     * @param dataSet The dataset
     */
    public void sort(int[] dataSet);

    /**
     * If
     *
     * @param dataSet The dataset
     */
    public void sortOneStep(int[] dataSet);

    /**
     * Whenever you want to create a new array to be sorted and have used the sortOneStep method before,
     * this reset() method can be called to reset the static variables/fields
     */
    public void reset();

}
