package com.gfg.dsa.practice.recursion.strings;

import java.util.ArrayList;

/*
    Time complexity for all the below: O(str.length())
 */
public class RecursionForStrings {
    public static void main(String[] args) {
        removeCharFromStringUsingAnotherString("baccad", "", 'a');
        System.out.println(removeCharFromStringInplace("baccad", 'a'));
        System.out.println(removeStringFromStringInplace("11apple22jevjw", "apple"));
        System.out.println(removeAppFromStringNotInAppleInplace("11apple22jevjw"));
        System.out.println("All possible sub-sequences of \"abc\" are :");
        findAllPoissibleSubSquence("", "abc");
        System.out.println("All possible sub-sequences of \"abc\" using list are : " + findAllPoissibleSubSquenceUsingArrayList("", "abc"));
    }

    private static void removeCharFromStringUsingAnotherString(String unprocessedStr, String processedStr, char skipCharacter) {
        if (unprocessedStr.isEmpty()) { // when all characters are processed, print it
            System.out.println(processedStr);
            return;
        }

        char firstChar = unprocessedStr.charAt(0);

        if (firstChar == skipCharacter) { // when a is present
            // don't consider the first character for further iterations and don't add char in the resultant string
            removeCharFromStringUsingAnotherString(unprocessedStr.substring(1), processedStr, skipCharacter);
        } else {
            // don't consider the first character for further iterations and add char in the resultant string
            removeCharFromStringUsingAnotherString(unprocessedStr.substring(1), processedStr + firstChar, skipCharacter);
        }
    }

    // return value and add them while emptying the stack
    private static String removeCharFromStringInplace(String unprocessedStr, char skipCharacter) {
        if (unprocessedStr.isEmpty()) { // when all characters are processed, return empty string
            return "";
        }

        char ch = unprocessedStr.charAt(0);

        if (ch == skipCharacter) { // when a is present
            // don't add char in the resultant string and don't consider the first character for further iterations
            return removeCharFromStringInplace(unprocessedStr.substring(1), skipCharacter);
        } else {
            // add char in the resultant string and don't consider the first character for further iterations
            return ch + removeCharFromStringInplace(unprocessedStr.substring(1), skipCharacter);
        }
    }

    // return value and add them while emptying the stack
    private static String removeStringFromStringInplace(String unprocessedStr, String skipString) {
        if (unprocessedStr.isEmpty()) { // when all characters are processed, return empty string
            return "";
        }

        if (unprocessedStr.startsWith(skipString)) { // when a is present
            // don't add char in the resultant string and don't consider the characters from skipString for further iterations
            return removeStringFromStringInplace(unprocessedStr.substring(skipString.length()), skipString);
        } else {
            char ch = unprocessedStr.charAt(0);
            // add char in the resultant string and don't consider the first character for further iterations
            return ch + removeStringFromStringInplace(unprocessedStr.substring(1), skipString);
        }
    }

    // return value and add them while emptying the stack
    private static String removeAppFromStringNotInAppleInplace(String unprocessedStr) {
        if (unprocessedStr.isEmpty()) { // when all characters are processed, return empty string
            return "";
        }

        if (unprocessedStr.startsWith("app") && !unprocessedStr.startsWith("apple")) { // when a is present
            // don't add char in the resultant string and don't consider the 3 characters for further iterations
            return removeAppFromStringNotInAppleInplace(unprocessedStr.substring(3));
        } else {
            char ch = unprocessedStr.charAt(0);
            // add char in the resultant string and don't consider the first character for further iterations
            return ch + removeAppFromStringNotInAppleInplace(unprocessedStr.substring(1));
        }
    }

    /*
        Subset(arrays)/Subseqquence(strings) questions
        Pattern of taking some elements and removing some elements is known as subset pattern
        Use when, we are asked for the below:
        1. Permutations and combinations
        2. Subsets -> collection of elements
     */
    private static void findAllPoissibleSubSquence(String processedStr, String unprocessedStr) {
        if (unprocessedStr.isEmpty()) {
            System.out.println(processedStr);
            return;
        }

        char ch = unprocessedStr.charAt(0);

        findAllPoissibleSubSquence(processedStr + ch, unprocessedStr.substring(1)); // consider the first char
        findAllPoissibleSubSquence(processedStr, unprocessedStr.substring(1)); // ignore the first char
    }

    private static ArrayList<String> findAllPoissibleSubSquenceUsingArrayList(String processedStr, String unprocessedStr) {
        if (unprocessedStr.isEmpty()) {
            ArrayList<String> result = new ArrayList<>();
            result.add(processedStr);
            return result;
        }

        char ch = unprocessedStr.charAt(0);

        ArrayList<String> left = findAllPoissibleSubSquenceUsingArrayList(processedStr + ch, unprocessedStr.substring(1)); // consider the first char
        ArrayList<String> right = findAllPoissibleSubSquenceUsingArrayList(processedStr, unprocessedStr.substring(1)); // ignore the first char

        ArrayList<String> result = new ArrayList<>();
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}