package com.leetcode.popularAlgos;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupOfAnagrams = new HashMap<>();
        for(int i=0; i< strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if(groupOfAnagrams.containsKey(s)){
                List<String> currentList = groupOfAnagrams.get(s);
                currentList.add(strs[i]);
            }else{
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                groupOfAnagrams.put(s, newList);
            }
        }
        return new ArrayList<List<String>>(groupOfAnagrams.values());
    }

    public static void main(String[] args) {
        GroupAnagrams gp = new GroupAnagrams();
        System.out.println(gp.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
