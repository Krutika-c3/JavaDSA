package com.gfg.dsa.practice.sortingAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Problem: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
    Description:
    - Given an array with elements from 1 to n, where n is the length of the array.
    - The array may contain duplicate elements.
    - Find and return all duplicate elements.

    Approach:
    - Sort the array using cyclic sort algorithm.
    - Find all elements that are not at their correct index.
 */

public class LeetCodeFindAllDuplicates {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        List<Integer> duplicateElements = findAllDuplicateElements(arr);
        System.out.println(Arrays.toString(arr) + " has elements " + duplicateElements + " missing");
    }

    private static List<Integer> findAllDuplicateElements(int[] arr) {
        List<Integer> missingElements = new ArrayList<>();
        for (int elenent = 0; elenent < arr.length; elenent++) {
            // If the current element is not at its correct index, add it to the list of duplicate elements
            if (arr[elenent] != elenent + 1) {
                missingElements.add(arr[elenent]);
            }
        }
        return missingElements;
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
