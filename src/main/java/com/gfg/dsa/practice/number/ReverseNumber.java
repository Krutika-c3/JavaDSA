package com.gfg.dsa.practice.number;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        System.out.printf("Reverse number of %s is %s %n", number, reverseNumber(number));
    }

    static int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number > 0) {
            int rem = number % 10;
            number = number / 10;
            reversedNumber = reversedNumber * 10 + rem;
        }
        return reversedNumber;
    }
}
