package com.gfg.dsa.practice.searchingAlgo.binary;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    Description:
    This problem is a modified version of the ceiling number problem.
    The difference between ceiling number and this question is:
        - If such a character does not exist, return the first character in letters.
        - We have to find the smallest letter greater (not greater than or equal to) than the target.
 */
public class LeetCodeFindSmallestNumberGreaterThanTarget {

    public static void main(String[] args) {
        char[] array =  {'c','f','j'};
        char target = 'j';
        System.out.printf("In array=%s.\nThe smallest character that is lexicographically greater than %s in letters is %s.", Arrays.toString(array), target, findCeiling(array, target));
    }

    // Function to find the smallest character lexicographically greater than the target in the array
    private static char findCeiling(char[] array, char target) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            // Calculate mid index avoiding integer overflow
            int mid = start + (end - start) / 2;

            if (target < array[mid]) {
                end = mid - 1; // Update end to search in the left subarray
            } else if (target >= array[mid]) {
                start = mid + 1; // Update start to search in the right subarray
            }
        }
        /*Return the smallest character lexicographically greater than the target.
        In case the target is greater than all characters in the array, start would point to the index beyond the last element.
        Since the array is circular, we use modulo operation to wrap around and return the first character.
        This ensures that even if the target is greater than all characters, we return the smallest character in the array.*/
        return array[start % array.length];
    }
}