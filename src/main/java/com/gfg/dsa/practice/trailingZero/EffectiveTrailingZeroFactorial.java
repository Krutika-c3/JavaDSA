package com.gfg.dsa.practice.trailingZero;

import java.util.Scanner;

public class EffectiveTrailingZeroFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        EffectiveTrailingZeroFactorial effectiveTrailingZeroFactorial = new EffectiveTrailingZeroFactorial();
        System.out.println(effectiveTrailingZeroFactorial.countTrailingZeros(number));
    }

    private int countTrailingZeros(int number) {
        int count = 0;
        // count no of 5 in prime factorization of factorial
        for (int i = 5; i <=number; i=i*5) {
            count = count + number / i;
        }
/*      time complexity = 5^k <=n
                        k  <= log(base5)n
                        logn*/

        return count;
    }
}
