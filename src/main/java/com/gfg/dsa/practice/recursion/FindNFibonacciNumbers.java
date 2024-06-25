package com.gfg.dsa.practice.recursion;

import java.util.Scanner;

public class FindNFibonacciNumbers {
    public static void main(String[] args) {
        System.out.print("Enter number of fibonacci number you want to find: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(findFibonacci(number));
    }

    private static int findFibonacci(int number) {
        if (number < 2) {
            return number;
        }
        return findFibonacci(number - 1) + findFibonacci(number - 2);
    }
}
