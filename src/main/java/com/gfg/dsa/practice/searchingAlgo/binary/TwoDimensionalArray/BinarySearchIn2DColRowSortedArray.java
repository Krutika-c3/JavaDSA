package com.gfg.dsa.practice.searchingAlgo.binary.TwoDimensionalArray;

import java.util.Arrays;

/*
    HINT: When you're given a large matrix, divide it into smaller search space
    Problem: 2D Matrix is sorted in row-wise and column-wise manner.
    Approach:
    Eg: In the below array you're searching index of element '37':
    10 20 30 40
    15 25 35 45
    28 29 37 49
    33 34 38 50

    lower bound = array[0]                  10
    upper bound = array[lastColumnStart]    40

    The below can be the possible cases:
    Case 1: element == target
            answer found
    Case 2: element < target
            eg: 30 in the above case
            30 < 37
            as the array is row-wise sorted all elements in the row[0] will be less than 30
            hence we can ignore this row.
            row++
    Case 3: element > target
            eg: 40 in the above case
            40 > 37
            as the array is row-wise sorted all elements in the column[0] will be greater than 40
            hence we can ignore this column.
            column--
    Repeat the process until the target is found or the search space is exhausted.

    Time Complexity = 2n times ~ O(n)
 */

public class BinarySearchIn2DColRowSortedArray {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int target = 49;
        System.out.println("In array : ");
        for (int[] row : arr) {
            for (int column = 0; column < arr.length; column++) {
                System.out.print(row[column] + " ");
            }
            System.out.println();
        }
        System.out.printf("target=%s is at index=%s", target, Arrays.toString(search(arr, target)));
    }

    private static int[] search(int[][] array, int target) {
        int row = 0;
        int column = array.length - 1;

        while (row < array.length && column >= 0) {
            if (array[row][column] == target) {
                return new int[]{row, column};
            } else if (array[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return new int[]{-1, -1};
    }
}
