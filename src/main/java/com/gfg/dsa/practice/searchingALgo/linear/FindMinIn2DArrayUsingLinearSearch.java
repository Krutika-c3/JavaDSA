package com.gfg.dsa.practice.searchingALgo.linear;

public class FindMinIn2DArrayUsingLinearSearch {
    public static void main(String[] args) {
        int[][] arr = {
                {324, 24, 25, 46},
                {47, 15},
                {73, 88, 94}
        };
        int[] results = getMinElementAndIndex(arr);
        print2DArray(arr);
        System.out.printf("has min number %s at %s, %s index", results[0], results[1], results[2]);
    }

    private static int[] getMinElementAndIndex(int[][] arr) {
        int min = Integer.MAX_VALUE;
        int result[] = new int[]{min, -1, -1};
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                if (arr[row][column] < min) {
                    min = arr[row][column];
                    result = new int[]{min, row, column};
                }
            }
        }
        return result;
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
}
