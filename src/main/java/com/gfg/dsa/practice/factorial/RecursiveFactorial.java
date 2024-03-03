package com.gfg.dsa.practice.factorial;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        RecursiveFactorial recursiveFactorial = new RecursiveFactorial();
        System.out.println(recursiveFactorial.calculateFactorialRecursive(number));
    }

    private int calculateFactorialRecursive(int number) {
        if (number == 0) {
            return 1;
        }
        return number * calculateFactorialRecursive(number - 1);
    }
}
