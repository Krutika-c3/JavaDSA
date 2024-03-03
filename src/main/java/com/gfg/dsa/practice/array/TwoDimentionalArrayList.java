package com.gfg.dsa.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoDimentionalArrayList {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<List<Integer>> list = new ArrayList<>();

        // initialisation
        for (int i = 0; i < 3; i++) {
            list.add(new ArrayList<>());
        }

        System.out.print("Enter 9 numbers: ");

        // add elements
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(in.nextInt());
            }
        }

        System.out.println(list);
    }
}
