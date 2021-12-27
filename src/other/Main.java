package other;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Array array = new Array();
        array.insert(15);
        array.insert(20);
        array.insert(40);
        array.insert(14);
        int index = array.indexOf(15);
        System.out.println("The index of 15 is: " + index);
        int data = array.removeAt(1);
        System.out.println("Removed " + data + " at index 1");
        System.out.println("Has removed number 14 from the array: " + array.remove(14));
        System.out.println("The new array values are: " + Arrays.toString(array.arr));

        printArrays();
        test(new int[]{1, 2, 3}, new String[]{"google, meta, tesla, twitter"});
        greet(new String[]{"Olutoba, Damilola, Sarah"});

    }

    // Time -> O(1)
    // Space -> O(1)
    private static void printArrays() {
        int[] numbers = {10, 20, 30};
        System.out.println(Arrays.toString(numbers));
    }

    public static void test(int[] numbers, String[] names) {
        System.out.println(numbers[0]);
        for (int number : numbers) {    // O(n)
            System.out.print(number + " ");
        }
        System.out.println();

        for (String name : names) { // O(n)
            System.out.println(name);
        }

        // O(n^2)
        for (int first : numbers) {
            for (int second : numbers) {
                System.out.println(first + ", " + second);
            }
        }

    }

    // Time -> O(n)
    // Space -> O(1)
    public static void greet(String[] names) {
        for (int i = 0; i < names.length; i++) {
            System.out.println("Hi " + names[i]);
        }
    }

    // An implementation of a custom dynamic integer array
    static class Array {
        int[] arr;
        int index = 0;
        // The actual array size
        int capacity;

        public Array() {
            this(3);
        }

        public Array(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
        }

        // Time -> O(n)
        // Space -> O(n)
        public void insert(int item) {
            // check if we need to resize the array
            if (index + 1 >= capacity) {
                if (capacity == 0) capacity = 1;
                else capacity *= 2; // double the size
                int[] new_arr = new int[capacity];
                for (int i = 0; i < index; i++) {
                    new_arr[i] = arr[i];
                }
                arr = new_arr; // may have extra nulls
            }
            arr[index++] = item;
            System.out.println(Arrays.toString(arr));
        }

        // Time -> O(n)
        // Space -> O(n)
        public boolean remove(int item) {
            int rm_index = indexOf(item);
            if (rm_index == -1) return false;
            removeAt(rm_index);
            return true;
        }

        // Time -> O(n)
        // Space -> O(n)
        public int removeAt(int rm_index) {
            if (rm_index < 0 || rm_index > capacity) throw new IndexOutOfBoundsException();
            int data = arr[rm_index];
            int[] new_arr = new int[arr.length - 1];
            for (int i = 0, j = 0; i < arr.length; i++, j++) {
                new_arr[j] = arr[i];
                if (i == rm_index) j--;
                else new_arr[j] = arr[i];
            }
            arr = new_arr;
            return data;
        }

        // Time -> O(n)
        // Space -> O(1)
        public int indexOf(int item) {
            for (int i = 0; i < arr.length; i++) {
                if (item == arr[i]) return i;
            }
            return -1;
        }

    }
}
