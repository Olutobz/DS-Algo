package datastructures.dynamicarray;

/**
 * A generic dynamic array implementation
 *
 * @author Olutoba Onikoyi
 * @since 02/11/2021
 */

public class DynamicArray<T> {

    private T[] arr;
    // The length user think the array is
    private int len = 0;
    // The actual array size
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * This returns the value at this specific index
     */
    public T get(int index) {
        if (index < 0 || index >= len)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    /**
     * This put an element at a specific location
     */
    public void set(int index, T elem) {
        if (index < 0 || index >= len)
            throw new IndexOutOfBoundsException();
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < len; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {
        // Check if we need to resize
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                // arrays may have extra nulls padded
                new_arr[i] = arr[i];
            }
            arr = new_arr;
        }
        arr[len++] = elem;
    }


}
