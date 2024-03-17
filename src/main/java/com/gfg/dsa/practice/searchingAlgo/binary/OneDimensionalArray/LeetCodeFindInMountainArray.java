package com.gfg.dsa.practice.searchingAlgo.binary.OneDimensionalArray;

import java.util.Arrays;

/*
   Problem: https://leetcode.com/problems/find-in-mountain-array/description/
   Description:
   - This problem involves searching for a target element in a mountain array, which is an array with a peak element.
   - The steps to solve the problem are:
     1. Find the peak element in the mountain array.
     2. Perform binary search in the ascending part of the array.
     3. If the target is not found in the ascending part, perform binary search in the descending part of the array.
 */
public class LeetCodeFindInMountainArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        System.out.printf("In array=%s target=%s is at index=%s", Arrays.toString(array), target, search(array, target));
    }

    private static int search(int[] array, int target) {
        int peak = findPeakElement(array); // Step 1: Find the peak element
        int firstTry = orderAgnosticBinarySearch(array, target, 0, peak); // Step 2: Binary search in ascending array
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBinarySearch(array, target, peak + 1, array.length - 1); // Step 3: Binary search in descending array
    }

    private static int orderAgnosticBinarySearch(int[] array, int target, int start, int end) {
        int middle;
        boolean isAscending = array[start] < array[end];
        while (start <= end) {
            middle = (start + end) / 2; // or (start + (end-start))/2;
            if (target < array[middle]) {
                if (isAscending) {
                    end = middle - 1; // Update end to search in the left subarray
                } else {
                    start = middle + 1; // Update start to search in the right subarray
                }
            } else if (target > array[middle]) {
                if (isAscending) {
                    start = middle + 1; // Update start to search in the right subarray
                } else {
                    end = middle - 1; // Update end to search in the left subarra
                }
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static int findPeakElement(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > array[mid + 1]) { // If ascending part is over and descending part starts
                // Update end to search in the left subarray
                // this is why end != mid - 1
                end = mid;
            } else { // If ascending part continues
                //Update start to search in the right subarray
                // because we know that mid+1 element > mid element
                start = mid + 1;
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are equal
    }
}
