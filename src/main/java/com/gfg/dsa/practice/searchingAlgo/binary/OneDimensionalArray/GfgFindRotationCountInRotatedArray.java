package com.gfg.dsa.practice.searchingAlgo.binary.OneDimensionalArray;

import java.util.Arrays;

/*
    Problem: https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
    Description:
    - This problem involves searching for a target element in a rotated sorted array, where elements are shifted right by one.
    - The array contains no duplicate values.
    eg: array: [1,2,3,4,5,6,7,8]
    after 1st rotation, array wil become
    array: [8,1,2,3,4,5,6,7]

    Approach:
    1. Find the pivot element (the largest element in the array).
        eg- array: [3,4,5,6,7,1,2] // 7 is the pivot here
    2. FInd number of rotation:
        - Add 1 to the pivot element's index to find the number of rotation.

    How to Find Pivot:
    - Case 1: If mid > mid + 1 element, mid is the pivot.
    - Case 2: If mid < mid - 1 element, mid - 1 is the pivot.
    - Case 3: If start >= mid,  all elements from mid to end will be smaller than start,
    hence ignore the left side as the pivot lies on the right (end = mid - 1).
     eg: 4,5,6,3,2,1,0
        s = 4, m = 3, e = 0
    - Case 4: If start < mid, the largest element lies on the right (start = mid + 1).
    because if mid was pivot, it would have be caught in case 1.
    eg: 3, 4, 5, 6 ,2
    s = 3, m = 5, e = 2
    - Case 5: Array is not rotated, return -1
 */
public class GfgFindRotationCountInRotatedArray {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        System.out.printf("In array=%s pivot is at index=%s", Arrays.toString(array), getRotationCount(array));
        int[] array2 = {4, 5, 6, 0, 1, 2, 3};
        System.out.printf("\nIn array=%s pivot is at index=%s", Arrays.toString(array2), getRotationCount(array2));
    }

    private static int getRotationCount(int[] array) {
        return findPivotIndex(array) + 1; // when array is not rotated -1 + 1 = 0
    }

    private static int findPivotIndex(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            // Calculate mid index avoiding integer overflow
            int mid = start + (end - start) / 2;
            if (mid < end && array[mid] > array[mid + 1]) {
                return mid;
            }
            if (mid > start && array[mid] < array[mid - 1]) {
                return mid - 1;
            }
            if (array[mid] <= array[start]) {
                end = mid - 1; // Update end to search in the left subarray
            } else {
                start = mid + 1; // Update start to search in the right subarray
            }
        }
        return -1; // array is not rotated
    }
}
