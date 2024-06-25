package com.gfg.dsa.practice.recursion;

import java.util.Scanner;

public class PrintNTimes {
    static int counter = 1;

    public static void main(String[] args) {
        System.out.print("Enter number of times you want to print: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        print(counter, number);
    }

    private static void print(int i, int number) {
        if (i > number) {
            return;
        }
        System.out.println("Hello World!");
        // tail recursion - as it is last function call
        print(++i, number);
    }
}
