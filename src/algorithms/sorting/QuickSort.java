package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];

        System.out.print("Before: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        System.out.print(Arrays.toString(nums));
        System.out.println();

        System.out.print("After: ");
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    // TC -> O(n^2), SC -> O(n)
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        int pivot = arr[highIndex];
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (arr[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(arr, leftPointer, rightPointer);
        }

        if (arr[leftPointer] > pivot) {
            swap(arr, leftPointer, highIndex);
        } else leftPointer = highIndex;

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
