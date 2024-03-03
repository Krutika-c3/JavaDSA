package com.gfg.dsa.practice.gcd;

import java.util.Scanner;

public class EuclideanGCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        EuclideanGCD euclideanGCD = new EuclideanGCD();
        System.out.println(euclideanGCD.calculateGcd(number1, number2));
    }

    /*subtract bigger number - smaller number
    until we're left with 0 and a number
    that number is the gcd between the two numbers.*/
    private int calculateGcd(int number1, int number2) {
        while (number1 != number2) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 = number2 - number1;
            }
        } // time complexity = theta(min(a,b))
        return number1;
    }
}
