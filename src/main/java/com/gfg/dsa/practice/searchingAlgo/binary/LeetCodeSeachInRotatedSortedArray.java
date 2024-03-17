package com.gfg.dsa.practice.searchingAlgo.binary;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    Description:
    - This problem involves searching for a target element in a rotated sorted array, where elements are shifted right by one.
    - The array contains no duplicate values.
    eg: array: [1,2,3,4,5,6,7,8]
    after 1st rotation, array wil become
    array: [8,1,2,3,4,5,6,7]

    Approach:
    1. Find the pivot element (the largest element in the array).
        eg- array: [3,4,5,6,7,1,2] // 7 is the pivot here
    2. Based on the pivot, determine the search space:
       - If the pivot is not found, the array is not rotated, so perform a regular binary search.
       - If the target is greater than or equal to the first element, search in the first half of the array before the pivot.
       - Otherwise, search in the second half of the array after the pivot.

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

    What to Do with Pivot:
    - Case 1: If pivot element equals target, return the pivot index.
    - Case 2: If target >= start, search space is (start, pivot - 1), as all numbers after pivot are smaller than start.
    - Case 3: If target < start, search space is (pivot + 1, end), as all elements from start to pivot are greater than target.
 */
public class LeetCodeSeachInRotatedSortedArray {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        System.out.printf("In array=%s pivot is at index=%s", Arrays.toString(array), binarySearch(array, target));
    }

    private static int binarySearch(int[] array, int target) {
        int pivot = findPivotIndex(array);
        // Case 1: If pivot is not found (array is not rotated), perform regular binary search
        if (pivot == -1) {
            return search(array, target, 0, array.length - 1);
        }
        // Case 2: If target >= start, search in the first half before the pivot
        if (target >= array[0]) {
            return search(array, target, 0, pivot - 1);
        }
        // Case 3: If target < start, search in the second half after the pivot
        return search(array, target, pivot + 1, array.length - 1);
    }

    private static int search(int[] array, int target, int start, int end) {
        int middle;
        while (start <= end) {
            middle = (start + end) / 2; // or (start + (end-start))/2;
            if (target < array[middle]) {
                end = middle - 1; // Update end to search in the left subarray
            } else if (target > array[middle]) {
                start = middle + 1; // Update start to search in the right subarray
            } else {
                return middle;
            }
        }
        return -1;
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
        return -1;
    }
}
