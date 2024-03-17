package com.gfg.dsa.practice.searchingAlgo.binary.TwoDimensionalArray;

import java.util.Arrays;

/*
    HINT: When you're given a large matrix, divide it into smaller search space
    Problem: 2D Matrix is sorted in ascending order.
    Approach:
    Eg: In the below array you're searching index of element '2':
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16

    lower bound = array[0][0]           1
    upper bound = array[lastRow][0]     13

    - Find middle column and perform binary search on it
    Case 1: target < middle (2 < 6)
            - all the elements after middle will be greater than target, so we can ignore them
            - ignore rows after it
            - row--
    Case 2: target > middle
            - all the elements before middle will be less than target, so we can ignore them
            - ignore rows before it
            - rows++
    Case 3: target == middle
            - answer found

    In the end two rows are remaining: eg : target = 3
    1 2 3 4
    5 6 7 8
    S1: check if middle column (2,6) has target value ?
    S2: consider the 4 parts:
    - apply binary search in all 4 parts

    Time complexity : logn + logn ~ 2logn ~ O(logn)
    Space complexity : O(1)

 */
public class BinarySearchIn2DAscSortedArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int target = 9;
        System.out.println("In array : ");
        for (int[] row : arr) {
            for (int column = 0; column < arr.length; column++) {
                System.out.print(row[column] + " ");
            }
            System.out.println();
        }
        System.out.printf("target=%s is at index=%s", target, Arrays.toString(search(arr, target)));
    }

    // search in the row provided between the cols provided
    static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;   // If the value in the middle column at the current row is less than the target,
                // it means the target may be located to the right of the middle column.
                // So, we update the starting column index to be the next column after the middle column.
            } else {
                cEnd = mid - 1;     // If the value in the middle column at the current row is greater than or equal to the target,
                // it means the target may be located to the left of the middle column.
                // So, we update the ending column index to be the column just before the middle column.
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious, matrix may be empty
        if (cols == 0) {
            return new int[]{-1, -1};
        }
        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { // while this is true it will have more than 2 rows
            int rMid = rStart + (rEnd - rStart) / 2;
            if (matrix[rMid][cMid] == target) {
                return new int[]{rMid, cMid};
            } else if (matrix[rMid][cMid] < target) {
                rStart = rMid; // ignore rows after it
            } else {
                rEnd = rMid; // ignores rows before it
            }
        }

        // now we have two rows, check whether the target is in mid of the col of 2 rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        } else if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

        // search in remaining 4 parts
        if (target <= matrix[rStart][cMid - 1]) { // search in 1st half
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        } else if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]) { // search in 2nd half
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        } else if (target <= matrix[rStart + 1][cMid - 1]) { // search in 3rd half
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        } else { // search in 4th half
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }
}