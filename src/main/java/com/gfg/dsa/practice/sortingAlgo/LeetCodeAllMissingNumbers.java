package com.gfg.dsa.practice.sortingAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    Description:
    - Range is from 1 to n
        - Every element will be at index n - 1
 */
public class LeetCodeAllMissingNumbers {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        List<Integer> missingElements = findMissingElement(arr);
        System.out.println(Arrays.toString(arr) + " has elements " + missingElements + " missing");
    }

    private static List<Integer> findMissingElement(int[] arr) {
        List<Integer> missingElements = new ArrayList<>();
        for (int elenent = 0; elenent < arr.length; elenent++) {
            if (arr[elenent] != elenent + 1) {
                missingElements.add(elenent + 1);
            }
        }
        return missingElements;
    }

    private static void sortArray(int[] arr) {
        for (int pass = 0; pass < arr.length; pass++) {
            int correctIndex = arr[pass] - 1;
            if (arr[pass] != arr[correctIndex]) {
                swap(arr, pass, correctIndex);
                pass--;
            }
        }
    }

    private static void swap(int[] arr, int pass, int correctIndex) {
        int temp = arr[pass];
        arr[pass] = arr[correctIndex];
        arr[correctIndex] = temp;
    }

}
