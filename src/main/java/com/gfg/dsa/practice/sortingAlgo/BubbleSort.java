package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        for (int pass = 0; pass <= arr.length - 1; pass++) {
            boolean isSwapped = false;
            for (int element = 1; element <= arr.length - pass - 1; element++) {
                if (arr[element - 1] > arr[element]) {
                    int temp = arr[element];
                    arr[element] = arr[element - 1];
                    arr[element - 1] = temp;
                    isSwapped = true;
                }
            }
            // If the array is never swapped, it means the array is sorted, and the program can be stopped
            if (!isSwapped) {
                break;
            }
        }
    }
}
