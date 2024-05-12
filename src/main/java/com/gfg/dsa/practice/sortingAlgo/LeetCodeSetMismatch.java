package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/set-mismatch/description/
    Description:
    - Given an array with numbers from 1 to n.
    - One number is duplicated, resulting in a missing number.
    - Find the duplicated number and the missing number.

    Approach:
    - Iterate through the array.
    - For each element, check if it's at its correct index (index + 1).
    - If not, return the duplicate number (current element) and the missing number (index + 1).
 */

public class LeetCodeSetMismatch {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 2, 6, 5};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        int[] duplicateAndMissingElements = findDuplicateAndMissingElements(arr);
        System.out.println(Arrays.toString(arr)
                            + " has duplicate element: "
                            + duplicateAndMissingElements[0]
                            + " and missing element: "
                            + duplicateAndMissingElements[1]);
    }

    private static int[] findDuplicateAndMissingElements(int[] arr) {
        for (int element = 0; element < arr.length; element++) {
            // If the current element is not at its correct index
            if( arr[element] != element + 1) {
                // Return the duplicate element (current element) and the missing element (index + 1)
                return new int[] {arr[element], element + 1};
            }
        }
        // If no duplicate or missing element is found, return [-1, -1]
        return new int[] {-1, -1};
    }

    private static void sortArray(int[] arr) {
        for (int pass = 0; pass < arr.length; pass++) {
            // Calculate the correct index for the current element
            int correctIndex = arr[pass] - 1;
            // If the current element is not at its correct index, swap it
            if(arr[pass] != arr[correctIndex]) {
                swap(arr, pass, correctIndex);
                // Decrement pass to recheck the current index after swapping
                pass--;
            }
        }
    }

    private static void swap(int[] arr, int pass, int correctIndex){
        int temp = arr[correctIndex];
        arr[correctIndex] = arr[pass];
        arr[pass] = temp;
    }
}
