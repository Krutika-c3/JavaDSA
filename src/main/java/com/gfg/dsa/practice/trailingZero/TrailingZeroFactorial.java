package com.gfg.dsa.practice.trailingZero;

import java.util.Scanner;

public class TrailingZeroFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        TrailingZeroFactorial trailingZeroFactorial = new TrailingZeroFactorial();
        System.out.println(trailingZeroFactorial.countTrailingZeros(number));
    }

    private int countTrailingZeros(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        } //theta(n)
        int zeroCount = 0;

        while (factorial % 10 == 0) {
            factorial = factorial / 10;
            zeroCount++;
        } //theta(logn)
        //time complexity = theta(n)
        return zeroCount;
    }
}
