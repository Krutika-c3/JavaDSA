package com.gfg.dsa.practice.recursion;

public class PatternsUsingRecursion {
    public static void main(String[] args) {
        printUpLeftTriangle(4, 0);
        printDownLeftTriangle(4, 0);
    }

    private static void printUpLeftTriangle(int row, int column) {
        if (row == 0) {
            return;
        }
        // print stars till column is less than row
        if (column < row) {
            System.out.print("*");
            // we want more stars hence increase the column count
            printUpLeftTriangle(row, column + 1);
        } else {
            // enter new line
            System.out.println();
            // we want to start with the new row hence decrease the row and reset the star count
            printUpLeftTriangle(row - 1, 0);
        }
    }

    /*
        Here sout will be printed when method calls are removing from the stack
        we will go down all the method calls and
        at the last we will first add a new line
        start with printing one *
        and then 2 stars
        and so on..
     */
    private static void printDownLeftTriangle(int row, int column) {
        if (row == 0) {
            return;
        }
        // print stars till column is less than row
        if (column < row) {
            // we want more stars hence increase the column count
            printDownLeftTriangle(row, column + 1);
            System.out.print("*");
        } else {
            // we want to start with the new row hence decrease the row and reset the star count
            printDownLeftTriangle(row - 1, 0);
            // enter new line
            System.out.println();
        }
    }
}
