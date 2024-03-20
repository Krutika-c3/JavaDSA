package com.gfg.dsa.practice.number;

import java.util.Scanner;

public class CountDigits {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        CountDigits countDigits = new CountDigits();
        System.out.println(countDigits.countDigits(number));
    }

    private int countDigits(int number) {
        int counter = 0;
        while (number > 0) {
            number = number / 10;
            counter++;
        } // time complexity = theta(number of digits)
        return counter;
    }
}
