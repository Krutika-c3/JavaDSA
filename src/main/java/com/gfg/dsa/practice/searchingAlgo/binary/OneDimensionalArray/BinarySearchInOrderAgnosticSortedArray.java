package com.gfg.dsa.practice.searchingAlgo.binary.OneDimensionalArray;

import java.util.Arrays;

public class BinarySearchInOrderAgnosticSortedArray {
    public static void main(String[] args) {
        int[] array = {1, 23, 34, 45, 63, 72, 81};
        int target = 23;
        System.out.printf("In array=%s target=%s is at index=%s", Arrays.toString(array), target, search(array, target));
        int[] array2 = {81, 72, 63, 45, 34, 23, 1};
        System.out.printf("\nIn array=%s target=%s is at index=%s", Arrays.toString(array2), target, search(array2, target));
    }

    private static int search(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int middle;
        boolean isAscending = array[start] < array[end];
        while (start <= end) {
            middle = (start + end) / 2; // or (start + (end-start))/2;
            if (target < array[middle]) {
                if (isAscending) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else if (target > array[middle]) {
                if (isAscending) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {
                return middle;
            }
        }
        return -1;
    }
}
