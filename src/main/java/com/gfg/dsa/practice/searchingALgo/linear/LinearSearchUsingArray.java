package com.gfg.dsa.practice.searchingALgo.linear;

import java.util.Arrays;

public class LinearSearchUsingArray {
    public static void main(String[] args) {
        int[] arr = {1, 14, 42, 25, 46};
        int target = 46;
        System.out.printf("%s has %s at %s index", Arrays.toString(arr), target, getTargetIndexIfPresent(arr, target));
        System.out.println();
        System.out.printf("%s has %s %s", Arrays.toString(arr), target, isTargetElementPresent(arr, target) ? "present" : "absent");
    }

    private static int getTargetIndexIfPresent(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isTargetElementPresent(int[] arr, int target) {
        for (int i : arr) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

}
