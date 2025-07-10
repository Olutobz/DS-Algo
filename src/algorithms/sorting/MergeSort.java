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

    // TC -> O(NLogN), SC -> O(N)
    public static void mergeSort(int[] nums) {
        if (nums.length <= 1) return;

        int mid = nums.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[nums.length - mid];

        System.arraycopy(nums, 0, leftArr, 0, mid);
        System.arraycopy(nums, mid, rightArr, 0, nums.length - mid);

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(nums, leftArr, rightArr);
    }

    public static void merge(int[] nums, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }

        while (i < leftArr.length) {
            nums[k++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            nums[k++] = rightArr[j++];
        }
    }
}
