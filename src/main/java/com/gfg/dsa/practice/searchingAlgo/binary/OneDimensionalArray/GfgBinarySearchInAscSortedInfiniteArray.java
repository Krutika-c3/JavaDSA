package com.gfg.dsa.practice.searchingAlgo.binary.OneDimensionalArray;

import java.util.Arrays;

/*
    Problem: https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
    Description:
    This problem deals with finding the position of an element in a sorted array with infinite numbers.
    As the array is infinite, we cannot use the length of the array, and the time complexity required is O(log n).
 */
public class GfgBinarySearchInAscSortedInfiniteArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 8, 10, 14, 19, 23, 34, 45, 63, 72, 81};
        int target = 2;
        System.out.printf("In array=%s, target=%s is at index=%s", Arrays.toString(array), target, getTargetIndex(array, target));
    }

    // Function to find the index of the target in the sorted array with infinite numbers
    private static int getTargetIndex(int[] array, int target) {
        int start = 0;
        int end = 1;

        // Condition for the target to lie in the range

        while (target > array[end]) {
            int temp = end + 1; // Store the new start index
            // Double the size of the range box
            // end = previous end + size of box * 2
            end = end + (end - start + 1) * 2;
            start = temp;  // Update start to the new start index
        }
        // Perform binary search within the found range
        return search(array, target, start, end);
    }

    private static int search(int[] array, int target, int start, int end) {
        int middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (target < array[middle]) {
                end = middle - 1; // Update end to search in the left subarray
            } else if (target > array[middle]) {
                start = middle + 1; // Update start to search in the right subarray
            } else { // If target is found
                return middle; // Return the index of the target
            }
        }
        return -1; // Return -1 if target is not found
    }
}