package com.leetcode.popularAlgos;
import java.util.Arrays;



/**
 * There is a better algorithm in leetcode submissions
 * Instead of iterating the characters of the string, an iteration is executed from char 'a'(98) to 'z' (123). Check if there is duplicate of char,
 * if not save the position and continue the process from a -> z.
 * @author vcheedel
 *
 */
public class FirstUniqueCharacter {
	
	public static int firstUniqChar(String s) {
		if(s == null) {
			return -1;
		}
		
		int[] checkDuplicate = new int[122];
		Arrays.fill(checkDuplicate, 0);
		
		//fill the array with given information
		for(int i=0; i< s.length(); ++i) {
			int currentValue = checkDuplicate[s.charAt(i)];
			checkDuplicate[s.charAt(i)] = ++currentValue;
		}
		
		//find the first unique char index
		for(int i=0; i< s.length(); ++i) {
			if(checkDuplicate[s.charAt(i)] == 1) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String sampleInput1 = "";
		String sampleInput2 = null;
		String duplicateString = "leetcode";
		String uniqueChars = "sample";
		System.out.println(firstUniqChar(sampleInput2));
	}
}
