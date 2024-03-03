package com.gfg.dsa.practice;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SumOfNNumbers {
    public static void main(String[] args) {
        System.out.println("Count sum of 'n' numbers");
        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();

        System.out.printf("Calculated sum without using loop : %d\n", CalculateSum.withoutUsingLoop(number));
        System.out.printf("Calculated sum using for loop : %d\n", CalculateSum.usingForLoop(number));
        System.out.printf("Calculated sum using two for loop : %d\n", CalculateSum.usingTwoForLoop(number));
    }
}

class CalculateSum{
    protected static Integer withoutUsingLoop(Integer number){
        return (number * (number + 1)) / 2;
    }

    protected static Integer usingForLoop(Integer number){
        Integer sum = 0;
        for(int i=1;i<=number;i++) {
            sum = sum + i ;
        }
        return sum;
    }

    protected static Integer usingTwoForLoop(Integer number){
        Integer sum = 0;
        for(int i=1;i<=number;i++) {
            for (int j=1;j<=i;j++) {
                sum ++;
            }
        }
        return sum;
    }
}
