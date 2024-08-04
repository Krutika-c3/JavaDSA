package com.gfg.dsa.practice.recursion.arrays.sortingAlgos;

import java.util.Arrays;

/*
    1. Keep comparing element to all other elements
    2. If you find current element is greater than an element, swap those
    3. Repeat 1 and 2 until largest element is at the last index in unsorted array
    4. Move to next iteration
    5. Repeat 1,2,3 and 4 for all elements
 */
public class BubbleSortUsingRecursion {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 1};
        System.out.print("Sorted array of " + Arrays.toString(array) + " is: ");
        sort(array, array.length - 1, 0);
        System.out.print(Arrays.toString(array));
    }

    /**
     * This method sorts an array using a recursive approach to bubble sort.
     * @param array The array to be sorted
     * @param passCount The current pass number, which decreases with each full pass through the array
     * @param currentIndex The current index within the pass, which increases to perform comparisons
     */
    static void sort(int[] array, int passCount, int currentIndex) {
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
            // Compare and swap if the current element is greater than the next element
            if (array[currentIndex] > array[currentIndex + 1]) {
                swap(array, currentIndex, currentIndex + 1);
            }
            sort(array, passCount, currentIndex + 1);
        } else {
            /*
             * When the pass is complete, reduce the pass count and reset currentIndex to 0:
             * The largest element in the unsorted portion has bubbled up to its correct position.
             * We decrease the passCount to exclude the last sorted element and start a new pass from the beginning.
             */
            sort(array, passCount - 1, 0);
        }
    }

    private static void swap(int[] array, int currentIndex, int nextIndex) {
        int temp = array[currentIndex];
        array[currentIndex] = array[nextIndex];
        array[nextIndex] = temp;
    }
}
