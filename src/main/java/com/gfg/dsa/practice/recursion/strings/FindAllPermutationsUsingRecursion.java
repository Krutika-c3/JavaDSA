package com.gfg.dsa.practice.recursion.strings;

import java.util.ArrayList;

/*
    number of recursive calls = size of processed + 1
    at every call, add first char from unprocessed at potential permutations which is equal to size of processed + 1
 */
public class FindAllPermutationsUsingRecursion {
    public static void main(String[] args) {
        permutations("", "abc");
        ArrayList<String> ans = permutationsList("", "abc");
        System.out.println(ans);
        System.out.println(permutationsCount("", "abc"));
        int[] permutationsCount = new int[1];
        permutationsCountUsingCounter("", "abc", permutationsCount);
        System.out.println(permutationsCount[0]);
    }

    static void permutations(String processedStr, String unprocessedStr) {
        if (unprocessedStr.isEmpty()) {
            System.out.println(processedStr);
            return;
        }
        char ch = unprocessedStr.charAt(0);
        for (int i = 0; i <= processedStr.length(); i++) {
            String f = processedStr.substring(0, i);
            String s = processedStr.substring(i, processedStr.length());
            permutations(f + ch + s, unprocessedStr.substring(1));
        }
    }

    static ArrayList<String> permutationsList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        // local to this call
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }

    static void permutationsCountUsingCounter(String p, String up, int[] count) {
        if (up.isEmpty()) {
            count[0]++;
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            permutationsCountUsingCounter(f + ch + s, up.substring(1), count);
        }
    }
}
