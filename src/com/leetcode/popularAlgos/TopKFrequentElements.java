package com.leetcode.popularAlgos;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    public static List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        ArrayList<Integer>[] buckets = new ArrayList[len+1];
        Map<Integer, Integer> frequencyList = new HashMap<>();
        for(int i : nums){
            frequencyList.put(i, frequencyList.getOrDefault(i,0) + 1);
        }
        ArrayList<Integer> bucket = null;
        for(int i : frequencyList.keySet()){
            int value = frequencyList.get(i);
            bucket = buckets[value];
            if( bucket == null){
                bucket  = new ArrayList<>();
                buckets[value] = bucket;
            }
            bucket.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int originalLen = k;
        for(int i =buckets.length-1; i>= 0 && k > 0; i--){
            if(buckets[i] != null){
                result.addAll(buckets[i]);
                k--;
            }
        }
        return result.subList(0, originalLen);

    }


    class NumItem{

        public NumItem(int num){
            this.num = num;
            this.count =1;

        }

        public void incrementCount(){
            this.count++;
        }


        public int getNum(){
            return this.num;
        }

        @Override
        public boolean equals(Object obj){
            if(obj == null) return false;
            if(!(obj instanceof NumItem)) return false;
            NumItem compareObject = (NumItem) obj;
            if(compareObject.num != this.num) return false;
            return true;
        }

        int num;
        int count;
    }

    public List<Integer> topKFrequent1(int[] nums, int k) {

        Map<Integer, NumItem> numCounts = new HashMap<>();
        PriorityQueue<NumItem> highFrequencyObjects = new PriorityQueue<>(k,(o1, o2)-> (o1.count - o2.count));
        for(int i=0; i< nums.length; i++){
            NumItem item = numCounts.getOrDefault(nums[i], null);
            if(item == null){
                NumItem newNum = new NumItem(nums[i]);
                numCounts.put(nums[i], newNum);
                if(highFrequencyObjects.size() < k){
                    highFrequencyObjects.offer(newNum);
                }
            }
            else{
                item.incrementCount();
                if(highFrequencyObjects.contains(item)){
                    highFrequencyObjects.remove(item);
                }
                if(highFrequencyObjects.size() < k) highFrequencyObjects.offer(item);
                else if (highFrequencyObjects.peek().count < item.count){
                    highFrequencyObjects.poll();
                    highFrequencyObjects.offer(item);
                }
            }
        }
        return highFrequencyObjects.stream().map(NumItem::getNum).collect(Collectors.toList());
    }

    public static void main(String[] args) {
       // System.out.println(TopKFrequentElements.topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
        TopKFrequentElements elements = new TopKFrequentElements();
        List<Integer> mostFrequentElements = elements.topKFrequent1(new int[]{4,1,-1,2,-1,2,3}, 2);
        mostFrequentElements.forEach(System.out::println);
    }
}
