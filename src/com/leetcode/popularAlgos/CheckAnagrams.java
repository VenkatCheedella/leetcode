package com.leetcode.popularAlgos;

import java.util.Arrays;



/**
 * Better algorithm , leetcode : Fill the integer array for first string. Make sure the value at an index 
 * doesn't go down to -1 . If it goes to -1 then the two anagrams are invalid anagrams
 * @author vcheedel
 *
 */
public class CheckAnagrams {
	
	public boolean isAnagram(String s, String t) {
        int[] valsOfS = new int[123];
        int[] valsOfT = new int[123];
        
        Arrays.fill(valsOfS, 0);
        Arrays.fill(valsOfT, 0);
        
        if(s == null || t == null) {
        		return false;
        }
        
        if(s.length() != t.length()) {
        		return false; 
        }
        
        int currentChar = 0;
        int currentCount = 0;
        
        for(int i=0; i< s.length(); ++i) {
        	
        		//fill the integer array for s string
        		currentChar = s.charAt(i);
        		currentCount = valsOfS[currentChar];
        		valsOfS[currentChar] = ++currentCount;
        		
        		//fill the integer array of t string
        		currentChar = t.charAt(i);
        		currentCount = valsOfT[currentChar];
        		valsOfT[currentChar] = ++currentCount;
        }
        
        // check if the integer arrays are same
        for(int i=0; i < valsOfS.length; ++i) {
        		if(valsOfS[i] != valsOfT[i]) {
        			return false;
        		}
        }
        return true;
    }
	
	public static void main(String[] args) {
		
		CheckAnagrams checkAnagrams = new CheckAnagrams();
		boolean status = checkAnagrams.isAnagram("nagzaram", "anagzram");
		System.out.println(status);
		
	}
	
}
