package com.gfg.dsa.practice.searchingAlgo.binary.OneDimensionalArray;

import java.util.Arrays;

public class BinarySearchInAscSortedArray {
    public static void main(String[] args) {
        int[] array = {1, 23, 34, 45, 63, 72, 81};
        int target = 81;
        System.out.printf("In array=%s target=%s is at index=%s", Arrays.toString(array), target, search(array, target));
    }

    private static int search(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int middle;
        while (start <= end) {
            middle = (start + end) / 2; // or (start + (end-start))/2;
            if (target < array[middle]) {
                end = middle - 1;
            } else if (target > array[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
