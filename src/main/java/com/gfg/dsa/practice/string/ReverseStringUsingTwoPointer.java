package com.gfg.dsa.practice.string;

import java.util.Arrays;

public class ReverseStringUsingTwoPointer {
    public static void main(String[] args) {
        String string = "abcdefg";
        System.out.println("Unsorted string: " + string);
        System.out.println("Reversed list: " + reverse(string));
    }

    static String reverse(String string) {
        int start = 0;
        char[] array = string.toCharArray();
        int end = array.length - 1;

        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
        return new String(array);
    }

    static void swap(char[] arr, int index1, int index2) {
        char temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
