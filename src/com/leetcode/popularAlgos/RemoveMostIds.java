package com.leetcode.popularAlgos;

import java.util.*;

public class RemoveMostIds {
    public int removeIds(List<Integer> ids, int m){
        Map<Integer, Integer> IdCount = new HashMap<>();
        for(int i: ids){
           int curr = IdCount.getOrDefault(i,0);
           IdCount.put(i,++curr);
        }

        Map<Integer, List<Integer>> sortedIds = new TreeMap<>();
        for(Integer i : IdCount.keySet()){
            int value = IdCount.get(i);
            if(sortedIds.containsKey(value)){
                List<Integer> Ids = sortedIds.get(value);
                Ids.add(i);
            }else{
                List<Integer> IdList = new ArrayList<>();
                IdList.add(i);
                sortedIds.put(value,IdList);
            }
        }

        int uniqueIds = IdCount.size();
        for(int i : sortedIds.keySet()) {
            while(sortedIds.get(i).size()>0) {
                if(m>=i) {
                    m=m-i;
                    sortedIds.get(i).remove(0);
                    uniqueIds--;
                } else {
                    return uniqueIds;
                }
            }

        }

        return uniqueIds;
    }

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(1);
        ints.add(2);
        ints.add(2);
        RemoveMostIds ids = new RemoveMostIds();
        System.out.println(ids.removeIds(ints, 3));

    }
}
