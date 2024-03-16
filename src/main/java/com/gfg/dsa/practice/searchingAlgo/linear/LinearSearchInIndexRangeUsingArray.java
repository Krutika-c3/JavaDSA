package com.gfg.dsa.practice.searchingAlgo.linear;

import java.util.Arrays;

public class LinearSearchInIndexRangeUsingArray {

    public static void main(String[] args) {
        int[] arr = {1, 14, 42, 25, 46};
        int target = 42;
        int rangeStart = 2;
        int rangeEnd = 4;
        System.out.printf("%s has %s in range of index %s and %s at %s index", Arrays.toString(arr), target, rangeStart, rangeEnd, getTargetIndexIfPresent(arr, target, rangeStart, rangeEnd));
        System.out.println();
        System.out.printf("%s has %s in range of index %s and %s %s", Arrays.toString(arr), target, rangeStart, rangeEnd, isTargetElementPresent(arr, target, rangeStart, rangeEnd) ? "present" : "absent");
    }

    private static boolean isTargetElementPresent(int[] arr, int target, int rangeStart, int rangeEnd) {
        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (target == arr[i]) {
                return true;
            }
        }
        return false;
    }

    private static int getTargetIndexIfPresent(int[] arr, int target, int rangeStart, int rangeEnd) {
        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (target == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
