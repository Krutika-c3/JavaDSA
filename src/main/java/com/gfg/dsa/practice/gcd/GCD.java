package com.gfg.dsa.practice.gcd;

import java.util.Scanner;

import static java.lang.Math.min;

/*  GCD - greatest common divisor
    eg : gcd(5,10) = 5
    as 5 is the greatest number that's a factor of both 5 and 10.
    gcd is always less than or equal to lower number.
 */
public class GCD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        GCD gcd = new GCD();
        System.out.println(gcd.calculateGcd(number1, number2));
    }

    private int calculateGcd(int number1, int number2) {
        int temp = min(number1, number2);
        while (temp > 0) {
            if (number1 % temp == 0 && number2 % temp == 0) {
                break;
            }
            temp--;
        } // time complexity = theta(min(a,b))
        return temp;
    }
}
