package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        for (int pass = 0; pass < arr.length; pass++) {
            // Calculate the correct index for the current element
            int correctIndex = arr[pass] - 1;
            // If the current element is not at its correct index, swap it
            if (arr[pass] != arr[correctIndex]) {
                swap(arr, pass, correctIndex);
                // Decrement pass to recheck the current index after swapping
                pass--;
            }
        }
    }

    private static void swap(int[] arr, int pass, int correctIndex) {
        int temp = arr[pass];
        arr[pass] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
