package other;

public class Main {

    public static void main(String[] args) {
        test(new int[]{1, 2, 3}, new String[]{"google, meta, amazon, twitter, Delivery Hero"});
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
}
