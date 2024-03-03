package com.gfg.dsa.practice.prime;

import java.util.Scanner;

public class ReducedTCPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

    }

    private boolean isPirme(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true; // time complexity = theta(n)
    }
}
