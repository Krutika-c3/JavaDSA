package com.gfg.dsa.practice.searchingAlgo.linear;

import java.util.Arrays;

/*
    https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
 */
public class LeetCodeCountEventDigitElementsInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-12, 345, 2, 6, 13, 0, 7896};
        System.out.println("Digit count: " + getDigitCount(-992384));
        System.out.println("Optimized Digit count: " + getOptimizedDigitCount(-992384));
        System.out.printf("The number of even digit elements present in %s is %s", Arrays.toString(nums), countEvenDigitELements(nums));
    }

    private static int countEvenDigitELements(int[] arr) {
        int count = 0;
        for (int element : arr) {
            if (isEven(getDigitCount(element))) {
                count++;
            }
        }
        return count;
    }

    private static boolean isEven(int digitCount) {
        return digitCount % 2 == 0;
    }

    private static int getDigitCount(int element) {
        int digitCount = 0;
        if (element < 0) {
            element = element * -1;
        }
        if (element == 0) {
            return 1;
        }
        while (element > 0) {
            element = element / 10;
            digitCount++;
        }
        return digitCount;
    }


    private static int getOptimizedDigitCount(int element) {
        if (element < 0) {
            element = element * -1;
        }
        return (int) (Math.log10(element)) + 1;
    }
}



