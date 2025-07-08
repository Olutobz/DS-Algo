package other;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        CustomArray customArray = new CustomArray();
        customArray.insert(15);
        customArray.insert(20);
        customArray.insert(40);
        customArray.insert(14);
        customArray.insert(85);
        int index = customArray.indexOf(15);
        System.out.println("The index of 15 is: " + index);
        int data = customArray.removeAt(4);
        System.out.println("Removed " + data + " at index 4");
        System.out.println("The new array values are: " + Arrays.toString(customArray.arr));
        System.out.println("Has removed number 14 from the array?: " + customArray.remove(14));
        System.out.println("The new array values are: " + Arrays.toString(customArray.arr));

        printNumbers();
        test(new int[]{1, 2, 3}, new String[]{"google, meta, tesla, twitter"});
        greet(new String[]{"Onikoyi, Damola, Olutoba"});

    }

    private static void printNumbers() {
        int[] numbers = {10, 20, 30};
        System.out.println(Arrays.toString(numbers));
    }

    public static void test(int[] numbers, String[] names) {
        System.out.println(numbers[0]);
        System.out.print("Numbers are: ");
        for (int number : numbers) {
            System.out.print(number + ", ");
        }

        System.out.println();

        System.out.print("Names are: ");
        for (String name : names) {
            System.out.print(name + ", ");
        }

        System.out.println();
        for (int first : numbers) {
            for (int second : numbers) {
                System.out.println(first + ", " + second);
            }
        }

    }

    public static void greet(String[] names) {
        for (String name : names) {
            System.out.println("Hi " + name);
        }
    }

    static class CustomArray {
        private int[] arr;
        private int counter = 0;
        // The actual array size
        private int capacity;

        public CustomArray() {
            this(3);
        }

        public CustomArray(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
        }

        // TC -> O(n), SC -> O(n)
        public void insert(int item) {
            if (counter + 1 >= capacity) {
                if (capacity == 0) capacity = 1;
                else capacity *= 2;
                int[] new_arr = new int[capacity];
                if (counter >= 0) {
                    System.arraycopy(arr, 0, new_arr, 0, counter);
                }
                arr = new_arr; // may have extra nulls
            }
            arr[counter++] = item;
            System.out.println(Arrays.toString(arr));
        }

        // TC -> O(n), SC -> O(n)
        public boolean remove(int item) {
            int rm_index = indexOf(item);
            if (rm_index == -1) return false;
            removeAt(rm_index);
            return true;
        }

        // TC -> O(n), SC -> O(n)
        public int removeAt(int rm_index) {
            if (rm_index < 0 || rm_index > counter) {
                throw new IndexOutOfBoundsException();
            }

            int data = arr[rm_index];
            int[] new_arr = new int[arr.length - 1];
            for (int i = 0, j = 0; i < arr.length; i++, j++) {
                if (i == rm_index) j--;
                else new_arr[j] = arr[i];
            }

            arr = new_arr;
            return data;
        }

        // TC -> O(n), SC -> O(1)
        public int indexOf(int item) {
            for (int i = 0; i < counter; i++) {
                if (item == arr[i]) return i;
            }
            return -1;
        }

    }
}
