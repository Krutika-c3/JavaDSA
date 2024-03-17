package com.gfg.dsa.practice.searchingAlgo.binary.OneDimensionalArray;

import java.util.Arrays;

/*
    Problem: https://leetcode.com/problems/split-array-largest-sum/description/
    Description:
    - The problem involves splitting an array into k non-empty continuous subarrays.
    - The goal is to minimize the largest sum among these k subarrays.
    - Array contains only positive numbers.

    Input: nums = [7,2,5,10,8], k = 2
    Output: 18
    Explanation: There are four ways to split nums into two subarrays.
    The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

    4 ways to split the arrays  |      sum      | largest sum
   -----------------------------------------------------------
    [7, 2, 5, 10] [8]           |   24  8       |   24
    [7, 2, 5] [10, 8]           |   14  18      |   18
    [7, 2] [5, 10, 8]           |   9   23      |   23
    [7] [2, 5, 10, 8]           |   7   25      |   25

    minimum largest sum = 18

    Case 1: What can be the minimum number of partition  ?
    A: 1 element per partition
    Q: What will be the max largest sum when array is divided into 1 partition ? (Case 1)
    A: sum of all elements (32)

    Case 2: What is the maximum number of partitions that can be ?
    A: k
    Q: How many time can we divide array of size n into n pieces ? (Case 2) - min largest sum ?
    A: max element in tha array (10)

    range of answer is max element in the aray to sum of all elements

    HERE WE KNOW WE WANT TO FIND POTENTIAL ANSWER IN A SORTED RANGE: that is why we are using binary search

    start = 10, end = 32, mid = 21
    Split array such that it has max sum as 21.
    [7, 2, 5] [10, 8] pieces = 2
C1: if (pieces <= k)
        end = mid //we have to make individual sum less - look into lhs

    start = 10, end = 21, mid = 15
    Split array such that it has max sum as 15.
    [7, 2, 5] [10] [8] pieces = 3
C2: if (pieces > k)
        start = mid + 1 //we want to make sum more - look into rhs

    start = 16, end = 21, mid = 18
    Split array such that it has max sum as 18.
    [7, 2, 5] [10, 8] pieces = 2
    end = mid

    start = 16, end = 18, mid = 17
    Split array such that it has max sum as 17.
    [7, 2, 5] [10] [8] pieces = 3
    start = mid + 1

    start = 18, end = 18, mid = 18
    when start = end, answer found!

    Time Complexity: O(n * log(sum)), where n is the size of the array and sum is the sum of all elements.
 */
public class LeetCodeSplitArrayLargestSum {
    public static void main(String[] args) {
        int[] array = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.printf("In the array %s the minimum possible largest sum value is %s with the array having %s sub arrays", Arrays.toString(array), getMinLargestSum(array, k), k);
    }

    private static int getMinLargestSum(int[] array, int k) {
        int max = 0, sum = 0;
        for (int num : array) {
            max = Math.max(max, num);
            sum = sum + num;
        }
        int start = max;
        int end = sum;
        while (start < end) {
            int mid = start + (end - start) / 2;
            // calculate how many pieces can you divide the array with the allowed max sum (mid)
            int subArraySum = 0;
            int subArrayPieces = 1; // can be divided into atleast 1 piece

            for (int num : array) {
                if (subArraySum + num > mid) { // current sun of the subArray is exceeding allowed max sum (mid)
                    // you cannot add this num in this subarray, make new one
                    // add this num in new subarray, then subArraySum = num
                    subArraySum = num;
                    // one subArray added
                    subArrayPieces++;
                } else {
                    // keep adding in this sub array
                    subArraySum += num;
                }
            }

            if (subArrayPieces > k) {
                start = mid + 1;  // we want to make sum more - look into rhs
            } else {
                end = mid; // we have to make individual sum less - look into lhs
            }
        }
        return end;
    }
}
