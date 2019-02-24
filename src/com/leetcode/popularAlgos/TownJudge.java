package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TownJudge {
	
	public int findJudge(int N, int[][] trust) {
        Map<Integer, Integer> ifJudgeCount = new HashMap<>();
        Map<Integer, List<Integer>> trustList = new HashMap<>();
        for(int i=0; i< trust.length; i++){
            int currCount = ifJudgeCount.getOrDefault(trust[i][1],0);
            ifJudgeCount.put(trust[i][1], currCount+1);
            if(trustList.containsKey(trust[i][0])){
                List<Integer> listOfJudges = trustList.get(trust[i][0]);
                listOfJudges.add(trust[i][1]);
                trustList.put(trust[i][0], listOfJudges);
            }else{
                List<Integer> newListOfJudges = new ArrayList<>();
                newListOfJudges.add(trust[i][1]);
                trustList.put(trust[i][0], newListOfJudges);
            }
        }
        for(Integer judge : ifJudgeCount.keySet()){
            if(ifJudgeCount.get(judge) == N-1 && !trustList.containsKey(judge)){
                return judge;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		TownJudge judge = new TownJudge();
		int[][] trust = new int[][] {{1,3}, {2,3}};
		trust = new int[][] {{1,3}, {2,3}, {3,1}};
		System.out.println(judge.findJudge(3, trust));
	}

}
