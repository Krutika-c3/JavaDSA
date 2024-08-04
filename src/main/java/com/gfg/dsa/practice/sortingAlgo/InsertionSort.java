package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

/*
    Time Complexity:
        Worst Case: O(n^2) - desc sorted array
        Best Case: O(n) - array is already sorted
    Space Complexity:
        O(1) - constant time
    Stability:
        Yes, if two elements are equal, the algorithm typically does not change their relative order.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        for (int pass = 0; pass <= arr.length - 2; pass++) {
            for (int element = pass + 1; element > 0; element--) {
                // Compare current element with its previous element
                if (arr[element] < arr[element - 1]) {
                    // Swap elements if they are in the wrong order
                    swapArray(arr, element, element - 1);
                } else
                    break; // Break the loop if the elements are in the correct order
            }
        }
    }

    private static void swapArray(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}