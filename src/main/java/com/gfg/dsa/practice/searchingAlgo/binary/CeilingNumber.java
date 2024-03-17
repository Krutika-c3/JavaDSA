package com.gfg.dsa.practice.searchingAlgo.binary;

import java.util.Arrays;

public class CeilingNumber {

    // Ceiling number: smallest number greater than or equal to the target

    public static void main(String[] args) {
        int[] array = {1, 23, 34, 45, 63, 72, 81};
        int target = 35;
        System.out.printf("In array=%s, ceiling number of target=%s is at index=%s", Arrays.toString(array), target, findCeiling(array, target));
    }

    private static int findCeiling(int[] array, int target) {
        // Check if the target is greater than the maximum number in the array
        if (target > array[array.length - 1]) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            // Calculate mid index avoiding integer overflow
            int mid = start + (end - start) / 2;

            if (target < array[mid]) {
                end = mid - 1; // Update end to search in the left subarray
            } else if (target > array[mid]) {
                start = mid + 1; // Update start to search in the right subarray
            } else {  // If target is equal to the element at mid
                return mid; // If target is found, return the index
            }
        }
        // If target is not found, return start which holds the ceiling index
        return start;
    }
}