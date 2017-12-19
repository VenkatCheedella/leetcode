package com.leetcode.popularAlgos;
import java.util.HashMap;
import java.util.HashSet;

public class LongSubString {
	
	private int removeCharsUntilDuplicate(String s, 
			HashSet<Character> uniqueChars, int startIndex, int currentIndex) {
		char duplicateChar = s.charAt(currentIndex);
		if(startIndex == currentIndex) {
			return currentIndex;
		}
		while(startIndex != currentIndex) {
			if(s.charAt(startIndex) == duplicateChar) {
				return ++startIndex;
			}
			uniqueChars.remove(s.charAt(startIndex));
			++startIndex;
		}
		return currentIndex;
	}
	
	
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		if(s.length() == 1) {
			return 1;
		}
		int slowIter = 0;
		int largestLen = 1;
		int currentLen = 1;
		HashSet<Character> uniqueChars = new HashSet<>();
		uniqueChars.add(s.charAt(slowIter));
		for(int i=1; i< s.length(); ++i) {
			int maxPossibleLen = s.length() - slowIter;
			if(maxPossibleLen <= largestLen) {
				return largestLen;
			}
			char currentChar = s.charAt(i);
			if(uniqueChars.contains(currentChar)) {
				 currentLen = i - slowIter;
				 largestLen = (currentLen > largestLen) ? currentLen : largestLen;
				 slowIter = removeCharsUntilDuplicate(s, uniqueChars, slowIter, i);
				 currentLen = i-slowIter+1;
			}
			else {
				uniqueChars.add(currentChar);
				++currentLen;
			}
		}
		largestLen = (currentLen > largestLen) ? currentLen : largestLen;
		return largestLen;
	}
	
	public static void main(String[] args) {
		LongSubString subString = new LongSubString();
		String s1 = "abcabcbb";
		String s2 = "bbbbb";
		String s3 = "pwwkew";
		String s4 = "abcdefcbcdefgabcdef";
		String s5 = "abcde";
		String s6 = "tmmzuxt";
		String s7 = "dvdf";
		System.out.println("Max len : " + subString.lengthOfLongestSubstring(s7));
	}

}
