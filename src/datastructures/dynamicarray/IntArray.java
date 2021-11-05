package datastructures.dynamicarray;

import java.util.Arrays;

/**
 * A generic dynamic array implementation
 *
 * @author Olutoba Onikoyi, damexxey94@gmail.com
 * @since 05/11/2021
 */
public class IntArray {

    // 1 * (2^3) = 8 -> 00001000 in binary form
    private static final int DEFAULT_SIZE = 1 << 3;

    public int[] arr;
    public int len = 0;
    public int capacity;

    // Initialize the array with a default capacity
    public IntArray() {
        this(DEFAULT_SIZE);
    }

    // Initialize the array with specified capacity
    public IntArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity : " + capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    // Given an array, turn it to a dynamic array
    public IntArray(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException("Array cannot be null");
        arr = Arrays.copyOf(arr, arr.length);
        capacity = len = arr.length;
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int get(int index) {
        if (index < 0 || index >= len)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    public void set(int index, int elem) {
        if (index < 0 || index >= len)
            throw new IndexOutOfBoundsException();
        arr[index] = elem;
    }

    public void add(int elem) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2; // double array size
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[len++] = elem;
    }

}
