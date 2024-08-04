package com.gfg.dsa.practice.recursion.arrays.sortingAlgos;

import java.util.Arrays;

/*
    1. Find largest number
    2. Swap with the last element in the unsorted array
    3. Move to next iteration
    4. Repeat 1,2 and 3 for all elements
 */
public class SelectionSortUsingRecursion {

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        System.out.print("Sorted array of " + Arrays.toString(array) + " is: ");
        // suppose pass starts from 4 - 4,3,2,1 and max number is at 0th index
        selection(array, array.length , 0, 0);
        System.out.print(Arrays.toString(array));
    }

    private static void selection(int[] array, int passCount, int currentIndex, int max) {
        // Base case: if the number of passes reaches to 0, the array is iterated and sorted
        if (passCount == 0) {
            return;
        }

        /*
         * If the current index is within the range of the current pass:
         * This ensures that comparisons and swaps are only performed within the unsorted portion of the array.
         * By limiting the range, we prevent unnecessary comparisons and make the sorting process more efficient.
         */
        if (currentIndex < passCount) {
            if (array[currentIndex] > array[max]) {
                // currentIndex will be the new max and check with other elements to find max of array
                selection(array, passCount, currentIndex + 1, currentIndex);
            } else {
                // check with other elements to find max of array
                selection(array, passCount, currentIndex + 1, max);
            }
        } else {
            // after iterating through the current pass, max will be at the end, hence swap max number with last element in the unsorted array
            swap(array, passCount - 1, max);
            selection(array, passCount - 1, 0, 0);
        }
    }

    private static void swap(int[] array, int nextIndex, int max) {
        int temp = array[nextIndex];
        array[nextIndex] = array[max];
        array[max] = temp;
    }
}
