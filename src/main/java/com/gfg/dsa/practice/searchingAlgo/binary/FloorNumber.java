package com.gfg.dsa.practice.searchingAlgo.binary;

import java.util.Arrays;

public class FloorNumber {

    // Floor = largest number less than or equal to the target

    public static void main(String[] args) {
        int[] array = {1, 23, 34, 45, 63, 72, 81};
        int target = 34;
        System.out.printf("In array=%s, floor number of target=%s is at index=%s", Arrays.toString(array), target, findFloor(array, target));
    }

    private static int findFloor(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            // Calculate mid index avoiding integer overflow
            int mid = start + (end - start) / 2;

            if (target < array[mid]) {
                end = mid - 1; // Update end to search in the left subarray
            } else if (target > array[mid]) {
                start = mid + 1; // Update start to search in the right subarray
            } else {
                return mid; // If target is found, return the index
            }
        }
        // If target is not found, return end which holds the floor index
        return end;
    }
}