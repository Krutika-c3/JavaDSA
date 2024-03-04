package com.gfg.dsa.practice.searchingALgo.linear;

public class LinearSearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6},
                {7, 8, 9}
        };
        int target = 9;
        int[] targetIndexIfPresent = getTargetIndexIfPresent(arr, target);
        print2DArray(arr);
        System.out.printf("has %s at %s, %s index", target, targetIndexIfPresent[0], targetIndexIfPresent[1]);
        System.out.println();
        print2DArray(arr);
        System.out.printf("has %s %s", target, isTargetElementPresent(arr, target) ? "present" : "absent");
    }

    private static void print2DArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    private static boolean isTargetElementPresent(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if (target == arr[row][column]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] getTargetIndexIfPresent(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if (target == arr[row][column]) {
                    return new int[]{row, column};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
