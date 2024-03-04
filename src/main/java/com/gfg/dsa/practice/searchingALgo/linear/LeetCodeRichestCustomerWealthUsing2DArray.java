package com.gfg.dsa.practice.searchingALgo.linear;

public class LeetCodeRichestCustomerWealthUsing2DArray {
    public static void main(String[] args) {
        int[][] array = {
                {1, 5},
                {7, 3},
                {3, 5}
        };
        System.out.println(getRichestWealthCustomer(array));

        int[][] array2 = {
                {2, 8, 7},
                {7, 1, 3},
                {1, 9, 5}
        };
        System.out.println(getRichestWealthCustomer(array2));
    }

    private static int getRichestWealthCustomer(int[][] accounts) {
        int[] totalWealthOfCustomer = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            totalWealthOfCustomer[i] = calculateWealthOfACustomer(accounts[i]);
        }
        return calculateMaxWealth(totalWealthOfCustomer);
    }

    private static int calculateMaxWealth(int[] totalWealthOfCustomer) {
        int maxWealth = totalWealthOfCustomer[0];
        for (int i = 0; i < totalWealthOfCustomer.length; i++) {
            if (totalWealthOfCustomer[i] > maxWealth) {
                maxWealth = totalWealthOfCustomer[i];
            }
        }
        return maxWealth;
    }

    private static int calculateWealthOfACustomer(int[] wealthInAllAccount) {
        int totalWealth = 0;
        for (int i = 0; i < wealthInAllAccount.length; i++) {
            totalWealth = totalWealth + wealthInAllAccount[i];
        }
        return totalWealth;
    }
}
