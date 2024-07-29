package com.gfg.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionForArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 4, 6, 8, 10, 41, 62};
        System.out.println("Is array " + Arrays.toString(array1) + " sorted? " + isArraySorted(array1));
        int[] array2 = {3, 2, 1, 182, 92, 23};
        int target2 = 2;
        System.out.println(target2 + " is at index " + linearSearchInArray(array2, target2) + " in the array " + Arrays.toString(array2));
        int[] array3 = {3, 2, 1, 18, 18, 92, 23};
        int target3 = 18;
        System.out.println(target3 + " is at index " + linearSearchMultipleInArray(array3, target3) + " in the array " + Arrays.toString(array3));
        System.out.println(target3 + " is at index " + linearSearchMultipleInArrayWithoutParameter(array3, target3) + " in the array " + Arrays.toString(array3));
        int[] array4 = {103, 92, 61, 1, 3, 48, 52};
        int target4 = 48;
        System.out.println(target4 + " is at index " + binarySearch(array4, target4) + " in the array " + Arrays.toString(array4));
    }

    /*
        arr[i] < arr[i+1] and remaining array is also sorted
        if last element is left in array to be checked that means all previous elements are checked hence return true
        eg: array {1,2,4,5}
        for F(array, 0) // array and index to be checked
            1 < 2 && F(array,1)
                        2 < 4 && F(array,2)
                                4 < 5 && F(array, 3)
                                            true
     */
    private static boolean isArraySorted(int[] array) {
        return checkIsSorted(array, 0);
    }

    private static boolean checkIsSorted(int[] array, int index) {
        if (index == array.length - 1) { // if last element needs to be checked return true
            return true;
        }
        return array[index] < array[index + 1] && checkIsSorted(array, index + 1);
    }

    /*
        search in all index, if index reached out of array.length - 1 then return -1 (element not found)
        array, target, index
     */
    private static int linearSearchInArray(int[] array, int target) {
        return search(array, target, 0);
    }

    private static int search(int[] array, int target, int index) {
        // if even after the last element the target element is not found that means it is not present in the list hence return -1
        if (index == array.length) {
            return -1;
        }
        if (target == array[index]) {
            return index;
        }
        return search(array, target, index + 1);
    }

    /*
        After you found the first occurrence, keep searching if you may find another occurrence
     */
    private static List<Integer> linearSearchMultipleInArray(int[] array, int target) {
        List<Integer> resultantIndices = new ArrayList<>();
        List<Integer> indices = searchIndex(array, target, 0, resultantIndices);
        return indices.size() > 0 ? indices : List.of(-1);
    }

    private static List<Integer> searchIndex(int[] array, int target, int index, List<Integer> resultantIndices) {
        // when we traversed the whole array, return whatever we found till now
        if (index == array.length) {
            return resultantIndices;
        }
        if (target == array[index]) {
            resultantIndices.add(index);
        }
        return searchIndex(array, target, index + 1, resultantIndices);
    }

    // without passing list in parameter, creating a new list in the method body
    private static List<Integer> linearSearchMultipleInArrayWithoutParameter(int[] array, int target) {
        List<Integer> indices = searchIndexWithoutParameter(array, target, 0);
        return indices.size() > 0 ? indices : List.of(-1);
    }

    private static List<Integer> searchIndexWithoutParameter(int[] array, int target, int index) {
        List<Integer> indices = new ArrayList<>();

        // when we traversed the whole array, return whatever we found till now
        if (index == array.length) {
            return indices;
        }

        // list will contain answer for this iteration only
        if (target == array[index]) {
            indices.add(index);
        }

        // when stack is emptying, and method calls are returned to the method who called the caller method call
        List<Integer> indicesFromBeforeMethodCalls = searchIndexWithoutParameter(array, target, index + 1);
        indicesFromBeforeMethodCalls.addAll(indices);
        return indicesFromBeforeMethodCalls;
    }

    /*
        Rotated Binary Search
        - search an element in a sorted array which is rotated a few times
        eg: {5, 6, 7, 8, 9, 1, 2, 3, 4}
        In first pass:
        start = 5
        mid = 8
        end = 4
        case 1:
        arr: 5,6,7,8
        target: 7
        if left part is sorted
            if key lies in the left part
                search in the left part
            else
                search in the right part
       case 2:
       arr: 5,1,2,3,4
       target: 2
            if key lies in the right part
                search in right part
        case 3:
        arr: 5,6,1,2,3,4
        target:
            if key lies in the left part
                search in left part
     */
    private static int binarySearch(int[] array, int target) {
        return search(array, target, 0, array.length - 1);
    }

    private static int search(int[] array, int target, int start, int end) {
        // all elements are traversed still no target element wasn't found
        if (start > end) {
            return -1;
        }

        int middle = start + (end - start) / 2;

        // target is in the middle
        if (array[middle] == target) {
            return middle;
        }

        // check if the first half is sorted
        if (array[start] <= array[middle]) {
            // check if target lies in first half of the array
            if (target >= array[start] && target <= array[middle]) {
                // if yes: search in the first half
                return search(array, target, start, middle - 1);
            } else {
                // if no: search in the second half
                return search(array, target, middle + 1, end);
            }
        }

        // check if target lies in the second half
        if (target >= array[middle] && target <= array[end]) {
            return search(array, target, middle + 1, end);
        }

        // check if target lies in the first unsorted half
        return search(array, target, start, middle - 1);
    }
}
