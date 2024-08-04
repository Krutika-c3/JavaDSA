package com.gfg.dsa.practice.recursion.arrays.sortingAlgos;

import java.util.Arrays;

/*
    Quick Sort:
    - Time complexity:
        Best case : O(nlog(n))
        Worst case : O(n^2)
    - Not stable - order is not maintained of same valued element
    - Space complexity: O(1) - inplace sorting algorithm
    - Merge sort is better with linkedList due to non-continuous memory allocation

    Advantage:
    - If array is already sorted, we will not sort it further like merge sort
    Steps:
    1. Choose a pivot element
    2. After first pass - pivot is at it's correct position.
        - All the elements less than pivot will be on the left side of pivot
        - All the elements greater than pivot will be on the right side of pivot

    How to get pivot at correct position?
    1. Take a random pivot element
    2. Take 2 pointers start and end
      goal: Elements from start till pivot should be smaller than pivot
            Elements from pivot till end should be greater than pivot
    3. Whenever we find violation of elements from "goal" - SWAP those elements
        - while array[start] is less than pivot - check further elements as start is at the correct side of pivot
        - while array[end] is greater than pivot - check previous elements as end is at the correct side of pivot
    4. After swapping, increase start by 1 and decrease end by 1 - as those elements are now at their desired side of pivot
    5. Repeat 3 and 4 until start = end
    6. Pivot will now be at the correct position
    7. Recursively check left and right side of pivot by following 1-7 steps
 */
public class QuickSortUsingRecursion {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // low and high tells us which part of array you're working on
    static void sort(int[] array, int low, int high) {
        if (low >= high) { // no need for sorting
            return;
        }

        // start and end are pointers for swapping
        int start = low;
        int end = high;
        int middle = (start + end) / 2;
        int pivot = array[middle]; // take pivot as middle element

        while (start <= end) { // because after this pivot element will be sorted

            // also a reason why if its already sorted it will not swap
            while (array[start] < pivot) { // check if elements on right are at the correct side
                start++; // check further elements as start is at the correct side of pivot
            } // start will have the index which is equal or greater than pivot

            while (array[end] > pivot) { // check if elements on left are at the correct side
                end--; // check previous elements as end is at the correct side of pivot
            }  // end will have the index which is equal or less than pivot

            if (start <= end) {
                swap(array, start, end);  // start and end both are not at desired state hence swapping
                start++; // check further elements as start is at the correct side of pivot
                end--; // check previous elements as end is at the correct side of pivot
            }
        }

        // pivot is at correct index, sort the left and right halves
        sort(array, low, end);
        sort(array, start, high);
    }

    private static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
