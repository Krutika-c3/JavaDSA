package com.gfg.dsa.practice.searchingALgo.linear;

import java.util.Arrays;

public class FindMinInArrayUsingLinearSearch {

    public static void main(String[] args) {
        int[] arr = {122, 14, 42, 25, 46};
        int[] results = getTargetIndexIfPresent(arr);
        System.out.printf("%s has min number %s at %s index", Arrays.toString(arr), results[0], results[1]);
    }

    private static int[] getTargetIndexIfPresent(int[] arr) {
        int[] results = new int[2];
        int min = arr[0]; // int min = Integer.MAX_VALUE
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                results[1] = i;
            }
        }
        results[0] = min;
        return results;
    }
}
