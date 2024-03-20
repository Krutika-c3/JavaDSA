package com.gfg.dsa.practice.numbers;

import java.util.Scanner;

public class CountRepeatNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = in.nextInt();
        System.out.print("Enter the number that you wnt to count: ");
        int repeatNumber = in.nextInt();
        System.out.printf("%s has %s time/s %s %n", number, countRepeatingNumbers(number, repeatNumber), repeatNumber);
    }

    static int countRepeatingNumbers(int number, int repeatNumber) {
        int count = 0;
        while (number > 0) {
            int lastDigit = number % 10; // gets the last digit
            if (lastDigit == repeatNumber) {
                count++;
            }
            number = number / 10; // removes the last digit
        }
        return count;
    }
}
