package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/missing-number/
    Description:
    - Array from 0 to n
    - Total n+1 numbers
    - As numbers are starting from 0
        - Every element will be at index n
        - element's correct index will be the number itself
    - When the number is n, ignore it, as we will be having a missing number hence index n won't be present.

    Steps:
    - Sort array
    - Search which first number isn't at the position it should be, or see if n itself is present in the array
 */
public class LeetCodeMissingNumber {
    public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        int missingElement = findMissingElement(arr);
        System.out.println(Arrays.toString(arr) + " has element " + missingElement + " missing");
    }

    private static int findMissingElement(int[] arr) {
        for (int element = 0; element < arr.length; element++) {
            if (element != arr[element]) {
                return element;
            }
        }
        // If all elements are at their designated position that would mean that last element is missing thus return the last index
        return arr.length;
    }

    private static void sortArray(int[] arr) {
        for (int pass = 0; pass < arr.length ; pass++) {
            int correctIndex = arr[pass];
            if (correctIndex != arr.length && arr[pass] != arr[correctIndex]) {
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
