package datastructures.dynamicarray;

import java.util.Arrays;

/**
 * An Integer array implementation
 *
 * @author Damola Olutoba Onikoyi, damexxey94@gmail.com
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

    public static void main(String[] args) {
        IntArray intArray = new IntArray(50);
        intArray.add(5);
        intArray.add(14);
        intArray.add(-2);
        intArray.add(75);
        intArray.add(121);
        intArray.add(12);

        intArray.sort(); // [-2,5,12,14,75,121]
        System.out.println("Does the array have empty contents?: " + intArray.isEmpty());

        for (int i = 0; i < intArray.size(); i++) {
            System.out.print(intArray.get(i) + " ");
        }
        System.out.println();
        intArray.reverse();
        for (int i = 0; i < intArray.size(); i++) {
            System.out.print(intArray.get(i) + " ");
        }
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

    // search and remove an element if it is found in the array
    // it takes O(n) time
    public boolean remove(int elem) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == elem) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private void removeAt(int rm_index) {
        System.arraycopy(arr, rm_index + 1, arr, rm_index, len - rm_index - 1);
        --len;
        --capacity;
    }

    // Reverse the contents of the array
    public void reverse() {
        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }

    }

    public void sort() {
        Arrays.sort(arr, 0, len);
    }

}
