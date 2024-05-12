package com.gfg.dsa.practice.sortingAlgo;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/first-missing-positive/
    Description:
    - Given an array of integers, find the smallest positive integer that does not exist in the array.
    - Apply cyclic sort starting from 1 to find the missing positive integer.

    Approach:
    - Sort the array using cyclic sort.
    - Check for elements at incorrect positions.
    - If none found, the missing positive integer is n+1.

    Note:
    - Ignore negative numbers.
    - Start checking from 1 and check if 1, 2, ..., n is present in the array or not.
 */
public class LeetCodeFirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        int missingElement = findMissingElement(arr);
        System.out.println(Arrays.toString(arr) + " has positive element " + missingElement + " missing");
    }

    private static int findMissingElement(int[] arr) {
        for (int element = 0; element < arr.length; element++) {
            // If the current element is not equal to its expected positive value
            if(arr[element] != element + 1){
                // Return the smallest missing positive integer
                return element + 1;
            }
        }
        // If all positive integers from 1 to n are present, return n+1
        return arr.length + 1;
    }

    private static void sortArray(int[] arr) {
        for (int element = 0; element < arr.length; element++) {
            int correctIndex = arr[element] - 1;
            // If the current element is positive and within the array bounds and not in its correct position
            if (arr[element] > 0 && arr[element] <= arr.length && arr[element] != arr[correctIndex]) {
                swap(arr, element, correctIndex);
                // Decrement element to recheck the current index after swapping
                element--;
            }
        }
    }

    private static void swap(int[] arr, int element, int correctIndex){
        int temp = arr[element];
        arr[element] = arr[correctIndex];
        arr[correctIndex] = temp;
    }
}
