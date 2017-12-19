package com.leetcode.popularAlgos;
import java.util.Arrays;

public class ReverseAString {
	
	public String reverseString(String s) {
		if(s == null) {
			return s;
		}
		if(s.length() < 2) {
			return s;
		}
		int len = s.length();
		char[] strChars = s.toCharArray();
		for(int i=0; i< len/2; ++i) {
			char firstChar = strChars[i];
			char secondChar = strChars[len-1-i];
			strChars[i] = secondChar;
			strChars[len-1-i] = firstChar;
		}
		return String.valueOf(strChars);
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseAString().reverseString("sampl"));
	}
}
