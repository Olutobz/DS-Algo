package datastructures.dynamicarray;

/**
 * A generic dynamic array implementation
 *
 * @author Olutoba Onikoyi
 * @since 02/11/2021
 */

public class DynamicArray<T> {

    // The initial static array container
    private T[] arr;
    // The length of the static array user thinks
    private int len;
    // The actual array size
    private int capacity = 0;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
    }

    public DynamicArray() {
        this(16);
    }
}
