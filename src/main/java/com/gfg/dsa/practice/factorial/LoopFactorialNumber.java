package com.gfg.dsa.practice.factorial;

import java.util.Scanner;

public class LoopFactorialNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        LoopFactorialNumber loopFactorialNumber = new LoopFactorialNumber();
        System.out.println(loopFactorialNumber.calculateFactorial(number));
    }

    private int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }// time complexity = theta(n)
        return factorial;
    }
}
