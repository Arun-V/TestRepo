package com.arun.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterOrder {

    // Given a list of strings, find the order of characters
    public static void main(String[] args) {
        String[] strings = {"geeks", "for", "geeks"};
        List<Character> result = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0;i < strings.length;i++) {
            String str = strings[i];
            for (int j = 0;j < str.length();j++) {
                Character character = str.charAt(j);
                if (!set.contains(character)) {
                    result.add(character);
                    set.add(character);
                }
            }
        }
        for (int i = 0;i < result.size();i++) {
            System.out.println(result.get(i));
        }
    }
}
