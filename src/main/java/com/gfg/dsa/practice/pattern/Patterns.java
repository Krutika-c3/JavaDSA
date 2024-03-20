package com.gfg.dsa.practice.pattern;

public class Patterns {
    public static void main(String[] args) {
        int n = 4;
        filledZero(n);
        System.out.println();
        left90dTriangle(n);
        System.out.println();
        invertedLeft90dTriangle(n);
        System.out.println();
        left90dTriangleWithNumbers(n);
        System.out.println();
        leftHalfDiamond(n);
        System.out.println();
        right90dTriangle(n);
        System.out.println();
        triangle(n);
        System.out.println();
        fullDiamond(n);
        System.out.println();
        triangleWithPallindromeNumbers(n);
        System.out.println();
        fullDiamondWithNumbers(n);
        System.out.println();
        numberSquare(n);
        System.out.println();
        numberSquareDescending(n);
    }

    private static void filledZero(int n) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void left90dTriangle(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void invertedLeft90dTriangle(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n - row + 1; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void left90dTriangleWithNumbers(int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    private static void leftHalfDiamond(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            if (row <= n) {
                for (int column = 1; column <= row; column++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int column = 1; column <= 2 * n - row; column++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

    private static void right90dTriangle(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  "); // 2 space is added
            }
            for (int column = 1; column <= row; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void triangle(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" "); // only 1 space is added
            }
            for (int column = 1; column <= row; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void fullDiamond(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            if (row <= n) {
                for (int space = 1; space <= n - row; space++) {
                    System.out.print(" ");
                }
                for (int column = 1; column <= row; column++) {
                    System.out.print("* ");
                }
                System.out.println();
            } else {
                for (int space = 1; space <= row - n; space++) {
                    System.out.print(" ");
                }
                for (int column = 1; column <= 2 * n - row; column++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }
    }

    private static void triangleWithPallindromeNumbers(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print("  "); // only 1 space is added
            }
            for (int column = row; column >= 1; column--) {
                System.out.print(column + " ");
            }
            for (int rightColumns = 2; rightColumns <= row; rightColumns++) {
                System.out.print(rightColumns + " ");
            }
            System.out.println();
        }
    }

    private static void fullDiamondWithNumbers(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            if (row <= n) {
                for (int space = 1; space <= n - row; space++) {
                    System.out.print("  ");
                }
                for (int column = row; column >= 1; column--) {
                    System.out.print(column + " ");
                }
                for (int rightColumns = 2; rightColumns <= row; rightColumns++) {
                    System.out.print(rightColumns + " ");
                }
                System.out.println();
            } else {
                for (int space = 1; space <= row - n; space++) {
                    System.out.print("  ");
                }
                for (int column = 2 * n - row; column >= 1; column--) {
                    System.out.print(column + " ");
                }
                for (int rightColumns = 2 * n - row; rightColumns >= 2; rightColumns--) {
                    System.out.print(rightColumns + " ");
                }
                System.out.println();
            }
        }
    }

    private static void numberSquare(int n) {
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryIndex = Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }

    private static void numberSquareDescending(int n) {
        int size = 2 * n - 1;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                int val = Math.max(Math.abs(size / 2 - row), Math.abs(size / 2 - column)) + 1;
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}