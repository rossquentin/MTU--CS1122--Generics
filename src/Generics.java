import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Generics<E extends Comparable<E>> implements Comparable<Generics<E>> {
    E first;
    E second;

    /**
     * Constructor of Generics that sets the first and second
     * instance variables to their respective values.
     *
     * @param first The first value
     * @param second    The second value.
     */

    public Generics(E first, E second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Allows functionality of the compareTo method between two objects
     * of generic type E.
     *
     * @param o The object to compare to.
     * @return  An integer value
     */

    public int compareTo(Generics<E> o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (o instanceof Generics) {
            if (this.getFirst() != o.getFirst()) {
                return this.getFirst().compareTo(o.getFirst());
            }
            return 0;
        }
        throw new ClassCastException();
    }

    /**
     * Gets the first value from the Generics class
     *
     * @return  the first value
     */

    public E getFirst() {
        return first;
    }

    /**
     * Gets the second value from the Generics class
     *
     * @return  the second value
     */

    public E getSecond() {
        return second;
    }

    /**
     * Overwrites index 1 of dataArr with data
     *
     * @param data  Data of Object type T to overwrite with
     * @param dataArr   Data Array of Object type T that is being overwritten
     * @param <T>   Generic data type used within the method
     * @return  dataArr with index 1 replaced with data
     */

    private static <T> T[] replaceIndexOne(T data, T[] dataArr) {
        if(dataArr.length < 2) {
            throw new IndexOutOfBoundsException("Array is not long enough");
        }
        dataArr[1] = data;
        return dataArr;
    }


    /**
     * Used for testing the compareTo and the replaceIndexOne methods
     */

    public static void main(String[] args) {

        Character[] arrayTData = {'r', 'e', 'p', 'l', 'a' , 'c', 'e', '1'};
        ArrayList<Comparable> compareToData = new ArrayList<>();
        Generics gen = new Generics(4.6031, 1.07543);

        compareToData.add(gen.getFirst());
        compareToData.add(gen.getSecond());

        System.out.println(compareToData);

        Collections.sort(compareToData);

        System.out.println(compareToData);

        System.out.println(Arrays.toString(arrayTData));

        arrayTData = replaceIndexOne('3', arrayTData);

        System.out.println(Arrays.toString(arrayTData));

    }
}
