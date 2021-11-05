package datastructures.dynamicarray;

import java.util.Iterator;

/**
 * A generic dynamic array implementation
 *
 * @author Olutoba Onikoyi, damexxey94@gmail.com
 * @since 02/11/2021
 */

public class DynamicArray<T> {

    private T[] arr;

    // The original size before expansion
    private int len = 0;

    // The actual array size
    private int capacity;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    /**
     * This returns the length of the array
     */
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
            else capacity *= 2; // double the size
            T[] new_arr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                new_arr[i] = arr[i];
            }
            // arrays may have extra nulls padded
            arr = new_arr;
        }
        arr[len++] = elem;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) return false;
        removeAt(index);
        return true;
    }

    // Removes an element at the specified index in this array.
    public T removeAt(int rm_index) {
        if (rm_index < 0 || rm_index >= len) throw new IndexOutOfBoundsException();
        T data = arr[rm_index];
        T[] new_arr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            // skips over rm_index
            if (i == rm_index) j--;
            else new_arr[j] = arr[i];
        }
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (obj == null) {
                if (arr[i] == null) return i;
            } else {
                if (obj.equals(arr[i])) return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;

    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len; i++) {
                sb.append(arr[i]).append(", ");
            }
            return sb.append("]").toString();
        }
    }
}
