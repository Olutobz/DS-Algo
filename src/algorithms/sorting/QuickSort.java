package algorithms.sorting;

public class QuickSort {

    // TC -> O(N^2), SC -> O(LogN)
    public static void quicksort(int[] arr, int low, int high) {
        if (low <= 1) return;

        int pivot = arr[high];
        int leftPointer = low;
        int rightPointer = high;
        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer] > pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }
        swap(arr, leftPointer, high);
        quicksort(arr, low, leftPointer - 1);
        quicksort(arr, leftPointer + 1, high);

    }

    private static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[left] = temp;
    }
}
