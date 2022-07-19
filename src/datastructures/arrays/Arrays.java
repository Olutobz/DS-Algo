package datastructures.arrays;

public class Arrays {

    public boolean linearSearch(int[] arr, int length, int val) {
        // check for edge cases
        if (arr == null || length == 0) return false;

        for (int i = 0; i < length; i++) {
            if (arr[i] == val) {
                return true;
            }
        }

        return false;
    }
}
