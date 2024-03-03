package com.gfg.dsa.practice;

import java.util.Arrays;

public class ReverseUsingTwoPointer {
    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 18, 56};
        System.out.println("Unsorted list: " + Arrays.toString(arr));
        System.out.println("Reversed list: " + Arrays.toString(reverse(arr)));
    }

    static int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
