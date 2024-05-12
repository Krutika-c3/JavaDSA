package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/find-the-duplicate-number/description/
    Description:
    - Given an array with elements from 1 to n, where n is the length of the array.
    - The array contain 1 duplicate element.
    - The task is to find and return the duplicate element.

    Approach:
    - Iterate through the array.
    - For each element, check if it is at its correct index.
    - If not, swap the element with the one at its correct index until it's at its correct position.
    - If the element at the correct index is already the same as the current element, return it as the duplicate.
    - If no duplicate is found, return -1.

    Note: This approach modifies the original array.
 */

public class LeetCodeFindDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        System.out.println(Arrays.toString(arr));
        int duplicateElement = findDuplicateElement(arr);
        System.out.println(Arrays.toString(arr) + " has element " + duplicateElement + " as duplicate element.");
    }

    private static int findDuplicateElement(int[] arr) {
        for (int element = 0; element < arr.length; element++) {
            // Check if the current element is not at its correct index
            if (arr[element] != element + 1) {
                int correctIndex = arr[element] - 1;
                // If the element at the correct index is not the same as the current element, swap them
                if (arr[element] != arr[correctIndex]) {
                    swap(arr, element, correctIndex);
                    // Decrement the loop variable to recheck the current index after swapping
                    element--;
                } else {
                    // If the element at the correct index is the same as the current element, return it as the duplicate
                    return arr[element];
                }
            }
        }
        // If no duplicate is found, return -1
        return -1;
    }

    private static void swap(int[] arr, int pass, int correctIndex) {
        int temp = arr[pass];
        arr[pass] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

}
