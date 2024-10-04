package com.gfg.dsa.practice.string;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateWordCount {
    public static void main(String[] args){
        String string = "abbcccdddd";
        getDuplicateCount(string);
    }

    private static void getDuplicateCount(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ele: string.toCharArray()) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        map.forEach( (key,value) -> {
            if (value > 1) {
                System.out.println(key + " is repeated " + value + " times.");
            }
        });
    }
}
