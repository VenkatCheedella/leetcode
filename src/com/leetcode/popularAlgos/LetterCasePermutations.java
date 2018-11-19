package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutations {
    public List<String> letterCasePermutation(String S) {
        List<String> permutations = new ArrayList<>();
        if(S == null) return permutations;
        if(S.equals("")) {
            permutations.add("");
            return permutations;
        }
        char[] chars = S.toCharArray();
        StringBuffer buffer = new StringBuffer();
        helper(0, chars, permutations, buffer);
        return permutations;
    }

    private void helper(int i, char[] chars, List<String> permutations, StringBuffer buff){
        if(i == chars.length) {
            permutations.add(new String(buff));
            return;
        }
        if((chars[i] - 0 > 96 && chars[i] - 0 < 123) || (chars[i] - 0 > 64 && chars[i] <91)){
            buff.append(chars[i]);
            helper(i+1, chars, permutations,buff);
            buff.deleteCharAt(buff.length() -1);
            char changeCase = (chars[i] - 0 > 90) ? (char)(chars[i] - 32) : (char)(chars[i] + 32);
            buff.append(changeCase);
            helper(i+1, chars, permutations,buff);
            buff.deleteCharAt(buff.length()-1);
        }
        else {
            buff.append(chars[i]);
            helper(i+1, chars, permutations, buff);
            buff.deleteCharAt(buff.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutations perm = new LetterCasePermutations();
        String s1 = "3z4";
        String s2 = "";
        String s3 = "C";
        perm.letterCasePermutation(s3).forEach(System.out::println);
    }
}
