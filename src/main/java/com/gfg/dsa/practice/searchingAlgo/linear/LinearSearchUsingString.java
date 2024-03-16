package com.gfg.dsa.practice.searchingAlgo.linear;

public class LinearSearchUsingString {
    public static void main(String[] args) {
        String name = "HelloWorld";
        char target = 'l';

        System.out.printf("%s has %s at %s index", name, target, getTargetIndexIfPresent(name, target));
        System.out.println();
        System.out.printf("%s has %s %s", name, target, isTargetElementPresent(name, target) ? "present" : "absent");
    }

    private static int getTargetIndexIfPresent(String name, int target) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == target) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isTargetElementPresent(String name, int target) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == target) {
                return true;
            }
        }
        return false;
    }
}
