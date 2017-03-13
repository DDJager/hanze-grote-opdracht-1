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

}
