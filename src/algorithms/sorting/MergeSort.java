package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000 + 1);
        }

        System.out.print("Before: ");
        System.out.print(Arrays.toString(nums));
        System.out.println();
        mergeSort(nums);
        System.out.print("Now: ");
        System.out.print(Arrays.toString(nums));
    }

    public static void mergeSort(int[] nums) {
        int len = nums.length;

        // Base case is when a single element (which is already sorted)
        if (len <= 1) return;

        int mid = len / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[len - mid];

        for (int i = 0; i < mid; i++) {
            leftArr[i] = nums[i];
        }
        for (int i = mid; i < len; i++) {
            rightArr[i - mid] = nums[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(nums, leftArr, rightArr);
    }

    public static void merge(int[] nums, int[] leftHalf, int[] rightHalf) {
        int i = 0, j = 0, k = 0;
        while (i < leftHalf.length && j < rightHalf.length) {
            if (leftHalf[i] <= rightHalf[j]) {
                nums[k++] = leftHalf[i++];
            } else {
                nums[k++] = rightHalf[j++];
            }
        }

        while (i < leftHalf.length) {
            nums[k++] = leftHalf[i++];
        }

        while (j < rightHalf.length) {
            nums[k++] = rightHalf[j++];
        }

    }
}
