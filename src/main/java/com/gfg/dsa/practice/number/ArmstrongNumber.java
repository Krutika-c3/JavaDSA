package com.gfg.dsa.practice.number;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        System.out.printf("%s %s an armstrong number %n", number, isArmstrong(number) ? "is" : "is not");
    }

    static boolean isArmstrong(int n) {
        int number = n;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum = sum + (rem * rem * rem);
            n = n / 10;
        }
        return sum == number;
    }
}
