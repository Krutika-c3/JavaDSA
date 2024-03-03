package com.gfg.dsa.practice;

import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.checkIfPallindrome(number));
    }

    private boolean checkIfPallindrome(int number) {
        int temp = number;
        int reverse = 0;
        while (temp != 0) {
            reverse = reverse * 10 + (temp % 10);
            temp = temp / 10;
        } // time complexity = theta(number of digits)
        return number == reverse;
    }
}
