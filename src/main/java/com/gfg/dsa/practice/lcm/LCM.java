package com.gfg.dsa.practice.lcm;

import com.gfg.dsa.practice.gcd.GCD;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
    LCM - least common multiple
    10 as 10 is the smallest number that's a multiple of both 5 and 10.
    lcm is always greater than or equal to the greater number.

    - if a number divides the other number, LCM is largest number
        eg: 2 and 8
        LCM is 8
    - if two number do not have any factor in common factors, LCM is multiplication of two numbers.
        eg: 3 and 7
        LCM is 21
 */
public class LCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        LCM lcm = new LCM();
        System.out.println(lcm.calculateLcm(number1, number2));
    }

    private int calculateLcm(int number1, int number2) {
        int temp = max(number1, number2);
        while (true) {
            if (temp % number1 == 0 && temp % number2 == 0) {
                return temp;
            }
            temp++;
        } // time complexity = theta(a*b+max(a,b))
    }
}