package com.gfg.dsa.practice.recursion.arrays.sortingAlgos;

import java.util.Arrays;

/*
    Steps:
    1. Divide array in two parts
    2. Recursively sort both the parts of the array
    3. Merge both arrays

    At each level, N elements are being merged.
    Total number of levels = log2(n)
    Total complexity    = total of a level * number of levels
                        = N * log(n)

    When copying array :
    Space complexity = O(n) because n elements in a stack 
 */
public class MergeSortUsingRecursion {
    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 7, 8};
        int[] sortedArray = sortArrayUsingCopy(array);
        System.out.println(Arrays.toString(array) + " is sorted via copy to: " + Arrays.toString(sortedArray));
        System.out.print(Arrays.toString(array) + " is sorted inplace to: ");
        sortArrayInplace(array, 0, array.length);
        System.out.print(Arrays.toString(array));
    }

    private static int[] sortArrayUsingCopy(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int middleIndex = array.length / 2;

        // we are creating new objects for each function call, orignal array isn't modified
        int[] leftArray = sortArrayUsingCopy(Arrays.copyOfRange(array, 0, middleIndex)); // pass a copy of array starting from 0th index to middle index
        int[] rightArray = sortArrayUsingCopy(Arrays.copyOfRange(array, middleIndex, array.length)); // pass a copy of array starting from middle index to end of array

        return mergeArrays(leftArray, rightArray);
    }

    private static int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];

        int firstArrayPointer = 0;
        int secondArrayPointer = 0;
        int resultantArrayIndex = 0;

        while (firstArrayPointer < array1.length && secondArrayPointer < array2.length) { // continue till both arrays have elements
            if (array1[firstArrayPointer] < array2[secondArrayPointer]) {
                mergedArray[resultantArrayIndex] = array1[firstArrayPointer];
                firstArrayPointer++;
            } else {
                mergedArray[resultantArrayIndex] = array2[secondArrayPointer];
                secondArrayPointer++;
            }
            resultantArrayIndex++;
        }

        // It may be possible that one of the arrays is not complete - copy the remaining elements

        while (firstArrayPointer < array1.length) {
            mergedArray[resultantArrayIndex] = array1[firstArrayPointer];
            firstArrayPointer++;
            resultantArrayIndex++;
        }

        while (secondArrayPointer < array2.length) {
            mergedArray[resultantArrayIndex] = array2[secondArrayPointer];
            secondArrayPointer++;
            resultantArrayIndex++;
        }

        return mergedArray;
    }

    private static void sortArrayInplace(int[] array, int start, int end) {
        if (end - start == 1) { // length of array in current iteration
            return;
        }

        int middleIndex = (start + end) / 2;

        sortArrayInplace(array, start, middleIndex);
        sortArrayInplace(array, middleIndex, end);

        mergeArraysInplace(array, start, middleIndex, end);
    }

    private static void mergeArraysInplace(int[] array, int start, int middleIndex, int end) {
        int[] mergedArray = new int[end - start]; // length of array in current iteration

        int firstPointer = start; // will iterate through first half
        int secondPointer = middleIndex; // will iterate through second half
        int resultantArrayIndex = 0;

        // first part is considered till element before mid, hence firstPointer will only go till middleIndex
        // similarly, second part is considered from mid to end
        while (firstPointer < middleIndex && secondPointer < end) {
            if (array[firstPointer] < array[secondPointer]) {
                mergedArray[resultantArrayIndex] = array[firstPointer];
                firstPointer++;
            } else {
                mergedArray[resultantArrayIndex] = array[secondPointer];
                secondPointer++;
            }
            resultantArrayIndex++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (firstPointer < middleIndex) {
            mergedArray[resultantArrayIndex] = array[firstPointer];
            firstPointer++;
            resultantArrayIndex++;
        }

        while (secondPointer < end) {
            mergedArray[resultantArrayIndex] = array[secondPointer];
            secondPointer++;
            resultantArrayIndex++;
        }

        // modify the original array to have the elements as they're in mergedArray
        for (int l = 0; l < mergedArray.length; l++) {
            array[start + l] = mergedArray[l];
        }
    }
}
