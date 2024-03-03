package com.gfg.dsa.practice.lcm;

import java.util.Scanner;

import static com.gfg.dsa.practice.gcd.OptimizedGCD.calculateGcd;
import static java.lang.Math.max;

public class OptimizedLCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        OptimizedLCM optimizedLCM = new OptimizedLCM();
        System.out.println(optimizedLCM.calculateLcm(number1, number2));
    }

    private int calculateLcm(int number1, int number2) {
        return (number1 * number2) / calculateGcd(number1, number2);
        // time complexity = theta(min(a,b))
    }
}
