package com.gfg.dsa.practice.gcd;

import java.util.Scanner;

public class OptimizedGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        System.out.println(calculateGcd(number1, number2));
    }

    /*subtract bigger number - smaller number
    until we're left with 0 and a number
    that number is the gcd between the two numbers.

    instead of repeated subtraction we can do modular division(remainder after devision)
    so now we
    */
    public static int calculateGcd(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        } else {
            return calculateGcd(number2, number1 % number2);
        }
    }
}
