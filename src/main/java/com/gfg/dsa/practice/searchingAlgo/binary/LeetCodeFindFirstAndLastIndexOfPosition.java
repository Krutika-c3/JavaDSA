package com.gfg.dsa.practice.searchingAlgo.binary;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    Description:
    - The problem requires finding the first and last occurrences of a target element in a sorted array.
    - Since the array is sorted and the requirement is to achieve logarithmic time complexity, binary search is a suitable approach.
 */

public class LeetCodeFindFirstAndLastIndexOfPosition {

    public static void main(String[] args) {
        int[] array = {1, 23, 34, 45, 63, 72, 72, 75, 81};
        int target = 90;
        int[] result = searchFirstAndLastIndex(array, target);
        System.out.printf("In array=%s, target=%s is at index=%s", Arrays.toString(array), target, Arrays.toString(result));
    }

    static int[] searchFirstAndLastIndex(int[] array, int target) {
        int[] results = {-1, -1};
        results[0] = search(array, target, true); // Find the first occurrence of the target
        if (results[0] != -1) { // If the first occurrence is found
            results[1] = search(array, target, false); // Find the last occurrence of the target
        }
        return results;
    }

    static int search(int[] array, int target, boolean isFirstStartIndex) {
        int start = 0;
        int end = array.length - 1;

        int result = -1; // Initialize result variable to -1

        // Binary search loop
        while (start <= end) {
            int middle = start - (start - end) / 2; // Calculate mid index avoiding integer overflow

            if (target < array[middle]) {
                end = middle - 1; // Update end to search in the left subarray
            } else if (target > array[middle]) {
                start = middle + 1; // Update start to search in the right subarray
            } else { // If target is found
                result = middle; // Store the index
                if (isFirstStartIndex) { // If searching for the first occurrence
                    end = middle - 1; // Update end to search for earlier occurrences
                } else { // If searching for the last occurrence
                    start = middle + 1; // Update start to search for later occurrences
                }
            }
        }
        // Return the potential answer
        return result;
    }
}