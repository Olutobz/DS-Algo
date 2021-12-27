package other;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        arrays();
        test(new int[]{1, 2, 3}, new String[]{"google, meta, amazon"});
        greet(new String[]{"Olutoba, Damilola, Sarah"});
    }

    private static void arrays() {
        int[] numbers = {10 , 20 , 30};
        System.out.println(Arrays.toString(numbers));
    }

    public static void test(int[] numbers, String[] names) {
        System.out.println(numbers[0]); // O(1)

        for (int number : numbers) {    // O(n)
            System.out.print(number + " ");
        }
        System.out.println(); // O(1)

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

    // O(1) space
    public static void greet(String[] names) {
        for (int i = 0; i < names.length; i++) {
            System.out.println("Hi " + names[i]);
        }
    }


}
