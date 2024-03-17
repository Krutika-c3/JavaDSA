package com.gfg.dsa.practice.searchingAlgo.binary;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
             https://leetcode.com/problems/find-peak-element/description/
    Description:
    - In this problem, the array represents a mountain-like texture where numbers ascend to a peak and then descend.
    - The array does not contain duplicate elements.
    - We aim to find the index of the peak element in the mountain array.
    - There are three cases to consider:
        Case 1: If e[mid] > e[mid + 1], meaning the ascending part is over, and after mid, we have the descending part.
            Update end = mid, and continue searching in the left half.
        Case 2: If e[mid] < e[mid + 1], meaning you are in the ascending part.
            Update start = mid + 1 because we know that the mid + 1 element > mid element.
        Case 3: The loop breaks when start equals end and both point to the largest element.
            At each step, start and end are trying to find the maximum element. When they are pointing to just one element,
            it's the peak because of the checks above.
 */
public class LeetCodePeakFindPeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] array = {1, 23, 34, 45, 63, 72, 81, 73, 63, 52, 30, 19, 9, 3};
        System.out.printf("In array=%s peak index is at index=%s", Arrays.toString(array), search(array));
    }

    private static int search(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > array[mid + 1]) { // If ascending part is over and descending part starts
                // Update end to search in the left subarray
                // this is why end != mid - 1
                end = mid;
            } else { // If ascending part continues
                //Update start to search in the right subarray
                // because we know that mid+1 element > mid element
                start = mid + 1;
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are equal
    }
}
