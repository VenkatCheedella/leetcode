package com.leetcode.popularAlgos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public static List<String> wordBreak(String s, Set<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}
	
	
	public static void main(String[] args) {
		String s = "catsanddog";
//		Set<String> 	words = new HashSet<>();
//		words.add("cat");
//		words.add("cats");
//		words.add("and");
//		words.add("sand");
//		List<String> sentences = WordBreak.wordBreak(s, words);
//		System.out.println(sentences.toString());
	}
}
