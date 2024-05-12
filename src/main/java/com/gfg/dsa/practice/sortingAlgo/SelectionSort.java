package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        for (int pass = 0; pass <= arr.length - 1; pass++) {
            // Find the maximum element in the remaining array and swap it with the last element
            int lastIndex = arr.length - pass - 1;
            int maxIndex = getMaxElementFromArray(arr, 0, lastIndex);
            swapArray(arr, maxIndex, lastIndex);
        }
    }

    private static int getMaxElementFromArray(int[] arr, int startIndex, int lastIndex) {
        int max = startIndex;
        for (int element = startIndex; element <= lastIndex; element++) {
            // Update max index if a greater element is found
            if (arr[element] > arr[max]) {
                max = element;
            }
        }
        return max;
    }

    private static void swapArray(int[] arr, int maxIndex, int lastIndex) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[lastIndex];
        arr[lastIndex] = temp;
    }
}