package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class PhoneCombinations {
    public static List<String> letterCombinations(String digits) {
        String[] keys = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        helper(0, digits, builder, keys, combinations);
        return combinations;
    }


    private static void helper(int start, String digits, StringBuilder builder, String[] keys, List<String> combinations){
        if(builder.length() == digits.length()) {
            combinations.add(new String(builder));
            return;
        }

        char[] currChars = keys[Character.getNumericValue(digits.charAt(start))].toCharArray();
        for(char c : currChars){
            builder.append(c);
            helper(start+1, digits, builder, keys, combinations);
            builder.deleteCharAt(builder.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(PhoneCombinations.letterCombinations("23"));
    }
}
