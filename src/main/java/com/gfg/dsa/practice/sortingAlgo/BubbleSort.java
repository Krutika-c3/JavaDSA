package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

/*
    Time complexity:
        Best: O(n) when array is already sorted
        Worst: O(n^2) when array is sorting in descending order
    Space complexity:
        O(1)
        No extra space required (like copying the array… AKA inplace sorting algorithm)
    Stability:
        Stability in sorting algorithms means that the relative order of equal elements remains unchanged after sorting.
        Yes, Bubble Sort is considered a stable sorting algorithm.
 */
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
