package com.gfg.dsa.practice.recursion;

public class RecursionForNumbers {
    public static void main(String[] args) {
        int number = 5;
        printNTo1(number);
        System.out.println();
        print1ToN(number + 1);
        System.out.println();
        System.out.println("Fibonacci number at " + number + " index is: " + findFibonacci(number));
        System.out.println("Factorial of " + number + " is: " + findFactorial(number));
        System.out.println("Factorial of " + number + " is: " + findSum(number));
        System.out.println("Sum of digits of 9832 is: " + findSumOfDigits(9832));
        System.out.println("Product of digits of 9832 is: " + findProductOfDigits(9832));
        System.out.println("Reverse of 193784 is: " + findReverse(193784));
        System.out.println("Is 123321 palindrome? " + isPalindrome(123321));
        System.out.println("Number of zeros in 1020402300 are: " + findZeros(1020402300));
        System.out.println("Count the number of steps required in 123 is: " + findNumberOfSteps(123));
    }

    private static void printNTo1(int number) {
        if (number == 0) {
            return;
        }
        System.out.print(number + " ");
        printNTo1(--number);
    }

    private static void print1ToN(int number) {
        if (number == 1) {
            /*
                 Once the base case is reached:
                 The recursive calls start returning, and the method continues executing from where it left off.
             */
            return;
        }
        print1ToN(--number);
        System.out.print(number + " ");
    }

    private static int findFibonacci(int number) {
        if (number < 2) {
            return number;
        }
        return findFibonacci(number - 1) + findFibonacci(number - 2);
    }

    /*
        F(n) = n * F(n-1)
        if number is less than or equal to 1 then return 1
     */
    private static int findFactorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * findFactorial(number - 1);
    }

    /*
    F(n) = n + F(n-1)
    if number is less than or equal to 1 then return 1
    */
    private static int findSum(int number) {
        if (number <= 1) {
            return 1;
        }
        return number + findSum(number - 1);
    }

    /*
    F(n) = last digit + F(all other digits)
    F(n) = n%10 + F(n/10)
    if number is less than or equal to 0 then return 0
    */
    private static int findSumOfDigits(int number) {
        if (number == 0) {
            return 0;
        }
        return number % 10 + findSumOfDigits(number / 10);
    }

    /*
    F(n) = last digit * F(all other digits)
    F(n) = n%10 * F(n/10)
    if number is last digit, return the number itself
    */
    private static int findProductOfDigits(int number) {
        if (number % 10 == number) { // if number is a 1-digit number
            return number;
        }
        return number % 10 * findProductOfDigits(number / 10);
    }

    /*
       eg: number: 1234
       reverse will be 4 * 10^3 + reverse of 123
                                    3 * 10^2 + reverse of 12
                                                2 * 10^1 + reverse of 1
       F(n, digits) = n%10 * 10^digits-1 + F(n/10, digits - 1)
       digits = log(n) + 1
     */
    private static int findReverse(int number) {
        int digits = (int) (Math.log10(number) + 1);
        return reverseNumber(number, digits);
    }

    private static int reverseNumber(int number, int digits) {
        if (number % 10 == number) { // if number is a 1-digit number
            return number;
        }
        int lastDigit = number % 10;
        return lastDigit * (int) (Math.pow(10, digits - 1)) + reverseNumber(number / 10, digits - 1);
    }

    private static boolean isPalindrome(int number) {
        return number == findReverse(number);
    }

    /*
        till number is 0
        Take remainder
        check if it's zero
        if yes, add count

        if zero is present:
        F(n) = F(n/10, ++count)
        else
        F(n) = F(n/10, count)
     */
    private static int findZeros(int number) {
        return countZeros(number, 0);
    }

    private static int countZeros(int number, int count) {
        if (number == 0) { // all numbers are traversed
            return count; // return the total count
        }
        int lastDigit = number % 10;
        if (lastDigit == 0) {
            return countZeros(number / 10, ++count);
        }
        return countZeros(number / 10, count);
    }

    /*
        https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
        If number is event divide it by 2
        else subtract it by 1
     */
    private static int findNumberOfSteps(int number) {
        return numberOfSteps(number, 0);
    }

    private static int numberOfSteps(int number, int steps) {
        if (number == 0) {
            return steps;
        }

        if (number % 2 == 0) {
            return numberOfSteps(number / 2, ++steps);
        }
        return numberOfSteps(number - 1, ++steps);
    }
}
