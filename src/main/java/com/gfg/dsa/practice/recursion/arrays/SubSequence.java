package com.gfg.dsa.practice.recursion.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Time complexity: time taken at each level * total number of subsets
        - O(n * 2^n)

    Space compleixty: number of subsets * space of each subset
        - O(2^n * n)
 */
public class SubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = subset(arr);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

        int[] duplicateArr = {1, 2, 2};
        List<List<Integer>> result = subsetDuplicate(duplicateArr);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    /*
        Working:
        Initialization
        - Start with an empty subsequence: outer = [[]].

        Iteration 1: Adding element 1
        - For each subsequence in outer, create a new subsequence by adding 1.
        - Outer List Before Adding 1: [[]]
        New Subsequences:
        - Add 1 to [] → [1]
        - Outer List After Adding 1: [[], [1]]

        Iteration 2: Adding element 2
        - For each subsequence in outer, create a new subsequence by adding 2.
        - Outer List Before Adding 2: [[], [1]]
        New Subsequences:
        - Add 2 to [] → [2]
        - Add 2 to [1] → [1, 2]
        - Outer List After Adding 2: [[], [1], [2], [1, 2]]

        Iteration 3: Adding element 3
        - For each subsequence in outer, create a new subsequence by adding 3.
        - Outer List Before Adding 3: [[], [1], [2], [1, 2]]
        New Subsequences:
        - Add 3 to [] → [3]
        - Add 3 to [1] → [1, 3]
        - Add 3 to [2] → [2, 3]
        - Add 3 to [1, 2] → [1, 2, 3]
        - Outer List After Adding 3: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
     */
    static List<List<Integer>> subset(int[] array) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : array) { // for every number in array
            int n = outer.size(); // take size of outer list and add the same number of inner lists
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>();
                internal.addAll(outer.get(i)); // create a copy of outer array's element at i index
                internal.add(num); // add current number to it
                outer.add(internal); // add these internal list to outer list
            }
        }
        return outer;
    }

    /*
        Initial State:
        outer = [[]]
        start = 0
        end = 0

        Iteration 1: Adding Element 1
        i = 0, arr[i] = 1
        start = 0, end = 0
        Generate new subsequences by adding 1 to each existing subsequence:
        [] + [1] = [1]
        Update outer:
        outer = [[], [1]]

        Iteration 2: Adding Element 2
        i = 1, arr[i] = 2
        start = 0, end = 1
        Generate new subsequences by adding 2 to each existing subsequence:
        [] + [2] = [2]
        [1] + [2] = [1, 2]
        Update outer:
        outer = [[], [1], [2], [1, 2]]

        Iteration 3: Adding Element 2 (Duplicate Handling)
        i = 2, arr[i] = 2
        Since arr[i] == arr[i-1], set start = end + 1 = 2
        end = 3
        Generate new subsequences by adding 2 to subsequences from start to end:
        [2] + [2] = [2, 2]
        [1, 2] + [2] = [1, 2, 2]
        Update outer:
        outer = [[], [1], [2], [1, 2], [2, 2], [1, 2, 2]]
     */
    private static List<List<Integer>> subsetDuplicate(int[] arr) {
        Arrays.sort(arr); // // Sort the array so that duplicates are at adjacent position
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int start = 0; // Variable to track the starting index for generating new subsequences
        int end = 0; // Variable to track the end index of the current subsequences

        // Iterate over each element in the array
        for (int i = 0; i < arr.length; i++) {
            start = 0; // Reset start to 0 for each new element

            // If the current element is the same as the previous one, update the start index
            if (i > 0 && arr[i] == arr[i-1]) {
                start = end + 1; // Start from the index after the last added subsequence of the previous element
            }

            end = outer.size() - 1; // Update the end to the current last index of outer
            int n = outer.size(); // Size of the current list of subsequences

            // Iterate over all existing subsequences from start to end
            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>();
                internal.addAll(outer.get(j)); // Create a new subsequence by copying the current subsequence
                internal.add(arr[i]); // Add the current element to the new subsequence
                outer.add(internal); // Add the new subsequence to the list of subsequences
            }
        }
        return outer; // Return the list of all unique subsequences
    }
}
