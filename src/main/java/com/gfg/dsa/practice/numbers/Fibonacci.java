package com.gfg.dsa.practice.numbers;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of you want to get fibonacci numbers: ");
        int number = in.nextInt();
        System.out.printf("First %s fibonacci numbers are: ",  number);
        showFibonacci(number);
    }

    static void showFibonacci(int number) {
        int num1 = 0, num2 = 1;
        for (int i = 2; i <= number; i++) {
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            System.out.print(num1 + " ");
        }
    }
}
