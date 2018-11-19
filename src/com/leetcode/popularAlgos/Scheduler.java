package com.leetcode.popularAlgos;

import java.util.*;

public class Scheduler {


    private List<Character> sortCharsBasesOnTaskCount(Map<Character, Integer> taskMap, List<Character> unorderedList){
        Collections.sort(unorderedList, (c1, c2) -> {
            int value = taskMap.get(c2) - taskMap.get(c1);
            return (value == 0) ?  c1 - c2 : value;
        });
        return unorderedList;
    }


    public int getMinTimeToCompleteTasks(char[] tasks, int n){
        // HashMap to hold tasks
        Map<Character, Integer> taskMap = new HashMap<>();
        for(char task : tasks){
            int count = taskMap.getOrDefault(task, 0);
            taskMap.put(task, ++count);
        }

        // create a LinkedList for above list of keys;
        List<Character> orderedTasks = sortCharsBasesOnTaskCount(taskMap, new ArrayList<>(taskMap.keySet()));

        //schedule the tasks
        int countOfPendingTasks = orderedTasks.size();
        int iter = 0;
        int totalScheduleCount = 0;
        int loopIter = 0;
        StringBuilder builder = new StringBuilder();
        while(countOfPendingTasks != 0){
            loopIter = 0;
            iter = 0;
            while(iter < n+1 && countOfPendingTasks != 0){
                if(loopIter++ >= orderedTasks.size()) {
                    totalScheduleCount++;
                    builder.append("idle->");
                    iter++;
                    continue;
                }
                char currTask = orderedTasks.get(iter);
                int count = taskMap.get(currTask);
                taskMap.put(orderedTasks.get(iter), count-1);
                if(count == 0) countOfPendingTasks--;
                if(count > 0) {
                    iter++;
                    totalScheduleCount++;
                    builder.append(currTask+ "->");
                }
            }
            orderedTasks = sortCharsBasesOnTaskCount(taskMap, orderedTasks);
        }
        System.out.println(builder.toString());
        return  totalScheduleCount;
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        System.out.println(scheduler.getMinTimeToCompleteTasks(new char[]{'a','b','c','a','a','c','a'}, 2));
    }
}
